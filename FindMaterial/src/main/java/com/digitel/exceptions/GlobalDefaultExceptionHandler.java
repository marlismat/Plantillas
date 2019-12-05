package com.digitel.exceptions;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.digitel.ConfigAdapter;
import com.digitel.common.ConcatString;
import com.digitel.common.Response;

@ControllerAdvice
public class GlobalDefaultExceptionHandler implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1845126319520259843L;
	private static final Logger logger = LogManager.getLogger(GlobalDefaultExceptionHandler.class);
	public static final String DEFAULT_ERROR_VIEW = "error";
	public static final String CODIGO_ERROR_GENERICO = "005";

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	Response handleExectRequest(HttpServletRequest req, HttpServletResponse response, Exception ex) {
		System.out.println("handleExectRequest ");
		ex.printStackTrace();
		logger.error(ex);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new Response(null, CODIGO_ERROR_GENERICO, ex.getMessage());
	}

	@ExceptionHandler(value = GenericException.class)
	@ResponseBody
	Response handleGenericExceptionRequest(HttpServletRequest req, HttpServletResponse response, GenericException ex)
			throws Exception {
		
		logger.info(ConcatString.generateSms("Ingreso en GenericException" ));
		
		String valuespropertie=null;
		try {
			System.err.println("error.cod_"+ex.getCodigo());
			valuespropertie = ConfigAdapter.mapErrorIc.get("error.cod_"+ex.getCodigo());
		} catch (Exception e) {
			logger.error(ConcatString.generateSms("Error al cargar el atributo: ","error.cod_"+ex.getCodigo() ,"intercorpError"));
			logger.error("Error Al cargar popiedad del prorperties de errores porfavor validar, el archivo cargado y redesplegar la app");
			logger.error(e.getMessage());
			logger.error(e);
			e.printStackTrace();
		}
		
		String[] parts = valuespropertie.split("@");
		String nameException = parts[0];
		String responseHttp = parts[1];
		String smsError = parts[2];
		
		ex.printStackTrace();
		StringBuilder smsResponse = new StringBuilder();
		smsResponse.append(nameException).append(" ").append(smsError);
		if (ex.getMessage() != null) smsResponse.append(" ").append(ex.getMessage());
		if (ex.getMessage() != null) smsResponse.append(" ").append(ex.getMessage());
		if (ex.getDescripcion() != null) smsResponse.append(" ").append(ex.getDescripcion());
		response.setStatus(Integer.parseInt(responseHttp));
		
		logger.error(ConcatString.generateSms("GenericException: ",ex.getCodigo(),null,smsResponse.toString()));
		
		return new Response(new String(req.getServerName() + req.getServletPath()), ex.getCodigo(),
				"GenericException: " + smsResponse);
	}

}
