package ar.edu.unlam.pb2;

public class Heladera extends Electrodomestico {
	private Boolean esNoFrost;

	public Heladera(Integer codigo, String descripcion, Boolean esNoFrost, Integer garantia, String marca, Double precio) {
		super(codigo, descripcion, garantia, marca, precio);
		this.esNoFrost = esNoFrost;
	}

	public Boolean esNoFrost() {
		return esNoFrost;
	}

}
