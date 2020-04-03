package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

public class GetData {

	private static HSSFWorkbook excelWBook;// Excel WorkBook
	private static HSSFSheet excelWSheet;// Excel Sheet
	private static HSSFCell cell;// Excel cell
	public static int rowNumb;// Row Number
	public static int colNumb;// Column Number
	public static FileInputStream fi;
	public static FileOutputStream fo;
	
	
//This method gets excel file, row and column number.
	public static String getCellData(int rowNum, int colNum) throws Exception {
		try {
			fi = new FileInputStream("User_data.xls");
			excelWBook = new HSSFWorkbook(fi);
			excelWSheet = excelWBook.getSheetAt(0);
			cell = excelWSheet.getRow(rowNum).getCell(colNum);

			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}

//This method gets excel file, row and column number and sets a value to a cell.
	public static void setCellData(String value, int rowNum, int colNum) {

		excelWSheet = excelWBook.getSheetAt(0);
		Row row = excelWSheet.getRow(rowNum);
		Cell cell = row.createCell(colNum);
		cell.setCellValue(value);

		try {
			FileOutputStream fo = new FileOutputStream("User_data.xls");
			excelWBook.write(fo);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//This method gets excel file, row and column number and sets a new value to a email cell.
	public static void newCellData(int n) throws Exception {
		if (n==0) {
		try {
			for (int i = 1; i < 31; i++) {
				fi = new FileInputStream("User_data.xls");
				excelWBook = new HSSFWorkbook(fi);
				excelWSheet = excelWBook.getSheetAt(0);
				cell = excelWSheet.getRow(i).getCell(0);
				StringBuilder sb = new StringBuilder();
				sb = sb.append(RandomStringUtils.randomAlphabetic(1)).append(cell);
				cell.setCellValue(sb.toString());
				FileOutputStream fo = new FileOutputStream("User_data.xls");
				excelWBook.write(fo);
			}

		} catch (Exception e) {
			throw (e);
		}
		}
	}  
	//This method gives a choice to keep or rewrite data from email column
	public static int rewriteData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("For rewriting data press 0, for keeping tested data press 1.");
		int i = sc.nextInt();
		if (i == 0) {
			System.out.println("New data will be ready in a moment.");
			return i;
		} else if (i == 1) {
			System.out.println("Data will not be rewritten");
		} else
			System.out.println("Wrong input, data will not be rewritten");
		return i;
	}

}