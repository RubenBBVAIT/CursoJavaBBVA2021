package cursoJava;

public class Triangulo extends Figura {
	private float altura;
	private float base;

	public Triangulo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Triangulo(String nombre,float altura, float base) {
		super(nombre);
		this.altura = altura;
		this.base = base;
	}
	
	public Triangulo(String nombre) {
		super(nombre);
	}



	@Override
	public float calcularPerimetro() {
		
		return Math.round((float) (altura + base + Math.sqrt(altura*altura+base*base)));
	}

	@Override
	public float calcularSuperficie() {
		// TODO Auto-generated method stub
		return base*altura;
	}

	@Override
	public String getValores() {
		StringBuilder sb = new StringBuilder("a=");
		sb.append(altura);
		return sb.toString();
	}



	public float getAltura() {
		return altura;
	}



	public void setAltura(float altura) {
		this.altura = altura;
	}



	public float getBase() {
		return base;
	}



	public void setBase(float base) {
		this.base = base;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(altura);
		result = prime * result + Float.floatToIntBits(base);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangulo other = (Triangulo) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (Float.floatToIntBits(base) != Float.floatToIntBits(other.base))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Triangulo [altura=" + altura + ", base=" + base + "]";
	}
	
	

}
