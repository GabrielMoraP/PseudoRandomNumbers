package pruebas;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

public class PruebaVarianza {

	private ArrayList<Double> numeros;
	private double sumatoria;
	private double sumatoriaVarianza;
	private double confianza;
	private double promedio;
	private double alfa;
	private double varianza;
	private double z;
	private double limiteInferior;
	private double limiteSuperior;
	private String resultado;

	public PruebaVarianza(ArrayList<Double> numeros) {
		this.numeros = numeros;
		this.confianza = 95.0 / 100;
		this.promedio = 0;
		this.alfa = 1 - confianza;
		this.varianza = 0;
		this.z = 0;
		this.limiteInferior = 0;
		this.limiteSuperior = 0;
		this.resultado = "";
	}

	public String varianza() {
		
		resultado += "PRUEBA VARIANZA: " + "\n";
		
		for (int i = 0; i < numeros.size(); i++) {
			sumatoria = sumatoria + numeros.get(i);
		}
		promedio = sumatoria / numeros.size();

		for (int i = 0; i < numeros.size(); i++) {
			sumatoriaVarianza = sumatoriaVarianza + Math.pow((numeros.get(i) - promedio), 2);
		}
		varianza = (sumatoriaVarianza) / (numeros.size() - 1);
		resultado += "VARIANZA = " + varianza + "\n";

		NormalDistribution nd = new NormalDistribution();
		z = nd.inverseCumulativeProbability(1 - alfa / 2);

		NumberFormat numberFormat = NumberFormat.getInstance();
		z = Double.parseDouble(numberFormat.format(z));

		ChiSquaredDistribution chi = new ChiSquaredDistribution(numeros.size() - 1);
		limiteInferior = chi.inverseCumulativeProbability(alfa / 2) / (12 * (numeros.size() - 1));
		
		resultado += "L.INFERIOR = " + limiteInferior + "\n";

		limiteSuperior = chi.inverseCumulativeProbability(1 - alfa / 2) / (12 * (numeros.size() - 1));
		resultado += "L.SUPERIOR = " + limiteSuperior + "\n";

		if (varianza >= limiteInferior & varianza <= limiteSuperior) {
			resultado += "CONJUNTO R(i) ACEPTADO!" + "\n\n";
		} else {
			resultado += "CONJUNTO R(i) DENEGADO!" + "\n\n";
		}
		return resultado;
	}

}
