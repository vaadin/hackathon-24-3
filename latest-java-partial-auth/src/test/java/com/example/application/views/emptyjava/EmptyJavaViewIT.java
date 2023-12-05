package com.example.application.views.emptyjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EmptyJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "empty-view";

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
		Locator root = page.locator("vaadin-app-layout").nth(0).locator("vaadin-vertical-layout").nth(0);
		Locator img = root.locator("img").nth(0);
		Assertions.assertNotNull(img);
		Locator header = root.locator("h2").nth(0);
		Assertions.assertNotNull(header);
		Locator paragraph = root.locator("p").nth(0);
		Assertions.assertNotNull(paragraph);
	}
}