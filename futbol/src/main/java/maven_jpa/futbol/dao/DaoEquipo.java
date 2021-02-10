package maven_jpa.futbol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import exception.EquipoExistenteException;
import exception.EquipoInexistenteException;
import exception.EquipoNoExistenteException;
import maven_jpa.futbol.entity.Equipo;

public class DaoEquipo {
	public Equipo saveEquipo(Equipo equipo){
		EntityManager em = EntityManagerUtil.getEntityManager();
		if (estaElEquipo(equipo.getIdEquipo()) == false) {
			System.out.println("agrego");
			try {
				em.getTransaction().begin();
				em.persist(equipo);
				em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			throw new EquipoExistenteException("tiro excepcion porque el equipo ya esta en la database");
		}
		em.close();
		return equipo;
	}

	// trae las Equipo con ese nombre
	public List<Equipo> findEquipo(String nombre) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Equipo> q = em.createQuery("SELECT e FROM Equipo e " + "WHERE e.nombre ='" + nombre + "'",
				Equipo.class);
		return q.getResultList();
	}

	public Equipo findEquipo(int idEquipo) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Equipo> q = em.createQuery("SELECT e FROM Equipo e " + "WHERE e.idEquipo =" + idEquipo + "",
				Equipo.class);
		if (!estaElEquipo(idEquipo)) {
			return null;
		}
		return q.getResultList().get(0);
	}

	public boolean estaElEquipo(int idEquipo) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Equipo> q = em.createQuery("SELECT e FROM Equipo e " + "WHERE e.idEquipo =" + idEquipo + "",
				Equipo.class);
		boolean res = false;
		if (q.getResultList().size() > 0)
			res = true;
		return res;
	}

	// trae todas los Equipo;
	public List<Equipo> findTodasLosEquipo() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Equipo> q = em.createQuery("SELECT e FROM Equipo e", Equipo.class);
		return q.getResultList();
	}

	// borra la Equipo que le digamos
	public void borrarEquipo(Equipo e) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		if(em.find(Equipo.class, e.getIdEquipo())==null) {
			throw new EquipoNoExistenteException("ERROR: NO SE PUEDE BORRAR ESE Equipo PORQUE YA NO ESTABA EN LA BASE DE DATOS");
		}
		try {
			em.getTransaction().begin();
			em.remove(em.merge(e));
			em.getTransaction().commit();
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void modificarEquipo(Equipo equipo) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		if(em.find(Equipo.class, equipo.getIdEquipo())==null) {
			throw new EquipoInexistenteException("ERROR: NO SE PUEDE modificar ESE Equipo PORQUE no esta");
		}
		Equipo e = em.find(Equipo.class, equipo.getIdEquipo());
		em.close();
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		e = em.merge(e);
		e.setDivision(equipo.getDivision());
		e.setNombre(equipo.getNombre());
		em.getTransaction().commit();
		em.close();
	}
}
