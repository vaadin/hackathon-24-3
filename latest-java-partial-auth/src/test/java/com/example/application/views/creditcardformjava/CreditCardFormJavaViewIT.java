package com.example.application.views.creditcardformjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CreditCardFormJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "credit-card-form-view";

	@BeforeEach
	public void setupTest() throws Exception {
		super.setupTest();
	}

	@Override
	public String getView() {
		return VIEW;
	}

	void log(java.lang.String msg) {
		System.out.println(this.getClass().getSimpleName() + " -> " + msg);
	}

	@Test
	void test() {
		Locator root = page.locator("vaadin-app-layout").nth(0).locator("div").nth(0);
		Locator h3 = root.locator("h3").nth(0);
		Assertions.assertNotNull(h3);
		Locator formLayout = root.locator("vaadin-form-layout").nth(0);
		Assertions.assertNotNull(formLayout);
		Locator cardNumber = formLayout.locator("vaadin-text-field").nth(0);
		Assertions.assertNotNull(cardNumber);
		log("TODO: send proper values to cardNumber cardNumber TextField <vaadin-text-field>");
		cardNumber.locator("input").fill("cardNumber-value");
		Locator cardholderName = formLayout.locator("vaadin-text-field").nth(1);
		Assertions.assertNotNull(cardholderName);
		log("TODO: send proper values to cardholderName cardholderName TextField <vaadin-text-field>");
		cardholderName.locator("input").fill("cardholderName-value");
		Locator expiration = formLayout.locator("vaadin-custom-field").nth(0);
		Assertions.assertNotNull(expiration);
		Locator csc = formLayout.locator("vaadin-password-field").nth(0);
		Assertions.assertNotNull(csc);
		log("TODO: send proper values to csc csc PasswordField <vaadin-password-field>");
		csc.locator("input").fill("csc-value");
		Locator cancel = root.locator("vaadin-button").nth(0);
		Assertions.assertNotNull(cancel);
		log("TODO: implement test for addClickListener (click) in component cancel Button <vaadin-button>");
		cancel.dispatchEvent("click");
		Locator layout = root.locator("vaadin-horizontal-layout").nth(0);
		Assertions.assertNotNull(layout);
	}
}