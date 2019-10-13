package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ValidateTestResult;

@Test
public class HeroImagePage extends InvokeBrowser {
	// click on the hero image (used as Westclox 32042r Retro 1950 Kitchen Wall
	// Clock 9.5-inch Red)
	
	public void clickOnHeroImage() {
		Xpath = read.readPropertiesFile("loc.heroimage.click.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

//Navigation of tabs
	
	public void navigateTabs() {
		Xpath = read.readPropertiesFile("loc.navigate.specifications.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.navigate.customer.xpath");
		PageActions.clickOnElement(driver, Xpath);
	}

//validation of the content of tabs
	
	public void validateContentOfTabs() {
		Xpath = read.readPropertiesFile("loc.validatecontent.description.xpath");
		String desc = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(desc, "description", "No matches");

		Xpath = read.readPropertiesFile("loc.validatecontent.specifications.xpath");
		String speccontent = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(speccontent, "specvalue", "No matches");

		Xpath = read.readPropertiesFile("loc.validatecontent.customer.xpath");
		String customercontent = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(customercontent, "customervalue", "No matches");

		Xpath = read.readPropertiesFile("loc.validate.productreviewdate.xpath");
		String reviewdate = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(reviewdate, "date", "No match");

	}

//validation for sorting by number

	public void validateSortByNumber() {
		// click on the dropdown
		Xpath = read.readPropertiesFile("loc.sortbynumber.click.xpath");
		PageActions.clickOnElement(driver, Xpath);
//select number from the dropdown
		Xpath = read.readPropertiesFile("loc.validate.sortperpage.xpath");
		PageActions.clickOnElement(driver, Xpath);
//validation of the number selected
		Xpath = read.readPropertiesFile("loc.validate.sortperpage.xpath");
		String perpage = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(perpage, "numberperpage", "No match");
	}

//validation for sorting by actions
	
	public void validateSortByActions() {
		// click on the dropdown
		Xpath = read.readPropertiesFile("loc.sortbyaction.click.xpath");
		PageActions.clickOnElement(driver, Xpath);
//select action from the dropdown
		Xpath = read.readPropertiesFile("loc.validate.sortbyactions.xpath");
		PageActions.clickOnElement(driver, Xpath);
//validation of the action selected
		Xpath = read.readPropertiesFile("loc.validate.sortbyactions.xpath");
		String byaction = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(byaction, "sortbyaction", "No match");
	}
}
