package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage{
    public void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public void clickElement(By by)
    {
        driver.findElement(by).click();
    }
    public void getTextFromElement(By by)
    {
        driver.findElement(by).getText();
    }
    public static void verifyCurrentURL(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
    public void VerifyActualAndExpected(By by,String text){
        String ActualText = driver.findElement(by).getText();
        System.out.println(ActualText);
        String ExpectedText =text;
        Assert.assertEquals(ActualText,ExpectedText,"Wrong Text");

    }
    public void SelectRadioButton(By by){
        WebElement radio1 = driver.findElement(by);
        radio1.click();
    }
    public void SelectCheckBox(By by) {
        WebElement Checkbox = driver.findElement(by);
        Checkbox.click();
        for (int i = 0; i < 2; i++) {
            System.out.println(Checkbox.isSelected());
        }
    }
    public void SelectFromDropDownMenuByValue(By by,String Value){
        Select BirthMonth = new Select(driver.findElement(by));
        BirthMonth.selectByValue(Value);
    }
}
