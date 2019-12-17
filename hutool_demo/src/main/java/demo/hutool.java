package demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * Created by luwb on 2019/12/16.
 * 使用 hutool
 */
public class hutool {
	public static void main(String[] args) {
		String dateStr = "20191216";
		DateTime dateTime = DateUtil.parse(dateStr);
		System.out.println(dateTime);
	}
}
