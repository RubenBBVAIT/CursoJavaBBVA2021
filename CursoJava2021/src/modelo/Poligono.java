package modelo;

public class Poligono extends Figura{
	
	private int nLados;
	private float lado;
	private float apotema;
	
	

	public Poligono(String pNombre) {
		super(pNombre);
		// TODO Auto-generated constructor stub
	}

	public Poligono() {
		super();
	}

	public Poligono(String pNombre, float lado, int nLados, float apotema) {
		super(pNombre);
		this.nLados = nLados;
		this.lado = lado;
		this.apotema = apotema;
	}
	
	


	public int getnLados() {
		return nLados;
	}

	public void setnLados(int nLados) {
		this.nLados = nLados;
	}

	public float getLado() {
		return lado;
	}

	public void setLado(float lado) {
		this.lado = lado;
	}

	public float getApotema() {
		return apotema;
	}

	public void setApotema(float apotema) {
		this.apotema = apotema;
	}

	@Override
	public float calcularPerimetro() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calcularSuperficie() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getValores() {
		// TODO Auto-generated method stub
		return null;
	}

}
