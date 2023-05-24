package fr.eql.ai113.mille.arts.back.service.impl;

import fr.eql.ai113.mille.arts.back.entity.Address;
import fr.eql.ai113.mille.arts.back.entity.City;
import fr.eql.ai113.mille.arts.back.entity.Command;
import fr.eql.ai113.mille.arts.back.entity.Customer;
import fr.eql.ai113.mille.arts.back.repository.AddressDao;
import fr.eql.ai113.mille.arts.back.repository.CityDao;
import fr.eql.ai113.mille.arts.back.repository.CustomerDao;
import fr.eql.ai113.mille.arts.back.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Configuration
public class UserServiceImpl implements UserService {

    /** Injectés par les setters */
    private CustomerDao customerDao;
    private CityDao cityDao;
    private AddressDao addressDao;
    private AuthenticationManager authenticationManager;

    private final String signingKey;

    public UserServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(String username, String password) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    @Override
    public UserDetails save(String firstName,
                            String lastName,
                            String phoneNumber,
                            LocalDate birthDate,
                            Address address,
                            String login,
                            String password) throws AccountExistsException {
        if (customerDao.findByLogin(login) != null) {
            throw new AccountExistsException();
        }
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhoneNumber(phoneNumber);
        customer.setBirthDate(birthDate);
        customer.addAddress(address);
        customer.setLogin(login);
        customer.setPassword(passwordEncoder().encode(password));
        customerDao.save(customer);
        return customer;
    }

    @Override
    public UserDetails change(long id, String firstName, String lastName, String phoneNumber, String username) {
        customerDao.changeCustomer(id, firstName, lastName, phoneNumber, username);

        return findCustomerById(id);
    }

    @Override
    public UserDetails findCustomerById(Long customerId) {
        return customerDao.findById(customerId).get();
    }

    @Override
    public List<Address> findAddressesByCustomerId(Long customerId) {
        return customerDao.findAllAddressesByCustomerId(customerDao.findById(customerId).get());
    }

    /**
     * Finds all past commands of a given customer
     * @param customerId the id of the customer
     * @return the list of past commands if the id is found in the database, else the method returns null
     */
    @Override
    public List<Command> findCommandsByCustomerId(Long customerId) {
        return customerDao.findById(customerId).isPresent() ?
                customerDao.findAllCommandsByCustomerId(customerDao.findById(customerId).get()) :
                null;
    }

    @Override
    public Address addAddress(Customer customer, String name, String streetNumber, String street, String cityName, String zipCode) {

        City city = checkCityAlreadyExists(cityName, zipCode);

        Address address = new Address();
        address.setName(name);
        address.setStreetNumber(streetNumber);
        address.setStreet(street);
        address.setCity(city);
        address.setCustomer(customer);
        customer.addAddress(address);

        addressDao.save(address);

        return address;
    }

    @Override
    public Address modifyAddress(Long addressId, String name, String streetNumber, String street, String cityName, String zipCode) {
        City city = checkCityAlreadyExists(cityName, zipCode);
        customerDao.modifyAddress(addressId, name, streetNumber, street, city);
        return new Address(streetNumber, street, city);
    }

    @Override
    public Address deleteAddress(Long addressId) {
        customerDao.deleteAddress(addressId);
        return new Address(null, null, null);
    }

    private City checkCityAlreadyExists(String cityName, String zipCode) {
        List<City> cities = cityDao.findByNameAndZipCode(cityName, zipCode);
        if (cities.size() == 0) {
            City city = new City();
            city.setName(cityName);
            city.setZipCode(zipCode);
            cityDao.save(city);
            return cityDao.findByNameAndZipCode(cityName, zipCode).get(0);
        }
        return cities.get(0);
    }

    @Override
    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600 * 1000);
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, signingKey).compact();
    }

    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDao.findByLogin(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Le propriétaire n'a pas été trouvé.");
        }
        return customer;
    }

    /// Setters ///
    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }
    @Autowired
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
}
