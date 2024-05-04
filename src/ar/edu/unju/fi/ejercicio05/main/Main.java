package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.Producto.origenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.categoria;

public class Main {

	public static void main(String[] args) {
		List<Producto> arrayProducto = new ArrayList<Producto>();
		List<Producto> arrayProdCarrito = new ArrayList<Producto>();

		int opcion=0;
		Scanner scanner = new Scanner(System.in);

		cargarProductos(arrayProducto);
		do {
			try {
				System.out.println("--- MENU ---");
				System.out.println("1 – Mostrar Productos en Stock");
				System.out.println("2 – Realizar compra ");
				System.out.println("3 – Salir");
				System.out.println("9 – Mostrar Todos los Productos");
				System.out.println("Ingrese opcion: ");
				opcion=scanner.nextInt();

				switch(opcion) {
				case 1:
					mostrarStock(arrayProducto);
					break;
				case 2:
					realizarCompra(arrayProducto, arrayProdCarrito);
					break;
				case 3:
					System.out.println("Adios...");
					break;
				case 4:

					break;
				case 9:
					mostrarProductos(arrayProducto);
					break;

				default:
					System.out.println("ERROR");
				}
			}catch(InputMismatchException e) {
				System.out.println("debe ingresar un numero");
				scanner.next();
			}
		}while(opcion!=3);
	}
	//carga de productos
	public static void cargarProductos(List<Producto> listaProd) {
		// Producto 1
		Producto prod1 = new Producto("p1", "Lavarropas", 28550.0, origenFabricacion.ARGENTINA, categoria.ELECTROHOGAR, false);
		listaProd.add(prod1);
		// Producto 2
		Producto prod2 = new Producto("p2", "Televisor", 35000.0, Producto.origenFabricacion.CHINA, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod2);

		// Producto 3
		Producto prod3 = new Producto("p3", "Laptop", 65000.0, Producto.origenFabricacion.CHINA, Producto.categoria.INFORMATICA, true);
		listaProd.add(prod3);

		// Producto 4
		Producto prod4 = new Producto("p4", "Taladro", 1500.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, false);
		listaProd.add(prod4);

		// Producto 5
		Producto prod5 = new Producto("p5", "Smartphone", 20000.0, Producto.origenFabricacion.BRASIL, Producto.categoria.TELEFONIA, false);
		listaProd.add(prod5);

		// Producto 6
		Producto prod6 = new Producto("p6", "Impresora", 5000.0, Producto.origenFabricacion.ARGENTINA, Producto.categoria.INFORMATICA, true);
		listaProd.add(prod6);

		// Producto 7
		Producto prod7 = new Producto("p7", "Aspiradora", 8000.0, Producto.origenFabricacion.CHINA, Producto.categoria.ELECTROHOGAR, false);
		listaProd.add(prod7);

		// Producto 8
		Producto prod8 = new Producto("p8", "Martillo", 200.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, true);
		listaProd.add(prod8);

		// Producto 9
		Producto prod9 = new Producto("p9", "Tablet", 120000.0, Producto.origenFabricacion.BRASIL, Producto.categoria.INFORMATICA, true);
		listaProd.add(prod9);

		// Producto 10
		Producto prod10 = new Producto("p10", "Licuadora", 3000.0, Producto.origenFabricacion.ARGENTINA, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod10);

		// Producto 11
		Producto prod11 = new Producto("p11", "Destornillador", 150.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, true);
		listaProd.add(prod11);

		// Producto 12
		Producto prod12 = new Producto("p12", "Cámara", 18000.0, Producto.origenFabricacion.BRASIL, Producto.categoria.INFORMATICA, false);
		listaProd.add(prod12);

		// Producto 13
		Producto prod13 = new Producto("p13", "Microondas", 6000.0, Producto.origenFabricacion.ARGENTINA, Producto.categoria.ELECTROHOGAR, true);
		listaProd.add(prod13);

		// Producto 14
		Producto prod14 = new Producto("p14", "Alicate", 100.0, Producto.origenFabricacion.URUGUAY, Producto.categoria.HERRAMIENTAS, true);
		listaProd.add(prod14);

		// Producto 15
		Producto prod15 = new Producto("p15", "Reproductor de DVD", 2500.0, Producto.origenFabricacion.BRASIL, Producto.categoria.ELECTROHOGAR, false);
		listaProd.add(prod15);
	}

