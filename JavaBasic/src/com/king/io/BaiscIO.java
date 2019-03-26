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
  IO��
	��Java��ʽ����/���ԭ��
	��Java����ķ���
	������/�������
	�������Ľڵ����ʹ�����
	���ļ���
	��������
	��ת����
	��������
	��Print��
	��Object��
���ķ���
    java.io����
        �����������ķ���ͬ���Է�Ϊ�������������
        �����������ݵ�λ��ͬ���Է�Ϊ�ֽ������ַ���
        �����չ��ܲ�ͬ���Է�Ϊ�ڵ�����������
           ����������λ�ڰ�java.io�ڶ��ֱ�̳��������ֳ���������
            	�ֽ��� 		       �ַ���
    ------------------------------------------
	    ������          InputStream      Reader
	    �����          OutputSteam      Writer
����/�����
    1���������������
    һ���Գ���Ϊ����
        �����ļ�������Ϊ������
        ���ӳ����ļ�Ϊ�����
    2���ֽ������ַ���
        ���ֽڣ�8bit��
        ���ַ���16bit��
        ��һ���ַ�����2���ֽ�
    3���ڵ����ʹ�����
        ���������ǰ��ڽڵ�����һ�㡰�ܵ���
�����Ľڵ����ʹ�����
    ���ڵ���Ϊ���Դ�һ���ض�������Դ���ڵ㣩��д���ݣ��磺�ļ����ڴ棩
            �ڵ���
        ����Դ -------------------- ����
    �����������������Ѵ��ڵ������ڵ�����������֮�ϣ�ͨ�������ݵĴ���Ϊ�����ṩ��Ϊǿ��Ķ�д����
            -->
        ����Դ -------======== ����
            <--
        ���� ============-------- ����Դ
�ݽڵ���----�ļ���
    		�ַ���            �ֽ���
---------------------------------------
������    FileReader    FileInputStream
�����    FileWriter    FileOutputStream


 */
/**
 * @author duanyong
 * 2019��3��25�� ����4:31:10
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
	
	//InputStream��OutputStream���ֽ����� 
	public static void byteFile() {
		try {
			//��ȡ�ļ�(�ֽ���)
			InputStream in = new FileInputStream("E:\\data.txt");
			//д����Ӧ���ļ�
			OutputStream out = new FileOutputStream("E:\\data2.txt");
			//��ȡ����
			//һ����ȡ�����ֽ�
			byte[] bytes = new byte[2048];
			//���ܶ�ȡ������(n�ʹ����������ݣ�ֻ���������ֵ���ʽ)
			int n = -1;
			//ѭ��ȡ������
			while ((n = in.read(bytes,0,bytes.length)) != -1) {
			    //ת�����ַ���
			    String str = new String(bytes,0,n,"GBK"); //�������ʵ���ֽڵ��ַ�����ת�����Ƚ�ʵ��
			    System.out.println(str);
			    //д������ļ�
			    out.write(bytes, 0, n);
			}
			//�ر���
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
	
	//BufferedInputStream��BufferedOutputStream�������ֽ�����ʹ�÷�ʽ���ֽ�����࣬����Ч�ʸ��ߣ��Ƽ�ʹ�ã�
	public static void bufferedStream() throws UnsupportedEncodingException, IOException {
		//��ȡ�ļ�(�����ֽ���)
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\data.txt"));
        //д����Ӧ���ļ�
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\data21.txt"));
        //��ȡ����
        //һ����ȡ�����ֽ�
        byte[] bytes = new byte[2048];
        //���ܶ�ȡ������(n�ʹ����������ݣ�ֻ���������ֵ���ʽ)
        int n = -1;
        //ѭ��ȡ������
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //ת�����ַ���
            String str = new String(bytes,0,n,"GBK");
            System.out.println(str);
            //д������ļ�
            out.write(bytes, 0, n);
        }
        //�������
        out.flush();
        //�ر���
        in.close();
        out.close();
	}

	//InputStreamReader��OutputStreamWriter���ֽ��������ַ�ʽ������ʹ�ã�����ֱ���ֽڳ��ȶ�д����ʹ�÷�Χ�����ַ�ת��
	public static void streamER( ) throws UnsupportedEncodingException, IOException {
		//��ȡ�ļ�(�ֽ���)
        InputStreamReader in = new InputStreamReader(new FileInputStream(filePath),"GBK");
        //д����Ӧ���ļ�
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("E:\\data31.txt"));
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.print((char)len);
            //д������ļ�
            out.write(len);
        }
        //�������
        out.flush();
        //�ر���
        in.close();
        out.close();
	}

	//BufferedReader��BufferedWriter(���������ṩreadLine������ȡһ���ı�)
	public static void lineIO( ) throws UnsupportedEncodingException, IOException {
		//��ȡ�ļ�(�ַ���)
		//������Ҫ���漰����
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
        //д����Ӧ���ļ�
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\data41.txt"),"GBK"));
        //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))��
        //��ȡ����
        //ѭ��ȡ������
        String str = null;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
            //д������ļ�
            out.write(str);
            out.newLine();
        }
        
        //�������
        out.flush();
        //�ر���
        in.close();
        out.close();
	}
	
	//Reader��PrintWriter��PrintWriter����ܺ��ã���д���ݵ�ͬ�¿��Ը�ʽ����
	public static void lineIO2( ) throws UnsupportedEncodingException, IOException {
		//��ȡ�ļ�(�ֽ���)
        Reader in = new InputStreamReader(new FileInputStream("E:\\data.txt"),"GBK");
        //д����Ӧ���ļ�
        PrintWriter out = new PrintWriter(new FileWriter("E:\\data51.txt"));
        //��ȡ����
        //ѭ��ȡ������
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.println((char)len);
            //д������ļ�
            out.write(len);
        }
        //�������
        out.flush();
        //�ر���
        in.close();
        out.close();
	}
}
