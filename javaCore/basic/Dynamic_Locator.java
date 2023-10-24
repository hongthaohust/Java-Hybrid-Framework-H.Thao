package basic;

public class Dynamic_Locator {

	public static void main(String[] args) {
		final String SITE_MAP_LINK = "//a[text()='Sitemap']";
		final String SEARCH_LINK = "//a[text()='Search']";
		final String NEW_PRODUCT_LINK = "//a[text()='New products']";
		
		final String DIANMIC_LINK = "//a[text()='%s']";
		
		final String DIANMIC_COUNTRY_TOTAL = "//td[text()='%s']/following-sibling::td[text()='%s']";
		
		final String DIANMIC_FEMALE_COUNTRY_TOTAL = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
		
		clickToElement(SITE_MAP_LINK);
		clickToElement(SEARCH_LINK);
		clickToElement(NEW_PRODUCT_LINK);
		
		clickToElement(DIANMIC_LINK,"Sitemap");
		clickToElement(DIANMIC_LINK,"Search");
		clickToElement(DIANMIC_LINK,"New products");
		
		clickToElement(DIANMIC_COUNTRY_TOTAL,"Afghanistan","791312");
		clickToElement(DIANMIC_COUNTRY_TOTAL,"Aruba","1312");
		
		clickToElement(DIANMIC_FEMALE_COUNTRY_TOTAL,"Aruba","Male","1312");
	}
	
//	public static void clickToElement(String locator) {
//		System.out.println("Click to element: " + locator);
//	}
//	
//	public static void clickToElement(String locator, String pageName) {
//		locator = String.format(locator, pageName);
//		System.out.println("Click to element: " + locator);
//	}
//	
//	public static void clickToElement(String locator, String countryName, String total) {
//		locator = String.format(locator, countryName, total);
//		System.out.println("Click to element: " + locator);
//	}
//	
//	public static void clickToElement(String locator, String countryName, String male, String total) {
//		locator = String.format(locator, countryName, male, total);
//		System.out.println("Click to element: " + locator);
//	}
	
	public static void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("Click to element: " + locator);
	}
}
