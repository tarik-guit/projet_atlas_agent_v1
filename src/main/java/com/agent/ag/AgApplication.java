package com.agent.ag;

import com.agent.ag.Entities.Compte;
import com.agent.ag.requestresponse.SignupRequest;
import com.agent.ag.securitycontroller.AuthController;
import com.agent.ag.securitymodels.ERole;
import com.agent.ag.securitymodels.Role;
import com.agent.ag.securitymodels.User;
import com.agent.ag.securitymodels.Userepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AgApplication    {
  @Autowired
  private AuthController u;
    public static void main(String[] args) {
        SpringApplication.run(AgApplication.class, args);
    }



}
