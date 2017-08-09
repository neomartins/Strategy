package com.strategy.model;

/**
 * Created by Gustavo Martins
 */
public class Retangulo extends Quadrilatero {

	public Retangulo(double lado1, double lado2) {
		super(lado1, lado2, lado1, lado2);
	}

	@Override
	public double calcArea() {
		return Math.floor(this.getLado1() * this.getLado2());

	}

}
