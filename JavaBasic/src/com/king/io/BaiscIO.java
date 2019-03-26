package com.king.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/*
  https://www.cnblogs.com/whgk/p/5326568.html
  IO流
	·Java流式输入/输出原理
	·Java流类的分类
	·输入/输出流类
	·常见的节点流和处理流
	·文件流
	·缓冲流
	·转换流
	·数据流
	·Print流
	·Object流
流的分类
    java.io包中
        ·按数据流的方向不同可以分为输入流、输出流
        ·按处理数据单位不同可以分为字节流、字符流
        ·按照功能不同可以分为节点流、处理流
           所有流类型位于包java.io内都分别继承以下四种抽象流类型
            	字节流 		       字符流
    ------------------------------------------
	    输入流          InputStream      Reader
	    输出流          OutputSteam      Writer
输入/输出流
    1、输出流跟输入流
    一切以程序为中心
        ·从文件到程序为输入流
        ·从程序到文件为输出流
    2、字节流和字符流
        ·字节（8bit）
        ·字符（16bit）
        ·一个字符等于2个字节
    3、节点流和处理流
        ·处理流是包在节点流的一层“管道”
常见的节点流和处理流
    ·节点流为可以从一个特定的数据源（节点）读写数据（如：文件，内存）
            节点流
        数据源 -------------------- 程序
    ·处理流是连接在已存在的流（节点流或处理流）之上，通过对数据的处理为程序提供更为强大的读写功能
            -->
        数据源 -------======== 程序
            <--
        程序 ============-------- 数据源
⑤节点流----文件流
    		字符流            字节流
---------------------------------------
输入流    FileReader    FileInputStream
输出流    FileWriter    FileOutputStream


 */
/**
 * @author duanyong
 * 2019年3月25日 下午4:31:10
 */
public class BaiscIO {
	
	public static String filePath="E:\\data.txt";
	
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
//		byteFile();
//		bufferedStream();
//		streamER();
//		lineIO();
		lineIO2();
	}
	
	//InputStream、OutputStream（字节流） 
	public static void byteFile() {
		try {
			//读取文件(字节流)
			InputStream in = new FileInputStream("E:\\data.txt");
			//写入相应的文件
			OutputStream out = new FileOutputStream("E:\\data2.txt");
			//读取数据
			//一次性取多少字节
			byte[] bytes = new byte[2048];
			//接受读取的内容(n就代表的相关数据，只不过是数字的形式)
			int n = -1;
			//循环取出数据
			while ((n = in.read(bytes,0,bytes.length)) != -1) {
			    //转换成字符串
			    String str = new String(bytes,0,n,"GBK"); //这里可以实现字节到字符串的转换，比较实用
			    System.out.println(str);
			    //写入相关文件
			    out.write(bytes, 0, n);
			}
			//关闭流
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//BufferedInputStream、BufferedOutputStream（缓存字节流）使用方式和字节流差不多，但是效率更高（推荐使用）
	public static void bufferedStream() throws UnsupportedEncodingException, IOException {
		//读取文件(缓存字节流)
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\data.txt"));
        //写入相应的文件
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\data21.txt"));
        //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"GBK");
            System.out.println(str);
            //写入相关文件
            out.write(bytes, 0, n);
        }
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
	}

	//InputStreamReader、OutputStreamWriter（字节流，这种方式不建议使用，不能直接字节长度读写）。使用范围用做字符转换
	public static void streamER( ) throws UnsupportedEncodingException, IOException {
		//读取文件(字节流)
        InputStreamReader in = new InputStreamReader(new FileInputStream(filePath),"GBK");
        //写入相应的文件
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\data31.txt"));
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.print((char)len);
            //写入相关文件
            out.write(len);
        }
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
	}

	//BufferedReader、BufferedWriter(缓存流，提供readLine方法读取一行文本)
	public static void lineIO( ) throws UnsupportedEncodingException, IOException {
		//读取文件(字符流)
		//这里主要是涉及中文
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
        //写入相应的文件
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\data41.txt"),"GBK"));
        //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
        //读取数据
        //循环取出数据
        String str = null;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
            //写入相关文件
            out.write(str);
            out.newLine();
        }
        
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
	}
	
	//Reader、PrintWriter（PrintWriter这个很好用，在写数据的同事可以格式化）
	public static void lineIO2( ) throws UnsupportedEncodingException, IOException {
		//读取文件(字节流)
        Reader in = new InputStreamReader(new FileInputStream("E:\\data.txt"),"GBK");
        //写入相应的文件
        PrintWriter out = new PrintWriter(new FileWriter("E:\\data51.txt"));
        //读取数据
        //循环取出数据
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.println((char)len);
            //写入相关文件
            out.write(len);
        }
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
	}
}
