package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.DAO.Entities.Classe;

public interface ClasseRepo extends JpaRepository<Classe, Integer> {
}
