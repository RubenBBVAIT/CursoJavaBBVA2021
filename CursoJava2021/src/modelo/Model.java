package modelo;
/**
 * Esta interface permite obliga a imprlementar los metodso equals, haschCode y toString
 * @author Gabriel
 *
 */
public interface Model {
	public boolean equals(Object ob);
	public int hashCode();
	public String toString();
	
}
