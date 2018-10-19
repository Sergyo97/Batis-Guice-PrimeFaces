package edu.eci.pdsw.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Item;

public interface ItemDAO {

	public void save(Item it) throws PersistenceException;

<<<<<<< HEAD
	public Item load(int id) throws PersistenceException;
=======
   public Item load(int id) throws PersistenceException;
   
   public List<Item> consultarItemsDisponiles() throws PersistenceException;
   
   public long ColsutarMultaPorDia(int itemId) throws PersistenceException;
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46

	public List<Item> consultarItemsDisponiles() throws PersistenceException;

	public long ColsutarMultaPorDia(int itemId) throws PersistenceException;

	public long consultarMultaAlquiler(int idItem, Date fechaDevolucion) throws PersistenceException;
	 
}		