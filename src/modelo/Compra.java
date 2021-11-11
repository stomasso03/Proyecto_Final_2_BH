package modelo;

public class Compra {
	
	private int id;
	private double cantidad;
	private double precio;
	private String fecha;
	private String moneda;
	
	public Compra(int id, String moneda, double cantidad, double precio, String fecha) throws Exception {
		if (precio<0){
			throw new Exception("el precio no puede ser negativo");
		}
		if (cantidad<0){
			throw new Exception("el precio no puede ser negativo");
		}
		this.id = id;
		this.moneda = moneda;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}	
	
	
}