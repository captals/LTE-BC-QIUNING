package name.qiu.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import name.qiu.utils.HttpTool;

public class DownLoadCall implements Callable<String>{
	
	/**
	 * 待下载的url
	 */
	private URL url;
	
	public DownLoadCall(URL url) {
		this.url = url;
	}

	@Override
	public String call() throws Exception {	
		String content = null;
		List<URL> list = new ArrayList<>();
		if (!list.contains(url))
		{
			try
			{
				content = HttpTool.doGet(url);
				list.add(url);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				call();
			}		
		}
		return content;
	}

	public URL getUrl() {
		return url;
	}

}
