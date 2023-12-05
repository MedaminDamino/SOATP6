package web;

import entities.Compte;
import entities.EtatCompte;
import entities.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CompteRepository;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repositories")
@EntityScan(basePackages = "entities")
public class MohamedAminAbdelkafiLsi3SoaTp6Application {

    public static void main(String[] args) {
        SpringApplication.run(MohamedAminAbdelkafiLsi3SoaTp6Application.class, args);
    }
    @Bean
    public CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            // Ajoutez des comptes initiaux à la base de données
          /*  Compte compteEpargne1 = new Compte(null, 11, new Date(), TypeCompte.EPARGNE, EtatCompte.ACTIVE);
            Compte compteEpargne2 = new Compte(TypeCompte.EPARGNE, 1500.0);
            Compte compteCourant = new Compte(TypeCompte.COURANT, 2000.0); */
            compteRepository.save(new Compte(null,300.20,new Date(),TypeCompte.EPARGNE,EtatCompte.ACTIVE));
            compteRepository.save(new Compte(null,50.20,new Date(),TypeCompte.EPARGNE,EtatCompte.ACTIVE));
            compteRepository.save(new Compte(null,7593.20,new Date(),TypeCompte.EPARGNE,EtatCompte.ACTIVE));


           /* compteRepository.save(compteEpargne1);
            compteRepository.save(compteEpargne2);
            compteRepository.save(compteCourant);
*/
            // Affichez les soldes des comptes
            System.out.println("Soldes des comptes :");
            Iterable<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes) {
                System.out.println("Solde: " + compte.getSolde());
            }
        };
    }
}

