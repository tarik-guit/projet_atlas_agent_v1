package com.agent.ag.Controllers;

import com.agent.ag.Entities.Client;
import com.agent.ag.Entities.Compte;
import com.agent.ag.Repositories.Repoclient;
import com.agent.ag.Repositories.Repocompte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin()
public class Controcompte {


    @Autowired
    private Repocompte rep;
    @Autowired
    private Repoclient repc;

    @GetMapping("/comptes")
    public List<Compte> getall() {
        return rep.findAll();
    }

    @DeleteMapping("/comptes")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/compte/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/compte_client/{id}")
    public Compte creerclient(@RequestBody Compte compte,@PathVariable Long id) {
        Client cl=repc.findById(id).get();
        cl.getComptes().add(compte);
        return  rep.save(compte);
    }

}
