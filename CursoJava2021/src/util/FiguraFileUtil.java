package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import cursoJava.Circulo;
import cursoJava.Cuadrado;
import cursoJava.Figura;
import cursoJava.Triangulo;

public class FiguraFileUtil {
	private String nombreArchivo;
	private String path;
	private ArrayList<Figura> figuras;
	
	public FiguraFileUtil(String nombre, String path, ArrayList<Figura> figuras) {
		this.nombreArchivo = nombre;
		this.path = path;
		this.figuras = figuras;
	}


	public String getNombre() {
		return nombreArchivo;
	}

	public void setNombre(String nombre) {
		this.nombreArchivo = nombre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}
	
	public static void generarArchivo(ArrayList<Figura> figuras,String nombreArchivo, String path) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(path+nombreArchivo);
            pw = new PrintWriter(fichero);
            
            for (Figura figura: figuras) {
                
                if (figura instanceof Cuadrado) {
					pw.println("tipo:1"+figura.getNombre());
				}
                
                if (figura instanceof Circulo) {
					pw.println("tipo:2"+figura.getNombre());
				}
                
                if (figura instanceof Triangulo) {
					pw.println("tipo:3"+figura.getNombre());
				}
              }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public void generarArchivo() {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(path+nombreArchivo);
            pw = new PrintWriter(fichero);
            
            for (Figura figura: figuras) {
                
                if (figura instanceof Cuadrado) {
					pw.println("{\"tipo\":1,\":\""+figura.getNombre()+"\",\"valores\":\""
                +figura.getValores()+"\"}");
				}
                
                if (figura instanceof Circulo) {
                	pw.println("{\"tipo\":2,\":\""+figura.getNombre()+"\",\"valores\":\""
                            +figura.getValores()+"\"}");
				}
                
                if (figura instanceof Triangulo) {
                	pw.println("{\"tipo\":3,\":\""+figura.getNombre()+"\",\"valores\":\""
                            +figura.getValores()+"\"}");
				}
              }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public static ArrayList<Figura> leerArchivo(String path,String nombreArchivo) {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      ArrayList<Figura> figuras = new ArrayList<Figura>();

	      try {
	         archivo = new File (path+nombreArchivo);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null) {
	        	 int finNombre=linea.indexOf(',', 9);
	        	 String tipo=linea.substring(8,9);
	        	 String nombre=linea.substring(19,finNombre-1);
	        	 int itipo=Integer.parseInt(tipo);
	        	 
	        	 if (itipo==1) {
						Cuadrado cua=new Cuadrado();
	        		 int inValor=linea.indexOf('=');
	        		 int finValor=linea.indexOf('"',inValor);
	        		 String valor=linea.substring(inValor+1,finValor);
	        		 float fvalor=Float.parseFloat(valor);
					cua.setNombre(nombre);
					cua.setLado(fvalor);
					figuras.add(cua);
				}
	        	 
	        	 if (itipo==2) {
					Circulo cir=new Circulo();
					int inValor=linea.indexOf('=');
	        		 int finValor=linea.indexOf('"',inValor);
	        		 String valor=linea.substring(inValor+1,finValor);
	        		 float fvalor=Float.parseFloat(valor);
					cir.setNombre(nombre);
					cir.setRadio(fvalor);
					figuras.add(cir);
				}
	        	 
	        	 if (itipo==3) {
					Triangulo tri=new Triangulo();
					
					int inValor1=linea.indexOf('=');
					int finValor1=linea.indexOf('-');
					String base=linea.substring(inValor1+1,finValor1);
					float fbase=Float.parseFloat(base);
					
					int inValor2=linea.indexOf('=',finValor1);
					int finValor2=linea.indexOf('"',inValor2);
					String altura=linea.substring(inValor2+1,finValor2);
					float faltura=Float.parseFloat(altura);
					
					tri.setNombre(nombre);
					tri.setBase(fbase);
					tri.setAltura(faltura);
					figuras.add(tri);
				}

	         }
	            
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
		return figuras;
		
	}
	
	public ArrayList<Figura> leerArchivo() {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      ArrayList<Figura> figuras = new ArrayList<Figura>();

	      try {
	         archivo = new File (path+nombreArchivo);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         String linea;
	         while((linea=br.readLine())!=null) {
	        	 String tipo=linea.substring(8,9);
	        	 int itipo=Integer.parseInt(tipo);
	        	 
	        	 if (itipo==1) {
						
				}
	        	 
	        	 if (itipo==2) {
					
				}
	        	 
	        	 if (itipo==3) {
					
				}

	         }
	            
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		
		return figuras;
		
	}

}
