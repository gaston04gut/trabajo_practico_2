package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	
	private String numeroTarjeta;
	private LocalDate fechaDePago;
	private double montoPagado;
	
	
	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		
	}

}
