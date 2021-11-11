package persistencia;

import java.util.ArrayList;

import entidades.CriptomonedaDto;

public class CriptomonedaPer implements ICriptomoneda {

	@Override
	public ArrayList<CriptomonedaDto> listar() {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstancia();
		ArrayList<CriptomonedaDto> lista = singleton.listarCripto();
		return lista;
	}

}
