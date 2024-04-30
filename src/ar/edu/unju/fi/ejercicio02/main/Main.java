package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio02.contantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		int opcion=0;
		Scanner scanner = new Scanner(System.in);
		List<Efemeride> arrayEfemeride = new ArrayList<Efemeride>();
		do {
			try {
				System.out.println("--- MENU ---");
				System.out.println("1 – Crear Efemeride");
				System.out.println("2 – Mostrar Efemeride ");
				System.out.println("3 – Eliminar Efemeride");
				System.out.println("4 – Modificar Efemeride");
				System.out.println("5 – Salir");
				System.out.println("Ingrese opcion: ");
				opcion=scanner.nextInt();

				switch(opcion) {
				case 1:
					arrayEfemeride.add(crearEfemeride());
					break;
				case 2:
					mostrarEfemeride(arrayEfemeride);
					break;
				case 3:
					eliminarEfemeride(arrayEfemeride);
					break;
				case 4:
					modificarEfemeride(arrayEfemeride);
					break;
				case 5:
					System.out.println("ADIOS...");
					break;
				default:
					System.out.println("ERROR");
				}
			}catch(InputMismatchException e) {
				System.out.println("debe ingresar un numero");
				scanner.next();
			}
		}while(opcion!=5);
	}

	public static Efemeride crearEfemeride() {
		String codigo="null";
		String descripcion="null";
		int opcion=0;
		int dia=0;
		boolean diaCorrecto=false;
		boolean mesCorrecto=false;
		boolean categoriaCorrecto=false;
		boolean mesCon31 = false;
		Mes mesE = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese Codigo del Efemeride");
		codigo=scanner.next();

		System.out.println("Ingrese Detalle del Efemeride");
		descripcion=scanner.next();

		do {
			try {
				System.out.println("----Ingrese Mes----");
				System.out.println("Elija una opcion: ");
				opcion=scanner.nextInt();
				if(opcion>=1 && opcion <=12) {
					switch(opcion) {
					case 1:
						mesE = Mes.ENERO;
						mesCorrecto=true;
						mesCon31=true;
						break;
					case 2:
						mesE = Mes.FEBRERO;
						mesCorrecto=true;
						break;
					case 3:
						mesE = Mes.MARZO;
						mesCorrecto=true;
						mesCon31=true;
						break;
					case 4:
						mesE = Mes.ABRIL;
						mesCorrecto=true;
						break;
					case 5:
						mesE = Mes.MAYO;
						mesCorrecto = true;
						mesCon31=true;
						break;
					case 6:
						mesE = Mes.JUNIO;
						mesCorrecto = true;
						break;
					case 7:
						mesE = Mes.JULIO;
						mesCorrecto = true;
						mesCon31=true;
						break;
					case 8:
						mesE = Mes.AGOSTO;
						mesCorrecto = true;
						mesCon31=true;
						break;
					case 9:
						mesE = Mes.SEPTIEMBRE;
						mesCorrecto = true;
						break;
					case 10:
						mesE = Mes.OCTUBRE;
						mesCorrecto = true;
						mesCon31=true;
						break;
					case 11:
						mesE = Mes.NOVIEMBRE;
						mesCorrecto = true;
						break;
					case 12:
						mesE = Mes.DICIEMBRE;
						mesCorrecto = true;
						mesCon31=true;
						break;
					default:
						System.out.println("ERROR");
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("Ingreso incorrecto de datos");
				scanner.next();
			}
		}while(!mesCorrecto);
		opcion=0;

		do {
			try {
				System.out.println("Ingrese el Dia");
				dia=scanner.nextInt();
				if(dia>=1 && dia<=31) {
					if((mesCon31==false && dia==31)||(mesE==Mes.FEBRERO && dia>28)) {
						System.out.println("El mes No tiene 31 dias");
					}else {
						diaCorrecto=true;	
					}
				}else {
					System.out.println("Ingreso Incorrecto");
				}
			}catch(InputMismatchException e) {
				System.out.println("Ingreso Incorrecto de Datos");
				scanner.next();
			}
		}while(!diaCorrecto);

		Efemeride efemerideN = new Efemeride();
		efemerideN.setCodigo(codigo);
		efemerideN.setDetalle(descripcion);
		efemerideN.setDia(dia);
		efemerideN.setMes(mesE);
		return efemerideN;
	}

	public static void mostrarEfemeride(List<Efemeride> efemeride) {
		for(Efemeride efe:efemeride) {
			System.out.println("-------------------");
			System.out.println(efe.toString());
			System.out.println("-------------------");
		}
	}

	public static void eliminarEfemeride(List<Efemeride> efemeride) {
		Iterator<Efemeride> iterador = efemeride.iterator();
		Scanner scanner = new Scanner(System.in);
		String codigo;
		boolean encontrado=false;
		System.out.println("Ingrese el codigo del Efemeride a Eliminar");
		codigo=scanner.next();

		while(iterador.hasNext() && encontrado==false) {
			Efemeride efe = iterador.next();
			if(efe.getCodigo().equals(codigo)) {
				iterador.remove();
				encontrado=true;
				System.out.println("Eliminado con exito");
			}
		}
		if(encontrado==false) {
			System.out.println("Efemeride no Encontrada");
		}
	}

	public static Efemeride modificarInterno(Efemeride efe) {
		String codigo="null";
		String descripcion="null";
		int opcion=0;
		int dia=0;
		int opc=0;
		boolean diaCorrecto=false;
		boolean mesCorrecto=false;
		boolean categoriaCorrecto=false;
		boolean mesCon31 = false;
		boolean modificarCorrecto=false;
		Mes mesE = null;

		Scanner scanner = new Scanner(System.in);
		do {
			try {
				System.out.println("¿Que deseea Modificar?");
				System.out.println("1 - Mes");
				System.out.println("2 - Dia");
				System.out.println("3 - Detalle");
				System.out.println("4 - Salir");
				opc = scanner.nextInt();
				switch(opc) {
				case 1:
					do {
						try {
							System.out.println("----Ingrese EL NUEVO Mes----");
							System.out.println("Elija una opcion: ");
							opcion=scanner.nextInt();
							if(opcion>=1 && opcion <=12) {
								switch(opcion) {
								case 1:
									mesE = Mes.ENERO;
									mesCorrecto=true;
									mesCon31=true;
									break;
								case 2:
									mesE = Mes.FEBRERO;
									mesCorrecto=true;
									break;
								case 3:
									mesE = Mes.MARZO;
									mesCorrecto=true;
									mesCon31=true;
									break;
								case 4:
									mesE = Mes.ABRIL;
									mesCorrecto=true;
									break;
								case 5:
									mesE = Mes.MAYO;
									mesCorrecto = true;
									mesCon31=true;
									break;
								case 6:
									mesE = Mes.JUNIO;
									mesCorrecto = true;
									break;
								case 7:
									mesE = Mes.JULIO;
									mesCorrecto = true;
									mesCon31=true;
									break;
								case 8:
									mesE = Mes.AGOSTO;
									mesCorrecto = true;
									mesCon31=true;
									break;
								case 9:
									mesE = Mes.SEPTIEMBRE;
									mesCorrecto = true;
									break;
								case 10:
									mesE = Mes.OCTUBRE;
									mesCorrecto = true;
									mesCon31=true;
									break;
								case 11:
									mesE = Mes.NOVIEMBRE;
									mesCorrecto = true;
									break;
								case 12:
									mesE = Mes.DICIEMBRE;
									mesCorrecto = true;
									mesCon31=true;
									break;
								default:
									System.out.println("ERROR");
								}
							}
						}catch(InputMismatchException e) {
							System.out.println("Ingreso incorrecto de datos");
							scanner.next();
						}
					}while(!mesCorrecto);
					efe.setMes(mesE);
					modificarCorrecto=true;
					break;

				case 2:
					do {
						try {
							System.out.println("Ingrese el NUEVO Dia");
							dia=scanner.nextInt();
							if(dia>=1 && dia<=31) {
								if((mesCon31==false && dia==31)||(mesE==Mes.FEBRERO && dia>28)) {
									System.out.println("El mes No tiene 31 dias");
								}else {
									diaCorrecto=true;	
								}
							}else {
								System.out.println("Ingreso Incorrecto");
							}
						}catch(InputMismatchException e) {
							System.out.println("Ingreso Incorrecto de Datos");
							scanner.next();
						}
					}while(!diaCorrecto);
					efe.setDia(dia);
					modificarCorrecto=true;
					break;
				case 3:
					System.out.println("Ingrese EL NUEVO Detalle del Efemeride");
					descripcion=scanner.next();
					efe.setDetalle(descripcion);
					modificarCorrecto=true;
					break;
				case 4:
					System.out.println("saliendo");
					modificarCorrecto=true;
					break;
				default:
					System.out.println("Opcion Incorrecta");
				}//finswitch

			}catch(InputMismatchException e) {
				System.out.println("ERROR");
				scanner.next();
			}
		}while(!modificarCorrecto);
		return efe; 
	}
		public static void modificarEfemeride(List<Efemeride> efemeride) {
		String codi;

		boolean encontrado=false;
		int i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese Codigo del Efemeride a Modificar");
		codi=scanner.next();
		for(i=0;i<efemeride.size() && encontrado==false;i++) {
			if(efemeride.get(i).getCodigo().equals(codi)){
				efemeride.set(i, modificarInterno(efemeride.get(i)));
				encontrado=true;
			}
		}
		if(encontrado==false) {
			System.out.println("Efemeride No encontrada");
		}
	}
	
}
