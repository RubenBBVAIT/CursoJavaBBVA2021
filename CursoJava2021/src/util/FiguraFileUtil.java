package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.Poligono;
import modelo.Rectangulo;
import modelo.Triangulo;

public class FiguraFileUtil{
	private ArrayList<Figura> figuras;
	private String nombreArchivo;
	private String path;
	
	//constructores

	public FiguraFileUtil(ArrayList<Figura> figuras, String nombreArchivo, String path) {
		super();
		this.figuras = figuras;
		this.nombreArchivo = nombreArchivo;
		this.path = path;
	}
	
	//Métodos de negocio
	
	public static void generarArchivo(ArrayList<Figura> figuras, String nombreArchivo, String path) throws IOException {
		FileWriter fichero = null;
        PrintWriter pw = null;
        int tipo = 0;

        fichero = new FileWriter(path + nombreArchivo);
        pw = new PrintWriter(fichero);
        
        for (Figura figura : figuras) {
        	if (figura instanceof Cuadrado)
        		tipo = 1;
        	else if (figura instanceof Circulo)
        		tipo = 2;
        	else if (figura instanceof Rectangulo)
        		tipo = 3;
        	else if (figura instanceof Triangulo)
        		tipo = 4;
        	else if (figura instanceof Poligono)
        		tipo = 5;
        	pw.println("{'Tipo':'" + tipo + "', 'nombre':'" + figura.getNombre() + "', 'valores':'" + figura.getValores() + "'},");
		}
        pw.close();
        System.out.println("Fichero generado correctamente.");
	}
	
	public void generarArchivo() throws IOException {
		FileWriter fichero = null;
        PrintWriter pw = null;
        int tipo = 0;

        fichero = new FileWriter(this.path + nombreArchivo);
        pw = new PrintWriter(fichero);
        
        for (Figura figura : figuras) {
        	if (figura instanceof Cuadrado)
        		tipo = 1;
        	else if (figura instanceof Circulo)
        		tipo = 2;
        	else if (figura instanceof Rectangulo)
        		tipo = 3;
        	else if (figura instanceof Triangulo)
        		tipo = 4;
        	else if (figura instanceof Poligono)
        		tipo = 5;
        	pw.println("{'Tipo':'" + tipo + "', 'nombre':'" + figura.getNombre() + "', 'valores':'" + figura.getValores() + "'},");
		}
        pw.close();
        System.out.println("Fichero generado correctamente.");
	}
	
	public static ArrayList<Figura> leerArchivo(String nombreArchivo, String Path) throws NumberFormatException, IOException{
		ArrayList<Figura> array = new ArrayList<Figura>();
		File f;
		FileReader fr = null;
		BufferedReader br;
		
		f = new File(Path + nombreArchivo  );
		fr = new FileReader(f);
		br = new BufferedReader(fr);
			
		String linea = "";
		while((linea = br.readLine())!= null) {
			String[] datos = linea.split(",");			
			String tipo = datos[0].split(":")[1];
			System.out.println(tipo);
			if(tipo.equals("1")) {
				String nombre = datos[1].split(":")[1];
				float lado = Float.parseFloat(datos[2].split(":")[1].substring(1, datos[2].split(":")[1].indexOf('}')-1).split("=")[1]);
				Cuadrado cu1 = new Cuadrado(nombre, lado);
				System.out.println(cu1.getNombre());
				System.out.println(cu1.getLado()+ "\n");
				array.add(cu1);
			}else if(tipo.equals("2")){
				String nombre = datos[1].split(":")[1];
				float radio = Float.parseFloat(datos[2].split(":")[1].substring(1, datos[2].split(":")[1].indexOf('}')-1).split("=")[1]);
				Circulo ci1 = new Circulo(nombre, radio);
				System.out.println(ci1.getNombre());
				System.out.println(ci1.getRadio()+ "\n");
				array.add(ci1);
			}else if(tipo.equals("3")){
				String nombre = datos[1].split(":")[1];
				float base = Float.parseFloat(datos[2].split(":")[1].split("-")[0].substring(1, datos[2].split(":")[1].split("-")[0].length()).split("=")[1]);
				float altura = Float.parseFloat(datos[2].split(":")[1].split("-")[1].substring(0, datos[2].split(":")[1].split("-")[1].indexOf('}')-1).split("=")[1]);
				Triangulo tr1 = new Triangulo(nombre, base, altura);
				System.out.println(tr1.getNombre());
				System.out.println(tr1.getBase());
				System.out.println(tr1.getAltura()+ "\n");
				array.add(tr1);
			}else if(tipo.equals("4")){
				String nombre = datos[1].split(":")[1];
				float base = Float.parseFloat(datos[2].split(":")[1].split("-")[0].substring(1, datos[2].split(":")[1].split("-")[0].length()).split("=")[1]);
				float altura = Float.parseFloat(datos[2].split(":")[1].split("-")[1].substring(0, datos[2].split(":")[1].split("-")[1].indexOf('}')-1).split("=")[1]);
				Rectangulo re1 = new Rectangulo(nombre, base, altura);
				System.out.println(re1.getNombre());
				System.out.println(re1.getBase());
				System.out.println(re1.getAltura()+ "\n");
				array.add(re1);
			}else if(tipo.equals("5")){
				String nombre = datos[1].split(":")[1];
				float lado = Float.parseFloat(datos[2].split(":")[1].split("-")[0].substring(1, datos[2].split(":")[1].split("-")[0].length()).split("=")[1]);
				int nlados = Integer.parseInt(datos[2].split(":")[1].split("-")[1].split("=")[1]);
				float apotema = Float.parseFloat(datos[2].split(":")[1].split("-")[2].substring(0, datos[2].split(":")[1].split("-")[2].indexOf('}')-1).split("=")[1]);
				Poligono po1 = new Poligono(nombre, lado, nlados, apotema);
				System.out.println(po1.getNombre());
				System.out.println(po1.getLado());
				System.out.println(po1.getnLados());
				System.out.println(po1.getApotema()+ "\n");
				array.add(po1);
			}
		}
		br.close();
		
		return array;
	}
	
