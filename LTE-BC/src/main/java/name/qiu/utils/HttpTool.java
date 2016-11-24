package name.qiu.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author qiu
 * 2016年11月23日
 */
public class HttpTool {
	/**
	 * 通过url获取网页信息
	 * @param linkUrl
	 * @return
	 */
	public static String doGet(URL url)
	{
	    String html = "";
    	LocalProxy proxy = ProxyDB.getProxy();	    	
    	if (proxy == null)
    		return html;
    	
	    try {  	    	
    		HttpURLConnection connection= (HttpURLConnection) url.openConnection(proxy);  	
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(5000);
	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");  		        
	        
	        if (connection.getResponseCode() == 200) {
	            if (ProxyDB.getCloseProxyList().contains(proxy.getStrProxy()))
	            	ProxyDB.getCloseProxyList().remove(proxy.getStrProxy());	        	
	        	
	            InputStream in = connection.getInputStream();
	            html = StreamTool.inToStringByByte(in);
	            in.close();	            
	        } else {
	        	ProxyDB.addCloseProxy(proxy.getStrProxy());
	            throw new RuntimeException("book.douban.com务器返回值不为200");
	        }		       	        
	    } catch (Exception e) {
	    	ProxyDB.addCloseProxy(proxy.getStrProxy());
	        throw new RuntimeException("get请求失败");
	    }
	    
	    return html;
	}
	
}
