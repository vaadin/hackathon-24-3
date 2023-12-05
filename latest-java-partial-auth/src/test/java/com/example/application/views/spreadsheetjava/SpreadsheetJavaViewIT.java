package com.example.application.views.spreadsheetjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SpreadsheetJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "spreadsheet-view";

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
		Locator spreadsheet = root.locator("vaadin-spreadsheet").nth(0);
		Assertions.assertNotNull(spreadsheet);
		log("TODO: implement test for addSheetChangeListener (sheet-change) in component spreadsheet Spreadsheet <vaadin-spreadsheet>");
		spreadsheet.dispatchEvent("sheet-change");
		log("TODO: implement test for addCellValueChangeListener (cell-value-change) in component spreadsheet Spreadsheet <vaadin-spreadsheet>");
		spreadsheet.dispatchEvent("cell-value-change");
		log("TODO: implement test for addSelectionChangeListener (selection-change) in component spreadsheet Spreadsheet <vaadin-spreadsheet>");
		spreadsheet.dispatchEvent("selection-change");
		Locator invoiceSource = root.locator("span").nth(0);
		Assertions.assertNotNull(invoiceSource);
	}
}