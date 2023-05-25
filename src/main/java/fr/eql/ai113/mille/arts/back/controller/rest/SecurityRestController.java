package fr.eql.ai113.mille.arts.back.controller.rest;

import fr.eql.ai113.mille.arts.back.entity.dto.AuthRequest;
import fr.eql.ai113.mille.arts.back.entity.dto.AuthResponse;
import fr.eql.ai113.mille.arts.back.service.UserService;
import fr.eql.ai113.mille.arts.back.service.impl.AccountExistsException;
import fr.eql.ai113.mille.arts.back.service.impl.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
@CrossOrigin(origins = "${front.url}")
public class SecurityRestController {

    /** Injecté par le setter */
    UserService userService;

    @PostMapping("/authorize")
    public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest requestDto) throws UnauthorizedException {
        Authentication authentication;
        try {
            authentication = userService.authenticate(requestDto.getUsername(), requestDto.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails owner = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(owner);
            return ResponseEntity.ok(new AuthResponse(owner, token));
        } catch (AuthenticationException e) {
            throw new UnauthorizedException();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistsException {
        UserDetails owner = userService.save(
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getPhoneNumber(),
                requestDto.getBirthDate(),
                requestDto.getAddress(),
                requestDto.getUsername(),
                requestDto.getPassword());
        String token = userService.generateJwtForUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token));
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<AuthResponse> changeCustomer(@PathVariable long id, @RequestBody AuthRequest requestDto) {
        UserDetails owner = userService.change(
                id,
                requestDto.getFirstName(),
                requestDto.getLastName(),
                requestDto.getPhoneNumber(),
                requestDto.getUsername()
        );
        String token = userService.generateJwtForUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token));
    }

    @PutMapping("/unsubscribe/{id}")
    public ResponseEntity<AuthResponse> unsubscribe(@PathVariable long id) {
        UserDetails owner = userService.unsubscribe(id);
        String token = userService.generateJwtForUser(owner);
        return ResponseEntity.ok(new AuthResponse(owner, token));
    }

    /// Setters ///
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
