package edu.eci.pdsw.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Item;

public interface ItemDAO {

	public void save(Item it) throws PersistenceException;
	
	public Item load(int id) throws PersistenceException;
   
   public List<Item> consultarItemsDisponiles() throws PersistenceException;
   
   public long ColsutarMultaPorDia(int itemId) throws PersistenceException;

	public long consultarMultaAlquiler(int idItem, Date fechaDevolucion) throws PersistenceException;

	public long consultarCostoAlquiler(int iditem, int numdias);

	public void actualizarTarifaItem(int id, long tarifa);
	 
}		