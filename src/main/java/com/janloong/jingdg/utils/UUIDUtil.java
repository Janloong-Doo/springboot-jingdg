package com.janloong.jingdg.utils;

import java.util.UUID;

/**
 * @author sam
 * 
 * @version v0.1
 * 
 * Created on 2013-06-24
 * 
 * Revision History:
 * Date   		Reviser		Description
 * ----   		-------   	----------------------------------------------------
 * 
 * Description:为数据库获取一个唯一的主键id的代码
 */
public class UUIDUtil {

	/**
	 * Description:获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * Description:获得指定数目的UUID
	 * 
	 * @param piNumber 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int piNumber) {
		if (piNumber < 1) {
			return null;
		}
		String[] ss = new String[piNumber];
		for (int i = 0; i < piNumber; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}

	public static void main(String[] args) {
		String[] ss = getUUID(1);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i].length());
		}
	}
}
