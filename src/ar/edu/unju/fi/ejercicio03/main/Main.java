package ar.edu.unju.fi.ejercicio03.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
	List<Provincia> arrayProv = new ArrayList<Provincia>();
	Scanner scanner = new Scanner(System.in);
	
	cargarArray(arrayProv);
	mostrarArray(arrayProv);
		
	}
	
	public static void cargarArray(List<Provincia> array) {
		Provincia jujuy = Provincia.JUJUY;
		array.add(jujuy);
		Provincia salta = Provincia.SALTA;
		array.add(salta);
		Provincia tucuman = Provincia.TUCUMAN;
		array.add(tucuman);
		Provincia laRioja = Provincia.LA_RIOJA;
		array.add(laRioja);
		Provincia santiagoDelEstero = Provincia.SANTIAGO_DEL_ESTERO;
		array.add(santiagoDelEstero);

	}

	public static void mostrarArray(List<Provincia> array) {
		for(Provincia prov:array) {
			System.out.println("________________");
			System.out.println("Provincia: "+prov.name()+"\nCantidad de Poblacion: "+prov.getCantidadPoblacion()+
					"\nSuperficie: "+prov.getSuperficie()+" Km²"+"\nDensidad de la Poblacion: "+prov.densidadPoblacional());
			System.out.println("________________");
		}
	}
	
	
}