	//Mostrar productos
	public static void mostrarStock(List<Producto> listaProd) {
		for(Producto prod:listaProd) {
			if(prod.isStock()==true) {
				System.out.println("_______________");
				System.out.println(prod.toString());
				System.out.println("_______________");
			}
		}
	}
	//mostrarTodo
	public static void mostrarProductos(List<Producto> listaProd) {
		for(Producto prod:listaProd) {
			System.out.println("_______________");
			System.out.println(prod.toString());
			System.out.println("Stock existente: "+prod.isStock());
			System.out.println("_______________");
		}
	}

	//buscarCodi


	//opc 2
	public static void realizarCompra(List<Producto> listaProd, List<Producto>listaCarrito) {
		Scanner scanner = new Scanner(System.in);
		int rta='#';
		String codigo;
		int i;
		double sumaTotal=0;

		do {
			try {
				boolean encontrado=false;
				mostrarStock(listaProd);
				System.out.println("**********");
				System.out.println("¿Que desea comprar?");
				System.out.println("**********");
				codigo=scanner.next();
				//buscar
				for(i=0;i<listaProd.size() && encontrado==false;i++) {
					if(listaProd.get(i).getCodigo().equals(codigo) && listaProd.get(i).isStock()==true) {
						encontrado=true;
						listaCarrito.add(listaProd.get(i));
						sumaTotal=sumaTotal+listaProd.get(i).getPrecioUnitario();
						System.out.println("Producto Agregado con Exito");
						System.out.println("");
						System.out.println("Precio Total: $"+sumaTotal);
					}else {
						encontrado=false;
					}
				}
				if(encontrado==false) {
					System.out.println("Producto no Encontrado");
				}
				System.out.println("¿Desea Seguir Comprando? s/n");
				rta=scanner.next().charAt(0);

			}catch(InputMismatchException e) {
				System.out.println("debe Ingresar un Caracter");
			}

		}while(rta!='n');
		System.out.println("----SU CARRITO----");
		mostrarStock(listaCarrito);
		System.out.println("***Precio Total $: "+ sumaTotal+" ***");

		boolean pagoRealizado=false;
		int opcion;
		double nuevoPrecio;
		do {
			try {
				System.out.println("¿Como deseea Pagar?");
				System.out.println("1 - Pagar Efectivo - %10 descuento");
				System.out.println("2 - Pagar Con Tarjeta - %15 aumento");
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:
					PagoEfectivo pago1 = new PagoEfectivo();
					pago1.setFechaDePago(LocalDate.now());
					nuevoPrecio=pago1.realizarPago(sumaTotal);
					pago1.setMontoPagado(nuevoPrecio);

					pago1.imprimirRecibo();
					pagoRealizado=true;
					break;
				case 2:

					System.out.println("Ingrese Numero de la tarjeta");
					String numTarjeta=scanner.next();
					PagoTarjeta pago2 = new PagoTarjeta();
					pago2.setFechaDePago(LocalDate.now());
					pago2.setNumeroTarjeta(numTarjeta);


					nuevoPrecio=pago2.realizarPago(sumaTotal);

					pago2.setMontoPagado(nuevoPrecio);

					pago2.imprimirRecibo();
					pagoRealizado=true;
					break;
				default:
					System.out.println("Ingreso Incorrecto de Opcion");
				}
			}catch(InputMismatchException e) {
				System.out.println("Error");
			}
		}while(!pagoRealizado);


	}

}
