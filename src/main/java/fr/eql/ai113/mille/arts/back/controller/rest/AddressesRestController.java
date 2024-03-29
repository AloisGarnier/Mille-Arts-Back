package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.entity.Address;
import fr.eql.ai113.mille.arts.back.entity.Customer;
import fr.eql.ai113.mille.arts.back.entity.dto.AddressDto;
import fr.eql.ai113.mille.arts.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("addresses")
@CrossOrigin(origins = "${front.url}")
public class AddressesRestController {

    UserService userService;

    @GetMapping("/{id}/all")
    public List<Address> findAllAddressesByCustomerId(@PathVariable long id) { return userService.findAddressesByCustomerId(id);}

    @PostMapping("/{id}/newaddress")
    public Address addNewAddress(@PathVariable long id, @RequestBody AddressDto addressDto) {
        return userService.addAddress(
            (Customer) userService.findCustomerById(id),
            addressDto.getName(),
            addressDto.getStreetNumber(),
            addressDto.getStreet(),
            addressDto.getCityName(),
            addressDto.getZipCode()
        );
    }

    @PutMapping("/modify")
    public Address modifyAddress(@RequestBody AddressDto addressDto) {
        return userService.modifyAddress(
                addressDto.getId(),
                addressDto.getName(),
                addressDto.getStreetNumber(),
                addressDto.getStreet(),
                addressDto.getCityName(),
                addressDto.getZipCode()
        );
    }

    @DeleteMapping("/{id}/delete")
    public Address deleteAddress(@PathVariable Long id) {
        return userService.deleteAddress(id);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
