package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.entity.Command;
import fr.eql.ai113.mille.arts.back.entity.dto.CommandDto;
import fr.eql.ai113.mille.arts.back.service.CommandService;
import fr.eql.ai113.mille.arts.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commands")
@CrossOrigin(origins = "${front.url}")
public class CommandRestController {

    UserService userService;
    CommandService commandService;

    @GetMapping("/{id}/all")
    public List<Command> findAllCommandByCustomerId(@PathVariable long id) { return userService.findCommandsByCustomerId(id); }

    @GetMapping("/todo")
    public List<Command> findTodoCommands() { return commandService.findTodoCommands(); }

    @PostMapping("/newcommand")
    public Command addNewCommand(@RequestBody CommandDto commandDto) {
        return null;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setCommandService(CommandService commandService) {
        this.commandService = commandService;
    }
}
