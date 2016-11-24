package name.qiu.utils;

import java.net.Proxy;
import java.net.SocketAddress;

public class LocalProxy extends Proxy {
	private String strProxy = null;
	
	public String getStrProxy() {
		return strProxy;
	}

	public void setStrProxy(String strProxy) {
		this.strProxy = strProxy;
	}

	public LocalProxy(Type type, SocketAddress sa) {
		super(type, sa);
		// TODO Auto-generated constructor stub
	}

}
