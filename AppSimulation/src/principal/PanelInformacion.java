package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utileria.FechaActual;
import utileria.Reloj;

public class PanelInformacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private Reloj horaActual = new Reloj();
	private FechaActual fechaActual = new FechaActual();
	private JLabel lblTitulo;

	public PanelInformacion() {
		setBorder(new EmptyBorder(0, 30, 0, 30));
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Product Sans", Font.BOLD, 30));
		setBackground(new Color(28, 32, 57));
		setLayout(new GridLayout(0, 2, 0, 0));

		lblTitulo = new JLabel("CUADRADOS MEDIOS");
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Product Sans", Font.PLAIN, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblTitulo);

		JLabel lblHora = new JLabel();
		lblHora.setVerticalAlignment(SwingConstants.TOP);
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Product Sans", Font.PLAIN, 40));
		add(lblHora);
		horaActual.currentHour(lblHora);

		JLabel label = new JLabel("");
		add(label);

		JLabel lblFecha = new JLabel("");
		lblFecha.setVerticalAlignment(SwingConstants.TOP);
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setForeground(new Color(244, 42, 87));
		lblFecha.setFont(new Font("Product Sans", Font.BOLD, 20));
		add(lblFecha);
		fechaActual.Fecha(lblFecha);
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

}
