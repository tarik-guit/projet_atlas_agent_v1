package com.agent.ag.Controllers;


import com.agent.ag.Entities.Client;
import com.agent.ag.Repositories.Repoclient;
import com.agent.ag.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class Controclient {

    @Autowired
    private Repoclient rep;
    @Autowired
    public AuthController u;
    @GetMapping("/myclients")
    public List<Client> getallclientofcurrentagent() {
        return rep.getall(u.getUsername());
    }


    @DeleteMapping("/clients")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/client/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/client")
    public Client creerclient(@RequestBody Client client) {

        return  rep.save(client);
    }



}
