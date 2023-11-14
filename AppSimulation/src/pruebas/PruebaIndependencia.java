package pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;

public class PruebaIndependencia {

	private ArrayList<Double> numeros;
	private ArrayList<Integer> numerosOi;
	private ArrayList<Double> numerosEi;
	private ArrayList<Double> probabilidades;
	private double chiCuadradaCalculada;
	private double chiCuadrada;
	private double alfa;
	private double confianza;
	private String resultado;

	public PruebaIndependencia(ArrayList<Double> numeros) {
		this.numeros = numeros;
		this.numerosOi = new ArrayList<Integer>();
		this.numerosEi = new ArrayList<Double>();
		this.probabilidades = new ArrayList<Double>();
		probabilidades.add(0.3024);
		probabilidades.add(0.5040);
		probabilidades.add(0.1080);
		probabilidades.add(0.0090);
		probabilidades.add(0.0720);
		probabilidades.add(0.0045);
		probabilidades.add(0.0001);
		this.confianza = 95.0 / 100.0;
		this.alfa = 1 - confianza;
		this.chiCuadrada = 0;
		this.chiCuadradaCalculada = 0;
		this.resultado = "";
	}

	public String poker() {

		int contadorTD = 0;
		int contador1P = 0;
		int contador2P = 0;
		int contadorTP = 0;
		int contadorT = 0;
		int contadorP = 0;
		int contadorQ = 0;

		for (int i = 0; i < numeros.size(); i++) {
			String cadenaNumero = String.valueOf(numeros.get(i));
			if (cadenaNumero.length() < 7) {
				int digitosFaltantes = 7 - cadenaNumero.length();
				for (int j = 0; j < digitosFaltantes; j++) {
					cadenaNumero += "0";
				}
			}
			ArrayList<Integer> digitosEncontrados = new ArrayList<Integer>();
			for (int j = 0; j < cadenaNumero.length() - 2; j++) {
				int contador = 0;
				char digito = cadenaNumero.charAt(j + 2);
				for (int k = 0; k < cadenaNumero.length() - 2; k++) {
					if (digito == cadenaNumero.charAt(k + 2)) {
						contador++;
					}
				}
				digitosEncontrados.add(contador);
			}
			Comparator<Integer> comparador = Collections.reverseOrder();
			Collections.sort(digitosEncontrados, comparador);

			if (digitosEncontrados.get(0) == 1 && digitosEncontrados.get(3) == 1) {
				contadorTD++;
			} else if (digitosEncontrados.get(0) == 2 && digitosEncontrados.get(3) == 1) {
				contador1P++;
			} else if (digitosEncontrados.get(0) == 2 && digitosEncontrados.get(3) == 2) {
				contador2P++;
			} else if (digitosEncontrados.get(0) == 3 && digitosEncontrados.get(3) == 2) {
				contadorTP++;
			} else if (digitosEncontrados.get(0) == 3 && digitosEncontrados.get(3) == 1) {
				contadorT++;
			} else if (digitosEncontrados.get(0) == 4) {
				contadorP++;
			} else if (digitosEncontrados.get(0) == 5) {
				contadorQ++;
			}
		}

		numerosOi.add(contadorTD);
		numerosOi.add(contador1P);
		numerosOi.add(contador2P);
		numerosOi.add(contadorTP);
		numerosOi.add(contadorT);
		numerosOi.add(contadorP);
		numerosOi.add(contadorQ);

		for (int i = 0; i < numerosOi.size(); i++) {
			numerosEi.add(numerosOi.get(i) * probabilidades.get(i));
		}

		for (int i = 0; i < numerosEi.size(); i++) {
			if(numerosEi.get(i)!=0) {
				chiCuadradaCalculada += (Math.pow((numerosOi.get(i) - numerosEi.get(i)), 2)) / numerosEi.get(i);
			}
		}

		ChiSquaredDistribution cs = new ChiSquaredDistribution(numerosOi.size() - 1);
        chiCuadrada = cs.inverseCumulativeProbability(1 - alfa);

        resultado += "PRUEBA INDEPENDENCIA: " + "\n";
		resultado += "Oi = " + numerosOi.toString() + "\n";
		resultado += "Ei = " + numerosEi.toString() + "\n";
		resultado += "X^2 = " + chiCuadradaCalculada + "\n";
		resultado += "X^2_alfa_m-1 = " + chiCuadrada + "\n";

		if (chiCuadradaCalculada <= chiCuadrada) {
			resultado += "HIPOTESIS ACEPTADA!" + "\n\n";
		} else {
			resultado += "HIPOTESIS RECHAZADA!" + "\n\n";
		}

		return resultado;
	}

}
