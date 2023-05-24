package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Address;
import fr.eql.ai113.mille.arts.back.entity.City;
import fr.eql.ai113.mille.arts.back.entity.Command;
import fr.eql.ai113.mille.arts.back.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long> {

    Customer findByLoginAndPassword(String login, String password);
    List<Customer> findAllByIdNot(long id);
    Customer findById(long id);
    Customer findByLogin(String login);

    @Query("SELECT a " +
            "FROM Address a " +
            "WHERE a.customer = ?1")
    List<Address> findAllAddressesByCustomerId(Customer customer);

    @Query("SELECT c " +
            "FROM Command c " +
            "WHERE c.customer = ?1")
    List<Command> findAllCommandsByCustomerId(Customer customer);

    @Transactional
    @Modifying
    @Query("UPDATE Customer c " +
            "SET c.firstName = ?2, " +
            "c.lastName = ?3, " +
            "c.phoneNumber = ?4, " +
            "c.login = ?5 " +
            "WHERE c.id = ?1")
    void changeCustomer(long id, String firstName, String lastName, String phoneNumber, String username);

    @Transactional
    @Modifying
    @Query("UPDATE Address a " +
            "SET a.name = ?2, " +
            "a.streetNumber = ?3, " +
            "a.street = ?4, " +
            "a.city = ?5 " +
            "WHERE a.id = ?1")
    void modifyAddress(Long addressId, String name, String streetNumber, String street, City city);

    @Transactional
    @Modifying
    @Query("DELETE FROM Address a WHERE a.id = ?1")
    void deleteAddress(Long addressId);
}
