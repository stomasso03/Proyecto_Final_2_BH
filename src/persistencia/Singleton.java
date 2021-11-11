package persistencia;

import java.util.ArrayList;

import entidades.*;

public class Singleton {
	private static Singleton instancia = null;
	// private static Singleton instancia2 = null;
	private ArrayList<CriptomonedaDto> listaCripto;
	private ArrayList<CompraDto> listaCompras;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton getInstancia() {
		if (instancia == null) {
			instancia = new Singleton();
			instancia.listaCripto = new ArrayList<CriptomonedaDto>();
			CriptomonedaDto p01 = new CriptomonedaDto(1, "Bitcoin", 52.50);
			CriptomonedaDto p02 = new CriptomonedaDto(2, "Leandrocoin", 2);
			CriptomonedaDto p03 = new CriptomonedaDto(3, "Litecoin", 95.50);
			CriptomonedaDto p04 = new CriptomonedaDto(4, "Ethereum", 105.50);

			instancia.listaCripto.add(p01);
			instancia.listaCripto.add(p02);
			instancia.listaCripto.add(p03);
			instancia.listaCripto.add(p04);
			instancia.listaCompras = new ArrayList<CompraDto>();
			CompraDto c01 = new CompraDto(1, "Litecoin", 2, 52.50, "7/10/2021");
			CompraDto c02 = new CompraDto(5, "Litecoin", 5, 42.50, "30/10/2021");
			CompraDto c03 = new CompraDto(3, "Litecoin", 8, 95.50, "7/10/2021");
			CompraDto c04 = new CompraDto(25, "Litecoin", 7, 105.50, "7/10/2021");
			instancia.listaCompras.add(c01);
			instancia.listaCompras.add(c02);
			instancia.listaCompras.add(c03);
			instancia.listaCompras.add(c04);

		}
		return instancia;
	}
	
	public ArrayList<CriptomonedaDto> listarCripto(){
		return listaCripto;
	};
	
	

}
