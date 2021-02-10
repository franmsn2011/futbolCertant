package maven_jpa.futbol;

import static org.junit.Assert.assertEquals;

import exception.EquipoExistenteException;
import exception.EquipoInexistenteException;
import exception.EquipoNoExistenteException;
import maven_jpa.futbol.dao.DaoEquipo;
import maven_jpa.futbol.entity.Equipo;
import maven_jpa.futbol.services.ServiceEquipo;

public class TestEquipos {

	@org.junit.Test
	public void insertEquipo() {
		System.out.println("TEST INSERTARR");
		ServiceEquipo se = new ServiceEquipo();
		Equipo e = new Equipo();
		e.setIdEquipo(2);
		e.setDivision("primera");
		e.setNombre("RACING");
		System.out.println(se.TraerEquipos());

		Equipo e2 = se.agregarEquipo(e);
		se.borrarEquipo(e);
		assertEquals(e.getIdEquipo(), e2.getIdEquipo());
	}

	@org.junit.Test(expected = EquipoExistenteException.class)
	public void insertEquipoEquipoExistenteException() {
		System.out.println("TEST INSERTAR");
		ServiceEquipo se = new ServiceEquipo();
		Equipo e = new Equipo();
		e.setIdEquipo(1);
		e.setDivision("primera");
		e.setNombre("RACING");
		se.agregarEquipo(e);
	}

	@org.junit.Test
	public void traerEquipo() {
		ServiceEquipo se = new ServiceEquipo();
		Equipo e = se.traerEquipo(1);
		assertEquals(e.getIdEquipo(), (int) 1L);
	}

	@org.junit.Test
	public void borrarEquipo() {
		System.out.println("TEST BORRAR EQUIPO");
		ServiceEquipo se = new ServiceEquipo();
		Equipo equipo = new Equipo(10, "Banfield", "Primera");
		se.agregarEquipo(equipo);
		se.borrarEquipo(equipo);
		DaoEquipo e = new DaoEquipo();
		assertEquals(e.estaElEquipo(10), false);
	}

	@org.junit.Test(expected = EquipoNoExistenteException.class)
	public void borrarEquipoEquipoNoExistenteException() {
		System.out.println("TEST BORRAR EQUIPO");
		ServiceEquipo se = new ServiceEquipo();
		Equipo equipo = new Equipo(20, "Banfield", "Primera");
		se.borrarEquipo(equipo);
	}

	@org.junit.Test
	public void traerTodosLosEquipos() {
		ServiceEquipo se = new ServiceEquipo();
		System.out.println(se.TraerEquipos());
		assertEquals(se.TraerEquipos().get(0).getIdEquipo(), (int) 1L);
	}

	@org.junit.Test
	public void modificarEquipo() {
		System.out.println("__5_Modificar");
		ServiceEquipo se = new ServiceEquipo();
		// Agrego un Equipo cualquiera
		Equipo e1 = new Equipo();
		e1.setIdEquipo(15);
		e1.setDivision("Segunda");
		e1.setNombre("Boca unidos");
		Equipo e2 = se.agregarEquipo(e1);
		// modifico el segundo Equipo para modificarlo
		e2.setNombre("Boquita");
		se.modificarEquipo(e2);
		se.borrarEquipo(e1);
		// Hago dao jugador para comprobar que este funcionando
		assertEquals(e1.getNombre(), e2.getNombre());
	}

	@org.junit.Test(expected = EquipoInexistenteException.class)
	public void modificarEquipoEquipoInexistenteException() {
		System.out.println("__5_Modificar");
		ServiceEquipo se = new ServiceEquipo();
		// Agrego un Equipo cualquiera
		Equipo e1 = new Equipo();
		e1.setIdEquipo(15);
		e1.setDivision("Segunda");
		e1.setNombre("Boca unidos");
		// modifico el segundo Equipo para modificarlo
		se.modificarEquipo(e1);
		se.borrarEquipo(e1);
	}

}
