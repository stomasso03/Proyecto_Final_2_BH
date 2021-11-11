package persistencia;

import java.util.ArrayList;

import entidades.CompraDto;
import entidades.CriptomonedaDto;

public class CompraPer implements ICompraPer {

	@Override
	public ArrayList<CompraDto> listar() {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<CompraDto> lista = singleton.listarCompra();
		return lista;
	}
}
