package edu.eci.pdsw.samples.services.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

	@Inject
	private ItemDAO itemDAO;

	@Inject
	private ClienteDAO clienteDAO;

	@Inject
	private TipoItemDAO tipoItemDAO;


	@Override
	public long valorMultaRetrasoxDia(int itemId) {
		try {
			return itemDAO.ColsutarMultaPorDia(itemId);
		}catch (PersistenceException e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	//tambien yo
	@Override
	public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
		try {
			return clienteDAO.load(docu);
		}catch(PersistenceException e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}

	}

	//
	@Override
	public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
		try {
			return clienteDAO.consultarItemsCliente(idcliente);
		}catch(PersistenceException e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
		try {
			return clienteDAO.loads();
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
		try {
			return itemDAO.load(id);
		} catch (PersistenceException ex) {
			throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
		}
	}

	@Override
	public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler{
		try {
			return itemDAO.consultarItemsDisponiles();
		}
		catch (Exception e) {
			throw new ExcepcionServiciosAlquiler("Error al consultar items disponibles" + e);
		}
	}

	@Override
	public long consultarMultaAlquiler(int idItem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
		try {
			return itemDAO.consultarMultaAlquiler(idItem, fechaDevolucion);			
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
		try {
			return tipoItemDAO.consultarTipoItem(id);
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
		try {
			return tipoItemDAO.consultarTiposItem();
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}

	}

	@Override
	public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
		try {
			LocalDate today = LocalDate.parse(date.toString());
			LocalDate tomorrow = today.plusDays(14);
			Date date2 = java.sql.Date.valueOf(tomorrow);

			int itemId = item.getId();


			clienteDAO.registrarAlquilerCliente(docu,itemId,date,date2);
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
		try {
			//clienteDAO.registrarCliente(c.getDocumento(),c.getNombre(),c.getTelefono(),c.getDireccion(),c.getEmail(),0);
			clienteDAO.save(c);
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
		try {
			return itemDAO.consultarCostoAlquiler(iditem,numdias);
		}catch (PersistenceException e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
		try {
			itemDAO.actualizarTarifaItem(id,tarifa);
		}catch (Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}
	@Override
	public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
		try {
			itemDAO.save(i);
		}catch(Exception e){
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	@Override
	public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
		try {
			int est=0;
			if (estado==true)
				est=1;
			clienteDAO.vetarCliente(docu,est);
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		}
		
		
	}
}