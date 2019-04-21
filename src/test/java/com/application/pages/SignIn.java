package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.GenericMethods;

public class SignIn extends GenericMethods {
	// ************************************LOGIN_WINDOW**************************************//
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Phone number']")
	public static WebElement txt_mobile_no;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	public static WebElement btn_mobile_no_submit;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Login with PIN']")
	public static WebElement txt_secure_pin;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public static WebElement btn_secure_pin_submit;

	// *********************************INITIALIZING*************************************************//
	public SignIn() {
		PageFactory.initElements(driver, this);
	}

	// *******************************METHOD_IMPLEMENTATION******************************************//
	/*
	 * Method Name 			:=enter_mobile_no() 
	 * Input Parameters 	:= mobile no. 
	 * OutPut Parameters 	:= NA 
	 * Designer 			:= SHAMSHEER KHAN 
	 * Sprint 				:= #
	 */
	// ***********************************************************************************************//
	public void enter_mobile_no(String mobileno) {
		boolean flag=false;
		
		try{
			hoverAndSendkeys(txt_mobile_no, mobileno);
			hoverAndClick(btn_mobile_no_submit);
			//logStatus("pass", "mobile Successfully entered");
			flag=true;
		}catch(Exception e){
			logStatus("fail", "mobile no not entered");
			e.printStackTrace();
		}
		if(flag)
			System.out.println("mobile Successfully entered");
		else
			System.out.println("mobile no not entered");
		
	}
	//************************************************************************************************//
	/*
	 * Method Name 			:=enter_secure_pin() 
	 * Input Parameters 	:= secure pin 
	 * OutPut Parameters 	:= NA 
	 * Designer 			:= SHAMSHEER KHAN 
	 * Sprint 				:= #
	 */
	// ***********************************************************************************************//
	public Account enter_secure_pin(String sec_pin) {
		boolean flag = false;
	
		try {
			hoverAndSendkeys(txt_secure_pin, sec_pin);
			hoverAndClick(btn_secure_pin_submit);
			//logStatus("pass", "Secured pin Successfully entered");
			flag = true;
		} catch (Exception e) {
			logStatus("fail", "Secured pin not entered");
			e.printStackTrace();
		}
		if (flag)
			System.out.println("Secured pin Successfully entered");
		else
			System.out.println("Secured pin not entered");
		return new Account();
	}
	// ************************************************************************************************//
	
}
