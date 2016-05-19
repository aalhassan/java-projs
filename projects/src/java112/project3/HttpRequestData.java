package java112.project3;

import java.util.*;
/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    mAlhassan
 */
public class HttpRequestData extends java.lang.Object {


	private  String client;
	private  String clientIp;
	private  String httpRequestMethod;
	private  String requestUri;
	private  StringBuffer requestUrl;
	private  String requestProtocol ;
	private  String serverName;
	private  int serverPort;
	private  Locale currentLocale ;
	private  String queryString;
	private  String queryParameter;
	private  String userAgent;

   
	
	/**
	 * Default constructor
	 */
	public HttpRequestData() {
		super();
	}
	

    /**
	 * @param client
	 * @param clientIp
	 * @param httpRequestMethod
	 * @param requestUri
	 * @param requestUrl
	 * @param requestProtocol
	 */
	public HttpRequestData(String client, String clientIp, String httpRequestMethod, String requestUri,
			StringBuffer requestUrl, String requestProtocol) {
		super();
		this.client = client;
		this.clientIp = clientIp;
		this.httpRequestMethod = httpRequestMethod;
		this.requestUri = requestUri;
		this.requestUrl = requestUrl;
		this.requestProtocol = requestProtocol;
	}


	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}


	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}


	/**
	 * @param clientIp the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}


	/**
	 * @return the httpRequestMethod
	 */
	public String getHttpRequestMethod() {
		return httpRequestMethod;
	}


	/**
	 * @param httpRequestMethod the httpRequestMethod to set
	 */
	public void setHttpRequestMethod(String httpRequestMethod) {
		this.httpRequestMethod = httpRequestMethod;
	}


	/**
	 * @return the requestUri
	 */
	public String getRequestUri() {
		return requestUri;
	}


	/**
	 * @param requestUri the requestUri to set
	 */
	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}


	/**
	 * @return the requestUrl
	 */
	public StringBuffer getRequestUrl() {
		return requestUrl;
	}


	/**
	 * @param requestUrl the requestUrl to set
	 */
	public void setRequestUrl(StringBuffer requestUrl) {
		this.requestUrl = requestUrl;
	}


	/**
	 * @return the requestProtocol
	 */
	public String getRequestProtocol() {
		return requestProtocol;
	}


	/**
	 * @param requestProtocol the requestProtocol to set
	 */
	public void setRequestProtocol(String requestProtocol) {
		this.requestProtocol = requestProtocol;
	}


	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}


	/**
	 * @param serverName the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}


	/**
	 * @return the serverPort
	 */
	public int getServerPort() {
		return serverPort;
	}


	/**
	 * @param serverPort the serverPort to set
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}


	/**
	 * @return the currentLocale
	 */
	public Locale getCurrentLocale() {
		return currentLocale;
	}


	/**
	 * @param currentLocale the currentLocale to set
	 */
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}


	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}


	/**
	 * @param queryString the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}


	/**
	 * @return the queryParameter
	 */
	public String getQueryParameter() {
		return queryParameter;
	}


	/**
	 * @param queryParameter the queryParameter to set
	 */
	public void setQueryParameter(String queryParameter) {
		this.queryParameter = queryParameter;
	}


	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}


	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}	

   
}
