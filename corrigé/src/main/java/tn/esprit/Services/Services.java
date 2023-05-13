package tn.esprit.Services;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.DAO.Entities.*;
import tn.esprit.DAO.Repositories.ClasseRepo;
import tn.esprit.DAO.Repositories.CoursClassroomRepo;
import tn.esprit.DAO.Repositories.UtilisateurRepo;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class Services implements IServices {

    UtilisateurRepo utilisateurRepo;

    ClasseRepo classeRepo;

    CoursClassroomRepo coursClassroomRepo;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
       return utilisateurRepo.save(utilisateur);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepo.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer idClasse) {
        Classe c = classeRepo.findById(idClasse).get();
        c.getCoursClassrooms().add(cc);
        classeRepo.save(c);
        cc.setClasse(c);
        return coursClassroomRepo.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer idClasse) {
        Utilisateur u = utilisateurRepo.findById(idUtilisateur).get();
        Classe c = classeRepo.findById(idClasse).get();

        u.setClasse(c);
        utilisateurRepo.save(u);
    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        int count=0;
        List<Utilisateur> users = utilisateurRepo.findAll();
        for (Utilisateur user : users) {
            if (user.getClasse().getNiveau().equals(nv))count++;
        }
        return count;
    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cc = coursClassroomRepo.findById(idCours).get();
        Classe c = cc.getClasse();
        c.getCoursClassrooms().remove(cc);
        classeRepo.save(c);
        cc.setClasse(null);
        coursClassroomRepo.save(cc);

    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void archiverCoursClassrooms() {
        System.out.println("Archiving");
        List<CoursClassroom>cours=coursClassroomRepo.findAll();
        for (CoursClassroom c : cours) {
            c.setArchive(true);
            coursClassroomRepo.save(c);
        }
    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        int count =0;
        List<Classe> classes=classeRepo.findAll();
        for (Classe c : classes) {
            if(c.getNiveau().equals(nv) ){
                for (CoursClassroom cc : c.getCoursClassrooms()) {
                    if (cc.getSpecialite().equals(sp))count+=cc.getNbHeueres();
                }
            }
        }
        return  count;
    }

}
