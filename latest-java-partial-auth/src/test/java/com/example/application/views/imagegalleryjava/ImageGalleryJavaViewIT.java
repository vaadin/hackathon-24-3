package com.example.application.views.imagegalleryjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ImageGalleryJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "image-list-view";

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
		Locator root = page.locator("vaadin-app-layout").nth(0).locator("main").nth(0);
		Locator container = root.locator("vaadin-horizontal-layout").nth(0);
		Assertions.assertNotNull(container);
		Locator headerContainer = container.locator("vaadin-vertical-layout").nth(0);
		Assertions.assertNotNull(headerContainer);
		Locator header = headerContainer.locator("h2").nth(0);
		Assertions.assertNotNull(header);
		Locator description = headerContainer.locator("p").nth(0);
		Assertions.assertNotNull(description);
		Locator sortBy = container.locator("vaadin-select").nth(0);
		Assertions.assertNotNull(sortBy);
		Locator imageContainer = root.locator("ol").nth(0);
		Assertions.assertNotNull(imageContainer);
		Locator imageGalleryJavaViewCard = imageContainer.locator("li").nth(0);
		Assertions.assertNotNull(imageGalleryJavaViewCard);
		Locator imageGalleryJavaViewCard_2 = imageContainer.locator("li").nth(1);
		Assertions.assertNotNull(imageGalleryJavaViewCard_2);
		Locator imageGalleryJavaViewCard_3 = imageContainer.locator("li").nth(2);
		Assertions.assertNotNull(imageGalleryJavaViewCard_3);
		Locator imageGalleryJavaViewCard_4 = imageContainer.locator("li").nth(3);
		Assertions.assertNotNull(imageGalleryJavaViewCard_4);
		Locator imageGalleryJavaViewCard_5 = imageContainer.locator("li").nth(4);
		Assertions.assertNotNull(imageGalleryJavaViewCard_5);
		Locator imageGalleryJavaViewCard_6 = imageContainer.locator("li").nth(5);
		Assertions.assertNotNull(imageGalleryJavaViewCard_6);
	}
}