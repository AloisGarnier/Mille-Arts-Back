package fr.eql.ai113.mille.arts.back.repository;

import fr.eql.ai113.mille.arts.back.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long> {

    Customer findByLoginAndPassword(String login, String password);
    List<Customer> findAllByIdNot(long id);
    Customer findById(long id);
    Customer findByLogin(String login);
}
