package persistencia;

import java.util.ArrayList;

import entidades.Compra;
import entidades.Criptomoneda;

public class Singleton {
	private static Singleton instancia = null;
	private static Singleton instancia2 = null;
	private ArrayList<Criptomoneda> listaCripto;
	private ArrayList<Compra> listaCompras;

	private Singleton() {
		// TODO Auto-generated constructor stub
	}

	public static Singleton getInstancia() {
		if (instancia == null) {
			instancia = new Singleton();
			instancia.listaCripto = new ArrayList<Criptomoneda>();
			Criptomoneda p01 = new Criptomoneda(1, "Bitcoin", 52.50);
			Criptomoneda p02 = new Criptomoneda(2, "Leandrocoin", 2);
			Criptomoneda p03 = new Criptomoneda(3, "Litecoin", 95.50);
			Criptomoneda p04 = new Criptomoneda(4, "Ethereum", 105.50);
			
			instancia.listaCripto.add(p01);
			instancia.listaCripto.add(p02);
			instancia.listaCripto.add(p03);
			instancia.listaCripto.add(p04);
		}
		return instancia;
	}
	
	public static Singleton getInstancia2() {
		if (instancia2 == null) {
			instancia2 = new Singleton();
			instancia2.listaCompras = new ArrayList<Compra>();
			Compra p01 = new Compra(1, "Litecoin", 2, 52.50, "7/10/2021");
			Compra p02 = new Compra(5,"Litecoin", 5, 42.50, "30/10/2021");
			Compra p03 = new Compra(3, "Litecoin", 8, 95.50, "7/10/2021");
			Compra p04 = new Compra(25, "Litecoin", 7, 105.50, "7/10/2021");
			
			instancia2.listaCompras.add(p01);
			instancia2.listaCompras.add(p02);
			instancia2.listaCompras.add(p03);
			instancia2.listaCompras.add(p04);
		}
		return instancia2;
	}

	public ArrayList<Criptomoneda> listarCripto() {
		return listaCripto;
	}
	
	public ArrayList<Compra> listarCompras() {
		return listaCompras;
	}
	
}
