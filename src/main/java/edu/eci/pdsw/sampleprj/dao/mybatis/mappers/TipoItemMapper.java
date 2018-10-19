package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.TipoItem;

/**
 *
 * @author 2106913
 */
public interface TipoItemMapper {
    
    public void addTipoItem(String des);

	public TipoItem consultarTipoItem(@Param("id") int id);

	public List<TipoItem> consultarTiposItem();

}
