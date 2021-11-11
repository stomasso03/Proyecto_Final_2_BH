package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import entidades.Compra;
import persistencia.Singleton;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AgregarCompraInternal extends JInternalFrame {
	private JTextField textCantidad;
	private JTextField textPrecio;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAño;
	private JComboBox comboBoxMoneda;
	private Compra compra;
	private int i = 4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCompraInternal frame = new AgregarCompraInternal();
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
	public AgregarCompraInternal() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(150, 98, 125, 20);
		panel.add(textCantidad);
		textCantidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setBounds(74, 101, 67, 14);
		panel.add(lblNewLabel);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(150, 141, 125, 20);
		panel.add(textPrecio);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(89, 144, 52, 14);
		panel.add(lblPrecio);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(74, 181, 52, 14);
		panel.add(lblFecha);
		
		textDia = new JTextField();
		textDia.setColumns(10);
		textDia.setBounds(150, 178, 29, 17);
		panel.add(textDia);
		
		textMes = new JTextField();
		textMes.setColumns(10);
		textMes.setBounds(207, 179, 29, 17);
		panel.add(textMes);
		
		textAño = new JTextField();
		textAño.setColumns(10);
		textAño.setBounds(266, 179, 60, 17);
		panel.add(textAño);
		
		JLabel lblNewLabel_1 = new JLabel(" /");
		lblNewLabel_1.setBounds(189, 178, 17, 20);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" /");
		lblNewLabel_1_1.setBounds(246, 178, 17, 20);
		panel.add(lblNewLabel_1_1);
		
		String hola[] = {"hola","refa"};

	    comboBoxMoneda = new JComboBox(hola);
		comboBoxMoneda.setBounds(150, 63, 125, 24);
		panel.add(comboBoxMoneda);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setBounds(74, 68, 67, 14);
		panel.add(lblMoneda);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i += 1;
				añadirCompra();
			}
		});
		btnNewButton.setBounds(282, 219, 89, 23);
		panel.add(btnNewButton);

	}
	
	public void añadirCompra() {
		try {
			Double cantidad = Double.parseDouble(textCantidad.getText());
			String moneda = comboBoxMoneda.getToolTipText();
			String fecha = textDia.getText() + "/" + textMes.getText() + "/" + textAño.getText();
			Double precio = Double.parseDouble(textPrecio.getText());
			int id = i;
			compra = new Compra(id, moneda, cantidad,precio, fecha);	
		
			
		} catch (NumberFormatException e) {
			//joption error al convertit
			// TODO: handle exception
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			
	}
}
