package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cursoJava.Circulo;
import cursoJava.Cuadrado;
import cursoJava.Figura;
import cursoJava.Triangulo;

public class FiguraTest {

	Figura cuadrado ; 
	Figura circulo ;
	Figura triangulo;
	
	ArrayList<Figura> figuras;
	@Before
	public void setUp() throws Exception {
		cuadrado = new Cuadrado("cua1", 10);
		circulo  = new Circulo("cir1", 10);
		triangulo =new Triangulo("tr1",10,10);
		
		figuras = new ArrayList<Figura>();
		figuras.add(new Cuadrado("cua1", 10));
		figuras.add(new Circulo("cir1", 10));
		figuras.add(new Cuadrado("cua2", 15));
		figuras.add(new Circulo("cir2", 15));
		figuras.add(new Cuadrado("cua3", 12.5f));
		figuras.add(new Circulo("cir3", 12.5f));
		figuras.add(new Triangulo("tr1",10,10));
		
		
	}

	@After
	public void tearDown() throws Exception {
		cuadrado = null;
		circulo = null;
		triangulo=null;
		figuras = null;
	}
//*********CUADRADO********
	@Test
	public void testCalcularPerimetro_cuadrado() {
		
		assertEquals(40, cuadrado.calcularPerimetro(),0.1);
	}

	@Test
	public void testCalcularSuperficie_Cuadrado() {
		assertEquals(100, cuadrado.calcularSuperficie(),0.1);
		
	}

	@Test
	public void testGetValores_cuadrado() {
		assertEquals("l=10.0", cuadrado.getValores());
	}
	
	@Test
	public void testGetNombre_cuadrado(){
		assertEquals("cua1",cuadrado.getNombre());
	}
//**************************
	
//*********CIRCULO********
		@Test
		public void testCalcularPerimetro_Circulo() {
			
			assertEquals(63, circulo.calcularPerimetro(),0.1);
		}

		@Test
		public void testCalcularSuperficie_Circulo() {
			assertEquals(314, circulo.calcularSuperficie(),0.1);
			
		}

		@Test
		public void testGetValores_circulo() {
			assertEquals("r=10.0", circulo.getValores());
		}
		
		@Test
		public void testGetNombre_circulo(){
			assertEquals("cir1",circulo.getNombre());
		}
	//**************************
		
		//*********TRIANGULO********
				@Test
				public void testCalcularPerimetro_Triangulo() {
					
					assertEquals(34, triangulo.calcularPerimetro(),0.1);
				}

				@Test
				public void testCalcularSuperficie_Triangulo() {
					assertEquals(100, triangulo.calcularSuperficie(),0.1);
					
				}

				@Test
				public void testGetValores_Triangulo() {
					assertEquals("a=10.0", triangulo.getValores());
				}
				
				@Test
				public void testGetNombre_Triangulo(){
					assertEquals("tr1",triangulo.getNombre());
				}
			//**************************		
	
	
	
	
	@Test
	public void testEqualsyHashCode(){
		Cuadrado cuaPrueba = new Cuadrado("cua1", 10);
		assertTrue(figuras.contains(cuaPrueba));
	}
}
