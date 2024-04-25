package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.origenFabricacion;

public class Main {

	public static void main(String[] args) {
		int opcion=0;
		Scanner scanner = new Scanner(System.in);
		List<Producto> arrayProducto = new ArrayList<Producto>();
		do {
			try {
			System.out.println("--- MENU ---");
			System.out.println("1 – Crear Producto");
			System.out.println("2 – Mostrar Producto ");
			System.out.println("3 – Modificar Producto");
			System.out.println("4 – Salir");
			System.out.println("Ingrese opcion: ");
			opcion=scanner.nextInt();

			switch(opcion) {
			case 1:
				arrayProducto.add(crearProducto());
				break;
			case 2:
				mostrarProductos(arrayProducto);
				break;
			case 3:
				modificarProducto(arrayProducto);
				break;
			case 4:
				System.out.println("Adios...");
				break;
				
			default:
				System.out.println("ERROR");
			}
			}catch(InputMismatchException e) {
				System.out.println("debe ingresar un numero");
				scanner.next();
			}
		}while(opcion!=4);
	}
	public static Producto crearProducto() {
		String codigo="null";
		String descripcion="null";
		Double precio=0.;
		int opcion=0;
		boolean precioCorrecto=false;
		boolean origenCorrecto=false;
		boolean categoriaCorrecto=false;
		origenFabricacion origen = null;
		categoria cat = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese Codigo del Producto");
		codigo=scanner.next();
		
		System.out.println("Ingrese Descripcion del Producto");
		descripcion=scanner.next();
		
		do {
			try {
				System.out.println("Ingrese Precio");
				precio=scanner.nextDouble();
				precioCorrecto=true;
			}catch(InputMismatchException e) {
				System.out.println("Ingreso Incorrecto de Datos");
				scanner.next();
			}
		}while(!precioCorrecto);
		
		do {
			try {
				System.out.println("----Origen de Fabricacion----");
				System.out.println("1 - Argentina");
				System.out.println("2 - China");
				System.out.println("3 - Brasil");
				System.out.println("4 - Uruguay");
				System.out.println("Elija una opcion: ");
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:
					origen=origenFabricacion.ARGENTINA;
					origenCorrecto=true;
					break;
				case 2:
					origen=origenFabricacion.CHINA;
					origenCorrecto=true;
					break;
				case 3:
					origen=origenFabricacion.BRASIL;
					origenCorrecto=true;
					break;
				case 4:
					origen=origenFabricacion.URUGUAY;
					origenCorrecto=true;
					break;
					default:
					System.out.println("ERROR");
				}
			}catch(InputMismatchException e) {
				System.out.println("Ingreso incorrecto de datos");
				scanner.next();
			}
		}while(!origenCorrecto);
		opcion=0;
		do {
			try {
				System.out.println("----Origen de Fabricacion----");
				System.out.println("1 - Telefonia");
				System.out.println("2 - Informatica");
				System.out.println("3 - Electro hogar");
				System.out.println("4 - Herramientas");
				System.out.println("Elija una opcion: ");
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:
					cat=categoria.TELEFONIA;
					categoriaCorrecto=true;
					break;
				case 2:
					cat=categoria.INFORMATICA;
					categoriaCorrecto=true;
					break;
				case 3:
					cat=categoria.ELECTROHOGAR;
					categoriaCorrecto=true;
					break;
				case 4:
					cat=categoria.HERRAMIENTAS;
					categoriaCorrecto=true;
					break;
					default:
					System.out.println("ERROR");
				}
			}catch(InputMismatchException e) {
				System.out.println("Ingreso incorrecto de datos");
				scanner.next();
			}
		}while(!categoriaCorrecto);

		Producto productonuevo = new Producto();
		productonuevo.setCodigo(codigo);
		productonuevo.setDescripcion(descripcion);
		productonuevo.setPrecioUnitario(precio);
		productonuevo.setOrigeFabricacion(origen);
		productonuevo.setCategoria(cat);
		return productonuevo;
	}
	
	public static void mostrarProductos(List<Producto> array) {
		for(Producto prod:array) {
			System.out.println("-------------------");
			System.out.println(prod.toString());
			System.out.println("-------------------");
		}
	}
	
	public static Producto modificarInterno(Producto prodi) {
		int opc=0;
		String descripcion="null";
		Double precio=0.;
		int opcion=0;
		boolean precioCorrecto=false;
		boolean origenCorrecto=false;
		boolean categoriaCorrecto=false;
		origenFabricacion origen = null;
		categoria cat = null;
		boolean modificarCorrecto=false;

		Scanner scanner = new Scanner(System.in);

		do {
			try {
				System.out.println("¿Que deseea Modificar?");
				System.out.println("1 - Descripcion");
				System.out.println("2 - Precio Unitario");
				System.out.println("3 - Origen de Fabricacion");
				System.out.println("4 - Categoria");
				System.out.println("5 - Salir");
				opc=scanner.nextInt();
				switch (opc) {
				case 1:
					System.out.println("Ingrese Nueva Descripcion del Producto");
					descripcion=scanner.next();
					modificarCorrecto=true;
					prodi.setDescripcion(descripcion);
					break;
				case 2:
					do {
						try {
							System.out.println("Ingrese Precio");
							precio=scanner.nextDouble();
							precioCorrecto=true;
						}catch(InputMismatchException e) {
							System.out.println("Ingreso Incorrecto de Datos");
							scanner.next();
						}
					}while(!precioCorrecto);
					prodi.setPrecioUnitario(precio);
					modificarCorrecto=true;
					break;
				case 3:
					do {
						try {
							System.out.println("----Origen de Fabricacion----");
							System.out.println("1 - Argentina");
							System.out.println("2 - China");
							System.out.println("3 - Brasil");
							System.out.println("4 - Uruguay");
							System.out.println("Elija una opcion: ");
							opcion=scanner.nextInt();
							switch(opcion) {
							case 1:
								origen=origenFabricacion.ARGENTINA;
								origenCorrecto=true;
								break;
							case 2:
								origen=origenFabricacion.CHINA;
								origenCorrecto=true;
								break;
							case 3:
								origen=origenFabricacion.BRASIL;
								origenCorrecto=true;
								break;
							case 4:
								origen=origenFabricacion.URUGUAY;
								origenCorrecto=true;
								break;
							default:
								System.out.println("ERROR");
							}
						}catch(InputMismatchException ex) {
							System.out.println("Ingreso incorrecto de datos");
							scanner.next();
						}
					}while(!origenCorrecto);
					prodi.setOrigeFabricacion(origen);
					modificarCorrecto=true;
					break;
				case 4:

					do {
						try {
							System.out.println("----Origen de Fabricacion----");
							System.out.println("1 - Telefonia");
							System.out.println("2 - Informatica");
							System.out.println("3 - Electro hogar");
							System.out.println("4 - Herramientas");
							System.out.println("Elija una opcion: ");
							opcion=scanner.nextInt();
							switch(opcion) {
							case 1:
								cat=categoria.TELEFONIA;
								categoriaCorrecto=true;
								break;
							case 2:
								cat=categoria.INFORMATICA;
								categoriaCorrecto=true;
								break;
							case 3:
								cat=categoria.ELECTROHOGAR;
								categoriaCorrecto=true;
								break;
							case 4:
								cat=categoria.HERRAMIENTAS;
								categoriaCorrecto=true;
								break;
							default:
								System.out.println("ERROR");
							}
						}catch(InputMismatchException e) {
							System.out.println("Ingreso incorrecto de datos");
							scanner.next();
						}
					}while(!categoriaCorrecto);
					prodi.setCategoria(cat);
					modificarCorrecto=true;
					break;
				case 5:
					System.out.println("ADIOS");
					modificarCorrecto=true;
					break;
				default:
					System.out.println("ERROR");
				}
			}catch(InputMismatchException e) {
				System.out.println("ERROR");
				scanner.next();
			}
		}while(!modificarCorrecto);
		return prodi;
	}
	
	public static void modificarProducto(List<Producto> array) {
		String codi;
		boolean encontrado=false;
		int i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese Codigo del Producto a Modificar");
		codi=scanner.next();
		for(i=0;i<array.size() && encontrado==false;i++) {
			if(array.get(i).getCodigo().equals(codi)){
				array.set(i, modificarInterno(array.get(i)));
				encontrado=true;
			}
		}
		if(encontrado==false) {
			System.out.println("Producto No encontrado");
		}
	}
}
