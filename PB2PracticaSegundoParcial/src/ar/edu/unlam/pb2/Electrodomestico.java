package ar.edu.unlam.pb2;

public class Electrodomestico extends Producto{
	
	private Integer garantia;
	private String marca;

	
	public Electrodomestico(Integer codigo, String descripcion, Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, precio);
		this.garantia = garantia;
		this.marca = marca;
	}
	
	
	public Integer getGarantia() {
		return garantia;
	}
	
	public String getMarca() {
		return marca;
	}
	
}
