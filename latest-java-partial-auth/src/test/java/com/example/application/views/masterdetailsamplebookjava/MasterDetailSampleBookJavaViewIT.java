package com.example.application.views.masterdetailsamplebookjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MasterDetailSampleBookJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "master-detail-view-samplebook";

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
		Locator splitLayout_2 = root.locator("vaadin-split-layout").nth(1);
		Assertions.assertNotNull(splitLayout_2);
	}
}