package edu.eci.pdsw.sampleprj.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ClienteDAO {
	
	public void save(Cliente cl) throws PersistenceException;
	
	public Cliente load(long docu) throws PersistenceException;
	
	public List<Cliente> loads() throws PersistenceException;

	@Transactional
	public void registrarAlquilerCliente(long docu,int itemId,Date date,Date date2);
	
	public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException;

	public void registrarCliente(long documento, String nombre, String telefono, String direccion, String email, int i);

	@Transactional
	public void vetarCliente(long docu, int est);

}
