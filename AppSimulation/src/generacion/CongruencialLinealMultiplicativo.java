package generacion;

import java.util.ArrayList;

public class CongruencialLinealMultiplicativo {

	private int x0;
	private int xInicial;
	private int a;
	private int m;
	private int x;
	private double r;
	private ArrayList<Integer> listaX0;
	private ArrayList<Integer> listaX;
	private ArrayList<Double> listaR;

	public CongruencialLinealMultiplicativo(int x0, int a, int m) {
		this.x0 = x0;
		this.xInicial = x0;
		this.a = a;
		this.m = m;
		this.x = 0;
		this.r = 0;
		this.listaX0 = new ArrayList<Integer>();
		this.listaX = new ArrayList<Integer>();
		this.listaR = new ArrayList<Double>();
	}

	public void getNumbers() {
		while (xInicial!=x) {
			listaX0.add(x0);
			x = (a*x0)%(m);
			listaX.add(x);
			r = x / (m-1.0);
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
