package edu.eci.pdsw.sampleprj.dao;

<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ClienteDAO {
	
	public void save(Cliente cl) throws PersistenceException;
	
<<<<<<< HEAD
	public Cliente load(long docu) throws PersistenceException;
	
	public List<Cliente> loads() throws PersistenceException;

	public List<ItemRentado> consultarItemsCliente(long idcliente);

	public void registrarAlquilerCliente(long docu,int itemId,Date date,Date date2);

=======
	public Cliente load(long documento) throws PersistenceException;
	
	public List<ItemRentado> consultarItemsCliente(long idCliente) throws PersistenceException;
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46

}
