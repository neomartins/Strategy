package com.strategy.model;

/**
 * Created by Gustavo Martins
 */
public class Quadrado extends Quadrilatero {

	public Quadrado(double lado) {
		super(lado, lado, lado, lado);
	}

	@Override
	public double calcArea() {
		return Math.floor(this.getLado1() * this.getLado2());
	}

}
