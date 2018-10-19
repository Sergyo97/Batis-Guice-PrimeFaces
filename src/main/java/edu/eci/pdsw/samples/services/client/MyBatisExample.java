/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.sql.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

	/**
	 * Método que construye una fábrica de sesiones de MyBatis a partir del
	 * archivo de configuración ubicado en src/main/resources
	 *
	 * @return instancia de SQLSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		if (sqlSessionFactory == null) {
			InputStream inputStream;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}

	/**
	 * Programa principal de ejempo de uso de MyBATIS
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String args[]) throws SQLException {

		Cliente cliente = new Cliente("Sergio", 2138850,"6006", "direccion", "Sergio.ruiz@mail.escuelaing.edu.com");
		TipoItem tipoItem = new TipoItem(1, "Video");
		Item item = new Item(tipoItem, 2185142, "CallOfDutty4", "blablabla", Date.valueOf("2018-10-15"), 30000, "Digital", "BOM");
		
		
		SqlSessionFactory sessionfact = getSqlSessionFactory();
		SqlSession sqlss = sessionfact.openSession();

		ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
		ItemMapper im = sqlss.getMapper(ItemMapper.class);
		TipoItemMapper tim = sqlss.getMapper(TipoItemMapper.class);

		//System.out.println(cm.consultarCliente(2138850));

		//System.out.println(cm.consultarClientes());

		//cm.agregarItemRentadoACliente(100, 121, new Date(1022018), new Date(10102018));


		//im.insertarItem(new Item(new TipoItem(3, "Juego"), 15, "Fortnite", "The best of the best", new Date(2017, 07, 25), 10000, "Digital", "BattleRoyale"));
		//im.deleteItem(15);
		//System.out.println(im.consultarItem(2185142));
		//System.out.println(im.consultarItems());
		//System.out.println(im.consultarItemsDisponibles());
		//System.out.println(im.consultarMultaPorDia(15));
		//System.out.println(cm.consultarItemsCliente(12345));
		//ARREGLAR SIGUIENTE
		//System.out.println(im.consultarMultaAlquiler(30, Date.valueOf("2018-10-18")));
		
		//System.out.println(tim.consultarTipoItem(1));
		//System.out.println(tim.consultarTiposItem());

		
		
		//cm.registrarAlquilerCliente(12345,15,Date.valueOf("2018-10-19"),Date.valueOf("2018-10-22"));	
		//cm.insertarCliente(cliente);
		//System.out.println(im.consultarCostoAlquiler(15, 3));
		//im.actualizarTarifaItem(15, 15000);
		//im.insertarItem(item);
		//cm.vetarCliente(2138850, 1);
		
		
		sqlss.commit();
		sqlss.close(); 
	}

}
