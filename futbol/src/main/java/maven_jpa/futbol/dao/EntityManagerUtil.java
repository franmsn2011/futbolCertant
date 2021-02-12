package maven_jpa.futbol.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	// USE THE SAME NAME IN persistence.xml!
	public static final String PERSISTENCE_UNIT_NAME = "FutbolPU";

	private static EntityManager entityManager;

	private EntityManagerUtil() {
	}

	public static EntityManager getEntityManager() {

		if (entityManager == null) {
			// the same in persistence.xml
			System.out.println("se crea coneccion..");
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			System.out.println("exitosa");
			return emFactory.createEntityManager();
		}
		return entityManager;
	}
}
