import BusinessObjects.Bahnhof;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // TODO: DAL
        logger.info("Starting EntityManagerFactory..");
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("westbahn");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Bahnhof bahnhof = new Bahnhof();
        bahnhof.setName("Wien Spittelau");

        entitymanager.persist(bahnhof);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        logger.info("Finished!");
    }
}
