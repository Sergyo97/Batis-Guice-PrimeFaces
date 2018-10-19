package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;

public class MyBatisTipoItemDAO implements TipoItemDAO{

	@Inject
	private TipoItemMapper tipoItemMapper;
	
	@Override
	public TipoItem consultarTipoItem(int id) throws PersistenceException {
		try {
			return tipoItemMapper.consultarTipoItem(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar tipo de item o Item no existente" + e);
		}
	}

	@Override
	public List<TipoItem> consultarTiposItem() {
		try {
			return tipoItemMapper.consultarTiposItem();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar tipos de item", e);
		}
	}

}
