package com.digitel.dao;

 

 

//import com.sap.mw.jco.IFunctionTemplate;
//import com.sap.mw.jco.IRepository;
//import com.sap.mw.jco.JCO;
//import com.sap.mw.jco.JCO.Function;
//import com.sap.mw.jco.JCO.ParameterList;
//import com.sap.mw.jco.JCO.Table;
//
//import digitel.com.ve.materialtypelookupsap.beans.MaterialBusinessBean;
//import digitel.com.ve.materialtypelookupsap.beans.SapResponse;
//import digitel.com.ve.materialtypelookupsap.businessconfigurations.GlobalProperties;

/**
 * @author ELuttinger
 * 
 */
public class SapWrapper {

	private static SapWrapper sapWrapper = (SapWrapper) null;
	private static String sapSID;
	private static String sapClient;
	private static String sapUser;
	private static String sapPassword;
	private static String saplanguage;
	private static String sapIPHost;
	private static String sapSysNum;
	int poolMaxConnections;

//	private static final Logger logger = BSSIntLogger
//			.getBSSIntLogger(SapWrapper.class);
//	private static String sapActivo = GlobalProperties
//			.getConfigProperty("SAP_ACTIVO");

	public SapWrapper() {
		
		super();
		
	}

	/**
	 * obtiene una conexion contra sap
	 * 
	 * @param traceID
	 */
	private SapWrapper(String traceID) {
		
//		logger.debug("******************Carga los parametros de conexion a SAP***************************");
//
//		MDC.put("traceid", traceID);
//		sapSID = GlobalProperties.getConfigProperty("SAP_SID");// "V19";
//		sapClient = GlobalProperties.getConfigProperty("SAP_CLIENT");// "810";
//		sapUser = GlobalProperties.getConfigProperty("SAP_USER");// "RFCSISAP";
//		sapPassword = GlobalProperties.getConfigProperty("SAP_PASSWORD");// "654654";
//		saplanguage = GlobalProperties.getConfigProperty("SAP_LANG");// "ES";
//		sapIPHost = GlobalProperties.getConfigProperty("SAP_HOST");// "10.27.31.150";
//		sapSysNum = GlobalProperties.getConfigProperty("SAP_SYSNUM");// "00";
//		poolMaxConnections = Integer.parseInt(GlobalProperties
//				.getConfigProperty("SAP_MAX_POOL_CONNECTIONS"));// 50;
//
//		JCO.Pool pool = JCO.getClientPoolManager().getPool(sapSID);
//
//		if (pool == null) {
//			JCO.addClientPool(sapSID, poolMaxConnections, sapClient, sapUser,
//					sapPassword, saplanguage, sapIPHost, sapSysNum);
//			logger.info("Se obtiene una conexion con SAP");
//		}

	}

