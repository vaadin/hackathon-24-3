package com.example.application.views.addressformjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;

public class AddressFormJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "address-form-view";

	@BeforeEach
	public void setupTest() throws Exception {
		super.setupTest();
		fill(page.locator("vaadin-text-field"), "admin");
		fill(page.locator("vaadin-password-field"), "admin");
		click(page.locator("vaadin-button"));
		page.waitForTimeout(50);
	}

	@Override
	public String getView() {
		return VIEW;
	}

	void log(String msg) {
		System.out.println(this.getClass().getSimpleName() + " -> " + msg);
	}

	@Test
	void test() {
		Locator root = page.locator("vaadin-app-layout").nth(0).locator("vaadin-vertical-layout").nth(0);
	}
}