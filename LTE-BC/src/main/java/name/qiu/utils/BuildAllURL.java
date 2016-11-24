package name.qiu.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import name.qiu.constants.SpiderConstant;

public class BuildAllURL {

	private static final int pageNum = 50;
	
	public static List<URL> allURL() throws MalformedURLException
	{
		List<URL> urls = new ArrayList<URL>();
		
		URL url = null;
		for (int page = 0; page < pageNum; page++)
		{
			url = new URL(SpiderConstant.INIT_URL_PREFIX + (SpiderConstant.PAGE_SIZE * page));
			urls.add(url);
		}
		
		return urls;
	}
}
