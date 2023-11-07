package pageUIs;

public class AdminProductPageUI {
	public static final String PAGING_NUMBER = "//ul[@class='pagination']//a[text()='%s']";
	public static final String PAGING_NUMBER_ACTIVE = "//li[@class='paginate_button page-item active']//a[text()='%s']";
	public static final String SELECT_ALL_CHECKBOX = "//th/input[@class='mastercheckbox']";
	public static final String GROUPS_CHECKBOX_ON_PAGE = "//input[@name='checkbox_products']";
	public static final String PRODUCT_CHECKBOX_BY_NAME = "//td[text()='%s']/parent::tr//input[@name='checkbox_products']";
	public static final String PRODUCT_DETAIL_IN_TABLE = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[contains(@class,'%s')]";
	public static final String SHOW_NUMBER_ITEM_DROPDOWN = "//select[@name='products-grid_length']";
	public static final String COLUMN_NAME_SIBLING = "//th[text()='%s']/preceding-sibling::th";
	public static final String CELL_VALUE = "//tr[%s]/td[%s]";
	public static final String PUBLISH_STATUS = "//tr[%s]/td[%s]/i[contains(@class,'%s-icon')]";
	public static final String EDIT_PRODUCT = "//td[text()='%s']/following-sibling::td/a";
}
