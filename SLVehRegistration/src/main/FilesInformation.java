package main;
import java.io.File;

public class FilesInformation {
	
	/*
	 * Function: getFilesInfo
	 * I/P Parameter: Folder location to start searching file
	 * O/P Parameter: List of exists
	 */
	public File[] getFilesInfo(String filePath) {
		//String filePath = System.getProperty("user.dir") + "\\Data";
		//System.out.println(filePath);
		
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();

		return listOfFiles;
	}
}
