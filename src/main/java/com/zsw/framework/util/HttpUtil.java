package com.zsw.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Simple utility class for operations used across multiple class hierarchies in
 * the web framework code.
 * <p/>
 * Some methods in this class were copied from the Spring Framework so we didn't
 * have to re-invent the wheel, and in these cases, we have retained all
 * license, copyright and author information.
 * 
 * @since 0.9
 */
public class HttpUtil {

	// TODO - complete JavaDoc
	/** 日志工具类 */
	private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

	// public static final String SERVLET_REQUEST_KEY =
	// ServletRequest.class.getName() + "_SHIRO_THREAD_CONTEXT_KEY";
	// public static final String SERVLET_RESPONSE_KEY =
	// ServletResponse.class.getName() + "_SHIRO_THREAD_CONTEXT_KEY";
	//
	// /**
	// * {@link org.apache.shiro.session.Session Session} key used to save a
	// request and later restore it, for example when redirecting to a
	// * requested page after login, equal to {@code shiroSavedRequest}.
	// */
	// public static final String SAVED_REQUEST_KEY = "shiroSavedRequest";
	//
	/**
	 * Standard Servlet 2.3+ spec request attributes for include URI and paths.
	 * <p>
	 * If included via a RequestDispatcher, the current resource will see the
	 * originating request. Its own URI and paths are exposed as request
	 * attributes.
	 */
	private static final String INCLUDE_REQUEST_URI_ATTRIBUTE = "javax.servlet.include.request_uri";
	private static final String INCLUDE_CONTEXT_PATH_ATTRIBUTE = "javax.servlet.include.context_path";
	// public static final String INCLUDE_SERVLET_PATH_ATTRIBUTE =
	// "javax.servlet.include.servlet_path";
	// public static final String INCLUDE_PATH_INFO_ATTRIBUTE =
	// "javax.servlet.include.path_info";
	// public static final String INCLUDE_QUERY_STRING_ATTRIBUTE =
	// "javax.servlet.include.query_string";
	//
	// /**
	// * Standard Servlet 2.4+ spec request attributes for forward URI and
	// paths.
	// * <p>If forwarded to via a RequestDispatcher, the current resource will
	// see its
	// * own URI and paths. The originating URI and paths are exposed as request
	// attributes.
	// */
	// public static final String FORWARD_REQUEST_URI_ATTRIBUTE =
	// "javax.servlet.forward.request_uri";
	// public static final String FORWARD_CONTEXT_PATH_ATTRIBUTE =
	// "javax.servlet.forward.context_path";
	// public static final String FORWARD_SERVLET_PATH_ATTRIBUTE =
	// "javax.servlet.forward.servlet_path";
	// public static final String FORWARD_PATH_INFO_ATTRIBUTE =
	// "javax.servlet.forward.path_info";
	// public static final String FORWARD_QUERY_STRING_ATTRIBUTE =
	// "javax.servlet.forward.query_string";
	//
	/**
	 * Default character encoding to use when
	 * <code>request.getCharacterEncoding</code> returns <code>null</code>,
	 * according to the Servlet spec.
	 * 
	 * @see ServletRequest#getCharacterEncoding
	 */
	private static final String DEFAULT_CHARACTER_ENCODING = Charset.UTF_8;

	/**
	 * 判断是否为Ajax请求
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 是true, 否false
	 */
	public static boolean isAjaxRequest() {
		HttpServletRequest request = getHttpServletRequest();
		String requestType = request.getHeader("X-Requested-With");
		boolean isAjax = requestType != null && requestType.equals("XMLHttpRequest");
		return isAjax;
	}

	/**
	 * Return the request URI for the given request, detecting an include
	 * request URL if called within a RequestDispatcher include.
	 * <p>
	 * As the value returned by <code>request.getRequestURI()</code> is
	 * <i>not</i> decoded by the servlet container, this method will decode it.
	 * <p>
	 * The URI that the web container resolves <i>should</i> be correct, but
	 * some containers like JBoss/Jetty incorrectly include ";" strings like
	 * ";jsessionid" in the URI. This method cuts off such incorrect appendices.
	 * 
	 * @param request
	 *            current HTTP request
	 * @return the request URI
	 */
	public static String getRequestUri(HttpServletRequest request) {
		String uri = (String) request.getAttribute(INCLUDE_REQUEST_URI_ATTRIBUTE);
		if (uri == null) {
			uri = request.getRequestURI();
		}
		return normalize(decodeAndCleanUriString(request, uri));
	}

