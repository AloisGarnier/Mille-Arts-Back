package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.entity.Command;
import fr.eql.ai113.mille.arts.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("commands")
@CrossOrigin(origins = "${front.url}")
public class CommandRestController {

    UserService userService;

    @GetMapping("/{id}/all")
    public List<Command> findAllCommandByCustomerId(@PathVariable long id) { return userService.findCommandsByCustomerId(id); }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
