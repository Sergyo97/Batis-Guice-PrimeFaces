package edu.eci.pdsw.samples.services;

import static com.google.inject.Guice.createInjector;

import java.util.Optional;

import org.mybatis.guice.XMLMyBatisModule;

import com.google.inject.Injector;

import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTipoItemDAO;
import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerImpl;
import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerItemsStub;

public class ServiciosAlquilerFactory {

	private static ServiciosAlquilerFactory instance = new ServiciosAlquilerFactory();

	private static Optional<Injector> optInjector;

	private Injector myBatisInjector(String env, String pathResource) {
		return createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				setEnvironmentId(env);
				setClassPathResource(pathResource);
				bind(ItemDAO.class).to(MyBatisItemDAO.class);
				bind(ClienteDAO.class).to(MyBatisClienteDAO.class);
				bind(TipoItemDAO.class).to(MyBatisTipoItemDAO.class);
				bind(ServiciosAlquiler.class).to(ServiciosAlquilerImpl.class);
				bind(ServiciosAlquiler.class).to(ServiciosAlquilerItemsStub.class);
				
			}
		});
	}

	private ServiciosAlquilerFactory(){
		optInjector = Optional.empty();
	}

	public ServiciosAlquiler getServiciosAlquiler(){
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
		}

		return optInjector.get().getInstance(ServiciosAlquiler.class);
	}


	public ServiciosAlquiler getServiciosAlquilerTesting(){
		if (!optInjector.isPresent()) {
			optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
		}

		return optInjector.get().getInstance(ServiciosAlquiler.class);
	}


	public static ServiciosAlquilerFactory getInstance(){
		return instance;
	}

}