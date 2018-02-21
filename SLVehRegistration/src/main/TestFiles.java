package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.MimetypesFileTypeMap;

import jxl.read.biff.BiffException;

public class TestFiles {

	public static void main(String[] args) throws IOException, BiffException {
		String path = System.getProperty("user.dir") + "\\src\\Resources\\Config.Properties";
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(path);
		config.load(fis);

		FilesInformation fi = new FilesInformation();
		File[] listOfFiles = fi.getFilesInfo(config.getProperty("filelocation"));

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File :" + i);
				System.out.println("\tFile name: " + listOfFiles[i].getName());
				System.out.println("\tFile mime type: " + new MimetypesFileTypeMap().getContentType(listOfFiles[i]));
				System.out.println("\tFile size: " + listOfFiles[i].length());
				System.out.println("\tFile extension: " + listOfFiles[i].getAbsolutePath());
			}
		}

		String vrFile = config.getProperty("VehRegFile");
		String sheetName = config.getProperty("sheetName");

		ExcelReader DT = new ExcelReader();
		System.out.println(DT.returnRowCount(vrFile, sheetName));

		for (int j = 1; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				System.out.println(DT.returnCellData(vrFile, sheetName, j, k));
			}
		}
		// DT.readExcel(vrFile, sheetName);
	}
}
