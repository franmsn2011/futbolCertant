package maven_jpa.futbol;

import java.util.List;
import java.util.Scanner;

import maven_jpa.futbol.entity.Equipo;
import maven_jpa.futbol.entity.Jugador;
import maven_jpa.futbol.entity.Posicion;
import maven_jpa.futbol.services.ServiceEquipo;
import maven_jpa.futbol.services.ServiceJugador;
import maven_jpa.futbol.services.ServicePosicion;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			System.out.println("9 - Traer todas las posiciones");
			System.out.println("10 - Borrar Equipo");
			System.out.println("11 - Borrar Jugador");
			System.out.println("12 - Borrar Posicion");

			System.out.println("- - Ver todo");

			System.out.println("0 - Salir");

			Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
			option = Integer.parseInt(entradaEscaner.nextLine());

			switch (option) {
			case 1:try {
				System.out.println(agregarEquipo());
				
			} catch (Exception e) {
				e.getMessage();
			}
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();
				break;
			case 2:

				System.out.println(agregarJugador());

				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 3:
				System.out.println(agregarPosicion());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 4:
					modificarEquipo();
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 5:
				modificarJugador();
			System.out.println("Presione una tecla para continuar...");
			new java.util.Scanner(System.in).nextLine();

			break;
			case 6:
				modificarPosicion();
			System.out.println("Presione una tecla para continuar...");
			new java.util.Scanner(System.in).nextLine();
			break;
			case 7:
				System.out.println(traerListaEquipo().toString());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 8:
				System.out.println(traerListaJugador().toString());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();

				break;
			case 9:
				System.out.println(traerListaPosicion().toString());
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();
				
				break;
			case 10:
				borrarEquipo();
				System.out.println("Presione una tecla para continuar...");
				new java.util.Scanner(System.in).nextLine();
				
				break;
			case 11:
				 borrarJugador();
				 System.out.println("Presione una tecla para continuar...");
					new java.util.Scanner(System.in).nextLine();
					
				 break;
			case 12:
				borrarPosicion();
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

	// Agregar
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
		ServicePosicion sp = new ServicePosicion();
		sp.agregarPosicion(p);
		return "Se agrego correctamente";
	}

	static String agregarJugador() {
		Jugador j = pedirDatosJugador();
		ServiceJugador sj = new ServiceJugador();
		sj.agregarJugador(j);
		return "Se agrego Correctamente";
	}

	// Piden los datos
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
		Posicion p = new Posicion();
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

	static Jugador pedirDatosJugador() {
		Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
		Jugador j = new Jugador();
		System.out.println("Ingrese el nombre");
		String nombre = entradaEscaner.nextLine();
		System.out.println("Ingrese dni");
		int dni = entradaEscaner.nextInt();
		System.out.println("Ingrese edad");
		int edad = entradaEscaner.nextInt();
		System.out.println("Ingrese estado civil");
		String estadoCivil = entradaEscaner.nextLine();
		System.out.println("Su jugador ya tiene un Equipo\n" + "1_Si" + "2_No");
		int opcion = entradaEscaner.nextInt();
		/*
		if (opcion == 1) {
			j.setEquipo(traerEquipo());
		}
		System.out.println("Ingrese el id De la posicion de el jugador ");
		System.out.println("Estos son los id posibles" + traerListaPosicion().toString());
		j.setPosicion(traerPosicion());
		j.setDni(dni);
		*/
		j.setEdad(edad);
		j.setNombre(nombre);
		j.setEstadoCivil(estadoCivil);
		return j;
	}

	// Traer
	static Equipo traerEquipo() {
		ServiceEquipo se = new ServiceEquipo();
		return se.traerEquipo(pedirId());
	}

	static Jugador traerJugador() {
		ServiceJugador sj = new ServiceJugador();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el dni de el jugador que quiera traer");
		return sj.traerJugador(entrada.nextInt());
	}

	static Posicion traerPosicion() {
		ServicePosicion sp = new ServicePosicion();
		return sp.traerPosicion(pedirId());
	}

	static List<Equipo> traerListaEquipo() {
		ServiceEquipo se = new ServiceEquipo();
		return se.TraerEquipos();
	}

	static List<Jugador> traerListaJugador() {
		ServiceJugador sj = new ServiceJugador();
		return sj.traerJugadores();
	}

	static List<Posicion> traerListaPosicion() {
		ServicePosicion sp = new ServicePosicion();
		return sp.traerPosiciones();
	}

	// Borrar
	static void borrarEquipo() {
		ServiceEquipo se = new ServiceEquipo();
		se.borrarEquipo(pedirDatosEquipo());
	}

	static void borrarJugador() {
		ServiceJugador sj = new ServiceJugador();
		sj.borrarJugador(pedirDatosJugador());
	}

	static void borrarPosicion() {
		ServicePosicion sp = new ServicePosicion();
		sp.borrarPosicion(pedirDatosPosicion());
	}

	// modificar
	static void modificarEquipo() {
		ServiceEquipo se = new ServiceEquipo();
		se.modificarEquipo(pedirDatosEquipo());
	}

	static void modificarJugador() {
		ServiceJugador sj = new ServiceJugador();
		sj.modificarJugador(pedirDatosJugador());
	}

	static void modificarPosicion() {
		ServicePosicion sp = new ServicePosicion();
		sp.modificarPosicion(pedirDatosPosicion());
	}
}