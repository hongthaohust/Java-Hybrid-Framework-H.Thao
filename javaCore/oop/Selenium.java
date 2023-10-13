package oop;

public class Selenium {

	// thuộc tính: property / field / variable
	private String name = "Selenium WebDriver"; // private
	String myName = "tên tôi là DEFAULT"; // default
	protected String protect = "Biến protected"; // protected
	public String public_variable = "Biến public nhé"; // public

	// Phương thức: Medthod / Function
	private String getname() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	String getMyName() {
		return this.myName;
	}
	
	protected String getProtected() {
		return this.protect;
	}
	
	public String getPublic() {
		return this.public_variable;
	}

	public static void main(String[] args) {
		Selenium selenium = new Selenium();

		// Private
		System.out.println(selenium.name);
		System.out.println(selenium.getname());
		
		selenium.setName("chào nhé");
		System.out.println(selenium.name);
		System.out.println(selenium.getname());
		
		// Default
		System.out.println(selenium.myName);
		System.out.println(selenium.getMyName());
		
		// Protected
		System.out.println(selenium.protect);
		System.out.println(selenium.getProtected());
		
		// Public
		System.out.println(selenium.public_variable);
		System.out.println(selenium.getPublic());
	}

}
