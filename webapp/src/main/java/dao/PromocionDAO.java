package main.java.dao;

import java.util.List;

import main.java.turismoEnLaTierraMedia.Atraccion;
import main.java.turismoEnLaTierraMedia.Promocion;

public interface PromocionDAO extends GenericDAO<Promocion> {
	abstract public List<Promocion> getAllPromo(List<Atraccion> atracciones);

}
