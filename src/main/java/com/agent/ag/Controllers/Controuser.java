package com.agent.ag.Controllers;


import com.agent.ag.Entities.username;
import com.agent.ag.securitycontroller.AuthController;
import com.agent.ag.securitymodels.User;
import com.agent.ag.securitymodels.Userepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin()
public class Controuser {

    @Autowired
    private Userepo repu;
    @Autowired
    public AuthController auth;
    @Autowired
    PasswordEncoder encoder;

    @PutMapping("/changeidentity")
    public User updateuser( @RequestBody User cla) {
      // User currentuser =repu.trouverparusername(auth.username);
        User currentuser = repu.findByUsername(auth.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + auth.getUsername()));

        if (cla.getUsername() != null) {
            currentuser.setUsername(cla.getUsername());
        }
        if (cla.getEmail() != null) {
            currentuser.setEmail(cla.getEmail());
        }

        if (cla.getPassword() != null) {
            currentuser.setPassword(encoder.encode(cla.getPassword()));
        }


        return repu.save(currentuser);
    }

@GetMapping("/username")
    public username username(){

        return new username(auth.getUsername());
}


}
