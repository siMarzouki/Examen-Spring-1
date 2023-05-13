package tn.esprit.RestControllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.DAO.Entities.*;
import tn.esprit.Services.IServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestControllers {
    @Autowired
    IServices services;

    @PostMapping("/addUser")
    public Utilisateur ajouterUtilisateur (@RequestBody Utilisateur utilisateur){
        return services.ajouterUtilisateur(utilisateur);
    }
    @PostMapping("/addClasse")
    public Classe ajouterClasse (@RequestBody  Classe c){
        return services.ajouterClasse(c);
    };
    @PostMapping("/addCours")
    public CoursClassroom ajouterCoursClassroom (@RequestBody CoursClassroom cc,@RequestParam Integer idClasse){
        return services.ajouterCoursClassroom(cc,idClasse);
    }

    @PutMapping("/affecterUtilisateurClasse")
    public void affecterUtilisateurClasse (@RequestParam Integer idUtilisateur,@RequestParam Integer idClasse){
        services.affecterUtilisateurClasse(idUtilisateur,idClasse);
    }
    @GetMapping("/nbUtilisateursParNiveau")

    public Integer nbUtilisateursParNiveau(@RequestParam Niveau nv){
        return services.nbUtilisateursParNiveau(nv);
    }
    @PutMapping("/desaffecterCoursClassroomClasse")

    public void desaffecterCoursClassroomClasse(@RequestParam Integer idCours){
        services.desaffecterCoursClassroomClasse(idCours);
    }

    @GetMapping("/nbHeuresParSpecEtNiv")
    public Integer nbHeuresParSpecEtNiv(@RequestParam Specialite sp,@RequestParam Niveau nv) {
        return services.nbHeuresParSpecEtNiv(sp,nv);
    }
}
