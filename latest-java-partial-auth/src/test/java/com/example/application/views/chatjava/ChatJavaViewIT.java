package com.example.application.views.chatjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.vaadin.uitest.common.BasePlayWrightIT;
import org.junit.jupiter.api.Assertions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ChatJavaViewIT extends BasePlayWrightIT {

	static String VIEW = "chat-view";

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
		Locator chatContainer = root.locator("vaadin-vertical-layout").nth(0);
		Assertions.assertNotNull(chatContainer);
		Locator list = chatContainer.locator("vaadin-message-list").nth(0);
		Assertions.assertNotNull(list);
		Locator input = chatContainer.locator("vaadin-message-input").nth(0);
		Assertions.assertNotNull(input);
		Locator side = root.locator("aside").nth(0);
		Assertions.assertNotNull(side);
		Locator header = side.locator("header").nth(0);
		Assertions.assertNotNull(header);
		Locator channels = header.locator("h3").nth(0);
		Assertions.assertNotNull(channels);
		Locator avatarGroup = header.locator("vaadin-avatar-group").nth(0);
		Assertions.assertNotNull(avatarGroup);
		Locator tabs = side.locator("vaadin-tabs").nth(0);
		Assertions.assertNotNull(tabs);
		log("TODO: implement test for addSelectedChangeListener (selected-change) in component tabs Tabs <vaadin-tabs>");
		tabs.dispatchEvent("selected-change");
		Locator badge = tabs.locator("span").nth(0);
		Assertions.assertNotNull(badge);
	}
}