package com.king.test;

import java.util.Arrays;

/**
 * @author duanyong
 * 2019年3月25日 下午4:10:10
 */
public class Test {
	
	public static void main(String[] args) {
		int[] a=new int[5];
		a[0]=4;
		a[2]=8;
		StringBuffer b=new StringBuffer("aaaaaaaaaaaaaa");
		System.out.println(Arrays.toString(a));
		transform(a,b);
		System.out.println(Arrays.toString(a));
		System.out.println(b);
		
	}
	
	public static void transform(int[] a,StringBuffer b) {
		a[4]=66;
		b.append("bbbbbbbbbb");
	}
}
