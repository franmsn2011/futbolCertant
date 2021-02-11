package maven_jpa.futbol;

import java.util.List;
import java.util.Scanner;

import maven_jpa.futbol.entity.Equipo;
import maven_jpa.futbol.entity.Jugador;
import maven_jpa.futbol.entity.Posicion;
import maven_jpa.futbol.services.ServiceEquipo;
import maven_jpa.futbol.services.ServicePosicion;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		int option = 1;
		while (option != 0) {
			System.out.println("MENU JUGADORES:");
			System.out.println("1 - Agregar Equipo");
			System.out.println("2 - Agregar Jugador");
			System.out.println("3 - Agregar Posicion");
			System.out.println("4 - Modificar Equipo");
			System.out.println("5 - Modificar Jugador");
			System.out.println("6 - Modificar Posicion");
			System.out.println("7 - Traer todos los Equipos");
			System.out.println("8 - Traer todos los Jugadores");
			System.out.println("9 - Traer todas las Posiciones");
			
			System.out.println("- - Ver todo");

			System.out.println("0 - Salir");

			Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
			option = Integer.parseInt(entradaEscaner.nextLine());

			switch (option) {
			case 1:
				try {
					System.out.println(agregarEquipo());

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();
				break;
			case 2:
				try {
					//System.out.println(agregarJugador(listJugador, listEquipos, listPosicion));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 3:
				System.out.println(agregarPosicion());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 4:
				//System.out.println(listEquipos.toString() + listJugador + listPosicion);
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 7:
				System.out.println(traerListaEquipo().toString());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 9:
				System.out.println(traerListaPosicion().toString());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;

			case 0:
				System.out.println("Gracias por usar este programa");
				break;
			default:
				System.out.println("Error ese numero no es una opcion...Vuelva a intentarlo por favor");
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();
			}
		}
		System.out.println("Termino el programa, Gracias por usarlo");

	}

	static String agregarEquipo() {
		String resultado = "";
		Equipo e = pedirDatosEquipo();

		ServiceEquipo se = new ServiceEquipo();
		se.agregarEquipo(e);
		resultado = "Se agrego correctamente";

		return resultado;
	}
	static String agregarPosicion() {
		Posicion p = pedirDatosPosicion();
		ServicePosicion sp= new ServicePosicion();
		sp.agregarPosicion(p);
		return "Se agrego correctamente";
	}

	/*
	 * static String agregarJugador(List<Jugador> listJugador, List<Equipo>
	 * listEquipo, List<Posicion> listPosicion) throws Exception { String resultado
	 * = ""; try {
	 * System.out.println("Ingrese el dni de el jugador que quiera agregar"); int
	 * dni; Scanner entradaEscaner = new Scanner(System.in); // Creación de un
	 * objeto Scanner dni = Integer.parseInt(entradaEscaner.nextLine()); for (int i
	 * = 0; i < listJugador.size(); i++) { if (listJugador.get(i).getDni() == dni) {
	 * resultado = "no se agrega"; throw new
	 * Exception("error no se puede agregar  ese JUGADOR porque ya esta agregado");
	 * }
	 * 
	 * } System.out.println("Ingrese el nombre.: "); String nombre =
	 * entradaEscaner.nextLine(); System.out.println("Ingrese la edad.: "); int edad
	 * = Integer.parseInt(entradaEscaner.nextLine());
	 * System.out.println("Ingrese el estado civil: "); String estadoCivil =
	 * entradaEscaner.nextLine();
	 * System.out.println("Ingrese el nombre del equipo que juega: "); String
	 * nombreEquipo = entradaEscaner.nextLine();
	 * System.out.println("Ingrese la posicion en que juega: "); String
	 * nombrePosicion = entradaEscaner.nextLine();
	 * 
	 * if (traerEquipo(nombreEquipo, listEquipo)== null ||
	 * traerPosicion(nombrePosicion, listPosicion) == null) { throw new
	 * Exception("Estan mal los datos ERROR"); } Jugador j=new Jugador(nombre, dni,
	 * edad, traerPosicion(nombrePosicion, listPosicion), estadoCivil,
	 * traerEquipo(nombreEquipo, listEquipo)); listJugador.add(j); resultado =
	 * "Se agrego correctamente";
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } return
	 * resultado; }
	 */ 
	static int pedirId() {
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		System.out.println("Ingrese id");
		return entradaEscaner.nextInt(); 
	}
 	static Equipo pedirDatosEquipo() {
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		
		Equipo e = new Equipo();
		System.out.println("Ingrese EL id de el Equipo que quiera agregar");

		int id = Integer.parseInt(entradaEscaner.nextLine());

		System.out.println("Ingrese un nombre de el Equipo que quiera agregar");
		String nombre;
		nombre = entradaEscaner.nextLine();

		System.out.println("Ingrese la divicion del Equipo.: ");
		String divicion = entradaEscaner.nextLine();

		e.setDivision(divicion);
		e.setIdEquipo(id);
		e.setNombre(nombre);
		return e;
	}
	static Posicion pedirDatosPosicion() {
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		Posicion p= new Posicion();
		System.out.println("Ingrese EL id de la Posicin que quiera agregar");

		int id = Integer.parseInt(entradaEscaner.nextLine());

		System.out.println("Ingrese un nombre de la Posicion que quiera agregar");
		String nombre;
		nombre = entradaEscaner.nextLine();

		System.out.println("Ingrese true si la posicion es adelanta y false si es atrasada: ");
		boolean adelantado = entradaEscaner.nextBoolean();

		p.setIdPosicion(id);
		p.setNombre(nombre);
		p.setAtrasadoAdelantado(adelantado);
		return p;
	}
	static Equipo traerEquipo() {
		ServiceEquipo se = new ServiceEquipo();
		return se.traerEquipo(pedirId());
	}
	static List<Equipo> traerListaEquipo(){
		ServiceEquipo se = new ServiceEquipo();
		return se.TraerEquipos();
	}
	static List<Posicion> traerListaPosicion(){
		ServicePosicion sp= new ServicePosicion();
		return sp.traerPosiciones();
	}
	static Posicion traerPosicion() {
		ServicePosicion sp =new ServicePosicion();
		return sp.traerPosicion(pedirId());
	}
	
	/*
	static Posicion traerPosicion(String nombre, List<Posicion> listPosicion) {
		Posicion p = null;
		int index = 0;
		while (index < listPosicion.size() && p == null) {

			if (listPosicion.get(index).getNombre().equalsIgnoreCase(nombre)) {
				p = listPosicion.get(index);
			}
			index++;
		}
		return p;
	}
}*/
}
