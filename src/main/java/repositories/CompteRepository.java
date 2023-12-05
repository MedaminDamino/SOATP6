package repositories;

import entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
//@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

}
