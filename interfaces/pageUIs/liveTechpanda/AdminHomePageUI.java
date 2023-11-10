package pageUIs.liveTechpanda;

import commons.AbstractPage;

public class AdminHomePageUI extends AbstractPage {
	public static final String USERNAME_TEXT = "//input[@id='username']";
	public static final String PASSWORD_TEXT = "//input[@id='login']";
	public static final String lOGIN_BUTTON = "//input[@title='Login']";
	public static final String CLOSE_POPUP_BUTTON = "//span[text()='close']";
	public static final String COLUMN_NAME_SIBLING = "//span[text()='%s']//ancestor::th/preceding-sibling::th";
	public static final String CELL_VALUE = "//tr[%s]/td[%s]";
}