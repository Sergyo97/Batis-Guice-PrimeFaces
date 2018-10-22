package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.Item;

public class MyBatisItemDAO implements ItemDAO{

	@Inject
	private ItemMapper itemMapper;    

	@Override
	public void save(Item it) throws PersistenceException{
		try{
			itemMapper.insertarItem(it);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al registrar el item "+it.toString(),e);
		}        

	}

	@Override
	public Item load(int id) throws PersistenceException {
		try{
			return itemMapper.consultarItem(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar el item "+id,e);
		}


	}

	@Override
	public List<Item> consultarItemsDisponiles() throws PersistenceException {
		try {
			return itemMapper.consultarItemsDisponibles();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar items disponibles" + e);
		}
	}

	@Override
	public long ColsutarMultaPorDia(int itemId) throws PersistenceException {
		try {
			return itemMapper.consultarMultaPorDia(itemId);
		}catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar multa diaria del item o Item no existente o Multa Nula" + e);
		}
	}

	@Override
	public long consultarMultaAlquiler(int idItem, Date fechaDevolucion) {
		try {
			return itemMapper.consultarMultaAlquiler(idItem, fechaDevolucion);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar multa del item o Item no existente" + e);
		}
	}

	@Override
	public long consultarCostoAlquiler(int iditem, int numdias) {
		try {
			return itemMapper.consultarCostoAlquiler(iditem, numdias);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar costo alquiler de Item o Item inexistente" + e);
		}
	}

	@Override
	@Transactional
	public void actualizarTarifaItem(int id, long tarifa) {
		try {
			itemMapper.actualizarTarifaItem(id, tarifa);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al actualizar tarifa o no exite ningun Item con ese Id" + e);
		}		
	}



}