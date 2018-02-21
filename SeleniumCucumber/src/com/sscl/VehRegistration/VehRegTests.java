package com.sscl.VehRegistration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.read.biff.BiffException;
import main.ExcelReader;

public class VehRegTests {
	// In order to pass data between implementation scenario, I have created Vehicle  class.
	ArrayList<Vehicle> veh = new ArrayList<Vehicle>();
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");		// Implementation for customised logs

	@Given("I retrieve list of VRNs from excel sheet")
	public void I_retrieve_list_of_VRNs_from_excel_sheet() throws BiffException, IOException {
		log.info("I retrieve list of VRNs from excel sheet");
		
		String path = System.getProperty("user.dir") + "\\src\\Resources\\Config.Properties";
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(path);
		config.load(fis);

		String vrFile = config.getProperty("VehRegFile");
		// System.out.println(vrFile);
		String sheetName = config.getProperty("sheetName");
		// System.out.println(sheetName);
		ExcelReader DT = new ExcelReader();
		// int rows = DT.returnRowCount(vrFile, sheetName);

		String vrn = "";
		String make = "";
		String color = "";

		for (int j = 1; j < 3; j++) {
			vrn = DT.returnCellData(vrFile, sheetName, j, 0);
			color = DT.returnCellData(vrFile, sheetName, j, 1);
			make = DT.returnCellData(vrFile, sheetName, j, 2);
			veh.add(new Vehicle(vrn, make, color));
		}
	}

	@And("I open DVLA site from internet")
	public void I_open_DVLA_site_from_internet() throws IOException {
		log.info("I open DVLA site from internet");
		// Log4j logger implementation pending
		
		String path = System.getProperty("user.dir") + "\\src\\Resources\\ObjectRepository.Properties";
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(path);
		config.load(fis);
		
		if (config.getProperty("browser").equals("firefox")){
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Tutorials\\IDE2E\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I search VRN on DVLA")
	public void I_search_VRN_on_DVLA() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\Resources\\ObjectRepository.Properties";
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(path);
		config.load(fis);
		
		if (veh.size() > 0) {
			System.out.println("size:" + veh.size());
			for (int i = 0; i < veh.size(); i++) {
				//System.out.println("\n-----");
				//System.out.print(veh.get(i).VRN + "\t");
				//System.out.print(veh.get(i).Make + "\t");
				//System.out.print(veh.get(i).Colour);
				
				driver.findElement(By.xpath(config.getProperty("btnStartNow"))).click();
				driver.findElement(By.xpath(config.getProperty("txtVRN"))).sendKeys(veh.get(i).VRN);
				driver.findElement(By.xpath(config.getProperty("btnContinue"))).click();
				
				//verify the make and colour
				WebElement makeFound = driver.findElement(By.xpath(config.getProperty("spanMake")));
				System.out.println(makeFound.getText());
				WebElement colourFound = driver.findElement(By.xpath(config.getProperty("spanColour")));
				System.out.println(colourFound.getText());
				
				Assert.assertEquals(veh.get(i).Make, makeFound.getText());
				Assert.assertEquals(veh.get(i).Colour, colourFound.getText());
				
				if (veh.get(i).Make == makeFound.getText() && veh.get(i).Colour ==colourFound.getText()) {
					System.out.println("Vehicle details found correctly.");
				} else {
					// to do: Capture Screenshot
				}
						
				// Go back the start page where search Vehicle details for next set of VRN will start
				driver.navigate().back();
				driver.navigate().back();
			}
		}
	}

	@Then("I get Make and Colour of entered VRN")
	public void I_get_Make_and_Colour_of_entered_VRN() {
		// Always release the memory
		if (driver != null) {
			driver.quit();
		}
	}
}
