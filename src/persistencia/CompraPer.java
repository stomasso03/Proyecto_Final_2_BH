package persistencia;

import java.util.ArrayList;

import entidades.CompraDto;
import entidades.CriptomonedaDto;

public class CompraPer implements ICriptomoneda {

	@Override
	public ArrayList<CriptomonedaDto> listar() {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<CompraDto> lista = singleton.listarCripto();
		return lista;
	}

}
