package maven_jpa.futbol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import exception.EstadoCivilException;
import exception.JugadorExistenteException;
import exception.JugadorInexistenteException;
import maven_jpa.futbol.entity.Jugador;

public class DaoJugador {
	public Jugador saveJugador(Jugador jugador) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		if (estaElJugador(jugador.getDni()) == false) {
			try {int id=0;
				if(findTodasLosJugadores().size()>0) {
				id=findTodasLosJugadores().get(findTodasLosJugadores().size()-1).getIdjugador()+1;
			}
				jugador.setIdjugador(id);
				em.getTransaction().begin();
				System.out.println("agregoooo\n--");
				em.persist(jugador);
				em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else {System.out.println("acaERRORRRR");
			throw new JugadorExistenteException("ERROR:Ese Jugador ya esta en base de datos ");
		}
		em.close();
		return jugador;
	}

	public boolean estaElJugador(int dni) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Jugador> q = em.createQuery("SELECT j FROM Jugador j " + "WHERE j.dni =" + dni + "", Jugador.class);
		boolean res = false;
		if (q.getResultList().size() > 0)
			res = true;
		return res;
	}

	// trae las Jugador con ese nombre
	public List<Jugador> findJugador(int dni) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Jugador> q = em.createQuery("SELECT j FROM Jugador j " + "WHERE p.dni =" + dni + "", Jugador.class);
		return q.getResultList();
	}

	// traer un Jugador con ese nombre;
	public Jugador findUnJugador(int dni) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Jugador> q = em.createQuery("SELECT j FROM Jugador j " + "WHERE j.dni =" + dni, Jugador.class);
		if (!estaElJugador(dni)) {
			return null;
		}
		return q.getResultList().get(0);
	}

	// trae todas las posiciones;
	public List<Jugador> findTodasLosJugadores() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		TypedQuery<Jugador> q = em.createQuery("SELECT j FROM Jugador j", Jugador.class);
		return q.getResultList();
	}

	// borra la posicion que le digamos
	public void borrarJugador(Jugador j) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Jugador j2 = em.find(Jugador.class, j.getIdjugador());
		if (j2 == null) {
			throw new JugadorInexistenteException("ERROR: No se puede borrar porque ese jugador no existe");
		}
		try {
			em.getTransaction().begin();
			em.remove(em.merge(j));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void modificarJugador(Jugador jugador) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Jugador j = findUnJugador(jugador.getDni());
		if (j == null) {
			throw new JugadorInexistenteException("ERROR: No se puede modificar porque ese jugador no existe");
		}
		if (jugador.getEstadoCivil().equalsIgnoreCase("Viudo") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Divorciado") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Soltero") == true
				|| jugador.getEstadoCivil().equalsIgnoreCase("Casado") == true) {
		} else {
			throw new EstadoCivilException("ERROR: No se puede modificar porque ese estado Civil es invalido");

		}
		em.close();
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		j = em.merge(j);
		j.setNombre(jugador.getNombre());
		j.setEdad(jugador.getEdad());
		//j.setEquipo(jugador.getEquipo());
		j.setEstadoCivil(jugador.getEstadoCivil());
		//j.setPosicion(jugador.getPosicion());
		em.getTransaction().commit();
		em.close();
	}
}
