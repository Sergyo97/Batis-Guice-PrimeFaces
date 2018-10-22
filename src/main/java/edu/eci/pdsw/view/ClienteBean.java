package edu.eci.pdsw.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.google.inject.Inject;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;

@ManagedBean(name = "clienteBean")
@ApplicationScoped

public class ClienteBean extends BasePageBean {
	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private long documento;
    private String telefono;
    private String direccion;
    private String email;
    private boolean vetado;
    private ArrayList<ItemRentado> rentados; 
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isVetado() {
		return vetado;
	}

	public void setVetado(boolean vetado) {
		this.vetado = vetado;
	}

	public ArrayList<ItemRentado> getRentados() {
		return rentados;
	}

	public void setRentados(ArrayList<ItemRentado> rentados) {
		this.rentados = rentados;
	}

	@Inject
	private ServiciosAlquiler serviciosAlquiler;
	
	public List<Cliente> getClientes() throws ExcepcionServiciosAlquiler {
		try {
			return serviciosAlquiler.consultarClientes();
		}catch(Exception e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

}
