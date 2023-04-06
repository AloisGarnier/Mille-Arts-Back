package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Address;
import fr.eql.ai113.mille.arts.back.entity.City;
import fr.eql.ai113.mille.arts.back.entity.Customer;
import fr.eql.ai113.mille.arts.back.service.impl.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.List;

public interface UserService extends UserDetailsService {

    Authentication authenticate(String username, String password) throws AuthenticationException;
    UserDetails save(String firstName,
                     String lastName,
                     String phoneNumber,
                     LocalDate birthDate,
                     Address address,
                     String login,
                     String password) throws AccountExistsException;
    UserDetails findCustomerById(Long customerId);
    List<Address> findAddressesByCustomerId(Long customerId);
    UserDetails addAddress(Customer customer, String streetNumber, String street, City city);
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);
}
