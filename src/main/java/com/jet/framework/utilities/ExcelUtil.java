package com.jet.framework.utilities;


import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.jet.framework.connections.ConfigReader;
import com.jet.framework.connections.Settings;

import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtil {
	
	private static String strFilePath;
	private static List<LinkedHashMap<String,String>> SheetData ;	
	private static List<String> rowheader;


	
		
	public ExcelUtil(String path) throws EncryptedDocumentException, IOException {
		strFilePath=path;
		SheetData =new ArrayList<LinkedHashMap<String,String>>();
		
		ExcelUtil.ReadExcel();
	}


	public static List<LinkedHashMap<String,String>> ReadExcel() throws EncryptedDocumentException, IOException {

			Workbook wb= WorkbookFactory.create(new File(strFilePath));
			Sheet sheet = wb.getSheetAt(0);
			rowheader=new ArrayList<String>();
			int i=0;				
				
			for(Row row : sheet){
				LinkedHashMap<String,String> rowdata=new LinkedHashMap<String,String>();
				if (i==0){
					for(Cell cell : row){
						String val=readCellValue(cell);
						rowheader.add(val);
					}
					i++;
					continue;
				}
				else {
						
					for (int j=0;j<rowheader.size();j++){
						String val=readCellValue(row.getCell(j));
						//if(val!=null)
						if(rowheader.equals("PhoneNum"))
							val = new BigDecimal(val).toPlainString();
						rowdata.put(rowheader.get(j), val);
					}
					SheetData.add(rowdata);
				}
					
			}
			//System.out.println(SheetData);
			return SheetData;
			
		}
	
		public int getRowCount() {
			return SheetData.size();			
		}
		
		public List<String> getColumns() {
			return rowheader;			
		}
		
		public String getCellValue(int row,String column) {
			return SheetData.get(row).get(column);			
		}
		
		public static LinkedHashMap<String, String> getRowData(int row) {
			return SheetData.get(row);			
		}
		
		public List<LinkedHashMap<String, String>> getSheetData() {
			return SheetData;			
		}
		
		public static String readCellValue(Cell cell){
			
			String val="";
			
			if(cell==null)
				return null;
			
			CellType type = cell.getCellType();
			switch(type){
			case STRING:{
				val=cell.getStringCellValue();
				break;
			}
			
			
			case BLANK:
			{
				val="";
				break;
			}	
				
		
			case NUMERIC :{
				val=cell.getNumericCellValue()+"";
				break;
			}			
	
				
			default :  	{
				System.out.println("Invalid Cell Type");
				break;
				}
			}
				
			return val.trim();
			
		}

		public static void main(String [] args) throws EncryptedDocumentException, IOException {
			ConfigReader.loadConfig();
			ExcelUtil util=new ExcelUtil(Settings.ExcelPath);
			System.out.println(util.getRowCount());
			System.out.println(util.getColumns());
			System.out.println(util.getCellValue(0, "e-mail"));
			System.out.println(util.getCellValue(0, "PhoneNum"));
			
		}
	
}
