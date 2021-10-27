package dao;

import java.util.List;

import turismoEnLaTierraMedia.Atraccion;
import turismoEnLaTierraMedia.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {
	abstract public List<Promocion> getAllPromo(List<Atraccion> atracciones);

}
