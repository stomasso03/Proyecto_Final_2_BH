package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.JTableHeader;

import entidades.CompraDto;
import entidades.CriptomonedaDto;
import modelo.GestionCeldas;
import modelo.GestionEncabezadoTabla;
import modelo.ModeloTabla;
import persistencia.Singleton;

public class VentanaPrincipal extends JFrame {

	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JTable tablaCriptos;
	private JTable tablaCompras;
	private ArrayList<CriptomonedaDto> listaCripto;
	private ArrayList<CompraDto> listaCompra;
	private ModeloTabla modelo;
	private AgregarCompraInternal internal;
	JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setBounds(0, 0, 883, 500);
		setResizable(true);
		setTitle("Listar Cliente");
		getContentPane().setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 33, 3000, 3000);
		getContentPane().add(desktopPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 91, 574, 300);
		desktopPane.add(scrollPane);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(700, 91, 574, 300);
		desktopPane.add(scrollPane2);
		
		tablaCriptos = new JTable();
		scrollPane.setViewportView(tablaCriptos);
		
		tablaCompras = new JTable();
		scrollPane2.setViewportView(tablaCompras);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 5000, 22);
		desktopPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Guardar...");
		mnNewMenu.add(mntmNewMenuItem);
		
		JButton btnNewButton = new JButton("Agregar compra");
		desktopPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInternalCompra();
				internal.toFront();
				internal.repaint();
			}
		});
		btnNewButton.setBounds(125, 427, 154, 23);
		//getContentPane().add(btnNewButton);
		
		construirTabla();
		construirTabla2();
	}
	
	private void construirTabla() {
		// llamamos
		listaCripto = Singleton.getInstancia().listarCripto();
		
		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("ID");
		titulosList.add("Nombre");
		titulosList.add("Precio");
		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos(titulosList);
		construirTabla(titulos, data);
	}
	
	private void construirTabla2() {
		// llamamos, diferente
		listaCompra = Singleton.getInstancia2().listarCompras();
		
		ArrayList<String> titulosList = new ArrayList<>();

		titulosList.add("Moneda");
		titulosList.add("Cantidad");
		titulosList.add("Precio");
		titulosList.add("Fecha");
		// se asignan las columnas al arreglo para enviarse al momento de construir la
		// tabla
		String titulos[] = new String[titulosList.size()];
		for (int i = 0; i < titulos.length; i++) {
			titulos[i] = titulosList.get(i);
		}
		/*
		 * obtenemos los datos de la lista y los guardamos en la matriz que luego se
		 * manda a construir la tabla
		 */
		Object[][] data = obtenerMatrizDatos2(titulosList);
		construirTabla2(titulos, data);
	}
	
	private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {
		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		String informacion[][] = new String[listaCripto.size()][titulosList.size()];
//		listaProductos.sort(new OrdenarClienteEdad());
		
		for (int x = 0; x < informacion.length; x++) {
			informacion[x][0] = listaCripto.get(x).getId() + "";
			informacion[x][1] = listaCripto.get(x).getNombre() + "";
			informacion[x][2] = "$ " + listaCripto.get(x).getPrecio() + "";
		}
		return informacion;
	}

	private Object[][] obtenerMatrizDatos2(ArrayList<String> titulosList) {
		/*
		 * se crea la matriz donde las filas son dinamicas pues corresponde a todos los
		 * usuarios, mientras que las columnas son estaticas correspondiendo a las
		 * columnas definidas por defecto
		 */
		String informacion[][] = new String[listaCompra.size()][titulosList.size()];
//		listaProductos.sort(new OrdenarClienteEdad());
		
		for (int x = 0; x < informacion.length; x++) {
			informacion[x][0] = listaCompra.get(x).getMoneda() + "";
			informacion[x][1] = listaCompra.get(x).getCantidad() + "";
			informacion[x][2] = "$ " + listaCompra.get(x).getPrecio() + "";
			informacion[x][3] = listaCompra.get(x).getFecha() + "";
		}
		return informacion;
	}
	private void construirTabla(String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaCriptos.setModel(modelo);

		for (int i = 0; i < titulos.length; i++) {
			tablaCriptos.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto

		tablaCriptos.getTableHeader().setReorderingAllowed(false);
		tablaCriptos.setRowHeight(25); // tama�o de las celdas
		tablaCriptos.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tablaCriptos.getColumnModel().getColumn(0).setPreferredWidth(100);// documento
		tablaCriptos.getColumnModel().getColumn(1).setPreferredWidth(200);// nombre
		tablaCriptos.getColumnModel().getColumn(2).setPreferredWidth(200);// direccion

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaCriptos.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaCriptos.setTableHeader(jtableHeader);

		// limitar seleccion a una fila
		tablaCriptos.setRowSelectionAllowed(true);
		tablaCriptos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// se asigna la tabla al scrollPane
		scrollPane.setViewportView(tablaCriptos);

		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());

	}
	
	private void construirTabla2 (String[] titulos, Object[][] data) {
		modelo = new ModeloTabla(data, titulos);
		// se asigna el modelo a la tabla
		tablaCompras.setModel(modelo);

		for (int i = 0; i < titulos.length; i++) {
			tablaCompras.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}

		// se recorre y asigna el resto de celdas que serian las que almacenen datos de
		// tipo texto

		tablaCompras.getTableHeader().setReorderingAllowed(false);
		tablaCompras.setRowHeight(25); // tama�o de las celdas
		tablaCompras.setGridColor(new java.awt.Color(0, 0, 0));
		// Se define el tama�o de largo para cada columna y su contenido
		tablaCompras.getColumnModel().getColumn(0).setPreferredWidth(100);// id
		tablaCompras.getColumnModel().getColumn(1).setPreferredWidth(200);// cantidad
		tablaCompras.getColumnModel().getColumn(2).setPreferredWidth(100);// precio
		tablaCompras.getColumnModel().getColumn(3).setPreferredWidth(200);// fecha

		// personaliza el encabezado
		JTableHeader jtableHeader = tablaCompras.getTableHeader();
		jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
		tablaCompras.setTableHeader(jtableHeader);

		// limitar seleccion a una fila
		tablaCompras.setRowSelectionAllowed(true);
		tablaCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// se asigna la tabla al scrollPane
		scrollPane2.setViewportView(tablaCompras);

		JScrollBar vertical = scrollPane.getVerticalScrollBar();
		vertical.setValue(vertical.getMaximum());

	}
	
	public void agregarInternalCompra() {
		if (internal == null || internal.isClosed()) { //crea un formulario solo si no hay otro ya creado
			internal = new AgregarCompraInternal();
			internal.setVisible(true);
			desktopPane.add(internal);
//			Dimension dimension = internal.getSize();
//			int posicionHorizontal = (desktopPane.getWidth() - dimension.width) / 2;
//			internal.setLocation(posicionHorizontal, 0);
		}
	}
}
