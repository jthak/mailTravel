package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Booking_SecondPage extends Utils{

    private By _viewDetails = By.xpath("//div[@class=\"nbf_tpl_pms_bf_panel__title__links\"]");
    private By _numberOfAdults = By.xpath("//div[@class=\"nbf_tpl_pms_bf_passenger_number unit size1of2 lastUnit\"]");
    private By _airportDetails = By.xpath("//div[@class=\"nbf_tpl_pms_bf_departure_value unit size1of2 lastUnit\"]/span");
    private By _accommodation = By.xpath("//select[@data-roomtype=\"Twin\"]");
    private By _confirmAccommodation = By.xpath("//div[@class=\"nbf_fancy_nbf_tpl_pms_book_room nbf_fg_pms_button_text \"]");
    private By _title1 = By.id("pax-a-title-1");
    private By _firstName1= By.id("pax-a-first-1");
    private By _lastName1 = By.id("pax-a-last-1");
    private By _DOBDay1 = By.id("pax-a-dobd-1");
    private By _DOBMonth1 = By.id("pax-a-dobm-1");
    private By _DOBYear1 = By.id("pax-a-doby-1");
    private By _title2 = By.id("pax-a-title-2");
    private By _firstName2= By.id("pax-a-first-2");
    private By _lastName2 = By.id("pax-a-last-2");
    private By _DOBDay2 = By.id("pax-a-dobd-2");
    private By _DOBMonth2 = By.id("pax-a-dobm-2");
    private By _DOBYear2 = By.id("pax-a-doby-2");
    private By _mobileNumber = By.id("contact-mobile");
    private By _emailAddress = By.id("contact-email");
    private By _addressLine1 = By.id("contact-address1");
    private By _city = By.id("contact-city");
    private By _postcode = By.id("contact-postcode");
    private By _reference = By.id("contact-hearabout");
    private By _continue = By.xpath("//div[@class=\"nbf_fancy_paxButton nbf_fg_pms_button_text \"]");
    private By _confirmationPage = By.className("nbf_fancyimg_payment_pageheader");
    private By _confirmButton = By.id("nbf_booknow_button");

    public void verifyPopulatedDetails(){
         List<WebElement> ViewDetailsButton=driver.findElements(_viewDetails);
        ViewDetailsButton.get(0).click();
        String NumberOfAdults = driver.findElement(_numberOfAdults).getText();
        NumberOfAdults.contains("2");
        String airport = driver.findElement(_airportDetails).getText();
        airport.contains("London Heathrow");
    }
    public void setupAccommodation() {
        Select Accommodation = new Select(driver.findElement(_accommodation));
        Accommodation.selectByVisibleText("1");
        clickElement(_confirmAccommodation);
        try {
            Thread.sleep((5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void fillPassengerDetails(){
        Select Title1 = new Select(driver.findElement(_title1));
        Title1.selectByVisibleText("Mr");
        typeText(_firstName1, "Tom");
        typeText(_lastName1, "Fernandez");
        Select DOB1 = new Select(driver.findElement(_DOBDay1));
        DOB1.selectByVisibleText("12");
        Select DOM1 = new Select(driver.findElement(_DOBMonth1));
        DOM1.selectByVisibleText("July");
        Select DOY1 = new Select(driver.findElement(_DOBYear1));
        DOY1.selectByVisibleText("1987");

        Select Title2 = new Select(driver.findElement(_title2));
        Title2.selectByVisibleText("Mrs");
        typeText(_firstName2, "Lisa");
        typeText(_lastName2, "Fernandez");
        Select DOB2 = new Select(driver.findElement(_DOBDay2));
        DOB2.selectByVisibleText("10");
        Select DOM2 = new Select(driver.findElement(_DOBMonth2));
        DOM2.selectByVisibleText("October");
        Select DOY2 = new Select(driver.findElement(_DOBYear2));
        DOY2.selectByVisibleText("1989");
       }
        public void fillLeadContactDetails(){
            typeText(_mobileNumber, "07912345678");
            typeText(_emailAddress, "tomfernandez@gmail.com");
            typeText(_addressLine1, "Flat 5A, 56 Shelley Road");
            typeText(_city, "Worthing");
            typeText(_postcode, "BN114BX");
            Select Info = new Select(driver.findElement(_reference));
            Info.selectByVisibleText("Email");
            clickElement(_continue);
            String ConfirmDetailsPage = driver.findElement(_confirmationPage).getText();
            ConfirmDetailsPage.contains("Confirm Details + Book");
            boolean BookNowButton = driver.findElement(_confirmButton).isEnabled();
            if (BookNowButton){
                clickElement(_confirmButton);
            }
        }
    }

