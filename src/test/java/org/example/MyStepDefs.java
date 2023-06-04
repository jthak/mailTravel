package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {

    MaiTravelHomePage maiTravelHomePage = new MaiTravelHomePage();
    Booking_SecondPage booking_secondPage = new Booking_SecondPage();

    @Given("user is on the homepage of mail travel")
    public void user_is_on_the_homepage_of_mail_travel() {
        // Write code here that turns the phrase above into concrete actions
        maiTravelHomePage.validateCurrentUrl();
        maiTravelHomePage.verifyTitle();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        maiTravelHomePage.acceptCookies();
    }
    @When("user search for India in search box on home page")
    public void user_search_for_india_in_search_box_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        maiTravelHomePage.searchForIndia();

    }
    @When("user clicks on Book online button")
    public void user_clicks_on_book_online_button() {
        // Write code here that turns the phrase above into concrete actions
        maiTravelHomePage.bookOnline();
    }
    @When("user selects next available date")
    public void user_selects_next_available_date() {
        // Write code here that turns the phrase above into concrete actions
        maiTravelHomePage.selectNextAvailableDay();
    }
    @When("user confirms details of travel on next page")
    public void user_confirms_details_of_travel_on_next_page() {
        // Write code here that turns the phrase above into concrete actions
        booking_secondPage.verifyPopulatedDetails();
        booking_secondPage.setupAccommodation();
    }
    @When("user fill passenger details")
    public void user_fill_passenger_details() {
        // Write code here that turns the phrase above into concrete actions
        booking_secondPage.fillPassengerDetails();
    }
    @Then("user should verify user details for booking successfully")
    public void user_should_verify_user_details_for_booking_successfully() {
        // Write code here that turns the phrase above into concrete actions
        booking_secondPage.fillLeadContactDetails();
    }
}
