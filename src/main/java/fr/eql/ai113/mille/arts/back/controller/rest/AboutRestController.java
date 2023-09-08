package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("about")
@CrossOrigin(origins = "${front.url}")
public class AboutRestController {

    UserService userService;

    @GetMapping("/get")
    public String findDescription() {return userService.findDescription();}

    @PutMapping("/modify")
    public String modifyDescription(@RequestBody String newDescription) {return userService.modifyDescription(newDescription);}

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
