package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
	public void insertarCliente(@Param("doc")Cliente cl);
	
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
<<<<<<< HEAD

	public List<ItemRentado> consultarItemsCliente(@Param("idcli") long idcliente);

	public void registrarAlquilerCliente(@Param("doc") long documento,
			@Param("itemid") long itemid,
			@Param ("fechain") Date fechain,
			@Param("fechafin") Date fechafin);
=======
    
    
    public List<ItemRentado> consultarItemsCliente(@Param("id") long idCliente);
    
>>>>>>> e95b9b7be0e6a44123f0cfad94a2ce710d15dd46
}
