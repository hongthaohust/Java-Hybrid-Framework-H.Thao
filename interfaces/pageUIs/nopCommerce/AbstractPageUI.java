package pageUIs.nopCommerce;

public class AbstractPageUI {
	public static final String CUSTOMER_INFO_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String DOWNLOADABLE_PRODUCT_LINK = "//div[@class='listbox']//a[text()='Downloadable products']";
	public static final String BACK_IN_STOCK_SUBSCRIPTIONS_LINK = "//div[@class='listbox']//a[text()='Back in stock subscriptions']";
	public static final String REWARD_POINTS_LINK = "//div[@class='listbox']//a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK = "//div[@class='listbox']//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";
	
	// Dynamic Link
	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	
	public static final String MAIN_LINK_IN_SIDEBAR = "//div[@class='os-padding']//ul[@role='menu']/li[%s]";
	public static final String SUB01_LINK_IN_SIDEBAR = "//div[@class='os-padding']//ul[@role='menu']/li[%s]/ul/li[%s]";
	public static final String SUB02_LINK_IN_SIDEBAR = "//div[@class='os-padding']//ul[@role='menu']/li[%s]/ul/li[%s]/ul/li[%s]";
	
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']";	
	
}
