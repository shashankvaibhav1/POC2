package com.tricentis.demowebshop.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	ArrayList<ArrayList> al;
	public ArrayList read_excel(){
		try {
			al = new ArrayList<ArrayList>();
			File f = new File("abc.xlsx");
			FileInputStream fis = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(0);
			for(int i=0; i<sh.getLastRowNum(); i++) {
				ArrayList ex = new ArrayList();
				XSSFRow row = sh.getRow(i+1);
				ex.add(row.getCell(0));
				ex.add(row.getCell(1));
				ex.add(row.getCell(2));
				al.add(ex);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
