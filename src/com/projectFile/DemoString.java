package com.projectFile;

public class DemoString {

	public static void main(String[] args) {

		String name1 = "ChanDAN";
		String name2 = "chandan";

		if(name1.equalsIgnoreCase(name2)) {
			System.out.println("Given name is similar");
		}else {
			System.out.println("Given name is different.");
		}
	}

}
