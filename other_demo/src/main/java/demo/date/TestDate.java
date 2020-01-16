package demo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by luwb on 2020/01/13.
 * 时间原点：1970年1月1日 8点0分0秒
 */
public class TestDate {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws ParseException {
		Date date1 = new Date();
		System.out.println("当前时间："+date1);
		// 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
		Date date2 = new Date(5000);
		System.out.println("从1970:01:01 08:00开始经历了5秒的时间"+date2);
		// 这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
		System.out.println("当前时间getTime()返回的值是："+date1.getTime());
		// 日期格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String dateStr = sdf.format(new Date());
		System.out.println("当前时间："+dateStr);
		// 字符串转日期
		String dateStr2 = "2020-1-13 12:12:12 010";
		Date parseDate = sdf.parse(dateStr2);
		System.out.println("字符串转换后日期："+parseDate);
		// 获取日历对象
		Calendar calendar = Calendar.getInstance();
		// 当前时间
		Date time = calendar.getTime();
		System.out.println(time);
		// 修改日期
		calendar.setTime(new Date(0));
		System.out.println("时间原点："+calendar.getTime());
		// 当前日期
		calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		System.out.println(format(now));
		// 下个月的今天
		calendar.setTime(now);
		calendar.add(calendar.MONTH,1);
		System.out.println(format(calendar.getTime()));
		// 去年的今天
		calendar.setTime(now);
		calendar.add(Calendar.YEAR, -1);
		System.out.println(format(calendar.getTime()));
		// 上个月的第三天
		calendar.setTime(now);
		calendar.add(Calendar.MONTH,-1);
		calendar.set(Calendar.DATE,3);
		System.out.println(format(calendar.getTime()));
	}

	private static String format(Date date) {
		return dateFormat.format(date);
	}
}
