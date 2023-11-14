package variables;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Convolucion {

	private int numVariables;
    private ArrayList<Double> randomNumbers;
    private double media;
    private double desviacion;

    public Convolucion(int numVariables, ArrayList<Double> randomNumbers, double media, double desviacion) {
		super();
		this.numVariables = numVariables;
		this.randomNumbers = randomNumbers;
		this.media = media;
		this.desviacion = desviacion;
	}

	public JScrollPane generarMuestras() {
        Random random = new Random();
        List<Double> generatedVariables = new ArrayList<>();
        double sum = 0.0;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ri");
        model.addColumn("Ri-6");
        model.addColumn("Sigma");
        model.addColumn("Variable");
        for (int i = 0; i < numVariables; i++) {
            sum = 0.0;
            for (int j = 0; j < 12; j++) {
                int randomIndex = random.nextInt(randomNumbers.size());
                double randomNumber = randomNumbers.get(randomIndex);
                sum += randomNumber;
            }
            double variable = (sum - 6.0) * desviacion + media;
            model.addRow(new Object[]{sum, (sum - 6.0), (sum - 6.0) * desviacion, variable});
            generatedVariables.add(variable);
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
		table.getTableHeader().setDefaultRenderer(headerRenderer);
		table.setDefaultEditor(Object.class, null);
		table.setEditingColumn(0);
		table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800,600));
		return scrollPane;
    }
    
}

