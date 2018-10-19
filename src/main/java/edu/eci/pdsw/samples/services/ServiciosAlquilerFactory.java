package edu.eci.pdsw.samples.services;

import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTipoItemDAO;
import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerImpl;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

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
				bind(ServiciosAlquiler.class).to(ServiciosAlquilerImpl.class);
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