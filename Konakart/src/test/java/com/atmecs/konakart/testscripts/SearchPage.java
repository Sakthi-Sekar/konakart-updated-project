package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ReadExcelData;
import com.atmecs.konakart.utils.ValidateTestResult;
@Test
public class SearchPage extends InvokeBrowser {

	// Click on search field
	
	public void clickOnSearch() {
		Xpath = read.readPropertiesFile("loc.search.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

//select a product from dropdown

	public void selectFromDropDown() {
		Xpath = read.readPropertiesFile("loc.dropdown.product.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

//Providing the data through data provider
	@Test(dataProvider = "data", dataProviderClass = ReadExcelData.class)
	public void enterData(String[] in) {
		Xpath = read.readPropertiesFile("loc.typesearch.xpath");
		driver.findElement(By.xpath(Xpath)).sendKeys(in[0]);
		log.info("Entered the data");
//Click on search
		Xpath = read.readPropertiesFile("loc.hitonsearch.xpath");
		PageActions.clickOnElement(driver, Xpath);

	}

//validation for outcome of valid data on search field
	
	public void validateValidOutcome() {
		Xpath = read.readPropertiesFile("loc.validate.validoutcome.xpath");
		PageActions.ClickElement(driver, Xpath);
		String validoutcome = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(validoutcome, "validinput", "No matches");
		log.info("Call of duty");
	}

	// validation for outcome of invalid data on search field
	
	public void validateInvalidOutcome() {
		Xpath = read.readPropertiesFile("loc.invalidinput.xpath");
		String invalidoutcome = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(invalidoutcome, "invalidinput", "No match");
	}

}
