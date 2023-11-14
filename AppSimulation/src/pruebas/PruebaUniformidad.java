package pruebas;

import java.util.ArrayList;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;

public class PruebaUniformidad {

	private ArrayList<Double> numeros;
	private ArrayList<Double> numerosIntervalos;
	private ArrayList<Integer> numerosOi;
	private int m;
	private double confianza;
	private double alfa;
	private int Ei;
	private double chiCuadradaCalculada;
	private double chiCuadrada;
	private String resultado;

	public PruebaUniformidad(ArrayList<Double> numeros) {
		this.numeros = numeros;
		this.m = (int) Math.sqrt(numeros.size());
		this.confianza = 95.0 / 100.0;
		this.alfa = 1 - confianza;
		this.Ei = numeros.size() / m;
		this.chiCuadradaCalculada = 0;
		this.chiCuadrada = 0;
		this.numerosIntervalos = new ArrayList<Double>();
		this.numerosOi = new ArrayList<Integer>();
		this.resultado = "";
	}

	public String chiCuadrada() {
		if (numeros.size() > 3) {
			for (double i = 0; i <= 1; i += (1.0 / m)) {
				numerosIntervalos.add(i);
			}

			for (int i = 0; i < numerosIntervalos.size() - 1; i++) {
				int contador = 0;
				for (int j = 0; j < numeros.size(); j++) {
					if (numeros.get(j) >= numerosIntervalos.get(i) && numeros.get(j) < numerosIntervalos.get(i + 1)) {
						contador++;
					}
				}
				numerosOi.add(contador);
			}

			for (int i = 0; i < numerosOi.size(); i++) {
				chiCuadradaCalculada += (Math.pow((numerosOi.get(i) - Ei), 2)) / Ei;
			}

			ChiSquaredDistribution cs = new ChiSquaredDistribution(m - 1.0);
			chiCuadrada = cs.inverseCumulativeProbability(1 - alfa);

			resultado += "PRUEBA UNIFORMIDAD: " + "\n";
			resultado += "INTERVALOS = " + numerosIntervalos.toString() + "\n";
			resultado += "Oi = " + numerosOi.toString() + "\n";
			resultado += "Ei = " + Ei + "\n";
			resultado += "X^2_0 = " + chiCuadradaCalculada + "\n";
			resultado += "X^2_alfa_m-1 = " + chiCuadrada + "\n";

			if (chiCuadradaCalculada <= chiCuadrada) {
				resultado += "HIPOTESIS ACEPTADA!" + "\n\n";
			} else {
				resultado += "HIPOTESIS RECHAZADA!" + "\n\n";
			}
		} else {
			resultado += "PRUEBA UNIFORMIDAD: " + "\n";
			resultado += "NO APLICA!" + "\n\n";
		}

		return resultado;
	}

}
