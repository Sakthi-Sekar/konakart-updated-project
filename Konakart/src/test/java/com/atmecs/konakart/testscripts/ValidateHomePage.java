package com.atmecs.konakart.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.atmecs.konakart.testbase.InvokeBrowser;
import com.atmecs.konakart.utils.PageActions;
import com.atmecs.konakart.utils.ValidateTestResult;



@Test
public class ValidateHomePage extends InvokeBrowser {
	String Id;

	public void validateTabsHomePage() {
		// Validation of landing page using url
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.konakart.com/konakart/Welcome.action");
		log.info("Landed into correct page");
		// validation of tabs in homepage using breadcrumbs(dynamic xpath is used)
		Xpath = read.readPropertiesFile("loc.click.tab.computer.xpath");
		PageActions.clickOnElement(driver, Xpath);

		Xpath = read.readPropertiesFile("loc.validate.computer.breadcrumb.xpath");
		String computerbreadcrumb = driver.findElement(By.xpath(Xpath)).getText();
		ValidateTestResult.validateData(computerbreadcrumb, "ComputerBreadcrumb", "No match");

	}

	public void validateDropDown() {
		Id = read.readPropertiesFile("loc.dropdown.id");
		PageActions.dropDownHandle(driver, Id);
		ValidateTestResult.validateData(Id, "dropdownvalus", "No match");
		log.info("Dropdown values");
	}

	public void isElementEnabled() {
		Id = read.readPropertiesFile("loc.fieldenabled.id");
		PageActions.elementEnabled(driver, Id);
	}
}
