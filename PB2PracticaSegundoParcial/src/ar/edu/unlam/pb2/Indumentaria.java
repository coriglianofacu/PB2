package ar.edu.unlam.pb2;

public class Indumentaria extends Producto{

	private String talle;
	private String color;
	private String marca;
	
	public Indumentaria(Integer codigo, String descripcion, String talle, String marca, String color, Double precio) {
		super(codigo, descripcion, precio);
		this.talle = talle;
		this.marca = marca;
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public String getColor() {
		return color;
	}

	public String getMarca() {
		return marca;
	}

}
