package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;

public class XXClienteDAO implements ClienteDAO {

	@Override
	public void save(Cliente cl) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente load(long documento) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> loads() throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void registrarAlquilerCliente(long docu, int itemId, Date date, Date date2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrarCliente(long documento, String nombre, String telefono, String direccion, String email,
			int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vetarCliente(long docu, int est) {
		// TODO Auto-generated method stub
		
	}

}
