package com.genericmethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.application.pages.Account;
import com.application.pages.Home;
import com.application.pages.SignIn;
import com.application.pages.Travel_selection;

public class test  extends GenericMethods{
	public static Home home;
	public static SignIn signin;
	public static Account account;
	public static Travel_selection travel_selection;
	public static void main(String[] args) {
			
	lanunchBowser();
	home = new Home();
	signin = home.click_login();
	
	String mobile_no = prop.getProperty("mobileno");
	signin.enter_mobile_no(mobile_no);
	String sec_pin = prop.getProperty("securepin");
	account = signin.enter_secure_pin(sec_pin);
	account = new Account();
	account.search_bus("Hyderabad", "Goa", "21");
	travel_selection=new Travel_selection();
	travel_selection.filter_lowest_pr_bus();
	List<WebElement>elements=driver.findElements(By.xpath("//div[contains(text(),'₹')]"));
	int element_size=elements.size();
	ArrayList<Integer> input = new ArrayList<Integer>();
	for(WebElement e: elements){
		String text=e.getText();
		
		String split[]=text.split(" ");
		int sp1=Integer.parseInt(split[0].substring(split[0].lastIndexOf("₹")+1));
		
		input.add(sp1);
		}
		System.out.println(input);
		System.out.println("Assending order");
		input.sort(null);
		System.out.println(input.get(0));
	}

}