	/**
	 * Normalize a relative URI path that may have relative values ("/./",
	 * "/../", and so on ) it it. <strong>WARNING</strong> - This method is
	 * useful only for normalizing application-generated paths. It does not try
	 * to perform security checks for malicious input. Normalize operations were
	 * was happily taken from org.apache.catalina.util.RequestUtil in Tomcat
	 * trunk, r939305
	 * 
	 * @param path
	 *            Relative path to be normalized
	 * @return normalized path
	 */
	public static String normalize(String path) {
		return normalize(path, true);
	}

	/**
	 * Normalize a relative URI path that may have relative values ("/./",
	 * "/../", and so on ) it it. <strong>WARNING</strong> - This method is
	 * useful only for normalizing application-generated paths. It does not try
	 * to perform security checks for malicious input. Normalize operations were
	 * was happily taken from org.apache.catalina.util.RequestUtil in Tomcat
	 * trunk, r939305
	 * 
	 * @param path
	 *            Relative path to be normalized
	 * @param replaceBackSlash
	 *            Should '\\' be replaced with '/'
	 * @return normalized path
	 */
	private static String normalize(String path, boolean replaceBackSlash) {

		if (path == null)
			return null;

		// Create a place for the normalized path
		String normalized = path;

		if (replaceBackSlash && normalized.indexOf('\\') >= 0)
			normalized = normalized.replace('\\', '/');

		if (normalized.equals("/."))
			return "/";

		// Add a leading "/" if necessary
		if (!normalized.startsWith("/"))
			normalized = "/" + normalized;

		// Resolve occurrences of "//" in the normalized path
		while (true) {
			int index = normalized.indexOf("//");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + normalized.substring(index + 1);
		}

		// Resolve occurrences of "/./" in the normalized path
		while (true) {
			int index = normalized.indexOf("/./");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + normalized.substring(index + 2);
		}

		// Resolve occurrences of "/../" in the normalized path
		while (true) {
			int index = normalized.indexOf("/../");
			if (index < 0)
				break;
			if (index == 0)
				return (null); // Trying to go outside our context
			int index2 = normalized.lastIndexOf('/', index - 1);
			normalized = normalized.substring(0, index2) + normalized.substring(index + 3);
		}

		// Return the normalized path that we have completed
		return (normalized);

	}

	/**
	 * Decode the supplied URI string and strips any extraneous portion after a
	 * ';'.
	 * 
	 * @param request
	 *            the incoming HttpServletRequest
	 * @param uri
	 *            the application's URI string
	 * @return the supplied URI string stripped of any extraneous portion after
	 *         a ';'.
	 */
	private static String decodeAndCleanUriString(HttpServletRequest request, String uri) {
		uri = decodeRequestString(request, uri);
		int semicolonIndex = uri.indexOf(';');
		return (semicolonIndex != -1 ? uri.substring(0, semicolonIndex) : uri);
	}

	/**
	 * Return the context path for the given request, detecting an include
	 * request URL if called within a RequestDispatcher include.
	 * <p>
	 * As the value returned by <code>request.getContextPath()</code> is
	 * <i>not</i> decoded by the servlet container, this method will decode it.
	 * 
	 * @param request
	 *            current HTTP request
	 * @return the context path
	 */
	public static String getContextPath(HttpServletRequest request) {
		String contextPath = (String) request.getAttribute(INCLUDE_CONTEXT_PATH_ATTRIBUTE);
		if (contextPath == null) {
			contextPath = request.getContextPath();
		}
		if ("/".equals(contextPath)) {
			// Invalid case, but happens for includes on Jetty: silently adapt
			// it.
			contextPath = "";
		}
		return decodeRequestString(request, contextPath);
	}

