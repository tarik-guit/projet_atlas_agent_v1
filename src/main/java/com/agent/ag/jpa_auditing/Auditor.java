package com.agent.ag.jpa_auditing;

import com.agent.ag.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class Auditor implements AuditorAware<String> {
  @Autowired
 public AuthController u;

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of(u.getUsername());
    }
}