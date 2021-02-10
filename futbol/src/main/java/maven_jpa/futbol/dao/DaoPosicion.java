package maven_jpa.futbol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import exception.PosicionExistenteException;
import exception.PosicionInexistenteException;
import exception.PosicionNoExistenteException;
import maven_jpa.futbol.entity.Posicion;

public class DaoPosicion {
	public Posicion savePosicion(Posicion posicion) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		if (!estaPosicion(posicion.getIdPosicion())) {
			try {
				em.getTransaction().begin();
				em.persist(posicion);
				em.getTransaction().commit();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			throw new PosicionExistenteException("ERROR: No se puede agregar porque ya hay una Posicion con ese id");
		}

		em.close();
		return posicion;
	}

	public boolean estaPosicion(int idPosicion) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Posicion> q = em.createQuery("SELECT p FROM Posicion p " + "WHERE p.idPosicion =" + idPosicion + "",
				Posicion.class);
		boolean res = false;
		if (q.getResultList().size() > 0)
			res = true;
		return res;
	}

	// trae las posiciones con ese nombre
	public List<Posicion> findPosicion(String nombre) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Posicion> q = em.createQuery("SELECT p FROM Posicion p " + "WHERE p.nombre ='" + nombre + "'",
				Posicion.class);
		return q.getResultList();
	}

	// trae las Equipo con ese nombre
	public Posicion findPosicion(int idPosicion) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Posicion> q = em.createQuery("SELECT p FROM Posicion p " + "WHERE p.idPosicion =" + idPosicion + "",
				Posicion.class);
		if (!estaPosicion(idPosicion)) {
			return null;
		}
		return q.getResultList().get(0);
	}

	// trae todas las posiciones;
	public List<Posicion> findTodasLasPosicion() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Posicion> q = em.createQuery("SELECT p FROM Posicion p", Posicion.class);
		return q.getResultList();
	}

	// borra la posicion que le digamos
	public void borrarPosicion(Posicion p) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Posicion p2= em.find(Posicion.class, p.getIdPosicion());
		if(p2==null) {
			throw new PosicionNoExistenteException("ERROR: NO SE PUEDE BORRAR ESE JUGADOR PORQUE YA NO ESTABA EN LA BASE DE DATOS");
		}
		try {
			em.getTransaction().begin();
			em.remove(em.merge(p));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void modificarPosicion(Posicion posicion) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		if(em.find(Posicion.class, posicion.getIdPosicion())==null) {
			throw new PosicionInexistenteException("ERROR: no se puede modificar esa posicion porque no existe");
		}
		Posicion p = em.find(Posicion.class, posicion.getIdPosicion());
		em.close();
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);
		p.setNombre(posicion.getNombre());
		p.setAtrasadoAdelantado(posicion.isAtrasadoAdelantado());
		em.getTransaction().commit();
		em.close();
	}
}
