package ar.edu.unju.fi.ejercicio04.main;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.contantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;


public class Main {

	public static void main(String[] args) {
		int opcion=0;
		Scanner scanner = new Scanner(System.in);
		List<Jugador> plantel = new ArrayList<Jugador>();

		do {
			System.out.println("--- MENU ---");
			System.out.println("1 – Alta de jugador");
			System.out.println("2 – Mostrar los datos del jugador ");
			System.out.println("3 – Mostrar todos los jugadores ordenados por apellido.");
			System.out.println("4 – Modificar los datos de un jugador");
			System.out.println("5 – Eliminar un jugador");
			System.out.println("6 – Mostrar la cantidad total de jugadores que tiene el ArrayList.");
			System.out.println("7 – Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
			System.out.println("8 – Salir");
			System.out.println("Ingrese opcion: ");
			opcion=scanner.nextInt();

			switch(opcion) {
			case 1:
				plantel.add(crearJugador());
				break;
			case 2:
				buscarJugador(plantel);
				break;
			case 3:
				ordenarApellido(plantel);
				break;
			case 4:
				modificarJugador(plantel);
				mostrarArray(plantel);
				break;
			case 5:
				eliminarJugador(plantel);
				mostrarArray(plantel);
				break;
			case 6:
				mostrarArray(plantel);
				contarArray(plantel);
				break;
			case 7:
				nacionalidadJugador(plantel);
				break;
			case 9:
				mostrarArray(plantel);
				break;
			case 8:
				System.out.println("Adios");
				break;
			default:
				System.out.println("ERROR");
			}

		}while(opcion!=8);

	}

	// 1 - alta Jugador 
	public static Jugador crearJugador() {
		int anio=0;
		int mes=0;
		int dia=0;
		int pos;
		Posicion posi = null;
		Double altura=0.;
		Double peso=0.;
		boolean correcto=false;
		boolean fechaCorrecta=false;
		boolean pesoCorrecto=false;
		boolean alturaCorrecta=false;

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese Nombre");
		String nombre = scanner.next();

		System.out.println("Ingrese Apellido");
		String apellido = scanner.next();

		do {
			try {
				System.out.println("Ingrese anio de nacimiento");
				anio=scanner.nextInt();
				System.out.println("Ingrese mes de nacimiento");
				mes=scanner.nextInt();
				System.out.println("Ingrese dia de nacimiento");
				dia=scanner.nextInt();
				fechaCorrecta=true;

				try {
					LocalDate fechadeNac = LocalDate.of(anio, mes, dia);
				}catch(DateTimeException e) {
					System.out.println("Fecha invalida");
					fechaCorrecta=false;
				}

			}catch(InputMismatchException ex) {
				System.out.println("Ingreso incorrecto de datos");
				scanner.next();
			}
		}while(!fechaCorrecta);


		System.out.println("Ingrese Nacionalidad");
		String nac = scanner.next();

		do {
			try {
				System.out.println("Ingrese Estatura");
				altura=scanner.nextDouble();
				alturaCorrecta=true;
			}catch(InputMismatchException ex) {
				System.out.println("Ingreso Incorrecto de Datos");
				scanner.next();
			}
		}while(!alturaCorrecta);

		do {
			try {
				System.out.println("Ingrese Peso");
				peso=scanner.nextDouble();
				pesoCorrecto=true;
			}catch(InputMismatchException ex) {
				System.out.println("Ingreso Incorrecto de Datos");
				scanner.next();
			}
		}while(!pesoCorrecto);


		do {
			try {
				System.out.println("Ingrese posicion del Jugador");
				System.out.println("1 - Delantero");
				System.out.println("2 - Medio");
				System.out.println("3 - Defensa");
				System.out.println("4 - Arquero");
				pos=scanner.nextInt();
				switch(pos) {
				case 1:
					posi=Posicion.DELANTERO;
					correcto=true;
					break;
				case 2:
					posi=Posicion.MEDIO;
					correcto=true;
					break;
				case 3:
					posi=Posicion.DEFENSA;
					correcto=true;
					break;
				case 4:
					posi=Posicion.ARQUERO;
					correcto=true;
					break;
				}	
			}catch(InputMismatchException ex) {
				System.out.println("Ingreso incorrecto");
				scanner.next();
			}

		}while(!correcto);

		Jugador jugador = new Jugador();
		jugador.setNombre(nombre);
		jugador.setApellido(apellido);
		jugador.setFechaNac(LocalDate.of(anio, mes, dia));
		jugador.setNacionalidad(nac);
		jugador.setEstatura(altura);
		jugador.setPeso(peso);
		jugador.setPosicion(posi);


		return jugador;
	}
	//fin alta Jugador

	// 2 - buscar
	public static void buscarJugador(List<Jugador> plantel) {
		Scanner scanner = new Scanner(System.in);
		String nom;
		String ape;
		boolean encontrado=false;
		System.out.println("Ingrese NOMBRE del jugador a buscar");
		nom=scanner.next();
		System.out.println("Ingrese APELLIDO del Jugador a buscar");
		ape=scanner.next();

		for(Jugador juga:plantel) {
			if(juga.getNombre().equalsIgnoreCase(nom) && juga.getApellido().equalsIgnoreCase(ape)) {
				System.out.println("-------------------");
				System.out.println(juga.toString());
				System.out.println("-------------------");
				encontrado=true;
			}
			if(encontrado==false) {
				System.out.println("No existe jugador con ese nombre");
			}
		}
	}
	//fin buscar

	// 3 - ordenar
	public static void ordenarApellido(List<Jugador> plantel) {
		Collections.sort(plantel,Comparator.comparing(Jugador::getApellido));
		for(Jugador juga:plantel) {
			System.out.println("-------------------");
			System.out.println(juga.toString());
			System.out.println("-------------------");
		}
	}
	//fin ordenar

	// 4 - modificar
	public static void modificarJugador(List<Jugador> plantel) {
		Scanner scanner = new Scanner(System.in);
		String nom;
		String ape;
		int i;
		boolean encontrado=false;
		System.out.println("Ingrese NOMBRE del jugador a buscar");
		nom=scanner.next();
		System.out.println("Ingrese APELLIDO del Jugador a buscar");
		ape=scanner.next();
		for(i=0; i<plantel.size() && encontrado==false;i++) {
			if(plantel.get(i).getNombre().equalsIgnoreCase(nom) && plantel.get(i).getApellido().equalsIgnoreCase(ape) && encontrado==false) {
				plantel.set(i, crearJugador());
				encontrado=true;
			}
		}
		if(encontrado==false) {
			System.out.println("No existe jugador con ese nombre");
		}

	}

	//fin modificar

	// 5 - eliminarJugador
	public static void eliminarJugador(List<Jugador> plantel) {
		Iterator<Jugador> iterador = plantel.iterator();
		Scanner scanner = new Scanner(System.in);
		String nom;
		String ape;

		boolean encontrado=false;
		System.out.println("Ingrese NOMBRE del jugador a buscar");
		nom=scanner.next();
		System.out.println("Ingrese APELLIDO del Jugador a buscar");
		ape=scanner.next();

		while(iterador.hasNext() && encontrado==false) {
			Jugador jugadorActual = iterador.next();
			if(jugadorActual.getApellido().equalsIgnoreCase(ape) && jugadorActual.getNombre().equalsIgnoreCase(nom) && encontrado==false) {
				iterador.remove();
				encontrado=true;
			}
			if(encontrado==false) {
				System.out.println("Jugador no encontrado");
			}
		}

	}
	//fin eliminarJugador

	// 6 - Cantidad de Jugadores
	public static void contarArray(List<Jugador> plantel) {
		int i=plantel.size();
		System.out.println("Cantidad de Jugadores en el Array: "+i);
	}
	//fin cantidad de jugadores

	// 7 - mostrarNacionaliad


	public static void nacionalidadJugador(List<Jugador> plantel) {
		Scanner scanner = new Scanner(System.in);
		String pais;
		int contador=0;
		boolean encontrado=false;
		System.out.println("Ingrese el Pais para listar");
		pais=scanner.next();
		for(Jugador juga:plantel) {
			if(juga.getNacionalidad().equalsIgnoreCase(pais)) {
				System.out.println("-------------------");
				System.out.println(juga.toString());
				System.out.println("-------------------");
				contador++;
				encontrado=true;
			}
			if(encontrado==false) {
				System.out.println("No existe jugador/es con ese Pais");
			}
		}
		System.out.println("Cantidad de jugadores con la misma nacionalidad: "+contador);
	}

	//fin
	public static void mostrarArray(List<Jugador> plantel) {
		for(Jugador juga:plantel) {
			System.out.println("-------------------");
			System.out.println(juga.toString());
			System.out.println("-------------------");
		}
	}

}
