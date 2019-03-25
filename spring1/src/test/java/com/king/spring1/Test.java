package com.king.spring1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duanyong
 * 2019年3月20日 上午9:22:33
 */
public class Test {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add(123l+"");
		list.add(124l+"");
		list.add(125l+"");
		list.add(126l+"");
		list.add(127l+"");

		System.out.println(list.contains(124+""));
		System.out.println(list.indexOf(124+""));
	}
}
