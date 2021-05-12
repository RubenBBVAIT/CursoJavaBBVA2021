package modelo;

public abstract class Figura implements Model {
	private static float maximaSuperfice;
	private String nombre;
	
	//constructores
	public Figura() {super();	}
	
	public Figura(String pNombre) {
		super();
		this.nombre = pNombre;
	}
	//getter y setter

	public static float getMaximaSuperfice() {
		return maximaSuperfice;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	//metodos de negocio
	public abstract float calcularPerimetro();
	public abstract float calcularSuperficie();
	public abstract String getValores();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("nombre=");
		sb.append(nombre);
		return sb.toString();
	}
	
	

}
