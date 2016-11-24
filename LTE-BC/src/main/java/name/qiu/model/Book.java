package name.qiu.model;

import java.io.Serializable;

/**
 * 创建书籍实体
 * @author qiu
 * 2016年11月23日
 */
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8217094467866331381L;

	/**
	 * 书籍链接（唯一）
	 */
	private String url;
	
	/**
	 * 书名
	 */
	private String bookName;
	
	/**
	 * 评价
	 */
	private String assess;
	
	/**
	 * 评价人数
	 */
	private int assessCount;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 出版社
	 */
	private String press;
	
	/**
	 * 出版时间
	 */
	private String pressDate;
	
	/**
	 * 价格
	 */
	private String price;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAssess() {
		return assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	public int getAssessCount() {
		return assessCount;
	}

	public void setAssessCount(int assessCount) {
		this.assessCount = assessCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPressDate() {
		return pressDate;
	}

	public void setPressDate(String pressDate) {
		this.pressDate = pressDate;
	}
	
}
