package pageUIs;

public class AdminProductPageUI {
	public static final String PAGING_NUMBER = "//ul[@class='pagination']//a[text()='%s']";
	public static final String PAGING_NUMBER_ACTIVE = "//li[@class='paginate_button page-item active']//a[text()='%s']";
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@class='mastercheckbox']";
	public static final String GROUPS_CHECKBOX_ON_PAGE = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/parent::tr//input[@name='checkbox_products']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']";
}
