package com.king.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author duanyong
 * 2019年3月26日 下午4:13:02
 */
public class MoneyTest {
	public static void main(String[] args) {
		System.out.println(getNum(5, 35)+getNum(2, 12));
		System.out.println(getNum(6, 33)+getNum(1, 16));
	}
	
	public static String getNum(int size,int max) {
		Set<Integer> set=new HashSet<>();
		while(set.size()<size) {
			set.add((int)(Math.random()*max)+1);
		}
		int[] res=new int[size];
		int index=0;
		for (int i : set) {
			res[index++] = i;
		}
		Arrays.sort(res);
		return Arrays.toString(res);
	}
}
