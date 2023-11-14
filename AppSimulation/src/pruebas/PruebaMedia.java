package pruebas;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;

public class PruebaMedia {

	private ArrayList<Double> numeros;
	private double sumatoria;
	private double confianza;
	private double promedio;
	private double alfa;
	private double z;
	private double limiteInferior;
	private double limiteSuperior;
	private String resultado;

	public PruebaMedia(ArrayList<Double> numeros) {
		this.numeros = numeros;
		this.confianza = 95.0/100;
		this.alfa = 1 - confianza;
		this.promedio = 0;
		this.z = 0;
		this.limiteInferior = 0;
		this.limiteSuperior = 0;
		this.resultado = "";
	}

	public String media() {
		
		resultado += "PRUEBA MEDIA: " + "\n";
		
		for (int i = 0; i < numeros.size(); i++) {
			sumatoria = sumatoria + numeros.get(i);
		}
		promedio = sumatoria / numeros.size();
		resultado += "MEDIA = " + promedio + "\n";
		
		NormalDistribution nd = new NormalDistribution();
		z = nd.inverseCumulativeProbability(1 - alfa / 2);
		
		NumberFormat numberFormat = NumberFormat.getInstance(); 
		z = Double.parseDouble(numberFormat.format(z));
		
		limiteInferior = 0.5 - z * (1 / Math.sqrt(12 * numeros.size()));
		resultado += "L.INFERIOR = " + limiteInferior + "\n";

		limiteSuperior = 0.5 + z * (1 / Math.sqrt(12 * numeros.size()));
		resultado += "L.SUPERIOR = " + limiteSuperior + "\n";

		if (promedio >= limiteInferior & promedio <= limiteSuperior){
			resultado += "HIPOTESIS ACEPTADA!" + "\n\n";
		} else {
			resultado += "HIPOTESIS RECHAZADA!" + "\n\n";
		}
		return resultado;
	}

}
