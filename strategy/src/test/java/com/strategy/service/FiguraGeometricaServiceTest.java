package com.strategy.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class FiguraGeometricaServiceTest {
	private FiguraGeometricaServiceImpl figuraGeometrica = new FiguraGeometricaServiceImpl();
	 @Test
	  public void isQuadrado() {
		 boolean isQuadrado = figuraGeometrica.isQuadrado(2, 2);
	     assertEquals(true, isQuadrado);
	  }
	 
	 @Test
	  public void isNotQuadrado() {
		 boolean isQuadrado = figuraGeometrica.isQuadrado(2, 3);
	    assertEquals(false, isQuadrado);
	  }
	 
	 @Test
	  public void getArea() {
		 double area = figuraGeometrica.getArea(2d, 2d);
	     assertEquals(4d, area, 0.001);
	  }
}
