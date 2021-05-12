package modelo;

public class Circulo extends Figura {
	private float radio;
	
	
	
	public Circulo() {		super();	}
	public Circulo(String pNombre) {	super(pNombre);}

		
	public Circulo(String pNonbre, float radio) {
		super(pNonbre);
		this.radio = radio;
	}
	
		
	public float getRadio() {				return radio;		}
	public void setRadio(float radio) {		this.radio = radio;	}
	
	
	@Override
	public float calcularPerimetro() {
		return 2 * (float)Math.PI * radio;
	}

	@Override
	public float calcularSuperficie() {
		return (float)Math.PI * radio * radio;
	}

	@Override
	public String getValores() {
		StringBuilder sb = new StringBuilder("r=");
		sb.append(radio);
		return sb.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(radio);
		return result+ super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (!super.equals(obj) || Float.floatToIntBits(radio) != Float.floatToIntBits(other.radio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("radio=");
		sb.append(radio);
		return sb.toString();
	}
	
	
	
	
	

}
