package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.GenericMethods;

public class Home extends GenericMethods {
	// ************************************HEADER**************************************//
	@FindBy(how = How.XPATH, using = "//a[normalize-space(text())='Login / Join']")
	public static WebElement lnk_login;

	// *********************************INITIALIZING*************************************************//
	public Home() {
		PageFactory.initElements(driver, this);
	}

	// *******************************METHOD_IMPLEMENTATION******************************************//
	/*
	 * Method Name 			:=click_login() 
	 * Input Parameters		:= NA 
	 * OutPut Parameters	:= NA
	 * Designer				:= SHAMSHEER KHAN
	 * Sprint				:= # 
	 */
	//***********************************************************************************************//
	public SignIn click_login() {
		boolean flag = false;
		try {
			hoverAndClick(lnk_login);
			//logStatus("pass", "Successfully login link clicked");
			flag = true;
		} catch (Exception e) {
			logStatus("fail", "login link Not clicked");
			e.printStackTrace();
		}
		if (flag)
			System.out.println("Successfully login link clicked");
		else
			System.out.println("login link Not clicked");
		return new SignIn();

	}
	//***********************************************************************************************//
	
}
