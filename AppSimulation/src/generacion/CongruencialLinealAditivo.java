package generacion;

import java.util.ArrayList;

public class CongruencialLinealAditivo {

	private int x0;
	private int m;
	private int x;
	private double r;
	private ArrayList<Integer> semillas;
	private ArrayList<Integer> listaX0;
	private ArrayList<Integer> listaX;
	private ArrayList<Double> listaR;

	public CongruencialLinealAditivo(ArrayList<Integer> semillas, int m) {
		this.semillas = semillas;
		this.m = m;
		this.x = 0;
		this.r = 0;
		this.listaX0 = new ArrayList<Integer>();
		this.listaX = new ArrayList<Integer>();
		this.listaR = new ArrayList<Double>();
	}

	public void getNumbers() {
		for (int i = 0; i < semillas.size(); i++) {
			if(i==0) {
				x0 = semillas.get(i);
				listaX0.add(x0);
				x = (x0+semillas.get(semillas.size()-1)) % (m);
				listaX.add(x);
				r = x/(m-1.0);
				listaR.add(r);
			}else {
				x0 = semillas.get(i);
				listaX0.add(x0);
				x = (x0+x) % (m);
				listaX.add(x);
				r = x/(m-1.0);
				listaR.add(r);
			}
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
