import BusinessObjects.Bahnhof;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    private static final long BAHNHOF_ID = 1L;

    public static void main(String[] args) {
        logger.info("Starting EntityManagerFactory..");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("westbahn");
        EntityManager entityManager = factory.createEntityManager();

        create(entityManager);
        update(entityManager);
        remove(entityManager);

        entityManager.close();
        factory.close();
        logger.info("Finished!");
    }

    private static void create(EntityManager entityManager) {
        logger.info("Creating Bahnhof Spittelau..");
        entityManager.getTransaction().begin();
        Bahnhof bahnhof = new Bahnhof();
        bahnhof.setName("Wien Spittelau");
        entityManager.persist(bahnhof);
        entityManager.getTransaction().commit();
        logger.info("Bahnhof Spittelau created!");
    }

    private static void update(EntityManager entityManager) {
        logger.info("Updating Bahnhof Spittelau -> Heiligenstadt..");
        entityManager.getTransaction().begin();
        Bahnhof bahnhof = entityManager.find(Bahnhof.class, BAHNHOF_ID);
        bahnhof.setName("Wien Heiligenstadt");
        entityManager.flush();
        entityManager.getTransaction().commit();
        logger.info("Bahnhof Spittelau updated to Heiligenstadt!");
    }

    private static void remove(EntityManager entityManager) {
        logger.info("Removing Bahnhof Heiligenstadt..");
        entityManager.getTransaction().begin();
        Bahnhof bahnhof = entityManager.find(Bahnhof.class, BAHNHOF_ID);
        entityManager.remove(bahnhof);
        entityManager.flush();
        entityManager.getTransaction().commit();
        logger.info("Bahnhof Heiligenstadt removed!");
    }
}
