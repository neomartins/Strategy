package com.strategy.service;

import com.strategy.model.Quadrado;
import com.strategy.model.Retangulo;

/**
 * Created by Gustavo Martins
 */
public class FiguraGeometricaServiceImpl implements FiguraGeometricaService {

	/**
	 * Verifica se é um quadrado ou um retangulo
	 * 
	 * @param double
	 *            lado1 da figura
	 * @param double
	 *            lado2 da figura
	 * @return booblean
	 */
	@Override
	public boolean isQuadrado(double lado1, double lado2) {
		if (lado1 == lado2)
			return true;

		return false;
	}

	/**
	 * Retorna a área da forma geometrica
	 * 
	 * @param double
	 *            lado1 da figura
	 * @param double
	 *            lado2 da figura
	 * @return area da forma geometrica
	 */
	@Override
	public double getArea(double lado1, double lado2) {

		if (this.isQuadrado(lado1, lado2))
			return new Quadrado(lado1).calcArea();

		return new Retangulo(lado1, lado2).calcArea();
	}

}
