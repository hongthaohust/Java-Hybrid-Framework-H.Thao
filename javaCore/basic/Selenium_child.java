package basic;

import oop.Selenium;

public class Selenium_child extends Selenium {

	public static void main(String[] args) {
		Selenium_child selechild = new Selenium_child();
		System.out.println(selechild.getparentProtected());
		
		selechild.setParentprotected("edit biến protected");
		System.out.println(selechild.getparentProtected());
	}
	
	String getparentProtected() {
		return protect;
	}
	
	void setParentprotected(String protect) {
		this.protect = protect;
	}
}
