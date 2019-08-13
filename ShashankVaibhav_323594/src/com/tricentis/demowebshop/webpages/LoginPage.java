package com.tricentis.demowebshop.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver dr;
	WebDriverWait wait;
	public LoginPage(WebDriver dr){
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement login_btn;
	
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void setPass(String password) {
		pass.sendKeys(password);
	}
	public void clickLogin() {
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(login_btn));
		login_btn.click();
	}
	
	@FindBy(xpath="//div[@class = 'validation-summary-errors']")
	WebElement summary_err;
	
	@FindBy(xpath="//span[@class = 'field-validation-error']")
	WebElement field_err;
	
	public String err() {
		String er = "";
		try {
			if(summary_err.isDisplayed()) {
				er = summary_err.getText();
			}
		}catch(Exception e) {}
		try {
			if(field_err.isDisplayed()) {
				er = field_err.getText();
			}
		}catch(Exception e) {}
		return er;
	}
}
