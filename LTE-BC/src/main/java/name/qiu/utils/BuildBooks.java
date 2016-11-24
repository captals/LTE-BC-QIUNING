package name.qiu.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import name.qiu.constants.SpiderConstant;
import name.qiu.model.Book;

/**
 * 
 * @author qiu
 * 2016年11月23日
 */
public class BuildBooks {

	public static List<Book> allBooks4Content(String content)
	{
		List<Book> books = new ArrayList<Book>();
		
		// 将获取的网页 HTML 源代码转化为 Document
		Document doc = Jsoup.parse(content);
		
		Elements links = doc.getElementsByClass(SpiderConstant.BOOK_CLASS);
		
		if (null == links || links.isEmpty())
		{
			return books;
		}
		
		Book book = null;
		for (Element link : links)
		{
			String assessCount = link.getElementsByClass(SpiderConstant.BOOK_ASSESS_COUNT_CLASS).get(0).text();
			assessCount = getNum(assessCount);
			// 若评价小于1000 则不进行后续排序
			if (StringUtil.isBlank(assessCount) 
					|| Integer.valueOf(assessCount) < SpiderConstant.ASSESS_COUNT_LIMIT)
			{
				continue;
			}
			
			book = new Book();
			String assess = link.getElementsByClass(SpiderConstant.BOOK_ASSESS_CLASS).get(0).text();
			String normal = link.getElementsByClass(SpiderConstant.BOOK_NORMAL_CLASS).get(0).text();
			Element bookinfo = link.getElementsByClass(SpiderConstant.BOOK_INFO_CLASS).get(0);
			
			String bookNameSuffix = bookinfo.getElementsByTag(SpiderConstant.BOOK_NAME_SUFFIX_SPAN).get(0).text();
			
			Elements bookLinks = bookinfo.select("a[href]");

			for (Element bookLink : bookLinks)
			{
				book.setUrl(bookLink.attr(SpiderConstant.BOOK_URL_HREF));
				
				book.setBookName(bookLink.attr(SpiderConstant.BOOK_NAME_TITLE));
				
				break;
			}
			
			String[] normals = normal.split("/");
			if (normals.length > 3)
			{
				book.setAuthor(normals[0]);
				book.setPress(normals[normals.length - 3]);
				book.setPressDate(normals[normals.length - 2]);
				book.setPrice(normals[normals.length - 1]);
			}
			String bookName = book.getBookName() + bookNameSuffix;
			book.setBookName(bookName);
			book.setAssessCount(Integer.valueOf(assessCount));
			book.setAssess(assess);
			books.add(book);
		}
		
		return books;
	}
	
	private static String getNum(String s)
	{
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(s);   
		return m.replaceAll("").trim();
	}
}
