package com.example.application.views.mapjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MapJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "map-view";

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
		Locator map = root.locator("vaadin-map").nth(0);
		Assertions.assertNotNull(map);
		Locator sidebar = root.locator("vaadin-vertical-layout").nth(0);
		Assertions.assertNotNull(sidebar);
		Locator searchField = sidebar.locator("vaadin-text-field").nth(0);
		Assertions.assertNotNull(searchField);
		log("TODO: send proper values to searchField searchField TextField <vaadin-text-field>");
		searchField.locator("input").fill("searchField-value");
		log("TODO: implement test for addValueChangeListener (value-change) in component searchField TextField <vaadin-text-field>");
		searchField.dispatchEvent("value-change");
		Locator scroller = sidebar.locator("vaadin-scroller").nth(0);
		Assertions.assertNotNull(scroller);
	}
}