package principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelOpciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCMedios;
	private JButton btnPMedios;
	private JButton btnMConstante;
	private JButton btnCLineal;
	private JButton btnCAditivo;
	private JLabel lblNewLabel_2;
	private JButton btnCMultiplicativo;
	private JButton btnCCMedios;

	public PanelOpciones() {
		setFocusCycleRoot(true);
		setFocusTraversalPolicyProvider(true);
		setFont(new Font("Product Sans", Font.BOLD, 11));
		setForeground(new Color(255, 255, 255));
		setBorder(null);
		setBackground(new Color(37, 44, 71));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 0};
		gridBagLayout.rowHeights = new int[]{40, 40, 16, 40, 16, 40, 16, 40, 16, 40, 16, 40, 16, 40, 16, 40, 16};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 10.0, 0.0, 30.0};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("@GMP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Product Sans", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIMULACION");
		lblNewLabel_1.setForeground(new Color(244, 42, 87));
		lblNewLabel_1.setFont(new Font("Product Sans", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		btnCMedios = new JButton("C.MEDIOS");
		btnCMedios.setEnabled(false);
		btnCMedios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCMedios.setForeground(Color.WHITE);
		btnCMedios.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnCMedios.setFocusTraversalPolicyProvider(true);
		btnCMedios.setFocusCycleRoot(true);
		btnCMedios.setDoubleBuffered(true);
		btnCMedios.setContentAreaFilled(false);
		btnCMedios.setBorder(null);
		GridBagConstraints gbc_btnCMedios = new GridBagConstraints();
		gbc_btnCMedios.insets = new Insets(0, 0, 5, 0);
		gbc_btnCMedios.gridx = 0;
		gbc_btnCMedios.gridy = 3;
		add(btnCMedios, gbc_btnCMedios);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnCMedios.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnPMedios = new JButton("P.MEDIOS");
		btnPMedios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPMedios.setDoubleBuffered(true);
		btnPMedios.setFocusCycleRoot(true);
		btnPMedios.setFocusTraversalPolicyProvider(true);
		btnPMedios.setForeground(Color.WHITE);
		btnPMedios.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnPMedios.setContentAreaFilled(false);
		btnPMedios.setBorder(null);
		GridBagConstraints gbc_btnPMedios = new GridBagConstraints();
		gbc_btnPMedios.insets = new Insets(0, 0, 5, 0);
		gbc_btnPMedios.gridx = 0;
		gbc_btnPMedios.gridy = 5;
		add(btnPMedios, gbc_btnPMedios);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnPMedios.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnMConstante = new JButton("M.CONSTANTE");
		btnMConstante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMConstante.setDoubleBuffered(true);
		btnMConstante.setFocusCycleRoot(true);
		btnMConstante.setFocusTraversalPolicyProvider(true);
		btnMConstante.setForeground(Color.WHITE);
		btnMConstante.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnMConstante.setContentAreaFilled(false);
		btnMConstante.setBorder(null);
		GridBagConstraints gbc_btnMConstante = new GridBagConstraints();
		gbc_btnMConstante.insets = new Insets(0, 0, 5, 0);
		gbc_btnMConstante.gridx = 0;
		gbc_btnMConstante.gridy = 7;
		add(btnMConstante, gbc_btnMConstante);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnMConstante.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnCLineal = new JButton("C.LINEAL");
		btnCLineal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCLineal.setDoubleBuffered(true);
		btnCLineal.setFocusCycleRoot(true);
		btnCLineal.setFocusTraversalPolicyProvider(true);
		btnCLineal.setForeground(Color.WHITE);
		btnCLineal.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnCLineal.setContentAreaFilled(false);
		btnCLineal.setBorder(null);
		GridBagConstraints gbc_btnCLineal = new GridBagConstraints();
		gbc_btnCLineal.insets = new Insets(0, 0, 5, 0);
		gbc_btnCLineal.gridx = 0;
		gbc_btnCLineal.gridy = 9;
		add(btnCLineal, gbc_btnCLineal);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnCLineal.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnCAditivo = new JButton("C.ADITIVO");
		btnCAditivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCAditivo.setForeground(Color.WHITE);
		btnCAditivo.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnCAditivo.setFocusTraversalPolicyProvider(true);
		btnCAditivo.setFocusCycleRoot(true);
		btnCAditivo.setDoubleBuffered(true);
		btnCAditivo.setContentAreaFilled(false);
		btnCAditivo.setBorder(null);
		GridBagConstraints gbc_btnCAditivo = new GridBagConstraints();
		gbc_btnCAditivo.insets = new Insets(0, 0, 5, 0);
		gbc_btnCAditivo.gridx = 0;
		gbc_btnCAditivo.gridy = 11;
		add(btnCAditivo, gbc_btnCAditivo);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnCAditivo.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnCMultiplicativo = new JButton("C.L.MULTIPLICATIVO");
		btnCMultiplicativo.setForeground(Color.WHITE);
		btnCMultiplicativo.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnCMultiplicativo.setFocusTraversalPolicyProvider(true);
		btnCMultiplicativo.setFocusCycleRoot(true);
		btnCMultiplicativo.setDoubleBuffered(true);
		btnCMultiplicativo.setContentAreaFilled(false);
		btnCMultiplicativo.setBorder(null);
		GridBagConstraints gbc_btnCMultiplicativo = new GridBagConstraints();
		gbc_btnCMultiplicativo.insets = new Insets(0, 0, 5, 0);
		gbc_btnCMultiplicativo.gridx = 0;
		gbc_btnCMultiplicativo.gridy = 13;
		add(btnCMultiplicativo, gbc_btnCMultiplicativo);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnCMultiplicativo.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnCCMedios = new JButton("C.C.MEDIOS");
		btnCCMedios.setForeground(Color.WHITE);
		btnCCMedios.setFont(new Font("Product Sans", Font.BOLD, 22));
		btnCCMedios.setFocusTraversalPolicyProvider(true);
		btnCCMedios.setFocusCycleRoot(true);
		btnCCMedios.setDoubleBuffered(true);
		btnCCMedios.setContentAreaFilled(false);
		btnCCMedios.setBorder(null);
		GridBagConstraints gbc_btnCCMedios = new GridBagConstraints();
		gbc_btnCCMedios.insets = new Insets(0, 0, 5, 0);
		gbc_btnCCMedios.gridx = 0;
		gbc_btnCCMedios.gridy = 15;
		add(btnCCMedios, gbc_btnCCMedios);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/home.png"));
			Image scaledImage = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			btnCCMedios.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 16;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

	}

	public JButton getBtnCMedios() {
		return btnCMedios;
	}

	public JButton getBtnPMedios() {
		return btnPMedios;
	}

	public JButton getBtnMConstante() {
		return btnMConstante;
	}

	public JButton getBtnCLineal() {
		return btnCLineal;
	}

	public JButton getBtnCAditivo() {
		return btnCAditivo;
	}

	public JButton getBtnCMultiplicativo() {
		return btnCMultiplicativo;
	}

	public JButton getBtnCCMedios() {
		return btnCCMedios;
	}

}
