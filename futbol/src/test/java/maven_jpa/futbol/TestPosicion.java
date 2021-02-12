package maven_jpa.futbol;

import static org.junit.Assert.assertEquals;

import exception.PosicionExistenteException;
import exception.PosicionInexistenteException;
import exception.PosicionNoExistenteException;
import maven_jpa.futbol.dao.DaoPosicion;
import maven_jpa.futbol.entity.Posicion;
import maven_jpa.futbol.services.ServicePosicion;

public class TestPosicion {

	@org.junit.Test
	public void insertPosicionOk() {
		System.out.println("__1");
		ServicePosicion sp = new ServicePosicion();
		Posicion p = new Posicion();
		p.setIdPosicion(7);
		p.setNombre("defensor");
		p.setAtrasadoAdelantado(true);
		System.out.println(sp.traerPosiciones());

		Posicion p2 = sp.agregarPosicion(p);
		sp.borrarPosicion(p);
		System.out.println(sp.traerPosiciones());

		assertEquals(p.getIdPosicion(), p2.getIdPosicion());
	}

	@org.junit.Test(expected = PosicionExistenteException.class)
	public void insertPosicionPosicionExistente() {
		System.out.println("__1");
		ServicePosicion sp = new ServicePosicion();
		Posicion p = new Posicion();
		p.setIdPosicion(1);
		p.setNombre("defensor");
		p.setAtrasadoAdelantado(true);
		Posicion p2 = sp.agregarPosicion(p);
		assertEquals(p.getIdPosicion(), p2.getIdPosicion());
	}

	
	
	
	@org.junit.Test
	public void traerPosicion() {
		ServicePosicion s = new ServicePosicion();
		Posicion p = s.traerPosicion(1);
		assertEquals(p.getIdPosicion(), (int) 1L);
	}

	@org.junit.Test
	public void traerTodasLasPosicion() {
		ServicePosicion s = new ServicePosicion();
		System.out.println(s.traerPosiciones());
		assertEquals(s.traerPosiciones().get(0).getIdPosicion(), (int) 1L);
	}

	@org.junit.Test
	public void borrarPosicionok() {
		System.out.println("__4");
		ServicePosicion s = new ServicePosicion();
		Posicion p = new Posicion(7, "Delantero", true);
		s.agregarPosicion(p);
		s.borrarPosicion(p);

		DaoPosicion dp = new DaoPosicion();

		assertEquals(dp.estaPosicion(7), false);
	}

	@org.junit.Test(expected = PosicionNoExistenteException.class)
	public void borrarPosicionPosicionNoExistenteException() {
		System.out.println("__4");
		ServicePosicion s = new ServicePosicion();
		Posicion p = new Posicion(9, "Delantero", true);
		s.borrarPosicion(p);
	}

	@org.junit.Test
	public void modificarPosicionok() {
		System.out.println("__5_Modificar");
		ServicePosicion s = new ServicePosicion();
		Posicion p = new Posicion(11, "river", false);
		Posicion p2 = new Posicion(11, "Boca", true);

		s.agregarPosicion(p);
		DaoPosicion dp = new DaoPosicion();
		s.modificarPosicion(p2);
		String nombre = dp.findPosicion(11).getNombre();
		s.borrarPosicion(p);
		assertEquals(nombre, p2.getNombre());
	}

	@org.junit.Test(expected = PosicionInexistenteException.class)
	public void modificarPosicionPosicionInexistenteException() {
		System.out.println("__5_Modificar");
		ServicePosicion s = new ServicePosicion();
		Posicion p = new Posicion(12, "river", false);
		s.modificarPosicion(p);
		System.out.println("Modificada\n" + s.traerPosiciones());

		s.borrarPosicion(p);

	}

}
