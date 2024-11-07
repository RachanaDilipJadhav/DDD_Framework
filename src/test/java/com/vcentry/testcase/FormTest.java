package com.vcentry.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.base.BaseClass;
import com.vcentry.pages.FormPage;
import com.vcentry.utils.Function;

public class FormTest extends BaseClass{
	
	FormPage form;
	@BeforeMethod
	public void launchUrl() {
		driver.get(Function.getProp("formUrl"));
		form = new FormPage();
}
	
	@Test(dataProvider="validData")
	public void placeOrder(String product,String mobileNum,String emailId,String category,String quantity,String purchasername,String gst,String payment,String msg) throws InterruptedException {	
	
	form.enterProdName(product);
	form.entermobNum(mobileNum);
	form.enterEmailId(emailId);
	form.selectProdCtg(category);
	form.enterProdQty(quantity);
	form.enterPurName(purchasername);
	form.selectGst(gst);
	form.selectPayment(payment);
	form.placeorder();
	form.verifyOrderPlaced(msg);
	System.out.println("msg");
	
	}
	
	@DataProvider(name="validData")
	public String[][] validData(){
		return Function.getTestData("form", "validData");
	}
}