	/**
	 * Decode the given source string with a URLDecoder. The encoding will be
	 * taken from the request, falling back to the default "ISO-8859-1".
	 * <p>
	 * The default implementation uses
	 * <code>URLDecoder.decode(input, enc)</code>.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param source
	 *            the String to decode
	 * @return the decoded String
	 * @see #DEFAULT_CHARACTER_ENCODING
	 * @see ServletRequest#getCharacterEncoding
	 * @see URLDecoder#decode(String, String)
	 * @see URLDecoder#decode(String)
	 */
	@SuppressWarnings( { "deprecation" })
	public static String decodeRequestString(HttpServletRequest request, String source) {
		String enc = determineEncoding(request);
		try {
			return URLDecoder.decode(source, enc);
		} catch (UnsupportedEncodingException ex) {
			if (log.isWarnEnabled()) {
				log.warn("Could not decode request string [" + source + "] with encoding '" + enc
						+ "': falling back to platform default encoding; exception message: "
						+ ex.getMessage());
			}
			return URLDecoder.decode(source);
		}
	}

	/**
	 * Determine the encoding for the given request. Can be overridden in
	 * subclasses.
	 * <p>
	 * The default implementation checks the request's
	 * {@link ServletRequest#getCharacterEncoding() character encoding}, and if
	 * that <code>null</code>, falls back to the
	 * {@link #DEFAULT_CHARACTER_ENCODING}.
	 * 
	 * @param request
	 *            current HTTP request
	 * @return the encoding for the request (never <code>null</code>)
	 * @see ServletRequest#getCharacterEncoding()
	 */
	protected static String determineEncoding(HttpServletRequest request) {
		String enc = request.getCharacterEncoding();
		if (enc == null) {
			enc = DEFAULT_CHARACTER_ENCODING;
		}
		return enc;
	}

	/**
	 * A convenience method that merely casts the incoming
	 * <code>ServletRequest</code> to an <code>HttpServletRequest</code>:
	 * <p/>
	 * <code>return (HttpServletRequest)request;</code>
	 * <p/>
	 * Logic could be changed in the future for logging or throwing an
	 * meaningful exception in non HTTP request environments (e.g. Portlet API).
	 * 
	 * @param request
	 *            the incoming ServletRequest
	 * @return the <code>request</code> argument casted to an
	 *         <code>HttpServletRequest</code>.
	 */
	public static HttpServletRequest toHttp(ServletRequest request) {
		return (HttpServletRequest) request;
	}

	/**
	 * A convenience method that merely casts the incoming
	 * <code>ServletResponse</code> to an <code>HttpServletResponse</code>:
	 * <p/>
	 * <code>return (HttpServletResponse)response;</code>
	 * <p/>
	 * Logic could be changed in the future for logging or throwing an
	 * meaningful exception in non HTTP request environments (e.g. Portlet API).
	 * 
	 * @param response
	 *            the outgoing ServletResponse
	 * @return the <code>response</code> argument casted to an
	 *         <code>HttpServletResponse</code>.
	 */
	public static HttpServletResponse toHttp(ServletResponse response) {
		return (HttpServletResponse) response;
	}

	/**
	 * 设置Session attribute
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setSessionAttribute(String key, Object value) {
		getHttpSession().setAttribute(key, value);
	}

	/**
	 * Session Attribute取值
	 * 
	 * @param key
	 */
	public static Object getSessionAttributeValue(String key) {
		return getHttpSession().getAttribute(key);
	}

	/**
	 * 设置Request attribute
	 * 
	 * @param key
	 * @param value
	 */
	public static void setRequestAttribute(String key, Object value) {
		getHttpServletRequest().setAttribute(key, value);
	}

	/**
	 * Request Attribute取值
	 * 
	 * @param key
	 */
	public static Object getRequestAttributeValue(String key) {
		return getHttpServletRequest().getAttribute(key);
	}

	/**
	 * Request getParameter取值
	 * 
	 * @param key
	 */
	public static Object getRequestParameter(String key) {
		return getHttpServletRequest().getParameter(key);
	}

