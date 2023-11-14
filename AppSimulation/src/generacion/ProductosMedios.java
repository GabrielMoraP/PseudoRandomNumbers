package generacion;

import java.util.ArrayList;

public class ProductosMedios {
	private int x0;
	private int x1;
	private int n;
	private long y;
	private int x;
	private double r;
	private ArrayList<Integer> listaX0;
	private ArrayList<Long> listaY;
	private ArrayList<Integer> listaX;
	private ArrayList<Double> listaR;

	public ProductosMedios(int x0, int x1, int n) {
		this.x0 = x0;
		this.x1 = x1;
		this.n = n;
		this.y = 0;
		this.x = 0;
		this.r = 0;
		this.listaX0 = new ArrayList<Integer>();
		this.listaY = new ArrayList<Long>();
		this.listaX = new ArrayList<Integer>();
		this.listaR = new ArrayList<Double>();
	}

	public void getNumbers() {
		for (int i = 0; i < n; i++) {
			listaX0.add(x0);
			y = x0 * x1;
			listaY.add(y);
			String cadenaY = String.valueOf(y);
			if (cadenaY.length() < 8) {
				int digitosFaltantes = 8 - cadenaY.length();
				String aux = "0";
				for (int j = 0; j < digitosFaltantes; j++) {
					cadenaY = aux + cadenaY;
				}
			}
			x = Integer.parseInt(cadenaY.substring(2, 6));
			listaX.add(x);
			r = x / 10000.0;
			listaR.add(r);
			x0 = x1;
			x1 = x;
		}
	}

	public ArrayList<Integer> getListaX0() {
		return listaX0;
	}

	public ArrayList<Long> getListaY() {
		return listaY;
	}

	public ArrayList<Integer> getListaX() {
		return listaX;
	}

	public ArrayList<Double> getListaR() {
		return listaR;
	}
}
