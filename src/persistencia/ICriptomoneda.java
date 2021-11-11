package persistencia;

import java.util.ArrayList;

import entidades.CriptomonedaDto;

public interface ICriptomoneda {
	ArrayList<CriptomonedaDto> listar();
}
