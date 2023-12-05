package com.example.application.views.helloworldjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HelloWorldJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "hello-world-view";

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
		Locator root = page.locator("vaadin-app-layout").nth(0).locator("vaadin-horizontal-layout").nth(0);
		Locator name = root.locator("vaadin-text-field").nth(0);
		Assertions.assertNotNull(name);
		log("TODO: send proper values to name name TextField <vaadin-text-field>");
		name.locator("input").fill("name-value");
		Locator sayHello = root.locator("vaadin-button").nth(0);
		Assertions.assertNotNull(sayHello);
		log("TODO: implement test for addClickListener (click) in component sayHello Button <vaadin-button>");
		sayHello.dispatchEvent("click");
	}
}