package principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBarra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnMinimizar;
	private JButton btnSalir;

	public PanelBarra() {
		setBorder(null);
		setBackground(new Color(28, 32, 57));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 99.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		btnMinimizar = new JButton("");
		btnMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimizar.setBorder(null);
		btnMinimizar.setFocusTraversalKeysEnabled(false);
		btnMinimizar.setFocusPainted(false);
		btnMinimizar.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnMinimizar.setForeground(new Color(255, 255, 255));
		btnMinimizar.setContentAreaFilled(false);
		GridBagConstraints gbc_btnMinimizar = new GridBagConstraints();
		gbc_btnMinimizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMinimizar.gridx = 1;
		gbc_btnMinimizar.gridy = 0;
		add(btnMinimizar, gbc_btnMinimizar);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/minimize.png"));
			Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			btnMinimizar.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}

		btnSalir = new JButton("");
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBorder(null);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setFont(new Font("Product Sans", Font.BOLD, 20));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setContentAreaFilled(false);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 0;
		add(btnSalir, gbc_btnSalir);
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/recursos/img/close.png"));
			Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			btnSalir.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public JButton getBtnMinimizar() {
		return btnMinimizar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

}
