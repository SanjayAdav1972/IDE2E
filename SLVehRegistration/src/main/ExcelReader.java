package main;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
	public String path;
	public int rowCount=0;
	
	public void readExcel(String filePath, String sheetName) throws BiffException, IOException {
		// String FilePath = "D:\\Tutorials\\IDE2E\\SLVehRegistration\\Data\\VR.xls";
		path = filePath;
		FileInputStream fs = new FileInputStream(path);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet(sheetName);

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 1; row < totalNoOfRows; row++) {
			for (int col = 0; col < totalNoOfCols; col++) {
				System.out.print(sh.getCell(col, row).getContents() + "\n");
			}
			System.out.println();
		}
	}

	public int returnRowCount(String filePath, String sheetName) throws BiffException, IOException {
		path = filePath;
		FileInputStream fs = new FileInputStream(path);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet(sheetName);

		// To get the number of rows present in sheet
		this.rowCount = sh.getRows();
		return rowCount;
	}
	
	/*
	 * Function: returnCellData
	 * Input Parameters: filePath, sheetName, rowNo (Row number), columnNo (Column Number)
	 * Return Type: Cell Data 
	 * 
	 * 
	 */
	public String returnCellData(String filePath, String sheetName, int rowNo, int columnNo) throws BiffException, IOException {
		path = filePath;
		FileInputStream fs = new FileInputStream(path);
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet(sheetName);

		// To get the number of rows present in sheet
		rowCount = sh.getRows();
		String cellData = sh.getCell(columnNo, rowNo).getContents();
		return cellData;
	}

}
