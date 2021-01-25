package com.agent.ag.Entities;

import com.agent.ag.jpa_auditing.auditingclasse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Compte extends auditingclasse<String> implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int  solde;
    @ManyToOne(optional = true)
    private Client client;

}
