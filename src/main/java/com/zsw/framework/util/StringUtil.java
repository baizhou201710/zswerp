/**
 * @since 2008-10-10,下午04:23:37
 */
package com.zsw.framework.util;

import com.zsw.util.Empty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符处理工具类，定义和实现了对字符进行处理的常用方法。
 * 
 * @author liangw0103@gmail.com
 * @date 2016-1-22 上午10:57:34
 * @description
 */
public class StringUtil {
	private static String IMG_EXT = ".jpg,.JPG,.gif,.GIF,.bmp,.BMP,.jpeg,.JPEG,.png,.PNG,";

	/**
	 * 得到文件扩展名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileExt(String fileName) {
		if (Empty.isEmpty(fileName)) {
			return "";
		}
		return fileName.substring(fileName.lastIndexOf('.'), fileName.length());
	}

	/**
	 * 判断是否为图片类型文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isImgFile(String fileName) {
		return IMG_EXT.indexOf(getFileExt(fileName) + ",") >= 0;
	}

	/**
	 * 从文件全路径中得到文件名
	 * 
	 * @param args
	 */
	public static String getFileName(String path) {
		// /abc/bcd/abc.txt
		if (Empty.isEmpty(path)) {
			return null;
		}
		String s = path.substring(path.lastIndexOf("/") + 1);
		s = path.substring(s.lastIndexOf("\\") + 1);
		return s;
	}

	/**
	 * 把文本转换成html 显示,静态化生成用到
	 * 
	 * @param text
	 * @return
	 */
	public static String toHtmlString(String text) {
		if (Empty.isEmpty(text)) {
			return "";
		}
		String tmp = text;

		String tmpS = null;
		try {
			String regex1 = "\n"; // 回车
			String regex2 = "^\\s"; // 首行为 tab 操作符
			tmpS = tmp.replaceAll(regex1, "<br/>&nbsp;&nbsp;&nbsp;&nbsp;").replaceAll(regex2, "&nbsp;&nbsp;");
		} catch (Exception e) {
			e.printStackTrace();
			tmpS = text;
		}
		return tmpS;
	}

	public static String toHexString(String text) {
		if (text == null) {
			return "";
		}
		StringBuffer buf = new StringBuffer();
		final String start = "\\u";
		for (int i = 0; i < text.length(); i++) {
			int c = text.charAt(i);
			buf.append(start);
			String s = Integer.toHexString(c);

			if (s.length() == 1) {
				s = "000" + s;
			} else if (s.length() == 2) {
				s = "00" + s;
			} else if (s.length() == 3) {
				s = "0" + s;
			}
			buf.append(s);
		}
		return buf.toString();
	}

	/**
	 * 向文件名中追加字符，以修改文件名称
	 * 
	 * @param oldName
	 *            文件原有名称
	 * @param appendString
	 *            追加名称
	 * @return 处理后的文件名
	 */
	public static String appendFileName(String oldName, String appendString) {
		// /abc/bcd/abc.txt
		if (Empty.isEmpty(oldName)) {
			return null;
		}
		String name = oldName.substring(oldName.lastIndexOf("\\") + 1);
		name = name.substring(name.lastIndexOf("/") + 1);
		StringBuffer sb = new StringBuffer();
		sb.append(oldName.substring(0, oldName.lastIndexOf(name)));
		sb.append(name.substring(0, name.lastIndexOf(".")));
		sb.append(appendString);
		sb.append(name.substring(name.lastIndexOf(".")));

		return sb.toString();
	}

