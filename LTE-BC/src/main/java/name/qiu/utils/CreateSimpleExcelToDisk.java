package name.qiu.utils;

import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import name.qiu.model.Book;

public class CreateSimpleExcelToDisk {
	@SuppressWarnings("deprecation")
	public static void CreateExcel(List<Book> bookList){
	    HSSFWorkbook wb = new HSSFWorkbook();  
	    // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	    HSSFSheet sheet = wb.createSheet("学生表一");  
	    // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	    HSSFRow row = sheet.createRow((int) 0);  
	    // 第四步，创建单元格，并设置值表头 设置表头居中  
	    HSSFCellStyle style = wb.createCellStyle();  
	    style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
	
	    HSSFCell cell = row.createCell((short) 0);  
	    cell.setCellValue("序号");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 1);  
	    cell.setCellValue("书名");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 2);  
	    cell.setCellValue("评分");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 3);  
	    cell.setCellValue("评价人数");  
	    cell.setCellStyle(style);  
	    cell = row.createCell((short) 4);  
	    cell.setCellValue("作者");  
	    cell.setCellStyle(style);  	   
	    cell = row.createCell((short) 5);  
	    cell.setCellValue("出版社");  
	    cell.setCellStyle(style);  	
	    cell = row.createCell((short) 6);  
	    cell.setCellValue("出版日期");  
	    cell.setCellStyle(style); 	    
	    cell = row.createCell((short) 7);  
	    cell.setCellValue("价格");  
	    cell.setCellStyle(style); 
	
	    // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
	    List<Book> list = bookList;  
	
	    for (int i = 0; i < list.size(); i++)  
	    {  
	        row = sheet.createRow((int) i + 1);  
	        Book book = (Book) list.get(i);  
	        // 第四步，创建单元格，并设置值  
	        row.createCell((short) 0).setCellValue((int) (i+1));  
	        row.createCell((short) 1).setCellValue(book.getBookName());  
	        row.createCell((short) 2).setCellValue(book.getAssess());  
	        row.createCell((short) 3).setCellValue(book.getAssessCount());  
	        row.createCell((short) 4).setCellValue(book.getAuthor());  
	        row.createCell((short) 5).setCellValue(book.getPress()); 	 
	        row.createCell((short) 6).setCellValue(book.getPressDate()); 	
	        row.createCell((short) 7).setCellValue(book.getPrice()); 	
	    }  
	    // 第六步，将文件存到指定位置  
	    try  
	    {  
	        FileOutputStream fout = new FileOutputStream("books.xls");  
	        wb.write(fout);  
	        fout.close();  
	    }  
	    catch (Exception e)  
	    {  
	        e.printStackTrace();  
	    }  
	}  
}
