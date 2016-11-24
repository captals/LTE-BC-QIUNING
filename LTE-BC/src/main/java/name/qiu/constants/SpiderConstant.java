package name.qiu.constants;

public interface SpiderConstant {

	/**
	 * 初始链接前缀
	 */
	String INIT_URL_PREFIX = "https://book.douban.com/tag/%E7%BC%96%E7%A8%8B?type=S&start=";
	
	String BOOK_CLASS = "subject-item";
	
	String BOOK_ASSESS_CLASS = "rating_nums";
	
	String BOOK_ASSESS_COUNT_CLASS = "pl";
	
	String BOOK_NORMAL_CLASS = "pub";
	
	String BOOK_INFO_CLASS = "info";
	
	String BOOK_NAME_SUFFIX_SPAN = "span";
	
	String BOOK_NAME_TITLE = "title";
	
	String BOOK_URL_HREF = "href";
	
	int ASSESS_COUNT_LIMIT = 1000;
	
	int PAGE_SIZE = 20;
	
	String PROXYS_ADDRESS = "src/main/resources/proxyIP.txt";
	
}
