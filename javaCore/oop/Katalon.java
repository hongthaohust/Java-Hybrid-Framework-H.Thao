package oop;

public class Katalon {

	public static void main(String[] args) {
		Selenium selenium = new Selenium();
		
		System.out.println(selenium.myName);
		System.out.println(selenium.getProtected());
		System.out.println(selenium.public_variable);
		
		selenium.public_variable = "Biến public được edit";
		System.out.println(selenium.getPublic());

	}
}