	/**
	 * 获取HttpServletRequest
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * 获取HttpSession
	 * 
	 * @return
	 */
	public static HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}

	/**
	 * 获得ServletContext对象
	 * */
	public static ServletContext getServletContext() {
		return getHttpServletRequest().getSession().getServletContext();
	}

	/**
	 * web服务器启动完成后,获得WEB项目在服务器上的根目录
	 * 
	 * @like C:/Tomcat6.0/webapps/ricore//
	 * */
	public static String getWebProjectRootPath() {
		try {
			return getServletContext().getRealPath("/").replace("\\", "/");
		} catch (Exception e) {
			System.out.println("WEB项目未启动，无法获得ServletContext对象！");
			return "";
		}
	}

	/**
	 * 获得web项目名
	 * 
	 * @like /ricore
	 * */
	public static String getWebProjectName() {
		return getHttpServletRequest().getContextPath();
	}

	/**
	 * 获得当前项目发布到服务器后的物理地址
	 * 
	 * @like C:\Tomcat6.0\webapps\ricore\
	 * */
	public static final String getWebProjectDeployPath() {
		return HttpUtil.getWebProjectRootPath();
	}

	/**
	 * 获得服务器应用发布路径
	 * 
	 * @like C:\Tomcat6.0\webapps\
	 * */
	public static final String getWebServerPath() {
		String webAppPath = getWebProjectDeployPath();
		String webAppName = HttpUtil.getWebProjectName();
		String[] serverpaths = webAppPath.split(webAppName);
		if (serverpaths.length >= 1) {
			return serverpaths[0] + "/";
		} else {
			return "";
		}
	}

	/**
	 * 获得远程访问IP
	 * */
	public static String getRemoteIpAddress() {
		HttpServletRequest request = getHttpServletRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		if ("0:0:0:0:0:0:0:1".equals(ip)) {
			ip = "127.0.0.1";
		}
		return ip;
	}

	/**
	 * get请求
	 * */
	public static String get(String url, Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		if (params != null) {
			url = url + "?";
			for (Entry<String, Object> e : params.entrySet()) {
				sb.append(e.getKey() + "=" + e.getValue().toString().trim() + "&");
			}
			url = url + sb.substring(0, sb.length() - 1);
		}

		HttpURLConnection con = null;
		try {
			URL u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("GET");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}

		StringBuilder buffer = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
				buffer.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * Post请求
	 * */
	public static String post(String url, Map<String, Object> params, Object content, String contentType) {
		StringBuilder sb = new StringBuilder();
		String p = "";
		if (params != null) {
			for (Entry<String, Object> e : params.entrySet()) {
				sb.append(e.getKey() + "=" + e.getValue().toString().trim() + "&");
			}
			p = sb.substring(0, sb.length() - 1);
		}

		HttpURLConnection con = null;
		try {
			URL u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", contentType);
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
			osw.write(p.trim());
			if (content != null)
				osw.write(content.toString());
			osw.flush();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}

		StringBuilder buffer = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String temp;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
				buffer.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}

	/**
	 * 上传附件
	 * */
	public static String upload(String requestUrl, Map<String, Object> params, Map<String, String> attachments) {
		String twoHyphens = "--";
		String boundary = "RQdzAAihJq7Xp1kjraqf";
		String lineEnd = "\r\n";

		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(20000 /* milliseconds */);
			conn.setConnectTimeout(20000 /* milliseconds */);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// conn.setRequestProperty("user-agent",
			// "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// conn.setRequestProperty("Charsert", "UTF-8");
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

			if (params != null) {
				for (Entry<String, Object> entry : params.entrySet()) {
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"" + entry.getKey() + "\""
							+ lineEnd);
					dos.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd);
					dos.writeBytes("Content-Length: " + entry.getValue().toString().length() + lineEnd);
					dos.writeBytes(lineEnd);
					dos.writeBytes(entry.getValue().toString() + lineEnd);
				}
			}

			if (attachments != null) {
				for (Entry<String, String> entry : attachments.entrySet()) {
					File file = new File(entry.getValue());
					dos.writeBytes(twoHyphens + boundary + lineEnd);
					dos.writeBytes("Content-Disposition: form-data; name=\"" + entry.getKey()
							+ "\";filename=\"" + file.getName() + "\"" + lineEnd);
					dos.writeBytes("Content-Type: image/jpeg" + lineEnd);
					dos.writeBytes(lineEnd);

					BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
					int bytes = 0;
					byte[] buffer = new byte[1024];
					while ((bytes = stream.read(buffer)) != -1) {
						dos.write(buffer, 0, bytes);
					}
					dos.writeBytes(lineEnd);
					stream.close();
				}
			}

			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
			dos.flush();
			dos.close();

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
				sb.append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据webPath获得绝对路径
	 * */
	public static String getRealPath(String webPath) {
		return getHttpSession().getServletContext().getRealPath(webPath);
	}

}