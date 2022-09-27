package com.MiWay.automationTestScript;

import java.util.ArrayList;
import java.util.List;

import org.MiWay.LifeInsurenceObjectRepositery.AddPaymentPage;
import org.MiWay.LifeInsurenceObjectRepositery.ClientName;
import org.MiWay.LifeInsurenceObjectRepositery.ClientStatusPage;
import org.MiWay.LifeInsurenceObjectRepositery.ClientsInformationPage;
import org.MiWay.LifeInsurenceObjectRepositery.TabNames;
import org.MiWay.LifeInsurenceObjectRepositery.TextFieldNames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.MiWay.Genericutility.BaseClass;

public class AutomationScriptPayment2Test extends BaseClass{
//changes done b1
	@Test
	public void payment2Test() {
	comman.clickOnrequriedTab(TabNames.CLIENTS);
	ClientsInformationPage clientInformationPage = new ClientsInformationPage(driver);
	clientInformationPage.clickOnReqClientStauts(ClientName.John_Red);
	ClientStatusPage clientsStatusPage = new ClientStatusPage(driver);
	clientsStatusPage.clickOnaddPaymentLink();
	
	AddPaymentPage addPaymentPage = new AddPaymentPage(driver);
	addPaymentPage.setDataForRequiredTextField(TextFieldNames.MONTH, "October");
	addPaymentPage.setDataForRequiredTextField(TextFieldNames.AMOUNT, "100000");
	addPaymentPage.setDataForRequiredTextField(TextFieldNames.DUE, "1000");
	addPaymentPage.setDataForRequiredTextField(TextFieldNames.FINE, "100");
	addPaymentPage.clickOnSubmitButton();
	comman.clickOnrequriedTab(TabNames.PAYMENTS);	
	
	List<WebElement> list1 = driver.findElements(By.xpath("//table/tbody//tr[last()]//td"));
	ArrayList<String> arry=new ArrayList<String>();
	for (WebElement ele : list1) {
		arry.add(ele.getText());
	}
	Assert.assertTrue(arry.contains("October") && arry.contains("100000") && arry.contains("1000") && arry.contains("100"));
	Reporter.log(" Payment record addaed successfully" , true);
}
}
