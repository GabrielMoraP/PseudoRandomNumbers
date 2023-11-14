package pruebas;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;

public class PruebaAleatoriedad {

	private ArrayList<Double> numeros;
	private int i;
	private int m;
	private int M;
	private double Pim;
	private double sumatoria;
	private double OPim;
	private double zCalculada;
	private double confianza;
	private double alfa;
	private double z;
	private String resultado;

	public PruebaAleatoriedad(ArrayList<Double> numeros) {
		this.numeros = numeros;
		this.i = 2;
		this.m = 5;
		this.M = 0;
		this.Pim = 0;
		this.sumatoria = 0;
		this.OPim = 0;
		this.zCalculada = 0;
		this.z = 0;
		this.confianza = 90.0 / 100.0;
		this.alfa = 1 - confianza;
		this.resultado = "";
	}

	public String autocorrelacion() {

		if (numeros.size() < 30) {
			m = 2;
			i = 0;
		}
		
		if(numeros.size() > 2) {
			M = (int) (((numeros.size() - i) / m) - 1);
			for (int k = 0; k < m - 1; k++) {
				sumatoria += numeros.get(i + k * m) * numeros.get(i + (k + 1) * m);
			}
			Pim = (1.0 / (M + 1.0)) * sumatoria;
			OPim = (Math.sqrt((13 * M + 7))) / (12 * (M + 1));
			zCalculada = (Pim - 0.25) / OPim;
			NormalDistribution nd = new NormalDistribution();
			z = nd.inverseCumulativeProbability(1 - alfa / 2);
			NumberFormat numberFormat = NumberFormat.getInstance();
			z = Double.parseDouble(numberFormat.format(z));

			resultado += "PRUEBA ALEATORIEDAD: " + "\n";
			resultado += "i = " + i + ", m = " + m + ", M = " + M + "\n";
			resultado += "Pim = " + Pim + "\n";
			resultado += "OPim = " + OPim + "\n";
			resultado += "Z = " + zCalculada + "\n";
			resultado += "Z_alfa/2 = " + z + "\n";

			if (zCalculada <= z) {
				resultado += "HIPOTESIS ACEPTADA!" + "\n\n";
			} else {
				resultado += "HIPOTESIS RECHAZADA!" + "\n\n";
			}
		}else {
			resultado += "PRUEBA ALEATORIEDAD: " + "\n";
			resultado += "NO APLICA!" + "\n\n";
		}
		
		return resultado;
	}

}
