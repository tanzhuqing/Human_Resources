package commonjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import db.DBManager;

/**
 * 常用的一些通用方法
 * 
 * @author Administrator
 * 
 */
public class CommonFunction {

	public static DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static DateFormat f2 = new SimpleDateFormat("yyyy");
	public static DateFormat f3 = new SimpleDateFormat("MM");

	/**
	 * 将字符串进行加密和解密（采用和某个字符串进行异或，异或的字符串“mayuanzhi”）
	 * 
	 * @param str
	 * @return
	 */
	public static String returnXORString(String str) {
		int l, m, t1, t2, t3;
		String strKey = "mayuanzhi";
		String s1, s2, Coding;
		try {
			Coding = "";
			m = str.length();
			l = strKey.length();
			for (int i = 0; i < m; i++) {
				s1 = str.substring(i, i + 1);
				s2 = strKey.substring(i % l, (i % l) + 1);
				t1 = (int) s1.charAt(0);
				t2 = (int) s2.charAt(0);
				t3 = t1 ^ t2;
				Coding = Coding + String.valueOf((char) t3);
			}
			return Coding;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将字符串进行加密和解密（采用和某个字符串进行异或）
	 * 
	 * @param str
	 * @return
	 */
	public static String returnXORString(String str, String XORString) {
		int l, m, t1, t2, t3;
		String strKey = XORString;
		String s1, s2, Coding;
		try {
			Coding = "";
			m = str.length();
			l = strKey.length();
			for (int i = 0; i < m; i++) {
				s1 = str.substring(i, i + 1);
				s2 = strKey.substring(i % l, (i % l) + 1);
				t1 = (int) s1.charAt(0);
				t2 = (int) s2.charAt(0);
				t3 = t1 ^ t2;
				Coding = Coding + String.valueOf((char) t3);
			}
			return Coding;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 判断是否为日期型
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static boolean isDate(int year, int month, int day) {
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		// 指定日期/时间解析是否不严格。进行不严格解析时，
		// 解析程序可以使用启发式的方法来解释与此对象的格式不精确匹配的输入。
		// 进行严格解析时，输入必须匹配此对象的格式。
		// lenient - 为 true 时，解析过程是不严格的
		// 严格控制输入 比如2006－02－31，根本没有这一天 ，也会认为时间格式不对
		calendar.setLenient(false);
		try {
			calendar.getTime();
		} catch (IllegalArgumentException iae) {
			return false;
		} finally {
			calendar = null;
		}
		return true;
	}

	// '---此函数用来检验身份证号码的正确性（15位或18位都可以）
	// '---此函数的参数：e为输入要检验的身份证号码，ee返回正确的身份证号码，如果输入的身份证号码不正确，则ee返回空值，Birth返回出生日期
	// '---此函数带有返回值，输入要检验的身份证号码正确，则返回True，否则返回False
	// 返回：＝0表示 正确
	// ＝1表示 身份证号码不是15位或18位
	// ＝2表示 身份证除最后一位外，必须为数字！
	// ＝3表示 身份证的出生日期不正确
	// ＝4表示 身份证号码输入错误
	public static int checkCardID(String e) {
		String arrVerifyCode[];
		String wi[];
		// String checker[];
		String str;
		String ai = null;
		// '---身份证的校验码（要记住，不能写错）
		str = "1,0,X,9,8,7,6,5,4,3,2";
		arrVerifyCode = str.split(",");
		str = "7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2";
		wi = str.split(",");
		str = "1,9,8,7,6,5,4,3,2,1,1";
		// checker = str.split(",");
		e = e.trim();
		// '---判断身份证号码的长度为15位或18位
		if ((e.length() < 15) || (e.length() == 16) || (e.length() == 17)
				|| (e.length() > 18)) {
			return 1;
		}
		if (18 == e.length()) {
			ai = e.substring(0, 17);
		} else if (15 == e.length()) {
			ai = e;
			ai = ai.substring(0, 6) + "19" + ai.substring(6, 15);
		}

		// '---判断身份证除最后一位外，必须为数字
		if (!isNumberic(ai)) {
			// MsgBox "身份证除最后一位外，必须为数字！"
			return 2;
		}

		int strYear;
		int strMonth;
		int strDay;
		strYear = Integer.parseInt(ai.substring(6, 10));
		strMonth = Integer.parseInt(ai.substring(10, 12));
		strDay = Integer.parseInt(ai.substring(12, 14));
		if (!isDate(strYear, strMonth, strDay)) {
			return 3;
		}
		int totalmulAiWi = 0;
		for (int i = 0; i <= 16; i++) {
			totalmulAiWi = totalmulAiWi
					+ Integer.parseInt(ai.substring(i, i + 1))
					* Integer.parseInt(wi[i]);
		}
		int modValue;
		modValue = totalmulAiWi % 11;
		String strVerifyCode;
		strVerifyCode = arrVerifyCode[modValue];
		ai = ai + strVerifyCode;
		if ((18 == e.length()) && (!e.equals(ai))) {
			// MsgBox "身份证号码输入错误！"
			return 4;
		}
		return 0;
	}

	// '---此函数用来检验身份证号码的正确性并返回出生日期（15位或18位都可以）
	// '---此函数的参数：e为输入要检验的身份证号码，ee返回正确的身份证号码，如果输入的身份证号码不正确，则ee返回空值，Birth返回出生日期
	// '---此函数带有返回值，输入要检验的身份证号码正确，则返回True，否则返回False
	public static String checkCardIDReturnBirth(String e) {
		String arrVerifyCode[];
		String wi[];
		// String checker[];
		String birthDay;
		String str;
		String ai = null;
		// '---身份证的校验码（要记住，不能写错）
		str = "1,0,X,9,8,7,6,5,4,3,2";
		arrVerifyCode = str.split(",");
		str = "7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2";
		wi = str.split(",");
		str = "1,9,8,7,6,5,4,3,2,1,1";
		// checker = str.split(",");
		birthDay = "";
		e = e.trim();
		// '---判断身份证号码的长度为15位或18位
		if ((e.length() < 15) || (e.length() == 16) || (e.length() == 17)
				|| (e.length() > 18)) {
			return "";
		}
		if (18 == e.length()) {
			ai = e.substring(0, 17);
		} else if (15 == e.length()) {
			ai = e;
			ai = ai.substring(0, 6) + "19" + ai.substring(6, 15);
		}

		// '---判断身份证除最后一位外，必须为数字
		if (!isNumberic(ai)) {
			// MsgBox "身份证除最后一位外，必须为数字！"
			return "";
		}

		int strYear;
		int strMonth;
		int strDay;
		strYear = Integer.parseInt(ai.substring(6, 10));
		strMonth = Integer.parseInt(ai.substring(10, 12));
		strDay = Integer.parseInt(ai.substring(12, 14));
		birthDay = strYear + "-" + strMonth + "-" + strDay;
		if (!isDate(strYear, strMonth, strDay)) {
			return "";
		}
		int totalmulAiWi = 0;
		for (int i = 0; i <= 16; i++) {
			totalmulAiWi = totalmulAiWi
					+ Integer.parseInt(ai.substring(i, i + 1))
					* Integer.parseInt(wi[i]);
		}
		int modValue;
		modValue = totalmulAiWi % 11;
		String strVerifyCode;
		strVerifyCode = arrVerifyCode[modValue];
		ai = ai + strVerifyCode;
		if ((18 == e.length()) && (!e.equals(ai))) {
			// MsgBox "身份证号码输入错误！"
			return "";
		}
		return birthDay;
	}

	// '---此函数用来检验身份证号码的正确性并返回18身份证（15位或18位都可以）
	// '---此函数的参数：e为输入要检验的身份证号码，ee返回正确的身份证号码，如果输入的身份证号码不正确，则ee返回空值，Birth返回出生日期
	// '---此函数带有返回值，输入要检验的身份证号码正确，则返回True，否则返回False
	public static String checkCardIDReturn18Bit(String e) {
		String ee;
		String arrVerifyCode[];
		String wi[];
		// String checker[];
		String str;
		String ai = null;
		// '---身份证的校验码（要记住，不能写错）
		str = "1,0,X,9,8,7,6,5,4,3,2";
		arrVerifyCode = str.split(",");
		str = "7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2";
		wi = str.split(",");
		str = "1,9,8,7,6,5,4,3,2,1,1";
		// checker = str.split(",");
		ee = "";
		e = e.trim();
		// '---判断身份证号码的长度为15位或18位
		if ((e.length() < 15) || (e.length() == 16) || (e.length() == 17)
				|| (e.length() > 18)) {
			return "";
		}
		if (18 == e.length()) {
			ai = e.substring(0, 17);
		} else if (15 == e.length()) {
			ai = e;
			ai = ai.substring(0, 6) + "19" + ai.substring(6, 15);
		}

		// '---判断身份证除最后一位外，必须为数字
		if (!isNumberic(ai)) {
			// MsgBox "身份证除最后一位外，必须为数字！"
			return "";
		}

		int strYear;
		int strMonth;
		int strDay;
		strYear = Integer.parseInt(ai.substring(6, 10));
		strMonth = Integer.parseInt(ai.substring(10, 12));
		strDay = Integer.parseInt(ai.substring(12, 14));
		if (!isDate(strYear, strMonth, strDay)) {
			return "";
		}
		int totalmulAiWi = 0;
		for (int i = 0; i <= 16; i++) {
			totalmulAiWi = totalmulAiWi
					+ Integer.parseInt(ai.substring(i, i + 1))
					* Integer.parseInt(wi[i]);
		}
		int modValue;
		modValue = totalmulAiWi % 11;
		String strVerifyCode;
		strVerifyCode = arrVerifyCode[modValue];
		ai = ai + strVerifyCode;
		if ((18 == e.length()) && (!e.equals(ai))) {
			// MsgBox "身份证号码输入错误！"
			return "";
		}
		ee = ai;
		return ee;
	}

	/**
	 * 判断字符串是否是整型或长整型
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isIntegerOrLong(String str) {
		boolean flag = true;
		int cu = 0;
		for (int i = 0; i < str.length(); i++) {
			cu = (int) str.charAt(i);
			if ((cu < 48) || (cu > 57)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * 判断电子邮件的格式
	 * 
	 * @param strEmail
	 * @return
	 */
	public static boolean isEmail(String strEmail) {
		Pattern pattern = Pattern.compile(".+@.+\\..+");
		Matcher matcher = pattern.matcher(strEmail);
		return matcher.matches();
	}

	/**
	 * 判断是否是数值型（方法1）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumberic(String str) {
		Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 判断是否是数值型（方法2）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumberic1(String str) {
		boolean flag = true;
		try {
			Float.parseFloat(str);
		} catch (NumberFormatException nfx) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 判断是否是数值型（方法2）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		boolean flag = true;
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfx) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 判断两个日期之间相差多少天
	 * 
	 * @param date1
	 *            开始日期
	 * @param date2
	 *            结束日期
	 * @return
	 */
	public static int getDateDiff(Date date1, Date date2) {
		int i = (int) ((date2.getTime() - date1.getTime()) / 3600 / 24 / 1000);
		return i;
	}

	/**
	 * 根据年月返回该月的最后一天
	 * 
	 * @param strDate
	 *            巜日期格式(yyyy-MM-dd)
	 * @return int 该月的最后一天(d)
	 */
	public static int getLastDay(Date strDate) {
		int year = java.lang.Integer.parseInt(f2.format(strDate));
		int month = java.lang.Integer.parseInt(f3.format(strDate));
		int day = 1;
		// 得到当前日期，输出
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
		// 考虑到给定的时间值和
		// getFirstDayOfWeek、getMinimalDaysInFirstWeek、getGregorianChange 和
		// getTimeZone 方法的当前值，
		// 返回此日历字段可能具有的最大值。
		// 例如，如果此实例的日期是 2004 年 2 月 1 日，则 DAY_OF_MONTH 字段的实际最大值是 29，
		// 因为 2004 年是闰年；如果此实例的日期是 2005 年 2 月 1 日，则最大值是 28。
		int maxDay = gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		return maxDay;
	}

	/**
	 * 根据年月日 返回星期几
	 * 
	 * @param y
	 * @param m
	 * @param d
	 * @return 星期 数字 =0星期一，=1星期二，...，6星期日
	 */
	public static int returnWeek(int y, int m, int d) {
		int a = 7;
		if ((m == 1) || (m == 2)) {
			m += 12;
			y--;
		}
		a = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
		return a;
	}

	/**
	 * 返回特定数值在一个数据集中的百分比排位
	 * 
	 * @param al
	 *            为定义相对位置的数组或数字区域
	 * @param currI
	 *            为数组中需要得到其排位的值
	 * @param youXiaoWeiShuo
	 *            小数点后的有效位数
	 * @return 表示返回的百分数值的有效位数。
	 */
	public static String Percentrank(ArrayList<Float> al, float currI,
			int youXiaoWeiShuo) {
		// 先将集合进行排序
		Collections.sort(al);
		int index = al.indexOf(currI);
		if (index == -1) {
			// 该元素在集合中不存在
			int i = 0, j = 0, k = 0;
			for (int m = 0; m < al.size(); m++) {
				if (al.get(m) > currI) {
					i = m - 1;
					j = m;
					break;
				}
			}
			if (i == -1) {
				return "0";
			}
			k = al.size() - i - 1;
			float k1 = i / (float) (i + k);
			k = al.size() - j - 1;
			float k2 = j / (float) (j + k);
			float r = k1 + (k2 - k1) * (currI - al.get(i))
					/ (float) ((al.get(j) - al.get(i)));
			String s = Float.toString(r);
			if (s.indexOf(".") == -1) {
				return "0";
			}
			if (s.substring(s.indexOf("."), s.length()).length() > youXiaoWeiShuo) {
				s = s.substring(0, s.indexOf(".") + (youXiaoWeiShuo + 1));
			}
			return s;
		} else if (index == 0) {
			return "0";
		} else {
			// 该元素在集合中存在,计算比它小的个数，比它大的个数
			int i = index;
			int j = al.size() - index - 1;
			float k = i / (float) (i + j);
			String s = Float.toString(k);
			if (s.substring(s.indexOf("."), s.length()).length() > youXiaoWeiShuo) {
				s = s.substring(0, s.indexOf(".") + (youXiaoWeiShuo + 1));
			}
			return s;
		}
	}

	/**
	 * 调用服务器时间
	 * 
	 * @return
	 */
	public static Date getServerTime() {
		Date tempD = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		String sql = "{call getServerTime()}";
		try {
			conn = DBManager.getConnection();
			// 调用mysql数据库的存储过程
			stm = conn.prepareCall(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				tempD = rs.getTimestamp("serverTime");
				try {
					tempD = f1.parse(f1.format(tempD));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tempD;
	}

	/**
	 * 判断移动手机号是否有效
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static boolean checkPhoneNum(String phoneNum) {
		Pattern p = Pattern.compile("^(13[4-9]|15(8|9))\\d{8}$");// 手机号码的正则表达式
		Matcher mm = p.matcher(phoneNum);
		return mm.matches();
	}

	/**
	 * 判断手机号是否正确
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static boolean IsChinaMobileNumber(String phoneNum) {
		Pattern p1 = Pattern
				.compile("^((\\(\\d{3}\\))|(\\d{3}\\-))?13[0-9]\\d{8}|15[89]\\d{8}");// 所有手机号码的正则表达式
		Matcher m1 = p1.matcher(phoneNum);
		if (m1.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 主函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = returnXORString("123456");
		System.out.println(s);
		s = returnXORString(s);
		System.out.println(s);

	}
}
