1.作者：邱宁
Java开发（不可用其它语言）

功能实现：
	将豆瓣（book.douban.com）里的关于“互联网，编程，算法”方面的书籍数据抓下来，并且显示评分最高的前100本数据（要求评价数目不低于1000）
	
	代码和爬下的结果（excel文件)
技术要点：
	1.多线程
	2.同步
	3.IP代理
	4.导出excel

项目工程管理：
	1.项目核心代码目录src/java/name/qiu
	2.核心代码块主要分为4块constants定义配置参数，model为数据原型，sevice块为服务类，utils为工具类
	3.项目测试代码放在src/text/java/qiu/TestSpider.java
	4.代理地址
	5.EXCEL放在根目录下