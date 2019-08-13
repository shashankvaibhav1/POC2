package com.tricentis.demowebshop.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver dr;
	public MyAccountPage(WebDriver dr){
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	@FindBy(xpath="//a[@href = '/customer/info']")
	WebElement uid;
	
	public String getEmail() {
		//System.out.println(dr.findElement(By.xpath("//a[@href = '/customer/info']")).getText());
		//System.out.println(uid.getText());
		return uid.getText();
	}
}
