package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.GenericMethods;

public class Account extends GenericMethods{
	
	// ************************************SEARCH_BUS*********************************************//
	@FindBy(how = How.XPATH, using = "//input[@id='from-city']")
	public static WebElement txt_from_place;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Destination city']")
	public static WebElement txt_to_place;

	 @FindBy(how=How.XPATH,using="//input[@id='from-date']")
	 public static WebElement txt_journey_date;

	@FindBy(how = How.XPATH, using = "//button[text()='SEARCH BUS']")
	public static WebElement btn_search_bus_submit;

	// *********************************INITIALIZING*************************************************//
	public Account() {
		PageFactory.initElements(driver, this);
	}

	// *******************************METHOD_IMPLEMENTATION******************************************//
	/*
	 * Method Name 			:=search_bus() 
	 * Input Parameters 	:= from place,to place,journey date 
	 * OutPut Parameters 	:= NA 
	 * Designer 			:= SHAMSHEER KHAN
	 * Sprint 				:= #
	 */
	// ***********************************************************************************************//
	public void search_bus(String from, String to, String date) {
		boolean flag = false;

		try {
			String date_arr[] = getTaodaydateArray();
			String day_string = (date_arr[0]);
			String month = (date_arr[1]).replace("0", "");
			String year = date_arr[2];
			int day=(Integer.parseInt(day_string))+3;
			hoverAndSendkeys(txt_from_place, from);
			hoverAndSendkeys(txt_to_place, to);
			hoverAndClick(txt_journey_date);
			
			WebElement dd_journey_date = driver
					.findElement(By.xpath("(/html/body/div[8]//tbody)[1]//td[@data-day='"+ day +"']"));
			hoverAndClick(dd_journey_date);
			hoverAndClick(btn_search_bus_submit);
			//logStatus("pass", "search bus successfully");
			flag = true;
		} catch (Exception e) {
			logStatus("fail", "unable to search bus");
			e.printStackTrace();
		}
		if (flag)
			System.out.println("search bus successfully");
		else
			System.out.println("unable to search bus");

	}
	// ************************************************************************************************//

}
