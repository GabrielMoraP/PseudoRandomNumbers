package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import generacion.CongruencialLineal;
import pruebas.PruebaAleatoriedad;
import pruebas.PruebaIndependencia;
import pruebas.PruebaMedia;
import pruebas.PruebaUniformidad;
import pruebas.PruebaVarianza;
import variables.Composicion;
import variables.Convolucion;
import variables.Inversa;

public class PanelCongruencialLineal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField valorC;
	private JTextField semilla;
	private JTable table;
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JTextArea txtPruebas;
	private JTextField valorA;
	private JTextField valorM;
	private ArrayList<Integer> listaX0;
	private ArrayList<Integer> listaX;
	private ArrayList<Double> listaR;
	private JPanel panelVariable;
	private JButton btnInversa;
	private JButton btnConvolucion;
	private JButton btnComposicion;

	public PanelCongruencialLineal() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 50.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 80.0, 1.0 };
		setLayout(gridBagLayout);

		JPanel panelCaptura = new JPanel();
		panelCaptura.setBorder(new EmptyBorder(15, 15, 0, 15));
		panelCaptura.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelCaptura = new GridBagConstraints();
		gbc_panelCaptura.insets = new Insets(0, 0, 5, 5);
		gbc_panelCaptura.fill = GridBagConstraints.BOTH;
		gbc_panelCaptura.gridx = 0;
		gbc_panelCaptura.gridy = 0;
		add(panelCaptura, gbc_panelCaptura);
		GridBagLayout gbl_panelCaptura = new GridBagLayout();
		gbl_panelCaptura.columnWidths = new int[] { 150, 150, 150, 100, 0 };
		gbl_panelCaptura.rowHeights = new int[] { 0, 0, 0, 52, 0 };
		gbl_panelCaptura.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelCaptura.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		panelCaptura.setLayout(gbl_panelCaptura);

		semilla = new JTextField();
		semilla.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"SEMILLA (X0)", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		semilla.setForeground(new Color(0, 0, 0));
		semilla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						valorA.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		semilla.setFont(new Font("Product Sans", Font.PLAIN, 16));
		semilla.setColumns(10);
		semilla.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_semilla = new GridBagConstraints();
		gbc_semilla.fill = GridBagConstraints.HORIZONTAL;
		gbc_semilla.gridwidth = 2;
		gbc_semilla.insets = new Insets(0, 0, 5, 5);
		gbc_semilla.gridx = 0;
		gbc_semilla.gridy = 0;
		panelCaptura.add(semilla, gbc_semilla);

		valorA = new JTextField();
		valorA.setForeground(Color.BLACK);
		valorA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						valorC.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		valorA.setFont(new Font("Product Sans", Font.PLAIN, 16));
		valorA.setColumns(10);
		valorA.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "(A)",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		valorA.setBackground(Color.WHITE);
		GridBagConstraints gbc_valorA = new GridBagConstraints();
		gbc_valorA.gridwidth = 2;
		gbc_valorA.insets = new Insets(0, 0, 5, 5);
		gbc_valorA.fill = GridBagConstraints.HORIZONTAL;
		gbc_valorA.gridx = 0;
		gbc_valorA.gridy = 2;
		panelCaptura.add(valorA, gbc_valorA);

		valorC = new JTextField();
		valorC.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "(C)",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		valorC.setForeground(new Color(0, 0, 0));
		valorC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						valorM.requestFocus();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		valorC.setFont(new Font("Product Sans", Font.PLAIN, 16));
		valorC.setColumns(10);
		valorC.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_valorC = new GridBagConstraints();
		gbc_valorC.fill = GridBagConstraints.HORIZONTAL;
		gbc_valorC.gridwidth = 2;
		gbc_valorC.insets = new Insets(0, 0, 0, 5);
		gbc_valorC.gridx = 0;
		gbc_valorC.gridy = 3;
		panelCaptura.add(valorC, gbc_valorC);

		valorM = new JTextField();
		valorM.setForeground(Color.BLACK);
		valorM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_ENTER
						|| evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						btnCalcular.doClick();
					}
				} else {
					evt.consume();
					JOptionPane.showMessageDialog(null, "SOLO INTRODUCIR DIGITOS", "-ERROR-",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		valorM.setFont(new Font("Product Sans", Font.PLAIN, 16));
		valorM.setColumns(10);
		valorM.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "(M)",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		valorM.setBackground(Color.WHITE);
		GridBagConstraints gbc_valorM = new GridBagConstraints();
		gbc_valorM.gridwidth = 2;
		gbc_valorM.insets = new Insets(0, 0, 5, 5);
		gbc_valorM.fill = GridBagConstraints.HORIZONTAL;
		gbc_valorM.gridx = 2;
		gbc_valorM.gridy = 0;
		panelCaptura.add(valorM, gbc_valorM);

		JPanel panelBtnProducto = new JPanel();
		panelBtnProducto.setBorder(new EmptyBorder(0, 15, 0, 0));
		panelBtnProducto.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelBtnProducto = new GridBagConstraints();
		gbc_panelBtnProducto.gridheight = 3;
		gbc_panelBtnProducto.gridwidth = 2;
		gbc_panelBtnProducto.fill = GridBagConstraints.BOTH;
		gbc_panelBtnProducto.gridx = 2;
		gbc_panelBtnProducto.gridy = 1;
		panelCaptura.add(panelBtnProducto, gbc_panelBtnProducto);
		GridBagLayout gbl_panelBtnProducto = new GridBagLayout();
		gbl_panelBtnProducto.columnWidths = new int[] { 166, 166, 0 };
		gbl_panelBtnProducto.rowHeights = new int[] { 64, 0 };
		gbl_panelBtnProducto.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelBtnProducto.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelBtnProducto.setLayout(gbl_panelBtnProducto);

		btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularValores();
			}
		});
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnCalcular.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_btnCalcular = new GridBagConstraints();
		gbc_btnCalcular.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCalcular.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalcular.gridx = 0;
		gbc_btnCalcular.gridy = 0;
		panelBtnProducto.add(btnCalcular, gbc_btnCalcular);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Product Sans", Font.BOLD, 18));
		btnLimpiar.setBackground(new Color(244, 42, 87));
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpiar.gridx = 1;
		gbc_btnLimpiar.gridy = 0;
		panelBtnProducto.add(btnLimpiar, gbc_btnLimpiar);

		JPanel panelPruebas = new JPanel();
		panelPruebas.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelPruebas.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelPruebas = new GridBagConstraints();
		gbc_panelPruebas.gridheight = 2;
		gbc_panelPruebas.insets = new Insets(0, 0, 5, 0);
		gbc_panelPruebas.fill = GridBagConstraints.BOTH;
		gbc_panelPruebas.gridx = 1;
		gbc_panelPruebas.gridy = 0;
		add(panelPruebas, gbc_panelPruebas);
		GridBagLayout gbl_panelPruebas = new GridBagLayout();
		gbl_panelPruebas.columnWidths = new int[] { 0, 0 };
		gbl_panelPruebas.rowHeights = new int[] { 600, 0 };
		gbl_panelPruebas.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelPruebas.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelPruebas.setLayout(gbl_panelPruebas);

		txtPruebas = new JTextArea();
		txtPruebas.setEditable(false);
		txtPruebas.setLineWrap(true);
		txtPruebas.setPreferredSize(new Dimension(150, 22));
		txtPruebas.setBorder(null);
		txtPruebas.setForeground(new Color(255, 255, 255));
		txtPruebas.setFont(new Font("Product Sans", Font.BOLD, 12));
		txtPruebas.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_txtPruebas = new GridBagConstraints();
		gbc_txtPruebas.insets = new Insets(0, 0, 0, 5);
		gbc_txtPruebas.fill = GridBagConstraints.BOTH;
		gbc_txtPruebas.gridx = 0;
		gbc_txtPruebas.gridy = 0;
		gbc_txtPruebas.weightx = 1.0;
		gbc_txtPruebas.weighty = 1.0;
		panelPruebas.add(txtPruebas, gbc_txtPruebas);

		JPanel panelTabla = new JPanel();
		panelTabla.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelTabla.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelTabla = new GridBagConstraints();
		gbc_panelTabla.insets = new Insets(0, 0, 5, 5);
		gbc_panelTabla.fill = GridBagConstraints.BOTH;
		gbc_panelTabla.gridx = 0;
		gbc_panelTabla.gridy = 1;
		add(panelTabla, gbc_panelTabla);
		panelTabla.setLayout(new GridLayout(1, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		panelTabla.add(scrollPane);
		
		panelVariable = new JPanel();
		panelVariable.setBorder(new EmptyBorder(15, 15, 15, 15));
		panelVariable.setBackground(new Color(38, 43, 73));
		GridBagConstraints gbc_panelVariable = new GridBagConstraints();
		gbc_panelVariable.gridwidth = 2;
		gbc_panelVariable.insets = new Insets(0, 0, 0, 5);
		gbc_panelVariable.fill = GridBagConstraints.BOTH;
		gbc_panelVariable.gridx = 0;
		gbc_panelVariable.gridy = 2;
		add(panelVariable, gbc_panelVariable);
		GridBagLayout gbl_panelVariable = new GridBagLayout();
		gbl_panelVariable.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelVariable.rowHeights = new int[]{0, 0};
		gbl_panelVariable.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelVariable.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelVariable.setLayout(gbl_panelVariable);
		
		btnInversa = new JButton("INVERSA");
		btnInversa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager.put("OptionPane.background", new Color(38, 43, 73));
		        UIManager.put("Panel.background", new Color(38, 43, 73));
		        UIManager.put("OptionPane.messageForeground", Color.WHITE);
		        UIManager.put("OptionPane.buttonForeground", Color.WHITE);
		        UIManager.put("OptionPane.okButtonText", "ACEPTAR");
		        UIManager.put("OptionPane.cancelButtonText", "CANCELAR");
		        try {
		        	Double lambda = Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL VALOR DE LAMBDA"));
			        Inversa inversa = new Inversa(lambda, listaR);
			        JOptionPane.showMessageDialog(null, inversa.generarMuestras(), "VARIABLES ALEATORIAS - INVERSA", JOptionPane.INFORMATION_MESSAGE);
		        }catch (Exception ex){
		        	JOptionPane.showMessageDialog(null, "INGRESE UN VALOR VALIDO", "VARIABLES ALEATORIAS - INVERSA", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnInversa.setEnabled(false);
		btnInversa.setBackground(new Color(255, 128, 0));
		btnInversa.setForeground(new Color(255, 255, 255));
		btnInversa.setFont(new Font("Product Sans", Font.BOLD, 18));
		GridBagConstraints gbc_btnInversa = new GridBagConstraints();
		gbc_btnInversa.insets = new Insets(0, 0, 0, 5);
		gbc_btnInversa.gridx = 0;
		gbc_btnInversa.gridy = 0;
		panelVariable.add(btnInversa, gbc_btnInversa);
		
		btnConvolucion = new JButton("CONVOLUCION");
		btnConvolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager.put("OptionPane.background", new Color(38, 43, 73));
		        UIManager.put("Panel.background", new Color(38, 43, 73));
		        UIManager.put("OptionPane.messageForeground", Color.WHITE);
		        UIManager.put("OptionPane.buttonForeground", Color.WHITE);
		        UIManager.put("OptionPane.okButtonText", "ACEPTAR");
		        UIManager.put("OptionPane.cancelButtonText", "CANCELAR");
		        try {
		        	int cantidad = Integer.parseInt(JOptionPane.showInputDialog("INGRESE LA CANTIDAD DE VARIABLES"));
		        	Double media = Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA MEDIA"));
		        	Double desviacion = Double.parseDouble(JOptionPane.showInputDialog("INGRESE LA DESVIACION ESTANDAR"));
			        Convolucion convolucion = new Convolucion(cantidad, listaR, media, desviacion);
			        JOptionPane.showMessageDialog(null, convolucion.generarMuestras(), "VARIABLES ALEATORIAS - CONVOLUCION", JOptionPane.INFORMATION_MESSAGE);
		        }catch (Exception ex){
		        	JOptionPane.showMessageDialog(null, "INGRESE UN VALOR VALIDO", "VARIABLES ALEATORIAS - CONVOLUCION", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnConvolucion.setEnabled(false);
		btnConvolucion.setBackground(new Color(255, 128, 0));
		btnConvolucion.setForeground(new Color(255, 255, 255));
		btnConvolucion.setFont(new Font("Product Sans", Font.BOLD, 18));
		GridBagConstraints gbc_btnConvolucion = new GridBagConstraints();
		gbc_btnConvolucion.insets = new Insets(0, 0, 0, 5);
		gbc_btnConvolucion.gridx = 1;
		gbc_btnConvolucion.gridy = 0;
		panelVariable.add(btnConvolucion, gbc_btnConvolucion);
		
		btnComposicion = new JButton("COMPOSICION");
		btnComposicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager.put("OptionPane.background", new Color(38, 43, 73));
		        UIManager.put("Panel.background", new Color(38, 43, 73));
		        UIManager.put("OptionPane.messageForeground", Color.WHITE);
		        UIManager.put("OptionPane.buttonForeground", Color.WHITE);
		        UIManager.put("OptionPane.okButtonText", "ACEPTAR");
		        UIManager.put("OptionPane.cancelButtonText", "CANCELAR");
		        try {
		        	Double alpha = Double.parseDouble(JOptionPane.showInputDialog("INGRESE EL VALOR DE ALPHA"));
			        Composicion composicion = new Composicion(alpha, listaR);
			        JOptionPane.showMessageDialog(null, composicion.generarMuestras(), "VARIABLES ALEATORIAS - COMPOSICION", JOptionPane.INFORMATION_MESSAGE);
		        }catch (Exception ex){
		        	JOptionPane.showMessageDialog(null, "INGRESE UN VALOR VALIDO", "VARIABLES ALEATORIAS - COMPOSICION", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		btnComposicion.setForeground(Color.WHITE);
		btnComposicion.setFont(new Font("Dialog", Font.BOLD, 18));
		btnComposicion.setEnabled(false);
		btnComposicion.setBackground(new Color(255, 128, 0));
		GridBagConstraints gbc_btnComposicion = new GridBagConstraints();
		gbc_btnComposicion.gridx = 2;
		gbc_btnComposicion.gridy = 0;
		panelVariable.add(btnComposicion, gbc_btnComposicion);
		
		table = new JTable();
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(28, 32, 57));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(null);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		table.setFont(new Font("Product Sans", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "X0", "X", "R" }));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(28, 32, 57));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		headerRenderer.setForeground(Color.WHITE);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
		table.getTableHeader().setDefaultRenderer(headerRenderer);
		table.getTableHeader().setDefaultRenderer(headerRenderer);
		table.setDefaultEditor(Object.class, null);
		table.setEditingColumn(0);
		table.getTableHeader().setReorderingAllowed(false);

	}

	public boolean areEmpty() {
		return semilla.getText().equalsIgnoreCase("") || valorC.getText().equalsIgnoreCase("");
	}

	public void limpiarCampos() {
		btnInversa.setEnabled(false);
		btnConvolucion.setEnabled(false);
		btnComposicion.setEnabled(false);
		semilla.setText("");
		valorA.setText("");
		valorC.setText("");
		valorM.setText("");
		txtPruebas.setText("");
		semilla.requestFocus();
		limpiarTabla();
	}

	@SuppressWarnings("unlikely-arg-type")
	public void calcularValores() {
		if (!areEmpty()) {
			if( valorC.equals("0")) {
				limpiarTabla();
				btnInversa.setEnabled(true);
				btnConvolucion.setEnabled(true);
				btnComposicion.setEnabled(true);
				int x0 = Integer.parseInt(semilla.getText());
				int a = Integer.parseInt(valorA.getText());
				int c = Integer.parseInt(valorC.getText());
				int m = Integer.parseInt(valorM.getText());
				CongruencialLineal congruencialLineal = new CongruencialLineal(x0, a, c, m);
				congruencialLineal.getNumbers();
				listaX0 = congruencialLineal.getListaX0();
				listaX = congruencialLineal.getListaX();
				listaR = congruencialLineal.getListaR();
				Object[] datos = new Object[table.getColumnCount()];
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				for (int i = 0; i < listaX0.size(); i++) {
					datos[0] = listaX0.get(i);
					datos[1] = listaX.get(i);
					datos[2] = listaR.get(i);
					modelo.addRow(datos);
				}
				String pruebas = "";
				PruebaMedia pruebaMedia = new PruebaMedia(listaR);
				pruebas = pruebaMedia.media();
				PruebaVarianza pruebaVarianza = new PruebaVarianza(listaR);
				pruebas += pruebaVarianza.varianza();
				PruebaUniformidad pruebaChiCuadrada = new PruebaUniformidad(listaR);
				pruebas += pruebaChiCuadrada.chiCuadrada();
				PruebaAleatoriedad pruebaAleatoriedad = new PruebaAleatoriedad(listaR);
				pruebas += pruebaAleatoriedad.autocorrelacion();
				PruebaIndependencia pruebaIndependencia = new PruebaIndependencia(listaR);
				pruebas += pruebaIndependencia.poker();
				txtPruebas.setText(pruebas);
			}else {
				JOptionPane.showMessageDialog(null, "C DEBE SER DIFERENTE A CERO");
				valorC.requestFocus();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
		}
	}

	public void limpiarTabla() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}

	public JButton getBtnCalcular() {
		return btnCalcular;
	}

}
