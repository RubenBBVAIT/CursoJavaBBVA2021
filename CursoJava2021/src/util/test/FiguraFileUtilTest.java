package util.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.Poligono;
import modelo.Rectangulo;
import modelo.Triangulo;
import util.FiguraFileUtil;

public class FiguraFileUtilTest {
	String path;
	String nomArchivo;
	ArrayList<Figura> figuras = new ArrayList<Figura>();
	@Before
	public void setUp() throws Exception {
		StringBuilder sb = new StringBuilder(System.getProperty("user.dir"));
		sb.append("/src/util/test/");
		path = sb.toString()   ;		
		nomArchivo ="Test.json";
		figuras.add(new Cuadrado("cua1", 10));
		figuras.add(new Circulo("cir1", 10));
		figuras.add(new Triangulo("triangulo1", 10, 8.4f));
		figuras.add(new Rectangulo("rect1", 12.3f, 8.4f));
		figuras.add(new Poligono("polig1", 10, 6, 6.2f));
		
	}

	@After
	public void tearDown() throws Exception {
		path=null;
		nomArchivo=null;
		figuras=null;
		
	}

	@Test
	public void testGenerarArchivoArrayListOfFiguraStringString() {
		//1 tengo que generar
		try {
			FiguraFileUtil.generarArchivo(figuras, "ArchivoGerado", path);
			 File archivo = new File (path +"ArchivoGerado" );
			 assertNotNull(archivo);
			 
		} catch (IOException e) {
			assertTrue(false);
			e.printStackTrace();
		}
		//2- verificar que se halla generado
		
	}

	@Test
	public void testLeerArchivoStringString() {
		//1. leer el archivo
		try {
			ArrayList<Figura> figurasLeidas = FiguraFileUtil.leerArchivo(nomArchivo, path);
			assertEquals(figuras, figurasLeidas);
		} catch (NumberFormatException | IOException e) {
			//pintar de rojo
			assertTrue(false);
			e.printStackTrace();
		}
		//2- verificar el contenido
	}

}
