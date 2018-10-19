package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.samples.entities.Item;

public class XXItemDAO implements ItemDAO {

	@Override
	public void save(Item it) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Item load(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> consultarItemsDisponiles() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long ColsutarMultaPorDia(int itemId) throws PersistenceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long consultarMultaAlquiler(int idItem, Date fechaDevolucion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
