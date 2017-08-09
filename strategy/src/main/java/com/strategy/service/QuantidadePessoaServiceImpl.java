package com.strategy.service;

import com.strategy.model.Quadrado;
import static com.strategy.service.Constantes.AREA_CADEIRA;
import static com.strategy.service.Constantes.LARGURA_CADEIRA;

import org.springframework.stereotype.Service;;

/**
 * Created by Gustavo Martins
 */
@Service
public class QuantidadePessoaServiceImpl implements QuantidadePessoaService {

	private FiguraGeometricaServiceImpl figuraGeometrica = new FiguraGeometricaServiceImpl();

	/**
	 * Method para verificar a quantidade de pessoas no salão
	 * 
	 * @param double
	 *            lado1, primeiro lado do salão
	 * 
	 * @param double
	 *            lado2, segundo lado do salão
	 * 
	 * @param mesa
	 * 
	 * @return quantidade de pessoas que o salão suporta
	 */

	@Override
	public double quantidadePessoaEmMesa(double lado1, double lado2, Quadrado mesa) {

		this.regras(lado1, lado2, mesa);

		double areaSalao = figuraGeometrica.getArea(lado1, lado2);
		double pessoaPorMesa = this.quantidadeCadeiraPorMesa(mesa.getLado1());
		double areaMesaComCadeira = this.areaMesaComCadeira(pessoaPorMesa, mesa.calcArea());
		double mesaSalão = this.quantidadeMesaSalão(areaSalao, areaMesaComCadeira);

		return Math.floor((mesaSalão * pessoaPorMesa));
	}

	private void regras(double lado1, double lado2, Quadrado mesa) {

		if (lado1 < 0 || lado1 < 0 || mesa.getLado1() < 0)
			throw new GenericException("Nenhum valor pode ser negativo ");

		if ((Math.floor(lado1 * lado2) < mesa.calcArea()))
			throw new GenericException("A area do salão é menor que a area da mesa ");
	}

	/**
	 * Method para verificar a area de cada mesa junto com a area da cadeira
	 * 
	 * @param double
	 *            quantidade de cadeiras por mesa
	 * 
	 * @param double
	 *            area da mesa
	 * 
	 * @return Area da mesa + area da cadeira, area total ocupada por cada mesa
	 */

	private double areaMesaComCadeira(double quantidadeCadeiraMesa, double areaMesa) {
		return Math.floor(quantidadeCadeiraMesa * AREA_CADEIRA) + areaMesa;
	}

	/**
	 * Method para verificar quantas cadeiras cabem em cada mesa
	 * 
	 * @param double
	 *            lado da mesa
	 * 
	 * @return quantidade total de cadeiras em cada mesa
	 */

	private double quantidadeCadeiraPorMesa(double ladoMesa) {
		return (Math.floor(ladoMesa / LARGURA_CADEIRA) * 4);
	}

	/**
	 * Method para verificar quantas mesas cabem no salão
	 * 
	 * @param double
	 *            area total salão
	 * 
	 * @param double
	 *            area total mesa
	 * 
	 * @return quantidade total mesas que cabem no salão
	 */

	private double quantidadeMesaSalão(double areaSalao, double areaMesa) {
		return Math.floor(areaSalao / areaMesa);
	}

}
