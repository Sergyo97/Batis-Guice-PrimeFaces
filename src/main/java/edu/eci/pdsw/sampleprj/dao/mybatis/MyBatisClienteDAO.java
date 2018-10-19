package edu.eci.pdsw.sampleprj.dao.mybatis;

<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.samples.entities.Cliente;
<<<<<<< HEAD
import edu.eci.pdsw.samples.entities.Item;
=======
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
import edu.eci.pdsw.samples.entities.ItemRentado;

public class MyBatisClienteDAO implements ClienteDAO {

	@Inject ClienteMapper clienteMapper;
	
	@Override
	public void save(Cliente cl) throws PersistenceException {
		try {
			clienteMapper.insertarCliente(cl);
		}
		catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al registrar el cliente" + cl.toString(), e);
		}

	}

	@Override
	public Cliente load(long documento) throws PersistenceException {
		try {
			return clienteMapper.consultarCliente((int) documento);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar cliente " + documento, e);
		}
	}
	
	@Override
	public List<Cliente> loads() throws PersistenceException {
		try {
			return clienteMapper.consultarClientes();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar los clientes ", e);
		}
	}

	@Override
	public List<ItemRentado> consultarItemsCliente(long idcliente) {
		try {
			return clienteMapper.consultarItemsCliente(idcliente);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar items del cliente o el cliente con documento " + idcliente, e);
		}
	}

		

	@Override
	public void registrarAlquilerCliente(long docu, int itemId, Date date, Date date2) {
		try {
			clienteMapper.registrarAlquilerCliente(docu,itemId,date,date2);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar items del cliente o el cliente con documento " + e);
		}
		
	}

	@Override
	public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}


}
