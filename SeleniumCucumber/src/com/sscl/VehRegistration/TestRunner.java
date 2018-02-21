package com.sscl.VehRegistration;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:format"}, 
			features = "D:\\Projects\\IDE2E\\SeleniumCucumber\\src\\com\\sscl\\VehRegistration\\VehRegistration.Feature")
			//glue = {"src.com.sscl.VehRegistration/"})
			
public class TestRunner {

}

//features = "D:\\Tutorials\\IDE2E\\SeleniumCucumber\\src\\com\\sscl\\VehRegistration\\VehRegistration.feature")