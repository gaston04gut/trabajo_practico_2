package ar.edu.unju.fi.ejercicio03.constantes;

public enum Provincia {
	JUJUY(797955,53219.0),
	SALTA(1440672,155488.0),
	TUCUMAN(2003186,22524.0),
	LA_RIOJA(324226,98680.0),
	SANTIAGO_DEL_ESTERO(1060906,136351.0);
	
	private double cantidadPoblacion;
	private double superficie;
	
	private Provincia() {
		// TODO Auto-generated constructor stub
	}

	private Provincia(double cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public double getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}
	
	public double densidadPoblacional() {
		return cantidadPoblacion / superficie;
	}
	
	
}
