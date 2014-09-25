package com.tdd.modelo.escenario;

public class Punto {
	
	private int x, y;
	
	private void inicializar(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto(int valorX, int valorY) {
		this.inicializar(valorX, valorY);
	}

	public Punto(Punto otroPunto) {
		this.inicializar(otroPunto.getX(), otroPunto.getY());
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int calcularXSumandoValor(int valor) {
		return this.getX() + valor;
	}
	
	public int calcularXRestandoValor(int valor) {
		return this.getX() - valor;
	}
	
	public int calcularYSumandoValor(int valor) {
		return this.getY() + valor;
	}
	
	public int calcularYRestandoValor(int valor) {
		return this.getY() - valor;
	}
	
	
	public boolean miXEsIgual(int otroX) {
		return (this.getX() == otroX);
	}
	
	public boolean miXEsMenor(int otroX) {
		return (this.getX() < otroX);
	}
	
	public boolean miXEsMenorOIgual(int otroX) {
		return (this.miXEsMenor(otroX) || this.miXEsIgual(otroX));
	}
	
	public boolean miXEsMayor(int otroX) {
		return (this.getX() > otroX);
	}
	
	public boolean miXEsMayorOIgual(int otroX) {
		return (this.miXEsMayor(otroX) || this.miXEsIgual(otroX));
	}
	
	public boolean miXEsIgual(Punto otroPunto) {
		return this.miXEsIgual(otroPunto.getX());
	}
	
	public boolean miXEsMenor(Punto otroPunto) {
		return this.miXEsMenor(otroPunto.getX());
	}
	
	public boolean miXEsMenorOIgual(Punto otroPunto) {
		return this.miXEsMenorOIgual(otroPunto.getX());
	}
	
	public boolean miXEsMayor(Punto otroPunto) {
		return this.miXEsMayor(otroPunto.getX());
	}
	
	public boolean miXEsMayorOIgual(Punto otroPunto) {
		return this.miXEsMayorOIgual(otroPunto.getX());
	}
	
	public boolean miYEsIgual(int otroY) {
		return (this.getY() == otroY);
	}
	
	public boolean miYEsMenor(int otroY) {
		return (this.getY() < otroY);
	}
	
	public boolean miYEsMenorOIgual(int otroY) {
		return (this.miYEsMenor(otroY) || this.miYEsIgual(otroY));
	}
	
	public boolean miYEsMayor(int otroY) {
		return (this.getY() > otroY);
	}
	
	public boolean miYEsMayorOIgual(int otroY) {
		return (this.miYEsMayor(otroY) || this.miYEsIgual(otroY));
	}
	
	public boolean miYEsIgual(Punto otroPunto) {
		return this.miYEsIgual(otroPunto.getY());
	}
	
	public boolean miYEsMenor(Punto otroPunto) {
		return this.miYEsMenor(otroPunto.getY());
	}
	
	public boolean miYEsMenorOIgual(Punto otroPunto) {
		return this.miYEsMenorOIgual(otroPunto.getY());
	}
	
	public boolean miYEsMayor(Punto otroPunto) {
		return this.miYEsMayor(otroPunto.getY());
	}
	
	public boolean miYEsMayorOIgual(Punto otroPunto) {
		return this.miYEsMayorOIgual(otroPunto.getY());
	}
	
	public boolean equals(Punto otroPunto) {
		return (this.miXEsIgual(otroPunto) && this.miYEsIgual(otroPunto));
	}
	
}
