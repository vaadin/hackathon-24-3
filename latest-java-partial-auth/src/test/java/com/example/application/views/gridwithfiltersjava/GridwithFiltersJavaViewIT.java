package com.example.application.views.gridwithfiltersjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GridwithFiltersJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "grid-with-filters-view";

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
		Locator layout = root.locator("vaadin-vertical-layout").nth(0);
		Assertions.assertNotNull(layout);
		Locator name = root.locator("vaadin-text-field").nth(0);
		Assertions.assertNotNull(name);
		log("TODO: send proper values to name name TextField <vaadin-text-field>");
		name.locator("input").fill("name-value");
		Locator phone = root.locator("vaadin-text-field").nth(1);
		Assertions.assertNotNull(phone);
		log("TODO: send proper values to phone phone TextField <vaadin-text-field>");
		phone.locator("input").fill("phone-value");
		Locator dateRangeComponent = root.locator("div").nth(0);
		Assertions.assertNotNull(dateRangeComponent);
		Locator occupations = root.locator("vaadin-multi-select-combo-box").nth(0);
		Assertions.assertNotNull(occupations);
		Locator roles = root.locator("vaadin-checkbox-group").nth(0);
		Assertions.assertNotNull(roles);
		Locator actions = root.locator("div").nth(1);
		Assertions.assertNotNull(actions);
	}
}