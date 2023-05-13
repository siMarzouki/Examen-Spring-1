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
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codeClasse;

    String classe;


    @Enumerated(EnumType.STRING)
    Niveau niveau;

@JsonIgnore
    @OneToMany(mappedBy = "classe")
    List<CoursClassroom> coursClassrooms;
}
