package com.digitel.common;

import java.io.Serializable;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import  com.digitel.ConfigAdapter;

/**
 * @author Cristancho
 *
 */
public class RechargeProperties implements Serializable{
	
	private static final long serialVersionUID = -3058880175477734512L;
	private static final Logger logger = LogManager.getLogger(RechargeProperties.class);

	static void rechargePropertie() throws Exception {
		
		Properties valuesProperties = ReadProperties.getProperties("findMaterial.properties"); // se cambia por el nombre del propertie
		
		if (!valuesProperties.getProperty("pnnprod").toString().equals(ConfigAdapter.mapConfAuthenticator.get("pnnprod"))) {
			
			StringBuilder logSerice = new StringBuilder();
			logSerice.append("Cambio del parametro: pnnprod");
			logSerice.append(" Old: ");
			logSerice.append(ConfigAdapter.mapConfAuthenticator.get("pnnprod"));
			logSerice.append(" new: ");
			logSerice.append(valuesProperties.getProperty("pnnprod").toString());
			logger.info(logSerice.toString());
			
			ConfigAdapter.mapConfAuthenticator.put("pnnprod", valuesProperties.getProperty("pnnprod").toString());
		}
		
		//Se deben crear tantos bloques if  como valores que esten en el properties
		if (!valuesProperties.getProperty("kenan").toString().equals(ConfigAdapter.mapConfAuthenticator.get("kenan"))) {
			
			StringBuilder sms = new StringBuilder();
			sms.append("Cambio del parametro: kenan");
			sms.append(" Old: ");
			sms.append(ConfigAdapter.mapConfAuthenticator.get("kenan"));
			sms.append(" new: ");
			sms.append(valuesProperties.getProperty("kenan").toString());
			logger.info(sms.toString());
			
			ConfigAdapter.mapConfAuthenticator.put("kenan", valuesProperties.getProperty("kenan").toString());
		}
		if (!valuesProperties.getProperty("expiryTime").toString().equals(ConfigAdapter.mapConfAuthenticator.get("expiryTime"))) {
			
			StringBuilder sms = new StringBuilder();
			sms.append("Cambio del parametro: expiryTime");
			sms.append(" Old: ");
			sms.append(ConfigAdapter.mapConfAuthenticator.get("expiryTime"));
			sms.append(" new: ");
			sms.append(valuesProperties.getProperty("expiryTime").toString());
			logger.info(sms.toString());
			
			ConfigAdapter.mapConfAuthenticator.put("expiryTime", valuesProperties.getProperty("expiryTime").toString());
		}
		if (!valuesProperties.getProperty("tokenSignature").toString().equals(ConfigAdapter.mapConfAuthenticator.get("tokenSignature"))) {
			
			StringBuilder sms = new StringBuilder();
			sms.append("Cambio del parametro: tokenSignature");
			sms.append(" Old: ");
			sms.append(ConfigAdapter.mapConfAuthenticator.get("tokenSignature"));
			sms.append(" new: ");
			sms.append(valuesProperties.getProperty("tokenSignature").toString());
			logger.info(sms.toString());
			
			ConfigAdapter.mapConfAuthenticator.put("tokenSignature", valuesProperties.getProperty("tokenSignature").toString());
		}
		if (!valuesProperties.getProperty("sp_loockup_msisdn_type").toString().equals(ConfigAdapter.mapConfAuthenticator.get("sp_loockup_msisdn_type"))) {
			
			StringBuilder sms = new StringBuilder();
			sms.append("Cambio del parametro: sp_loockup_msisdn_type");
			sms.append(" Old: ");
			sms.append(ConfigAdapter.mapConfAuthenticator.get("sp_loockup_msisdn_type"));
			sms.append(" new: ");
			sms.append(valuesProperties.getProperty("sp_loockup_msisdn_type").toString());
			logger.info(sms.toString());
			
			ConfigAdapter.mapConfAuthenticator.put("sp_loockup_msisdn_type", valuesProperties.getProperty("sp_loockup_msisdn_type").toString());
		}
		
		if (!valuesProperties.getProperty("featc_validate_type_sim").toString().equals(ConfigAdapter.mapConfAuthenticator.get("featc_validate_type_sim"))) {
			
			StringBuilder sms = new StringBuilder();
			sms.append("Cambio del parametro: featc_validate_type_sim");
			sms.append(" Old: ");
			sms.append(ConfigAdapter.mapConfAuthenticator.get("featc_validate_type_sim"));
			sms.append(" new: ");
			sms.append(valuesProperties.getProperty("featc_validate_type_sim").toString());
			logger.info(sms.toString());
			
			ConfigAdapter.mapConfAuthenticator.put("featc_validate_type_sim", valuesProperties.getProperty("featc_validate_type_sim").toString());
		}
	}

}
