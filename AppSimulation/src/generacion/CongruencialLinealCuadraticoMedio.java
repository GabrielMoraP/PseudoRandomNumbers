package generacion;

import java.util.ArrayList;

public class CongruencialLinealCuadraticoMedio {

	private int x0;
	private int d;
	private int a;
	private int b;
	private int c;
	private int n;
	private double m;
	private int x;
	private double r;
	private ArrayList<Integer> listaX0;
	private ArrayList<Integer> listaX;
	private ArrayList<Double> listaR;

	public CongruencialLinealCuadraticoMedio(int x0, int d, int a, int b, int c, int n) {
		this.x0 = x0;
		this.d = d;
		this.m = 0;
		this.a = a;
		this.b = b;
		this.c = c;
		this.n = n;
		this.x = 0;
		this.r = 0;
		this.listaX0 = new ArrayList<Integer>();
		this.listaX = new ArrayList<Integer>();
		this.listaR = new ArrayList<Double>();
	}

	public void getNumbers() {
		m = Math.pow(2, d);
		for (int i = 0; i < n; i++) {
			listaX0.add(x0);
			x = ((a * (x0 * x0)) + (b * x0) + c) % ((int) m);
			listaX.add(x);
			r = x / m;
			listaR.add(r);
			x0 = x;
		}
	}

	public ArrayList<Integer> getListaX0() {
		return listaX0;
	}

	public ArrayList<Integer> getListaX() {
		return listaX;
	}

	public ArrayList<Double> getListaR() {
		return listaR;
	}

}
