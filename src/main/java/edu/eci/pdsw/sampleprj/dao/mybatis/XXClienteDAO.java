package edu.eci.pdsw.sampleprj.dao.mybatis;

<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.samples.entities.Cliente;
<<<<<<< HEAD
import edu.eci.pdsw.samples.entities.Item;
=======
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
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
<<<<<<< HEAD
	public List<ItemRentado> consultarItemsCliente(long idcliente) {
=======
	public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException {
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
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

}
