package com.stepdefinitions;

import java.util.Properties;

import com.application.pages.Account;
import com.application.pages.Home;
import com.application.pages.SignIn;
import com.application.pages.Travel_selection;
import com.genericmethods.GenericMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInTest extends GenericMethods {
	public static Home home;
	public static SignIn signin;
	public static Account account;
	public static Travel_selection travel_selection;

	@Given("^User is on Home page$")
	public void user_is_on_Home_page() {
		lanunchBowser();

	}

	@When("^User navigate to login Page$")
	public void user_navigate_to_login_Page() {
		home = new Home();
		signin = home.click_login();
	}

	@When("^User Enters the Mobile no\\.$")
	public void user_Enters_the_Mobile_no() {
		String mobile_no = prop.getProperty("mobileno");
		signin.enter_mobile_no(mobile_no);

	}

	@Then("^Check for Secure Pin$")
	public void check_for_Secure_Pin() {
		String sec_pin = prop.getProperty("securepin");
		account = signin.enter_secure_pin(sec_pin);
	}

	@Then("^User Book bus from \"([^\"]*)\" to \"([^\"]*)\" on journey date \"([^\"]*)\"$")
	public void user_Book_bus_from_to_on_journey_date(String from, String to, String date) {
		account = new Account();
		account.search_bus(from, to, date);
	}

	@Then("^User check for Any Travel from filter having lowestprice$")
	public void user_check_for_Any_Travel_from_filter_having_lowestprice() {

		travel_selection=new Travel_selection();
		travel_selection.filter_lowest_pr_bus();
	}

	@Then("^User select lowestprice available bus by clicking on select seat$")
	public void user_select_lowestprice_available_bus_by_clicking_on_select_seat() {

	}

	@Then("^Select any available seat, if there are no available seats select other travels from filter$")
	public void select_any_available_seat_if_there_are_no_available_seats_select_other_travels_from_filter() {

	}

}
