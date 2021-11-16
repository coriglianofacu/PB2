package ar.edu.unlam.pb2;

public class Carne extends Comestible {
	private Double kilos;

	public Carne(Integer codigo, String descripcion, String fechaDeElaboracion, String fechaDeVencimiento, Double kilos, String marca,
			Double precio) {
		super(codigo, descripcion, fechaDeElaboracion, fechaDeVencimiento, marca, precio);
		this.kilos = kilos;
	}

	public Double getKilos() {
		return kilos;
	}

}
