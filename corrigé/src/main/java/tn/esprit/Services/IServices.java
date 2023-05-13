package tn.esprit.Services;

import tn.esprit.DAO.Entities.*;

public interface IServices {
    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur);
    public Classe ajouterClasse (Classe c);
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer idClasse);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer idClasse);

    public Integer nbUtilisateursParNiveau(Niveau nv);

    public void desaffecterCoursClassroomClasse(Integer idCours);

    public void archiverCoursClassrooms();


    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);


}
