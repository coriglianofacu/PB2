package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Supermercado {
	
	String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el número de venta)
	Integer contadorDeVentas; // Identificador del número de venta
	private Map<Integer, Integer> carrito;
	
	public Supermercado(String nombre) {
		this.nombre=nombre;
		this.productosExistentes = new HashSet<>();
		this.productosDisponibles = new ArrayList<>();
		this.ventasRealizadas = new HashMap<>();
		this.carrito = new HashMap<>();
		this.contadorDeVentas = 0;
	}

	public void ingresarProducto(Producto nuevo) {
		// Ingresa un nuevo producto
		this.productosExistentes.add(nuevo);
		this.productosDisponibles.add(nuevo);
	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que se comercializan
		return productosExistentes;
	}
	
	public Integer getStock(Integer codigo) {
		Integer cantidad = 0;
		for (Producto producto : productosDisponibles) {
			if(producto.getCodigo().equals(codigo)) {
				cantidad++;
			}
		}
		return cantidad;

	}
	
	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente{
		// Verifica si un producto existe
		for (Producto producto : productosExistentes) {			
			if(producto.getCodigo().equals(codigoDeProducto)) {
				return true;
			}
		}
		
		throw new ProductoInexistente("El producto no está en el inventario");
	}
	
	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto
		for (Producto producto : productosDisponibles) {
			if(producto.getCodigo().equals(codigoDeProducto)) {
				return producto;
			}
		}
		throw new ProductoSinStock("El producto no está disponible");
	}
	
	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(++contadorDeVentas, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}
	
	public Venta getVenta(Integer numeroDeVenta) {
		// Devuelve una venta en función de su número identificatorio
		return this.ventasRealizadas.get(numeroDeVenta);
	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto) throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el "numeroDeVenta", el producto identificado por el "codigoDeProducto"
		if(productoExiste(codigoDeProducto)) {
			this.carrito.put(numeroDeVenta, codigoDeProducto);
			this.productosDisponibles.remove(getProductoPorCodigo(codigoDeProducto));
		}
	}
}
