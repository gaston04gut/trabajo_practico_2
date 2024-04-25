package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private Double precioUnitario;
	private origenFabricacion origeFabricacion;
	private categoria categoria;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public Producto(String codigo, String descripcion, Double precioUnitario, origenFabricacion origeFabricacion,
			ar.edu.unju.fi.ejercicio01.model.Producto.categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origeFabricacion = origeFabricacion;
		this.categoria = categoria;
	}
	
	

	@Override
	public String toString() {
		return "Producto \nCodigo: " + codigo + "\nDescripcion: " + descripcion + "\nPrecio Unitario: $" + precioUnitario
				+ "\nOrigen de Fabricacion: " + origeFabricacion + "\nCategoria: " + categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public origenFabricacion getOrigeFabricacion() {
		return origeFabricacion;
	}

	public void setOrigeFabricacion(origenFabricacion origeFabricacion) {
		this.origeFabricacion = origeFabricacion;
	}

	public categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(categoria categoria) {
		this.categoria = categoria;
	}



	public enum origenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
}
