package variables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Composicion {

	private double alpha;
	private ArrayList<Double> listaU;

	public Composicion(double alpha, ArrayList<Double> listaU) {
		super();
		this.alpha = alpha;
		this.listaU = listaU;
	}

	public JScrollPane generarMuestras() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ri");
		model.addColumn("Comparacion");
		model.addColumn("Rango");
		model.addColumn("Formula");
		model.addColumn("Variable");
		for (int i = 0; i < listaU.size(); i++) {
			String rango = "";
			String comparacion = "";
			String formula = "";
			double resultado = 0.0;
			if (listaU.get(i) < alpha) {
				comparacion = listaU.get(i) + "<0.5";
				rango = "X1";
				if (i == listaU.size() - 1) {
					formula = "[" + 10 + "(" + listaU.get(0) + ")]+" + 1;
					resultado = (10 * listaU.get(0)) + 1;
				} else {
					formula = "[" + 10 + "(" + listaU.get(i + 1) + ")]+" + 1;
					resultado = (10 * listaU.get(i + 1)) + 1;
				}
			} else {
				comparacion = listaU.get(i) + ">=0.5";
				rango = "X2";
				if (i == listaU.size() - 1) {
					formula = "[" + 5 + "(" + listaU.get(0) + ")]+" + 6;
					resultado = (5 * listaU.get(0)) + 6;
				} else {
					formula = "[" + 5 + "(" + listaU.get(i + 1) + ")]+" + 6;
					resultado = (5 * listaU.get(i + 1)) + 6;
				}
			}
			model.addRow(new Object[] { listaU.get(i), comparacion, rango, formula, resultado });
		}
		JTable table = new JTable(model);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(28, 32, 57));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBorder(null);
		table.setRowHeight(30);
		table.setFont(new Font("Product Sans", Font.PLAIN, 14));
		DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
		headerRenderer.setBackground(new Color(28, 32, 57));
		headerRenderer.setHorizontalAlignment(JLabel.CENTER);
		headerRenderer.setForeground(Color.WHITE);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		table.getTableHeader().setDefaultRenderer(headerRenderer);
		table.setDefaultEditor(Object.class, null);
		table.setEditingColumn(0);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800,600));
		return scrollPane;
	}
}