	/**
	 * retorna una instancia del Objeto que maneja las operaciones con SAP
	 * 
	 * @param traceId
	 * @return
	 */
//	public static SapWrapper getInstance(String traceId) {
//
//		if (sapWrapper == null && sapActivo.equals("1")) {
//			sapWrapper = new SapWrapper(traceId);
//		} else if (sapWrapper == null && sapActivo.equals("0")) {
//			logger.debug("******************Llama al constructor por defecto ***************************");
//			sapWrapper = new SapWrapper();
//		}
//		return sapWrapper;
//	}
//
//	private synchronized SapResponse runRFCBySap(String materialCode)
//			throws Throwable {
//		
//		logger.debug("******** Se realiza una consulta contra sap por el material ID "+ materialCode);
//
//		SapResponse sapResponse = (SapResponse) null;
//		Function function = (Function) null;
//		ParameterList response = (ParameterList) null;
//		Table table = (Table) null;
//		MaterialBusinessBean material = (MaterialBusinessBean) null;
//		JCO.Client clientJco = null;
//		IRepository repository = (IRepository) null;
//
//		try {
//
//			clientJco = JCO.getClient(sapSID);
//			repository = JCO.createRepository("MYRepository", sapSID);
//
//			logger.info("Se realiza una consulta contra sap por el material ID "+ materialCode);
//
//			IFunctionTemplate ftemplate = repository
//					.getFunctionTemplate(GlobalProperties
//							.getConfigProperty("SAP_RFC")); // ZSD_RFC_MATERIAL_SERIAL
//
//			function = ftemplate.getFunction();
//
//			JCO.ParameterList input = function.getImportParameterList();
//
//			input.setValue(GlobalProperties.getConfigProperty("TIPO_MATERIAL"),
//					"TIPO_MATERIAL"); // ZVTM
//			input.setValue(materialCode, "SERIAL");
//			input.setValue("", "DESC_MATERIAL");
//
//			clientJco.execute(function);
//
//			response = function.getTableParameterList();
//
//			table = response.getTable("TI_MATERIALES");
//			sapResponse = new SapResponse();
//			material = new MaterialBusinessBean();
//
//			if (table.getNumRows() > 0) {
//
//				material.setMaterialCodeIn(materialCode);
//				material.setMaterialCodeOut((String) table.getValue("MATNR"));
//				material.setMaterialDescriptionOut((String) table
//						.getValue("MAKTX"));
//				material.setMaterialTypeOut((String) table.getValue("MATYPE"));
//				material
//						.setMaterialSapCodeOut((String) table.getValue("MATNR"));
//				sapResponse.setMaterialBean(material);
//				sapResponse.setErrorCode(GlobalProperties
//						.getMessageProperty("SAP_SUCCESS_CODE"));
//				sapResponse.setErrorMessage(GlobalProperties
//						.getMessageProperty("SAP_SUCCESS_MESSAGE"));
//
//			} else {
//
//				material.setMaterialCodeIn(materialCode);
//				material.setMaterialCodeOut("");
//				material.setMaterialDescriptionOut("");
//				material.setMaterialTypeOut(GlobalProperties
//						.getConfigProperty("SAP_MATERIAL_TYPE_DEFAULT"));
//				material.setMaterialSapCodeOut("");
//				sapResponse.setMaterialBean(material);
//				sapResponse.setErrorCode(GlobalProperties
//						.getMessageProperty("SAP_SUCCESS_CODE"));
//				sapResponse.setErrorMessage(GlobalProperties
//						.getMessageProperty("SAP_SUCCESS_MESSAGE"));
//				// sapResponse.setErrorCode(GlobalProperties.getMessageProperty("SAP_ERROR_CODE"));
//				// sapResponse.setErrorMessage(GlobalProperties.getMessageProperty("SAP_ERROR_MESSAGE"));
//
//			}
//
//		} catch (Throwable e) {
//			logger.error("Error realizando la consulta contra sap del codigo material: "
//							+ materialCode);
//			throw e;
//
//		} finally {
//			if (clientJco != null) {
//				function = null;
//				JCO.releaseClient(clientJco);
//			}
//
//		}
//
//		return sapResponse;
//	}
//
//	/**
//	 * M�todo para devolver parametros por defectos a la consulta de materiales 
//	 * sin conectarse a SAP
//	 * @param materialCode
//	 * @return
//	 */
//	private synchronized SapResponse runRFCNotSap(String materialCode) {
//		
//		logger.debug("**************** Se retornan los parametros por defetos  por el material ID "+ materialCode);
//		
//		 
//		SapResponse sapResponse= new SapResponse();
//		MaterialBusinessBean material = new MaterialBusinessBean();
//		
//		material.setMaterialCodeIn(materialCode);
//		material.setMaterialCodeOut("");
//		material.setMaterialDescriptionOut("");
//		material.setMaterialTypeOut(GlobalProperties.getConfigProperty("SAP_MATERIAL_TYPE_DEFAULT"));
//		material.setMaterialSapCodeOut("");
//		sapResponse.setMaterialBean(material);
//		sapResponse.setErrorCode(GlobalProperties.getMessageProperty("SAP_SUCCESS_CODE"));
//		sapResponse.setErrorMessage(GlobalProperties.getMessageProperty("SAP_SUCCESS_MESSAGE"));
//		// sapResponse.setErrorCode(GlobalProperties.getMessageProperty("SAP_ERROR_CODE"));
//		// sapResponse.setErrorMessage(GlobalProperties.getMessageProperty("SAP_ERROR_MESSAGE"));
//		
//		return sapResponse;
//		
//	}
//
//	/**
//	 * Corre el RFC en sap que consulta el tipo de material
//	 */
//	public synchronized SapResponse runRFC(String materialCode)
//			throws Throwable {
//
//		SapResponse sapResponse = (SapResponse) null;
//		
//		try {
//			
//			logger.debug("******************parametro  sapActivo " + sapActivo);
//
//			if (sapActivo.equals("1")) {
//				logger.debug("******************parametro igua a 1 va contra SAP***************************");
//				sapResponse = this.runRFCBySap(materialCode);
//
//			} else {
//				logger.debug("******************parametro igua a 0 parametros por defecto***************************");
//				sapResponse = this.runRFCNotSap(materialCode);
//			}
//
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
// 
//
//		return sapResponse;
//
//	}
//
//	/**
//	 * libera la conexion obtenida del pool de conexiones con SAP
//	 */
//	public static void releaseSapConnection() {
//
//		JCO.Pool pool = JCO.getClientPoolManager().getPool(sapSID);
//		if (pool != null) {
//			JCO.getClientPoolManager().removePool(sapSID);
//			logger.info("Se libera la conexion con sap");
//		}
//	}

}
