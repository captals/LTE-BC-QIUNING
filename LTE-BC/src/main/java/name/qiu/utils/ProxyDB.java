package name.qiu.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import name.qiu.constants.SpiderConstant;

public class ProxyDB {
	private static List<String> proxyList = new ArrayList<String>();
	private static volatile int count;
	private static volatile Set<String> closeProxyList = new HashSet<String>();

	static {
		File file = new File(SpiderConstant.PROXYS_ADDRESS);
		
		try {
            String encoding="GBK";
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    if (null != lineTxt && lineTxt.trim().length() > 0)
                    {
                    	proxyList.add(lineTxt);
                    }
                }
                read.close();
	    }else{
	        System.out.println("找不到指定的文件");
	    }
	    } catch (Exception e) {
	        System.out.println("读取文件内容出错");
	    }
		
	}
	
	public static Set<String> getCloseProxyList() {
		return closeProxyList;
	}
	
	public static void addCloseProxy(String proxy){
		closeProxyList.add(proxy);
	}
	
	public static List<String> getProxyList() {
		return proxyList;
	}	
	
	private static int getCount(){		
		if (count > proxyList.size() - 1)
			count = 0;	
		
		return count++;
	}
	
	private static String hostPort()
	{
		if ( proxyList.size() <= closeProxyList.size() )
			return null;
		
		List<String> list = getProxyList();		
		String proxy = null;
				
		proxy = list.get(getCount());		
		while ( closeProxyList.contains(proxy) ){
			if ( proxyList.size() <= closeProxyList.size() )
				return null;			
			proxy = list.get(getCount());
		}
		
		return proxy;
	}
	
	public static LocalProxy getProxy()
	{		
		String hostPort = hostPort();
		if (hostPort == null)
			return null;		
		
		String host = hostPort.split(":")[0];
		int port = Integer.valueOf(hostPort.split(":")[1]);
		SocketAddress socketaddress = new InetSocketAddress(host.trim(), port);
		LocalProxy proxy = new LocalProxy(Proxy.Type.HTTP, socketaddress);
		proxy.setStrProxy(hostPort);
		return proxy;
	}		
}