	public ArrayList<Figura> leerArchivo() throws NumberFormatException, IOException{
		ArrayList<Figura> array = new ArrayList<Figura>();
		File f;
		FileReader fr = null;
		BufferedReader br;
		
		f = new File(nombreArchivo + path);
		fr = new FileReader(f);
		br = new BufferedReader(fr);
			
		String linea = "";
		while((linea = br.readLine())!= null) {
			String[] datos = linea.split(",");			
			String tipo = datos[0].split(":")[1];
			System.out.println(tipo);
			if(tipo.equals("1")) {
				String nombre = datos[1].split(":")[1];
				float lado = Float.parseFloat(datos[2].split(":")[1].substring(1, datos[2].split(":")[1].indexOf('}')-1).split("=")[1]);
				Cuadrado cu1 = new Cuadrado(nombre, lado);
				System.out.println(cu1.getNombre());
				System.out.println(cu1.getLado()+ "\n");
				array.add(cu1);
			}else if(tipo.equals("2")){
				String nombre = datos[1].split(":")[1];
				float radio = Float.parseFloat(datos[2].split(":")[1].substring(1, datos[2].split(":")[1].indexOf('}')-1).split("=")[1]);
				Circulo ci1 = new Circulo(nombre, radio);
				System.out.println(ci1.getNombre());
				System.out.println(ci1.getRadio()+ "\n");
				array.add(ci1);
			}else if(tipo.equals("3")){
				String nombre = datos[1].split(":")[1];
				float base = Float.parseFloat(datos[2].split(":")[1].split("-")[0].substring(1, datos[2].split(":")[1].split("-")[0].length()).split("=")[1]);
				float altura = Float.parseFloat(datos[2].split(":")[1].split("-")[1].substring(0, datos[2].split(":")[1].split("-")[1].indexOf('}')-1).split("=")[1]);
				Triangulo tr1 = new Triangulo(nombre, base, altura);
				System.out.println(tr1.getNombre());
				System.out.println(tr1.getBase());
				System.out.println(tr1.getAltura()+ "\n");
				array.add(tr1);
			}else if(tipo.equals("4")){
				String nombre = datos[1].split(":")[1];
				float base = Float.parseFloat(datos[2].split(":")[1].split("-")[0].substring(1, datos[2].split(":")[1].split("-")[0].length()).split("=")[1]);
				float altura = Float.parseFloat(datos[2].split(":")[1].split("-")[1].substring(0, datos[2].split(":")[1].split("-")[1].indexOf('}')-1).split("=")[1]);
				Rectangulo re1 = new Rectangulo(nombre, base, altura);
				System.out.println(re1.getNombre());
				System.out.println(re1.getBase());
				System.out.println(re1.getAltura()+ "\n");
				array.add(re1);
			}else if(tipo.equals("5")){
				String nombre = datos[1].split(":")[1];
				float lado = Float.parseFloat(datos[2].split(":")[1].split("-")[0].substring(1, datos[2].split(":")[1].split("-")[0].length()).split("=")[1]);
				int nlados = Integer.parseInt(datos[2].split(":")[1].split("-")[1].split("=")[1]);
				float apotema = Float.parseFloat(datos[2].split(":")[1].split("-")[2].substring(0, datos[2].split(":")[1].split("-")[2].indexOf('}')-1).split("=")[1]);
				Poligono po1 = new Poligono(nombre, lado, nlados, apotema);
				System.out.println(po1.getNombre());
				System.out.println(po1.getLado());
				System.out.println(po1.getnLados());
				System.out.println(po1.getApotema()+ "\n");
				array.add(po1);
			}
		}
		br.close();
		
		return array;
	}
	
	//Getters and setters

	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		path = path;
	}
}
