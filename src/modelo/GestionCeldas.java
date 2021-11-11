package modelo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import org.w3c.dom.css.RGBColor;

/**
 * 
 * Esta clase permite gestionar la tabla y los eventos realizados sobre ella
 * cada celda seria un objeto personalizable
 * 
 * @author CHENAO
 * 
 *
 */
public class GestionCeldas extends DefaultTableCellRenderer {

	private String tipo = "texto";

	// se definen por defecto los tipos de datos a usar
	private Font normal = new Font("Verdana", Font.PLAIN, 12);
	JComponent jcomponent = null;
	
	public GestionCeldas() {

	}

	/**
	 * Constructor explicito con el tipo de dato que tendr� la celda
	 * 
	 * @param tipo
	 */
	public GestionCeldas(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
			int row, int column) {
		this.setForeground(new Color(0, 0, 0));

		Color colorFondoGeneral = new Color(255, 255, 255);
		Color colorFondoFilasPares = new Color(192, 192, 192);
		Color colorFondoFilasImpares = new Color(100, 100, 192);
		Color colorFondoFilaSeleciona = new Color(255, 187, 65);
		Color colorFondoActiva = new Color(255, 187, 65);

		this.setBackground(colorFondoGeneral);
		// fila en la que estoy
		boolean esPar = (row % 2) == 0;
		if (esPar) {
			this.setBackground(colorFondoFilasPares);
		}
		else this.setBackground(colorFondoFilasImpares);

		if (selected) {
			this.setBackground(colorFondoFilaSeleciona);
		}

		if (focused) {
			this.setBackground(colorFondoActiva);
		}
		// le asigno el valor
		this.setText((String) value);

		this.setFont(normal);

		if (tipo.equals("texto")) {
			this.setHorizontalAlignment(JLabel.LEFT);
		}

		if (tipo.equals("numerico")) {
			this.setHorizontalAlignment(JLabel.CENTER);
		}
		return this;

	}

}
