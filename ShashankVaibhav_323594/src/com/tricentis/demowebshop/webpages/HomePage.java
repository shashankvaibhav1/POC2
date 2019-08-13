package com.tricentis.demowebshop.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver dr;
	WebDriverWait wait;
	public HomePage(WebDriver dr){
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	WebElement login;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement register;
	
	public String login_check() {
		return login.getText();
	}
	
	public String register_check() {
		return register.getText();
	}
	
	public void login() {
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
	}
	

}
