package com.digitel.controllers;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.common.ConcatString;
import com.digitel.common.Response;
import com.digitel.dao.FindMaterialTypeDao;
import com.digitel.entities.FindMaterialResponse;
import com.digitel.entities.ImsiDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin
@Api(value="Get Sale Representative Controller", tags=" Busqueda de representante de ventas")//cambiar mensaje
public class GetFindMaterialController implements Serializable {//Nombre de la clase debe tener semejanza con el servicio que se esta creando
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5598679240223374078L;
	private static final Logger logger = LogManager.getLogger(GetFindMaterialController.class); //cambiar GetSaleRepresentativeController
	@ApiOperation(value = "Obtener tipo de material")
	@ApiResponses({
        @ApiResponse(code = 200, message = "Success", response = FindMaterialResponse.class), //colocar objeto de respuesta       
        @ApiResponse(code = 204, message = "Not Content" ),
        @ApiResponse(code = 400, message = "Bad request", response = Response.class)
    })
	
	
	@RequestMapping(value = "/findMaterialType/{idImsi}", method = RequestMethod.GET) //Url para servicio y metodo 
	private Object customerLookupController(//cambiar de acuerdo  al servicios
			HttpServletResponse response,
			@PathVariable(value="idImsi") String idImsi,
			@RequestHeader(value="token") String Authorization
			) throws Exception {
		System.out.println("idImsi:::::"+idImsi);
		logger.info(ConcatString.generateSms("Service: ", Response.getNameMethod()));
		
		return new Response(FindMaterialTypeDao.validate( idImsi),"200","ok") ; //cual metodo va a tener la logica del servicio
		
	}
	
	
	
	
}
		
	  