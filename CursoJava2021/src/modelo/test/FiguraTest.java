package modelo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;

public class FiguraTest {
	//pregunta de examen
	//diferencia entre objeto y clase
	//que es clase abstracta
	//Que es interface
	
	
	//los tres pasos para trabajar con objetos
	Figura cuadrado ; //1- definicion 
	Figura circulo ;
	
	ArrayList<Figura> figuras;
	@Before
	public void setUp() throws Exception {
		cuadrado = new Cuadrado("cua1", 10);//2- creacion, 3-asignacion
		circulo  = new Circulo("cir1", 10);
		
		figuras = new ArrayList<Figura>();
		figuras.add(new Cuadrado("cua1", 10));
		figuras.add(new Circulo("cir1", 10));
		figuras.add(new Cuadrado("cua2", 15));
		figuras.add(new Circulo("cir2", 15));
		figuras.add(new Cuadrado("cua3", 12.5f));
		figuras.add(new Circulo("cir3", 12.5f));
		
		
	}

	@After
	public void tearDown() throws Exception {
		cuadrado = null;
		circulo = null;
		figuras = null;
	}
//************************************teste del un cuadrado **************
	@Test
	public void testCalcularPerimetro_cuadrado() {
		//valor esperado, metodo a testear, presicion
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
//****************************fin de testeo del un cuadrado *********************
	@Test
	public void testEqualsyHashCode_cuadrado(){
		Cuadrado cuaPrueba = new Cuadrado("cua1", 10);
		assertTrue(figuras.contains(cuaPrueba));
	}
}
