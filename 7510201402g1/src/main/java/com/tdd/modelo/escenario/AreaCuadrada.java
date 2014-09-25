package com.tdd.modelo.escenario;

public class AreaCuadrada {
	
	private Punto centro;
	private int distancia;
	
	public AreaCuadrada(Punto centroRecibido, int distanciaAlBorde) {
		this.centro = new Punto(centroRecibido);
		this.distancia = distanciaAlBorde;
	}
	
	public void centrarEn(Punto punto) {
		this.centro = new Punto(punto);
	}
	
	private boolean puntoFormaParteRangoHorizontal(Punto punto) {
		int bordeVerticalMayor = this.centro.calcularXSumandoValor(this.distancia);
		int bordeVerticalMenor = this.centro.calcularXRestandoValor(this.distancia);
		
		return (punto.miXEsMenorOIgual(bordeVerticalMayor)
			 && punto.miXEsMayorOIgual(bordeVerticalMenor));
	}
	
	private boolean puntoFormaParteRangoVertical(Punto punto) {
		int bordeHorizontalMayor = this.centro.calcularYSumandoValor(this.distancia);
		int bordeHorizontalMenor = this.centro.calcularYRestandoValor(this.distancia);
		
		return (punto.miYEsMenorOIgual(bordeHorizontalMayor)
			 && punto.miYEsMayorOIgual(bordeHorizontalMenor));
	}
	
	public boolean puntoFormaParte(Punto punto) {
		return (this.puntoFormaParteRangoHorizontal(punto)
			 && this.puntoFormaParteRangoVertical(punto));
	}
	
}