	/**
	 * 判断字符串是否在字符数组中
	 * 
	 * @param s
	 *            字符串数组
	 * @param str
	 *            需要比较的字符串
	 * @return 如果存在返回：true,如果不存在返回：false
	 */
	public static boolean contains(String[] s, String str) {
		if (s == null || str == null)
			return false;
		for (int i = 0; i < s.length; i++) {
			if (str.equals(s[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 过滤字符中的HTML标签
	 * 
	 * @param element
	 *            含有HTML标签体的字符串
	 * @return
	 */
	public static String getTxtWithoutHTML(String element) {
		// String reg="<[^<|^>]+>";
		// return element.replaceAll(reg,"");

		if (null == element || "".equals(element.trim())) {
			return element;
		}

		Pattern pattern = Pattern.compile("&[a-z]{1,10}+;|<[^<|^>]*>");

		Matcher matcher = pattern.matcher(element);
		StringBuffer txt = new StringBuffer();

		// 替换字符中HTML标签和特殊符号

		while (matcher.find()) {
			String group = matcher.group();

			if (group.matches("<[\\s]*>")) {
				matcher.appendReplacement(txt, group);
			} else if (group.matches("&nbsp;")) {
				matcher.appendReplacement(txt, " ");
			} else if (group.matches("&amp;")) {
				matcher.appendReplacement(txt, "&");
			} else if (group.matches("&lt;")) {
				matcher.appendReplacement(txt, "<");
			} else if (group.matches("&gt;")) {
				matcher.appendReplacement(txt, ">");
			} else if (group.matches("&quot;")) {
				matcher.appendReplacement(txt, "\"");
			} else if (group.matches("&apos;")) {
				matcher.appendReplacement(txt, "\'");
			} else {
				matcher.appendReplacement(txt, "");
			}

		}

		// 加裁最后字符

		matcher.appendTail(txt);
		/*
		 * txt.repaceEntities(txt,"&","&"); repaceEntities(txt,"<","<");
		 * repaceEntities(txt,">",">"); repaceEntities(txt,""","\"");
		 * repaceEntities(txt," ","");
		 */

		return txt.toString();

	}

	/**
	 * 过滤字符中的HTML标签
	 * 
	 * @param element
	 *            含有HTML标签体的字符串
	 * @param length
	 *            返回过滤后字符长度
	 * @return 返回过虑后的字符串
	 */
	public static String getTxtWithoutHTML(String element, int length) {
		/*
		 * if (null == element || "".equals(element.trim())) { return element; }
		 * String reg="<[^<|^>]+>"; return
		 * element.replaceAll(reg,"").substring(0, element.length() > length ?
		 * length : element.length());
		 */

		if (null == element || "".equals(element.trim())) {
			return element;
		}

		Pattern pattern = Pattern.compile("&[a-z]{1,10}+;|<[^<|^>|[^\\x00-\\xff]]*>");
		Matcher matcher = pattern.matcher(element);
		StringBuffer txt = new StringBuffer();
		// 替换字符中HTML标签和特殊符号
		while (matcher.find() && length > txt.length()) {
			String group = matcher.group();
			if (group.matches("&nbsp;")) {
				matcher.appendReplacement(txt, " ");
			} else if (group.matches("&amp;")) {
				matcher.appendReplacement(txt, "&");
			} else if (group.matches("&lt;")) {
				matcher.appendReplacement(txt, "<");
			} else if (group.matches("&gt;")) {
				matcher.appendReplacement(txt, ">");
			} else if (group.matches("&quot;")) {
				matcher.appendReplacement(txt, "\"");
			} else if (group.matches("&apos;")) {
				matcher.appendReplacement(txt, "\'");
			} else if (group.matches("<br />")) {
				matcher.appendReplacement(txt, "");
			} else {
				matcher.appendReplacement(txt, "");
			}
		}
		// 加裁最后字符
		if (length > txt.length())
			matcher.appendTail(txt);

		return txt.toString().substring(0, txt.length() > length ? length : txt.length());
	}

	/**
	 * 截取字符长度。
	 * 
	 * @param longStr
	 * @param max
	 * @return
	 */
	public static String getShortString(String longStr, int max) {
		String returnStr = longStr;
		if (longStr != null && !"".equals(longStr)) {
			int length = longStr.length();
			if (length > max) {
				returnStr = longStr.substring(0, max) + "......";
			}
		}
		return returnStr;
	}

	/**
	 * 
	 * @param context
	 * @param path
	 * @param fileMap
	 * @return
	 */
	public static String filterIMG(String context, String path, Map<String, ?> fileMap) {
		Pattern pattern = Pattern.compile("<IMG style[^<|^>|[^\\x00-\\xff]]*>");
		String imgString = "";
		Matcher matcher = pattern.matcher(context);
		StringBuffer txt = new StringBuffer();
		String temp = null;
		String group = null;
		while (matcher.find()) {
			group = matcher.group();
			temp = group;
			Set<String> set = fileMap.keySet();
			for (java.util.Iterator<String> it = set.iterator(); it.hasNext();) {
				String oldName = it.next();
				if (group.indexOf(oldName + "');") != -1) {
					imgString = "src='" + path + fileMap.get(oldName) + "\'";
					temp = group.replaceFirst("FILTER:[^<|^>|[^\\x00-\\xff]]*'\\);", "");
					temp = temp.replaceFirst("src=\"[^<|^>|^']*editor/none.gif\"", imgString);
					// System.out.println(temp);

				}
			}
			matcher.appendReplacement(txt, temp);
		}
		matcher.appendTail(txt);
		return txt.toString();
	}

	/**
	 * 将集合中的String 拼接成字符串
	 * 
	 * @param col
	 * @param fitex
	 * @return
	 */
	public static String join(Collection<String> col, String fitex) {
		Iterator<String> it = col.iterator();
		StringBuffer str = new StringBuffer();
		while (it.hasNext()) {
			str.append(it.next()).append(fitex);
		}
		String target = str.toString();
		target = target.substring(0, target.lastIndexOf(fitex));
		return target;
	}

	/**
	 * 半角转全角，暂时只对普通的标点符号半角转全角
	 * 
	 * @param input
	 * @return
	 */
	public static String toNSBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++)
			if (",\"'<>《》".indexOf(c[i]) != -1) {
				if (c[i] == ' ') {
					c[i] = '\u3000';
				} else if (c[i] < '\177') {
					c[i] = (char) (c[i] + 65248);
				}
			}

		return new String(c);
	}

	/**
	 * 全角转半角
	 * 
	 * @param input
	 * @return
	 */
	public static String toDBC(String input) {
		char c[] = input.toCharArray();
		for (int i = 0; i < c.length; i++)
			if (c[i] == '\u3000')
				c[i] = ' ';
			else if (c[i] > '\uFF00' && c[i] < '\uFF5F')
				c[i] = (char) (c[i] - 65248);

		return new String(c);
	}

	/**
	 * 判断字段集合中是否包含某字符串的前缀
	 * 
	 * @param l
	 * @param str
	 * @return
	 */
	public static boolean startsWith(List<String> l, String str) {
		if (l == null || str == null)
			return false;
		for (String s : l) {
			if (str.startsWith(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串中是否包含某个字符或字符组。
	 * 
	 * @param str
	 *            判断的字符串
	 * @param patternS
	 *            判断的表示式，如（<|&|>）表示包括 "<"或者">"或者"&"中任意一个。
	 * @return
	 */
	public static boolean hasStr(String str, String patternS) {
		if(str == null){
			return false;
		}
		Pattern pattern = Pattern.compile(patternS);
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	/**
     * Check whether the given String has actual text.
     * More specifically, returns <code>true</code> if the string not <code>null</code>,
     * its length is greater than 0, and it contains at least one non-whitespace character.
     * <p/>
     * <code>StringUtils.hasText(null) == false<br/>
     * StringUtils.hasText("") == false<br/>
     * StringUtils.hasText(" ") == false<br/>
     * StringUtils.hasText("12345") == true<br/>
     * StringUtils.hasText(" 12345 ") == true</code>
     * <p/>
     * <p>Copied from the Spring Framework while retaining all license, copyright and author information.
     *
     * @param str the String to check (may be <code>null</code>)
     * @return <code>true</code> if the String is not <code>null</code>, its length is
     *         greater than 0, and it does not contain whitespace only
     * @see java.lang.Character#isWhitespace
     */
    public static boolean hasText(String str) {
        if (Empty.isEmpty(str)) {
            return false;
        }
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * 根据map键值对,替换string中的{key}占位符
     * @param str
     * @param map
     * @return
     */
    public static String format(String str, Map<String, Object> map){
    	Set<String> keySet = map.keySet();
    	for(String key : keySet){
    		str = str.replaceAll("\\{"+key+"}", (String)map.get(key));
    	}
    	return str;
    }

	
	public static void  main(String[] args){
//		String s = "a/../../adds.txt";
//		System.out.println(s.indexOf(".."));
		String str = "asa{aaa}dasda{aaa}";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaa", "bbb");
		System.out.println(StringUtil.format(str, map));
	}

}
