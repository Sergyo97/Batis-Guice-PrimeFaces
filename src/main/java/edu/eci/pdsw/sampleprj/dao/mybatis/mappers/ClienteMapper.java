package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {

	public void insertarCliente(Cliente cl);

	public Cliente consultarCliente(@Param("idcli")long documento); 

	/**
	 * Consultar todos los clientes
	 * @return 
	 */
	public List<Cliente> consultarClientes();

	/**
	 * Registrar un nuevo item rentado asociado al cliente identificado
	 * con 'idc' y relacionado con el item identificado con 'idi'
	 * @param id
	 * @param idit
	 * @param fechainicio
	 * @param fechafin 
	 */
	public void agregarItemRentadoACliente(@Param("idir") int id,
			@Param("idit")int idit, 
			@Param("fiir")Date fechainicio,
			@Param("ffir")Date fechafin);

	public List<ItemRentado> consultarItemsCliente(@Param("idcli") long idcliente);

	public void registrarAlquilerCliente(@Param("doc") long documento,
			@Param("itemid") long itemid,
			@Param ("fechain") Date fechain,
			@Param("fechafin") Date fechafin);

	public void registrarCliente(@Param("doc")long documento,
			@Param("nombre") String nombre,
			@Param("telefono") String telefono,
			@Param("dir") String direccion,
			@Param("email") String email,
			@Param("vet") int i);

	public void vetarCliente(@Param("doc") long docu,@Param("estado") int est);
	
	
}
