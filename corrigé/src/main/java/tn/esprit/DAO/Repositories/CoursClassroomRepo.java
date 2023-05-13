package tn.esprit.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.DAO.Entities.CoursClassroom;

public interface CoursClassroomRepo extends JpaRepository<CoursClassroom, Integer> {
}
