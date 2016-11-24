package name.qiu;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import name.qiu.model.Book;
import name.qiu.service.impl.DownLoadCall;
import name.qiu.utils.BuildAllURL;
import name.qiu.utils.BuildBooks;
import name.qiu.utils.CreateSimpleExcelToDisk;

public class TestSpider {
	
	/**
	 * 测试网页信息下载
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		Date startTime = new Date();
		
		// 取前50页按评价排序的编程书籍
		List<URL> urls = BuildAllURL.allURL();
		
		// 并发线程数量
		int threads = 4;
		
		ExecutorService es = Executors.newFixedThreadPool(threads);
		
		Set<Future<String>> set = new HashSet<Future<String>>();
		
		for (final URL url : urls)
		{
			DownLoadCall task = new DownLoadCall(url);
			
			Future<String> future = es.submit(task);
			
			set.add(future);
			
		}
		List<Book> books = new ArrayList<Book>();
		// 通过future对象取得结果
		for (Future<String> future : set)
		{
			try {
				String content = future.get();
				
				if (content != null && !content.isEmpty() )
					books.addAll(BuildBooks.allBooks4Content(content));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Collections.sort(books,new Comparator<Book>(){  
            public int compare(Book arg0, Book arg1) {  
                return arg1.getAssess().compareTo(arg0.getAssess());  
            }  
        });  
					
		Date endTime = new Date();			
		CreateSimpleExcelToDisk.CreateExcel(books);		
		System.out.println("总耗时：" + (endTime.getTime() - startTime.getTime()));	
	}
}
