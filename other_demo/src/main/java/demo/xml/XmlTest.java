package demo.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.net.URL;

/**
 * Created by luwb on 2020/01/13.
 * 解析xml
 */
public class XmlTest {
	public static void main(String[] args) throws IOException {
		// 基于字符串获取doc
		String html = "<html><body><p>Hello HTML</p><p>Hello World</p></body></html>";
		Document doc1 = Jsoup.parse(html);
		// 基于url获取doc
		Document doc2 = Jsoup.parse(new URL("http://www.baidu.com"), 5000);
		Elements elements = doc2.getElementsByTag("p");
		// 基于文件获取doc
		File file = new File("D:\\Git_project\\MyDemo\\other_demo\\src\\main\\resources\\test.html");
		if (!file.exists()) {
			System.out.println("文件路径不存在！");
			return;
		}
		Document doc3 = Jsoup.parse(file, "utf8");
//		 获取id为productName的文本内容
		Element productName = doc3.getElementById("productName");
		System.out.println(productName);
		// 通过标签获取内容
		Elements elementsByTag = doc3.getElementsByTag("a");
		show(elementsByTag);
		// 通过Class获取内容
		Elements elementsByClass = doc3.getElementsByClass("RightBox");
		show(elementsByClass);

		String html2 = "<div id=\"d1\" class=\"c1 c2\">let us<a href=\"how2j.cn\">study java</a></div>";
		Document doc = Jsoup.parse(html2);
		Element e = doc.getElementById("d1");
		// 获取属性
		System.out.println(e.attr("id"));
		// 获取所有属性
		System.out.println(e.attributes());
		// 获取id
		System.out.println(e.id());
		// 获取类名称
		System.out.println(e.className());
		// 获取所有类名称
		System.out.println(e.classNames());
		// 获取文本
		System.out.println(e.text());
		// 获取html
		System.out.println(e.html());
		// 获取外html
		System.out.println(e.outerHtml());
		// 获取标签信息
		System.out.println(e.tagName());
	}

	private static void show(Elements elements) {
		for (Element element : elements) {
			System.out.println(element);
		}
	}
}
