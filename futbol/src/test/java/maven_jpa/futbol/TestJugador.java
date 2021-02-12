package maven_jpa.futbol;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.EstadoCivilException;
import exception.JugadorExistenteException;
import exception.JugadorInexistenteException;
import maven_jpa.futbol.dao.DaoJugador;
import maven_jpa.futbol.entity.Jugador;
import maven_jpa.futbol.services.ServiceEquipo;
import maven_jpa.futbol.services.ServiceJugador;
import maven_jpa.futbol.services.ServicePosicion;

public class TestJugador {

	@org.junit.Test
	public void insertJugadorOk() {
		ServiceJugador sj = new ServiceJugador();
		Jugador j = new Jugador();
		j.setDni(12358328);
		j.setEdad(20);
		ServiceEquipo se = new ServiceEquipo();
		j.setEquipo(se.traerEquipo(1));
		j.setEstadoCivil("Soltero");
		j.setNombre("Franco");
		System.out.println("a");
		Jugador j2 = sj.agregarJugador(j);
		
		System.out.println("//jugadores\n" + sj.traerJugadores() + "//");
		System.out.println("s");
		ServicePosicion sp = new ServicePosicion();
		j2.setEdad(12);
		sj.borrarJugador(j);
		System.out.println("muestro");
		System.out.println("//jugadores\n" + sj.traerJugadores() + "//");
		
		assertEquals(j.getIdjugador(), j2.getIdjugador());
	}

	@org.junit.Test(expected = JugadorExistenteException.class)
	public void insertJugadorExistente() {
		ServiceJugador sj = new ServiceJugador();
		Jugador j = new Jugador();
		j.setDni(233458889);
		j.setEdad(20);
		// ServiceEquipo se = new ServiceEquipo();
		// j.setEquipo(se.traerEquipo(6));
		j.setEstadoCivil("Soltero");
		// j.setIdjugador(2);
		j.setNombre("Franco");
		// ServicePosicion sp = new ServicePosicion();
		// j.setPosicion(sp.traerPosicion(1));
		sj.agregarJugador(j);
		System.out.println(sj.traerJugador(233458889));
		System.out.println("//jugadores\n" + sj.traerJugadores() + "//");
	}

	@org.junit.Test
	public void traerJugador() {
		ServiceJugador se = new ServiceJugador();
		Jugador j = se.traerJugador(12345678);
		System.out.println(se.traerJugador(12345678));
		assertEquals(j.getIdjugador(), (int) 1L);
	}

	@org.junit.Test
	public void traerTodasLosJugadores() {
		ServiceJugador sj = new ServiceJugador();
		System.out.println("Muestro todas las");
		System.out.println("//jugadores\n" + sj.traerJugadores() + "//");
		assertEquals(sj.traerJugadores().get(0).getIdjugador(), (int) 1L);
	}

	@org.junit.Test(expected = JugadorInexistenteException.class)
	public void borrarJugador() {
		System.out.println("TEST BORRAR JUGADOR");
		ServiceJugador sj = new ServiceJugador();
		Jugador j = new Jugador();
		j.setDni(11132222);
		j.setEdad(20);
		ServiceEquipo se = new ServiceEquipo();
		j.setEquipo(se.traerEquipo(1));
		j.setEstadoCivil("Soltero");
		// j.setIdjugador(31);
		j.setNombre("Franco");
		ServicePosicion sp = new ServicePosicion();
		j.setPosicion(sp.traerPosicion(1));
		// Jugador j2 = sj.agregarJugador(j);

		sj.borrarJugador(j);

		assertEquals(null, sj.traerJugador(j.getDni()));
	}

	@org.junit.Test
	public void borrarJugadorOk() {
		System.out.println("TEST BORRAR JUGADOR");
		ServiceJugador sj = new ServiceJugador();
		Jugador j = new Jugador();
		j.setDni(11114333);
		j.setEdad(20);
		ServiceEquipo se = new ServiceEquipo();
		j.setEquipo(se.traerEquipo(1));
		j.setEstadoCivil("Soltero");
		// j.setIdjugador(3);
		j.setNombre("Franco");
		ServicePosicion sp = new ServicePosicion();
		j.setPosicion(sp.traerPosicion(1));
		sj.agregarJugador(j);
		sj.borrarJugador(j);

		assertEquals(null, sj.traerJugador(j.getDni()));
	}

	@Test
	public void modificarJugador() {
		System.out.println("__5_Modificar ok");
		ServiceJugador sj = new ServiceJugador();
		// Agrego un jugador cualquiera
		Jugador j1 = new Jugador();
		j1.setDni(11113344);
		j1.setEdad(20);
		ServiceEquipo se = new ServiceEquipo();
		j1.setEquipo(se.traerEquipo(1));
		j1.setEstadoCivil("Soltero");
		// j1.setIdjugador(3);
		j1.setNombre("Franco");
		ServicePosicion sp = new ServicePosicion();
		j1.setPosicion(sp.traerPosicion(1));
		Jugador j2 = sj.agregarJugador(j1);
		// modifico el segundo jugador para modificarlo
		j2.setEstadoCivil("Divorciado");

		sj.modificarJugador(j2);
		// Hago dao jugador para comprobar que este funcionando
		DaoJugador dj = new DaoJugador();
		String ec = dj.findUnJugador(11113344).getEstadoCivil();
		sj.borrarJugador(j1);
		assertEquals(ec, j1.getEstadoCivil());
	}

	@Test(expected = JugadorInexistenteException.class)
	public void modificarJugadorExceptionJugadorInexistente() {
		System.out.println("__5_Modificar jugador inexistente");
		ServiceJugador sj = new ServiceJugador();
		// Agrego un jugador cualquiera
		Jugador j1 = new Jugador();
		j1.setDni(1111223222);
		j1.setEdad(20);
		ServiceEquipo se = new ServiceEquipo();
		j1.setEquipo(se.traerEquipo(1));
		j1.setEstadoCivil("Soltero");
		j1.setIdjugador(30);
		j1.setNombre("Franco");
		ServicePosicion sp = new ServicePosicion();
		j1.setPosicion(sp.traerPosicion(1));
		j1.setEstadoCivil("Casado");
		sj.modificarJugador(j1);
	}

	@Test(expected = EstadoCivilException.class)
	public void modificarJugadorExceptionEstadoCivil() {
		System.out.println("__5_Modificar exception estado civil");
		ServiceJugador sj = new ServiceJugador();
		// Agrego un jugador cualquiera
		Jugador j1 = new Jugador();
		j1.setDni(11113333);
		j1.setEdad(20);
		ServiceEquipo se = new ServiceEquipo();
		j1.setEquipo(se.traerEquipo(1));
		j1.setEstadoCivil("ninguno");
		j1.setIdjugador(3);
		j1.setNombre("Franco");
		ServicePosicion sp = new ServicePosicion();
		j1.setPosicion(sp.traerPosicion(1));

		sj.modificarJugador(j1);
	}

}
