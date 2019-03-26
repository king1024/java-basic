package com.king.spring1.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @author duanyong
 * 2019年3月26日 下午4:40:40
 */
public class ExcelUtils {
	
	public static void main(String[] args) {
		List<List<String>> datas=new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			List<String> temp=new ArrayList<>();
			for (int j = 1; j < 16; j++) {
				temp.add("king"+i+j);
			}
			datas.add(temp);
		}
		System.out.println(datas.size());
		System.out.println(writeFile("D:/king2.xls", "我的测试", "第一个sheet", datas));
	}
	
	public static String writeFile(String pathname,String title,String sheetName,List<List<String>> datas) {
		WritableWorkbook workbook =null;
		FileOutputStream fos=null;
		OutputStream os=null;
		try {
			File file=new File(pathname);
			fos=new FileOutputStream(file);
			os=new BufferedOutputStream(fos);
			workbook = exportFormatExcel(title, sheetName, datas, os);
			if(workbook!=null) {
				workbook.write();
				return pathname;
			} else {
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(workbook!=null) {
					workbook.close();
				}
				if(fos!=null) {
					fos.close();
				}
				if(os!=null) {
					os.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static WritableWorkbook exportFormatExcel(String title,String sheetName,List<List<String>> datas,OutputStream os) {
		WritableWorkbook workbook=null;
		try {
			workbook=Workbook.createWorkbook(os);
			WritableSheet sheet=null;
			if(StringUtils.isEmpty(sheetName)) {
				sheet=workbook.createSheet("sheet1", 0);
			}else {
				sheet=workbook.createSheet(sheetName, 0);
			}
			int n=0;
			if(StringUtils.isEmpty(title)) {
				WritableFont font=new WritableFont(WritableFont.ARIAL,12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
				WritableCellFormat wformat=new WritableCellFormat(font);
				wformat.setAlignment(Alignment.CENTRE);
				Label label=new Label(0, 0, title, wformat);
				sheet.addCell(label);
				sheet.mergeCells(0, 0, datas.get(0).size()-1, 0);
				n++;
			}
			for (int i = 0; i < datas.size(); i++) {
				for (int j = 0; j < datas.get(i).size(); j++) {
					WritableCellFormat wformat=new WritableCellFormat(NumberFormats.TEXT);
					wformat.setAlignment(Alignment.LEFT);
					wformat.setVerticalAlignment(VerticalAlignment.CENTRE);
					Label label=new Label(j, i+n, datas.get(i).get(j), wformat);
					sheet.addCell(label);
				}
			}
			return workbook;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workbook;
	}
}
