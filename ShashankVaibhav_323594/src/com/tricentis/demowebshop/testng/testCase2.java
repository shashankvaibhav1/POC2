package com.tricentis.demowebshop.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tricentis.demowebshop.webpages.LoginPage;
import com.tricentis.demowebshop.webpages.MyAccountPage;

public class testCase2 extends testCase1{
	
	
	@Test(dataProvider = "dp",priority =5) //dependsOnMethods = "homePage"
	public void loginPage(String emailid, String password, String expected) {
		log.info("loginPage() is invoked");
		lp = new LoginPage(dr);
		map = new MyAccountPage(dr);
		lp.setEmail(emailid);
		lp.setPass(password);
		lp.clickLogin();	
		this.expected = expected;
//		if(dr.getTitle().equals("Demo Web Shop. Login")) {
//			String actual = lp.err();
//			Assert.assertEquals(actual, expected);
//			log.info("\nExpected Result: "+expected+ "\nActual Result:"+actual);
//			dr.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
//		}
		if(dr.getTitle().equals("Demo Web Shop")) {
			String actual = map.getEmail();
			Assert.assertEquals(actual, expected);
			log.info("\nExpected Result: "+expected+ "\nActual Result:"+actual+"\nTest Result: PASS");
			dr.quit();
			after();
		}
	}

	@DataProvider(name="dp")
	public String[][] dp() {
		String[][] array = new String[al.size()][3];
		for(int i=0; i<al.size(); i++){
			for (int j = 0; j < al.get(i).size(); j++) {
				array[i][j] = al.get(i).get(j).toString();
			}
		}
		return array;
	}
	
	public void after() {
		System.setProperty("webdriver.chrome.driver", "chromedriver_version_75.exe");
		dr = new ChromeDriver();
		dr.manage().window().maximize();
		dr.get("http://demowebshop.tricentis.com/");	
		dr.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
	}
}
