import BusinessObjects.Bahnhof;
import BusinessObjects.Benutzer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class.getName());
    private static long BAHNHOF_ID = 1L;

    public static void main(String[] args) {
        logger.info("Starting EntityManagerFactory..");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("westbahn");
        EntityManager entityManager = factory.createEntityManager();


        createStations(entityManager);
        createUsers(entityManager);
        update(entityManager);
        remove(entityManager);

        entityManager.close();
        factory.close();
        logger.info("Finished!");
    }

    private static void createStations(EntityManager entityManager) {
        Bahnhof spittelau = new Bahnhof();
        spittelau.setName("Wien Spittelau");
        create(entityManager, spittelau);
        BAHNHOF_ID = spittelau.getID();

        String[] names = new String[]{"Wien Westbhf", "Wien Hütteldorf", "St. Pölten", "Amstetten", "Linz", "Wels", "Attnang-Puchheim", "Salzburg"};
        for (String name : names){
            Bahnhof bahnhof = new Bahnhof();
            bahnhof.setName(name);
            bahnhof.setAbsKmEntfernung((int)(Math.random() * 1000));
            bahnhof.setAbsPreisEntfernung((int)(Math.random() * 1000));
            bahnhof.setAbsZeitEntfernung((int)(Math.random() * 1000));
            create(entityManager, bahnhof);
        }
    }

    private static void createUsers(EntityManager entityManager) {
        String[] names = new String[]{"Marc", "Max", "David", "Mike"};
        for (String name : names){
            Benutzer benutzer = new Benutzer();
            benutzer.setVorName(name);
            benutzer.setNachName("?");
            benutzer.seteMail(name + "@gmail.com");
            benutzer.setPasswort("123");
            benutzer.setSmsNummer("+431234");
            create(entityManager, benutzer);
        }
    }

    private static void create(EntityManager entityManager, Object object) {
        logger.info("Creating " + object.toString() + "..");
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        logger.info(object.toString() + " created!");
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
