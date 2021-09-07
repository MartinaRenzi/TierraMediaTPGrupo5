package turismoEnLaTierraMedia;

import java.util.Comparator;

public class ListarPreferido implements Comparator <Producto> {
    private TipoDeAtraccion preferido;

    public ListarPreferido(TipoDeAtraccion preferencia){
        this.preferido = preferencia;
    }
    
    @Override
    public int compare(Producto o1, Producto o2) {
    	if(o1.tipo == this.preferido && o2.tipo == this.preferido) {
    		if(o1.tienePromocion() && o2.tienePromocion()) 
        		return compararOpciones(o1,o2);
    		 else 
        		return compararPorBool(o1, o2);
    		
    	} else if (o1.tipo != this.preferido && o2.tipo != this.preferido) {
	    	if(o1.tienePromocion() && o2.tienePromocion()) 
	    		return compararOpciones(o1,o2);
	    		
	    	else if (!o1.tienePromocion() && !o2.tienePromocion()) 
	    		return compararOpciones(o1, o2);
	    	else 
	    		return compararPorBool(o1, o2);
	    	
    } else {
    	if(o1.tipo == this.preferido) return -1;
    	return 1;
    }
}
	private int compararOpciones(Producto o1, Producto o2) {
		if(Double.compare(o1.costo, o2.costo) == 0) {
			return -Double.compare(o1.duracion, o2.duracion);
		} else {
			return -Double.compare(o1.costo, o2.costo);
		}
	}
	
	private int compararPorBool(Producto o1, Producto o2) {
		return -Boolean.compare(o1.tienePromocion(), o2.tienePromocion());
	}
}
