package com.digitel.client;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;





@SuppressWarnings("deprecation")
public class SoapClient {
	
private static Object object;
	
	public static String soapActionKey = "SOAPAction";
	
	public static String Token = null;

	public SoapClient() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused"  })
	public static Object execute(String endPoint, Object request, String requestName, Class requestClass, Class responseClass, String soapAction , String HeadParamts , Object obj, String respond, String xmls) throws Exception {
			
	    try {
            JAXBContext jaxbContextRequest = JAXBContext.newInstance(requestClass);
            Marshaller jaxbMarshaller = jaxbContextRequest.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
       
			JAXBElement jx = new JAXBElement(new QName(requestName), requestClass, request);
            StringWriter writer = new StringWriter();
            jaxbMarshaller.marshal(jx, writer);
           
            CloseableHttpClient httpClient = HttpClients.custom()
            .setHostnameVerifier(new AllowAllHostnameVerifier())
            .setSslcontext(
                       new SSLContextBuilder().loadTrustMaterial(null,
                                   new TrustStrategy() {
                             public boolean isTrusted(
                                         X509Certificate[] arg0,
                                         String arg1)
                             throws CertificateException {
                                   return true;
                             }
                       }).build()).build();

            HttpPost httpPost = new HttpPost(endPoint);
            httpPost.addHeader(soapActionKey, soapAction);
            String headTemplate = "<soapenv:Envelope "+HeadParamts+"><soapenv:Header/>";        
            String bodyTemplate = "<soapenv:Body>";
            String footTemplate = "</soapenv:Body></soapenv:Envelope>";
            String requestString = null;
            String Body = writer.toString();            
            requestString = headTemplate + bodyTemplate + Body + footTemplate;
            System.out.println("ENvADIO");
            System.out.println(requestString);
            StringEntity entity = new StringEntity(requestString);           
            entity.setContentType("ext/xml;charset=UTF-8");
          
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("charset", "UTF-8");
            httpPost.setHeader("Accept-Encoding", "gzip,deflate");
            httpPost.setHeader("Host", "wsaduhomoext.afip.gob.ar");
      
            httpPost.setEntity(entity);
            CloseableHttpResponse response = null;
       
            response = httpClient.execute(httpPost);
            InputStream in = response.getEntity().getContent();
            InputStreamReader is = new InputStreamReader(in);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(is);
            String read = br.readLine();

            while (read != null) {
                 sb.append(read);
                 read = br.readLine();
                 System.out.println(read);
            }
            System.out.println("Recibiendo XML: " + sb.toString());
            if (sb.toString().contains("<?xml version='1.0' encoding='ISO-8859-1'?><soapenv:Fault") || (sb.toString().contains("<soap:Fault"))) {
            	
	           	 String soapHeader = "";
	           	 String soapFooter = "";
	    	 
	           	if (sb.toString().contains("<?xml version='1.0' encoding='ISO-8859-1'?>")){
	           		soapHeader = "<?xml version='1.0' encoding='ISO-8859-1'?><soapenv:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"  ><soapenv:Body>";
	                   soapFooter = "</soapenv:Body></soapenv:Envelope>";    
	           	}else{
	           	  soapHeader = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"  ><soap:Body>";
	                 soapFooter = "</soap:Body></soap:Envelope>";                  
	           	}
                 String messageSoapFault = sb.toString().replace(soapHeader, "").replace(soapFooter, "");
                     
                 StringReader reader = new StringReader(messageSoapFault);
                 String errorCode = null;
                 Pattern p = Pattern.compile("<ErrorCode>(.*)</ErrorCode>");
                 Matcher m = p.matcher(messageSoapFault);
                 
                 if (m.find()) {
                       errorCode = m.group(1).replaceFirst("<ErrorCode>(.*)</ErrorCode>", "$1");
                 }
                 String errorDescription = null;
                 p = Pattern.compile("<ErrorDescription>(.*)</ErrorDescription>");
                 m = p.matcher(messageSoapFault);

                 if (m.find()) {
                       errorDescription = m.group(1).replaceFirst("<ErrorDescription>(.*)</ErrorDescription>", "$1");
                 }
                                
                 System.out.println(" Error  Type:"+errorCode +"  Error des:"+errorDescription);
                 String sResp = " Error  Type:"+errorCode +"  Error des:"+errorDescription;
                   
                	 
                   	 throw new Exception (sResp);      
                 
                 
            } else {                
            	 String soapHeader = "";
                 String soapFooter = "";
            	if (sb.toString().contains("<?xml version='1.0' encoding='UTF-8'?>")){
            		System.out.println("x ENTROO: 222 ");
            		    soapHeader = "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><ns2:"+respond+ " "+ xmls+">";
            		    			
            		    //   <?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"><S:Body><ns2:getIterautoIdResponse xmlns:ns2="http://services.iterautoid.digitel.com.ve/">
            		    			
            		    soapFooter = "</ns2:"+respond+"></S:Body></S:Envelope>";
                }/*else{               		
                	System.out.println("x2");
                	    soapHeader = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><"+respond+" xmlns=\"http://services.iterautoid.digitel.com.ve\">";
                        soapFooter = "</"+respond+"></soapenv:Body></soapenv:Envelope>";
                        
                        System.out.println(soapHeader);
               	}*/
                  
                 String responseString = sb.toString().replace(soapHeader, "").replace(soapFooter, "");
                 responseString = "<materialTypeLookupSapResponse>"+responseString+"</materialTypeLookupSapResponse>";
                 System.out.println(responseString);
                 System.out.println(soapHeader);
                 StringReader reader = new StringReader(responseString);
                 JAXBContext jaxbContextResponse = JAXBContext.newInstance(responseClass);
                 Unmarshaller unmarshaller = jaxbContextResponse.createUnmarshaller();
                 JAXBElement root = unmarshaller.unmarshal(new StreamSource(reader), responseClass);
                 return obj = (Object) root.getValue();  
        
            }	
            
      
      }catch (Exception e) {
  
    	  System.out.println(e.getMessage());
            throw e;
      }
		

	}

	public static Object getObj() {
		return object;
	}

	public static void setObj(Object obj) {
		object = obj;
	}

	
	
	

}
