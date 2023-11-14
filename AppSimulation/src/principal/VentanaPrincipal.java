package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vista.PanelCongruencialAditivo;
import vista.PanelCongruencialCuadraticoMedio;
import vista.PanelCongruencialLineal;
import vista.PanelCongruencialLinealMultiplicativo;
import vista.PanelCuadradosMedios;
import vista.PanelMultiplicadorConstante;
import vista.PanelProductosMedios;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelBarra panelSuperior = new PanelBarra();
	private PanelInformacion panelInformacion = new PanelInformacion();
	private PanelOpciones panelOpciones = new PanelOpciones();
	private PanelCuadradosMedios panelCuadradosMedios = new PanelCuadradosMedios();
	private PanelProductosMedios panelProductosMedios = new PanelProductosMedios();
	private PanelMultiplicadorConstante panelMultiplicadorConstante = new PanelMultiplicadorConstante();
	private PanelCongruencialLineal panelCongruencialLineal = new PanelCongruencialLineal();
	private PanelCongruencialAditivo panelCongruencialAditivo = new PanelCongruencialAditivo();
	private PanelCongruencialLinealMultiplicativo panelCongruencialLinealMultiplicativo = new PanelCongruencialLinealMultiplicativo();
	private PanelCongruencialCuadraticoMedio panelCongruencialCuadraticoMedio = new PanelCongruencialCuadraticoMedio();
	private GridBagConstraints gbc_panelSuperior = new GridBagConstraints();
	private GridBagConstraints gbc_panelIzquierda = new GridBagConstraints();
	private GridBagConstraints gbc_panelInformacion = new GridBagConstraints();
	private GridBagConstraints gbc_panelDerecha = new GridBagConstraints();

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

	public VentanaPrincipal() {

		// Componentes
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 250, 1000 };
		gbl_contentPane.rowHeights = new int[] { 47, 54, 0 };
		gbl_contentPane.columnWeights = new double[] { 10.0, 90.0 };
		gbl_contentPane.rowWeights = new double[] { 5.0, 5.0, 90.0 };
		contentPane.setLayout(gbl_contentPane);

		gbc_panelSuperior = new GridBagConstraints();
		gbc_panelSuperior.fill = GridBagConstraints.BOTH;
		gbc_panelSuperior.gridx = 1;
		gbc_panelSuperior.gridy = 0;
		panelSuperior.setBorder(new EmptyBorder(15, 0, 0, 15));
		contentPane.add(panelSuperior, gbc_panelSuperior);

		gbc_panelIzquierda = new GridBagConstraints();
		gbc_panelIzquierda.gridheight = 3;
		gbc_panelIzquierda.fill = GridBagConstraints.BOTH;
		gbc_panelIzquierda.gridx = 0;
		gbc_panelIzquierda.gridy = 0;
		panelOpciones.setBorder(new EmptyBorder(15, 0, 15, 0));
		contentPane.add(panelOpciones, gbc_panelIzquierda);

		gbc_panelInformacion.fill = GridBagConstraints.BOTH;
		gbc_panelInformacion.gridx = 1;
		gbc_panelInformacion.gridy = 1;
		panelInformacion.setBorder(new EmptyBorder(0, 15, 0, 15));
		contentPane.add(panelInformacion, gbc_panelInformacion);

		panelCuadradosMedios.setBackground(new Color(28, 32, 57));
		panelCuadradosMedios.setBorder(new EmptyBorder(0, 15, 15, 15));
		gbc_panelDerecha.fill = GridBagConstraints.BOTH;
		gbc_panelDerecha.gridx = 1;
		gbc_panelDerecha.gridy = 2;
		contentPane.add(panelCuadradosMedios, gbc_panelDerecha);

		// Metodos Barra Superior
		panelSuperior.getBtnMinimizar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		panelSuperior.getBtnSalir().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.exit(0);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});

		// Metodos Barra Opciones
		panelOpciones.getBtnCMedios().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelCuadradosMedios);
			}
		});
		panelOpciones.getBtnPMedios().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelProductosMedios);
			}
		});
		panelOpciones.getBtnMConstante().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelMultiplicadorConstante);
			}
		});
		panelOpciones.getBtnCLineal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelCongruencialLineal);
			}
		});
		panelOpciones.getBtnCAditivo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelCongruencialAditivo);
			}
		});
		panelOpciones.getBtnCMultiplicativo().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelCongruencialLinealMultiplicativo);
			}
		});
		panelOpciones.getBtnCCMedios().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPaneles(panelCongruencialCuadraticoMedio);
			}
		});

	}

	public void removerPaneles(JPanel panelNuevo) {
		if (panelNuevo instanceof PanelCuadradosMedios) {
			habilitarBotones(true);
			panelOpciones.getBtnCMedios().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelCuadradosMedios, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("CUADRADOS MEDIOS");
			repaint();
			setVisible(true);
			System.gc();

		} else if (panelNuevo instanceof PanelProductosMedios) {
			habilitarBotones(true);
			panelOpciones.getBtnPMedios().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelProductosMedios, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("PRODUCTOS MEDIOS");
			repaint();
			setVisible(true);
			System.gc();
		} else if (panelNuevo instanceof PanelMultiplicadorConstante) {
			habilitarBotones(true);
			panelOpciones.getBtnMConstante().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelMultiplicadorConstante, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("M. CONSTANTE");
			repaint();
			setVisible(true);
			System.gc();
		} else if (panelNuevo instanceof PanelCongruencialLineal) {
			habilitarBotones(true);
			panelOpciones.getBtnCLineal().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelCongruencialLineal, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("C. LINEAL");
			repaint();
			setVisible(true);
			System.gc();
		} else if (panelNuevo instanceof PanelCongruencialAditivo) {
			habilitarBotones(true);
			panelOpciones.getBtnCAditivo().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelCongruencialAditivo, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("C. ADITIVO");
			repaint();
			setVisible(true);
			System.gc();
		} else if (panelNuevo instanceof PanelCongruencialLinealMultiplicativo) {
			habilitarBotones(true);
			panelOpciones.getBtnCMultiplicativo().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelCongruencialLinealMultiplicativo, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("C. MULTIPLICATIVO");
			repaint();
			setVisible(true);
			System.gc();
		} else if (panelNuevo instanceof PanelCongruencialCuadraticoMedio) {
			habilitarBotones(true);
			panelOpciones.getBtnCCMedios().setEnabled(false);
			contentPane.removeAll();
			contentPane.add(panelCongruencialCuadraticoMedio, gbc_panelDerecha);
			contentPane.add(panelSuperior, gbc_panelSuperior);
			contentPane.add(panelOpciones, gbc_panelIzquierda);
			contentPane.add(panelInformacion, gbc_panelInformacion);
			panelInformacion.getLblTitulo().setText("C.C.MEDIO");
			repaint();
			setVisible(true);
			System.gc();
		}
	}

	public void habilitarBotones(boolean state) {
		panelOpciones.getBtnCMedios().setEnabled(state);
		panelOpciones.getBtnPMedios().setEnabled(state);
		panelOpciones.getBtnMConstante().setEnabled(state);
		panelOpciones.getBtnCLineal().setEnabled(state);
		panelOpciones.getBtnCAditivo().setEnabled(state);
		panelOpciones.getBtnCMultiplicativo().setEnabled(state);
		panelOpciones.getBtnCCMedios().setEnabled(state);
	}

}
