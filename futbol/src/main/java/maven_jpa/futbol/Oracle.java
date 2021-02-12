package maven_jpa.futbol;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import maven_jpa.futbol.dao.EntityManagerUtil;
import maven_jpa.futbol.entity.Equipo;

public class Oracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola mundo");
		EntityManager em = EntityManagerUtil.getEntityManager();
		System.out.println("as");
		//TypedQuery<Equipo> q = em.createQuery("SELECT p FROM POSICION p ",
			//	Equipo.class);
		//System.out.println( q.getResultList().toString());
	}

}
