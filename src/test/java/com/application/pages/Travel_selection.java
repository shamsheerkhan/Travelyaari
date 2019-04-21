package com.application.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.GenericMethods;

public class Travel_selection extends GenericMethods{
	
	// ************************************FILTER**************************************//
	@FindBy(how = How.XPATH, using = "//div[@id='pric_f']")
	public static WebElement btn_price;

	@FindBy(how = How.XPATH, using = "//span[text()='APPLY FILTERS']")
	public static WebElement btn_apply_filter;
	// **************************************HEADER****************************************//
	@FindBy(how = How.XPATH, using = "//div[text()='Starting price']")
	public static WebElement btn_pri_sort;
	
	//*********************************SEAT_SELECTION**************************************//
	
	
	@FindBy(how=How.XPATH,using="//div[@id='root']//section[2]/div[3]/div")
	public static WebElement txt_lowest_price;
	
	
	
	// *********************************INITIALIZING*************************************************//
	public Travel_selection() {
		PageFactory.initElements(driver, this);
	}

	// *******************************METHOD_IMPLEMENTATION******************************************//
	/*
	 * Method Name 			:=filter_lowest_pr_bus()
	 * Input Parameters 	:= NA 
	 * OutPut Parameters 	:= NA 
	 * Designer 			:= SHAMSHEER KHAN 
	 * Sprint				 := #
	 */
	// ***********************************************************************************************//
	public void filter_lowest_pr_bus() {
		boolean flag = false;

		try {
			hoverAndClick(btn_price);
			hoverAndClick(btn_apply_filter);
			//logStatus("pass", "successfully filtered lowest price bus");
			flag = true;
		} catch (Exception e) {
			logStatus("fail", "unable to filter lowest price bus");
			e.printStackTrace();
		}
		if (flag)
			System.out.println("successfully filtered lowest price bus");
		else
			System.out.println("unable to filter lowest price bus");

	}
	// ************************************************************************************************//
	/*
	 * Method Name 			:=verify_seat_available()
	 * Input Parameters 	:= NA 
	 * OutPut Parameters 	:= NA 
	 * Designer 			:= SHAMSHEER KHAN 
	 * Sprint				 := #
	 */
	// ***********************************************************************************************//
	public void verify_seat_available() {
		List<WebElement>elements=driver.findElements(By.xpath("//div[contains(text(),'₹')]"));
		int element_size=elements.size();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(WebElement e: elements){
			String text=e.getText();
			String split[]=text.split(" ");
			int sp1=Integer.parseInt(split[0].substring(split[0].lastIndexOf("₹")+1));
			input.add(sp1);
		}
		input.sort(null);
		List<WebElement>btn_seat_select=driver.findElements(By.xpath("//div[@id='view_chart']"));
		boolean flag = false;
		for (WebElement e : btn_seat_select) {
			hoverAndClick(e);
		}

		if (flag)
			System.out.println("successfully filtered lowest price bus");
		else
			System.out.println("unable to filter lowest price bus");

	}
	// ************************************************************************************************//

}
