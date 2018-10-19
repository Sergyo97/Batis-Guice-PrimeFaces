package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;

/**
 *
 * @author 2138850
 */
public interface ItemMapper {
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("id") int id);
    
    public void insertarItem(@Param("item")Item it);

    public void deleteItem(@Param("id") int id);
        
    public List<Item> consultarItemsDisponibles();
    
    public long consultarMultaPorDia(@Param("id") int itemid);

	public long consultarMultaAlquiler(@Param("idItem")int idItem, @Param("date")Date date);
	
	public TipoItem consultarTipoItem(@Param("id") int itemid) ;

	public long consultarCostoAlquiler(@Param("id") int iditem,@Param("dias") int numdias);

	public void actualizarTarifaItem(@Param("id") int id,@Param("tarifa") long tarifa);
	
	
    
}
