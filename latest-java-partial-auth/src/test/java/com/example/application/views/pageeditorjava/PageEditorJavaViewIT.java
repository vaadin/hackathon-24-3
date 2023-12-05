package com.example.application.views.pageeditorjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageEditorJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "editor-view";

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
		Locator editor = root.locator("vaadin-rich-text-editor").nth(0);
		Assertions.assertNotNull(editor);
		Locator select = root.locator("vaadin-select").nth(0);
		Assertions.assertNotNull(select);
	}
}