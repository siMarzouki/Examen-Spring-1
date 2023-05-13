package tn.esprit.DAO.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoursClassroom implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idCours;

    @Enumerated(EnumType.STRING)
    Specialite specialite;

    String nom;
    int nbHeueres ;

    boolean archive;
    @JsonIgnore

    @ManyToOne
    Classe classe;

}
