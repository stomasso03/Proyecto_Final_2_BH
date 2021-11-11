package modelo;

import java.util.ArrayList;

import entidades.CriptomonedaDto;
import persistencia.CriptomonedaPer;
import persistencia.ICriptomoneda;

public class Criptomoneda {

	public ArrayList<CriptomonedaDto> listar() {
		// TODO Auto-generated method stub
		ArrayList<CriptomonedaDto> lista = new ArrayList<CriptomonedaDto>();
        //luego voy a cambiarlo por CriptomonedaDao()
		ICriptomoneda per = new CriptomonedaPer();
		lista = per.listar();
		return lista;
	}

}
