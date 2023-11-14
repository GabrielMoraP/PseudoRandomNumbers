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

public class Inversa {
    private double lambda;
    private ArrayList<Double> listaU;

    public Inversa(double lambda, ArrayList<Double> listaU) {
        this.lambda = lambda;
        this.listaU = listaU;
    }

    public JScrollPane generarMuestras() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ri");
        model.addColumn("Variable");
        for (int i = 0; i < listaU.size(); i++) {
            double x = -1.0 / lambda * Math.log(1 - listaU.get(i));
            model.addRow(new Object[]{listaU.get(i), x});
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
		table.getTableHeader().setDefaultRenderer(headerRenderer);
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
