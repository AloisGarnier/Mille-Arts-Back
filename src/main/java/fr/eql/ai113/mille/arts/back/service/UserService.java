package fr.eql.ai113.mille.arts.back.service;

import fr.eql.ai113.mille.arts.back.entity.Address;
import fr.eql.ai113.mille.arts.back.entity.City;
import fr.eql.ai113.mille.arts.back.entity.Command;
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
    UserDetails change(long id, String firstName, String lastName, String phoneNumber, String username);
    UserDetails findCustomerById(Long customerId);
    UserDetails unsubscribe(long id);
    List<Address> findAddressesByCustomerId(Long customerId);
    List<Command> findCommandsByCustomerId(Long customerId);
    Address addAddress(Customer customer, String name, String streetNumber, String street, String cityName, String zipCode);
    Address modifyAddress(Long addressId, String name, String streetNumber, String street, String cityName, String zipCode);
    Address deleteAddress(Long addressId);
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);
}
