package com.projectFile;

public class Contact {

	private String Name;
	private String PhNo;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhNo() {
		return PhNo;
	}

	public void setPhNo(String phNo) {
		PhNo = phNo;
	}

	public Contact() {
		super();
	}

	public Contact(String name, String phNo) {
		super();
		Name = name;
		PhNo = phNo;
	}

	@Override
	public String toString() {
		return "Contact [Name=" + Name + ", PhNo=" + PhNo + "]";
	}
}
