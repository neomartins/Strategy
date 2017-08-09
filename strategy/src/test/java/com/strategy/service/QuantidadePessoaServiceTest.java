package com.strategy.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.strategy.model.Quadrado;
	

public class QuantidadePessoaServiceTest {

	private QuantidadePessoaServiceImpl pessoas = new QuantidadePessoaServiceImpl();

	 @Test
	  public void isQuadrado() {
		 Quadrado mesa = new Quadrado(5);
		 double quantidade = pessoas.quantidadePessoaEmMesa(10, 10, mesa);
	     assertEquals(96, quantidade, 000.1);
	  }
}
