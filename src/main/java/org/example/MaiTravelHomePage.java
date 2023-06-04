package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class MaiTravelHomePage extends Utils {

    private By _AcceptCookies = By.id("onetrust-accept-btn-handler");
    private By _searchText = By.id("searchtext_freetext_search_form");
    private By _selectSearch = By.xpath("//div[@id=\"as_searchtext_freetext_search_form\"]/ul/li[1]/a");
    private By _bookOnlineOnHeader = By.xpath("//button[@name=\"enterbookingflow\"]");
    private By _departureAirport = By.xpath("//div[@class=\"nbf_tpl_pms_departure_select\"]");
    private By _availableDay = By.id("calbox-f0050aa159413059b0d39248658bdb50-1");
    private By _nextPageForDate = By.xpath("//div[@class=\"nbf_tpl_pms_calendar_next nbf_tpl_pms_calendar_update\"]");
    private By _numberOfAdults = By.name("numAdults");
    private By _priceForAdult = By.xpath("//div[@class=\"nbf_tpl_pms_calendar_price\"]/span");
    private By _totalPrice = By.xpath("//span[@id=\"tour-price\"]/span");
    private By _bookOnlineButton = By.xpath("//div[@id=\"book-button\"]/div/button/div/div");

    public void validateCurrentUrl() {
        verifyCurrentURL("https://www.mailtravel.co.uk/");
    }

    public void verifyTitle() {
        //String actualTitle = driver.findElement(By.xpath("//img[@class=\"nbf_tpl_image site-logo\"]")).getText();
        String actualTitle = driver.getTitle();
        actualTitle.contains("Mail Travel Home Page");
    }
    public void acceptCookies(){
        clickElement(_AcceptCookies);
    }
    public void searchForIndia(){
       //clickElement(By.id("header-search"));
        typeText(_searchText,"India");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement(_selectSearch);

    }
    public void bookOnline() {
        clickElement(_bookOnlineOnHeader);
        String DepartureAirport = driver.findElement(_departureAirport).getText();
        System.out.println(DepartureAirport);
    }
    public void selectNextAvailableDay(){
        WebElement elm = driver.findElement(By.id("dates_and_prices_title"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",elm);
       //clickElement(_availableDay);
        boolean availableDay = driver.findElement(_availableDay).isDisplayed();
        if (availableDay){
            clickElement(_availableDay);
        }
        else {
            clickElement(_nextPageForDate);
            clickElement(_availableDay);
        }
        Select numberOfAdults = new Select(driver.findElement(_numberOfAdults));
        numberOfAdults.selectByVisibleText("2");
        String PriceForOneAdult = driver.findElement(_priceForAdult).getText();
        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = null;
        try {
            number = format.parse(PriceForOneAdult);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(number.toString());
       int expectedTotalPrice = (Integer.parseInt(number.toString()))*2;
       System.out.println(expectedTotalPrice);
       String actualTotalPrice = driver.findElement(_totalPrice).getText();
       actualTotalPrice.contains("£"+ expectedTotalPrice);
       clickElement(_bookOnlineButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
