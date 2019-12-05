package com.digitel.dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;


import com.digitel.ConfigAdapter;
import com.digitel.common.ConcatString;
import com.digitel.common.Connect;
import com.digitel.common.JdbcFeatcDao;
import com.digitel.common.JdbcPNNDao;
import com.digitel.common.Response;
import com.digitel.entities.FindMaterialResponse;
import com.digitel.entities.ImsiDetail;
import com.digitel.entities.ImsiDetails;
import com.digitel.entities.Sap;
import com.digitel.entities.SapResponse;
import com.digitel.exceptions.*;

import oracle.jdbc.OracleTypes;

public class FindMaterialTypeDao implements Serializable{ //cambiar nombre de acuerdo al servicio
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8953623511830256266L;
	static String error_id; // var manejo errores
	static String error_descr; // var manejo errores
	static String CodigoError; // var manejo errores
	private static final Logger logger = LogManager.getLogger(FindMaterialTypeDao.class);  // cambiar por el nombre de la clase
	
	
	public static FindMaterialResponse validate (String codeValidate ) throws Exception {
		error_id = "0";
		error_descr = null;
		String type=null;
		
		
		
		
        ImsiDetails imsisPnn = pnn(codeValidate);
		
		 type= imsisPnn.getImsiDetails().get(0).getType();
	    
		
		 type = kenan(codeValidate);
		
		FindMaterialResponse response = new FindMaterialResponse();
		response.setType(type);
		
		return response;
	}
	
	public static ImsiDetails pnn (String codeValidate ) throws Exception  {
		List<ImsiDetail> ObjectList = null;
		ImsiDetails obj = new ImsiDetails();
		error_id = "0";
		error_descr = null;
		
		try {
			
//			JdbcPNNDao js = new JdbcPNNDao();
//			js.setJdbcTemplate();
//			JdbcTemplate jdbcTemplate = js.getJdbcTemplate();
			JdbcTemplate jdbcTemplate =  JdbcPNNDao.getJdbcTemplate(); // inicia o  invoca la conexion a la db
			
			// Senstivio
			jdbcTemplate.setResultsMapCaseInsensitive(true); // indica que sera sensitivo a mayusculas y minusculas
			SimpleJdbcCall ProcListMarca;  // crea la variable donde se relizará el llamado
			
			
			// seteas el datasource(conexion). con el esuqema del sp (usuario de la bd).el nombre del procedure. la variable de salida soo en caso de que sea un cursor
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("pnnprod").
					withProcedureName("sp_iccid_type")					
					.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(ImsiDetail.class));		 
			;
			
			System.out.println(codeValidate);
			
			//crea parametro de entrada del sp
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("p_value_iccid", codeValidate);
			
			
			// ejecuta el sp con las variales de entrada
			Map<String, Object> resultMap = ProcListMarca.execute(in);	
			// imprime respiuesta en log
			System.out.println(resultMap); 
			
			error_id = (String) resultMap.get("P_EXECUTION_CODE").toString() ; // tomando el valor de error de la respuesta del sp
			System.out.println(error_id);
			error_descr = (String) resultMap.get("P_EXECUTION_MESSAGE"); // tomando el valor del mensaje de la respuesta del sp
			System.out.println(error_descr);
			if (error_id.equalsIgnoreCase("0")) { // valido si la resp es exitosa
				// obteniendo las lista de respuesta del sp
				ObjectList = (List<ImsiDetail>) resultMap.get("cv_results");
				obj.setImsiDetails(ObjectList);
				
				
				logger.info(ConcatString.generateSms("Respuesta: " , error_descr ));
				logger.info(ConcatString.generateSms("Fin de la Consulta"));
			}else {
				CodigoError = "014";
			}
		
			
						
		} catch (Exception e) {
			logger.error(ConcatString.generateSms("Exception: ", e.getMessage()));
			logger.error(e);
			e.printStackTrace();
			throw new GenericException("000",e.getMessage());
		
		}
		
		
		
		if (!error_id.equalsIgnoreCase("0") ) {
			
			GenericException ex = new  GenericException(CodigoError, error_descr);
			logger.error(ConcatString.generateSms("Error al material en PNN... "));
			logger.error(ex);
			throw ex;
		}
		return obj;

	}
	
	
	
	
	
	
	public static  String kenan (String codeValidate ) {
		//return null;
		
//		List<ImsiDetail> ObjectList = null;
		String obj = null;
		
		try {
			JdbcTemplate jdbcTemplate =  JdbcFeatcDao.getJdbcTemplate(); // inicia o  invoca la conexion a la db
			
			// Senstivio
			jdbcTemplate.setResultsMapCaseInsensitive(true); // indica que sera sensitivo a mayusculas y minusculas
			SimpleJdbcCall ProcListMarca;  // crea la variable donde se relizará el llamado
			
			/*
			// seteas el datasource(conexion). con el esuqema del sp (usuario de la bd).el nombre del procedure. la variable de salida soo en caso de que sea un cursor
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("pnnprod").
					withProcedureName("sp_iccid_type")					
					.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(ImsiDetail.class));		 
			;
			*/
			
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()).withCatalogName("pkg_featc_valid_sim").
					withProcedureName("featc_validate_type_sim");	
			
			
			System.out.println(codeValidate);
			
			//crea parametro de entrada del sp
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("p_sim", codeValidate);
			
			
			//resultMap.get("p_type");
			
			
			
			// ejecuta el sp con las variales de entrada
			Map<String, Object> resultMap = ProcListMarca.execute(in);	
			// imprime respiuesta en log
			
			System.out.println(resultMap); 
			obj=(String) resultMap.get("p_type");
			
			
			// obteniendo las lista de respuesta del sp
//			ObjectList = (List<ImsiDetail>) resultMap.get("cv_results");
			//obj.setImsiDetails(ObjectList);
						
		} catch (Exception e) {
			// TODO: handle exception
//			ObjectList = null;
			obj = null;
			e.printStackTrace();
		
		}
		
		return obj;
		
		
		
		

	}
	public  SapResponse sap (String codeValidate ) {
	
	Sap inputSap = new Sap();
	SapResponse sapResponse = new SapResponse();
	
	
	
	return sapResponse;
	
		
		

	}
	
	
		
		
		
	}
