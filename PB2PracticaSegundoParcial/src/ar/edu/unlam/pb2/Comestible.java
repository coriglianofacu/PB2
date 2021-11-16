package ar.edu.unlam.pb2;

public class Comestible extends Producto{

	private String fechaDeElaboracion;
	private String fechaDeVencimiento;
	private String marca;
	
	public Comestible(Integer codigo, String descripcion, String fechaDeElaboracion, String fechaDeVencimiento, String marca, Double precio) {
		super(codigo, descripcion, precio);
		this.fechaDeElaboracion = fechaDeElaboracion;
		this.fechaDeVencimiento = fechaDeVencimiento;
		this.marca = marca;
	}


	public String getFechaDeElaboracion() {
		return fechaDeElaboracion;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public String getMarca() {
		return marca;
	}
	
}
