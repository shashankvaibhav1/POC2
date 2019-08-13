package com.tricentis.demowebshop.testng;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tricentis.demowebshop.webpages.HomePage;
import com.tricentis.demowebshop.webpages.LoginPage;
import com.tricentis.demowebshop.webpages.MyAccountPage;
import com.tricentis.demowebshop.utilities.Excel;

public class testCase1{
	WebDriver dr;
	WebDriverWait wait;
	Logger log;
	HomePage hp;
	LoginPage lp;
	MyAccountPage map;
	ArrayList<ArrayList> al;
	String expected;
	
	@BeforeClass
	public void bc(){
		al = new ArrayList<ArrayList>();
		Excel excel = new Excel();
		al = excel.read_excel();
		System.out.println(al);
		log = log.getLogger("devpinoyLogger");
		log.info("beforeClass() is invoked");
		System.setProperty("webdriver.chrome.driver", "chromedriver_version_75.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://demowebshop.tricentis.com/");		
	}
	@Test(priority=1)
	public void verifyHomeTitle() {
		log.info("verifyHomeTitle() is invoked");
		String actual = dr.getTitle();
		Assert.assertEquals(actual, "Demo Web Shop");
				
	}
	@Test(priority=2)
	public void verifyRegisterText() {
		log.info("verifyRegisterText() is invoked");
		hp = new HomePage(dr);
		String actual = hp.register_check();
		Assert.assertEquals(actual, "Register");				
	}
	@Test(priority=3)
	public void verifyLoginText() {
		log.info("verifyLoginText() is invoked");
		hp = new HomePage(dr);
		String actual = hp.login_check();
		Assert.assertEquals(actual, "Log in");	
		hp.login();
	}
	@Test(priority=4)
	public void verifyLoginTitle() {
		log.info("verifyLoginTitle() is invoked");
		String actual = dr.getTitle();
		Assert.assertEquals(actual, "Demo Web Shop. Login");
	}
	@AfterClass
	public void ac() {
		dr.quit();
	}
	
	
	
}
