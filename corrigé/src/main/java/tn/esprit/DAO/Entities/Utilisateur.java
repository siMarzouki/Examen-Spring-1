package tn.esprit.DAO.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idUtilisateur;
    String prenom;
    String nom;
    String password;

    @JsonIgnore
    @ManyToOne
    Classe classe;
}
