package com.projectFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ContManagementSystemUsingFileHand {

	public static List<Contact> contactList = new ArrayList<>();
	static Scanner s = new Scanner(System.in);

	static {
		/// System.out.println("Today we are going to get contact from file and add it
		/// into arrayList object.");

		try {
			FileReader fr = new FileReader("ContactStorage\\contactList.txt");
			BufferedReader br = new BufferedReader(fr);

			String temp = br.readLine();

			String name, mobile;

			while (temp != null) {
				name = temp;
				temp = br.readLine();
				mobile = temp;
				temp = br.readLine();

				Contact contact = new Contact();
				contact.setName(name);
				contact.setPhNo(mobile);

				contactList.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		int choice;
		boolean flag = true;
		System.out.println("======Welcome to Contact Management System========= \n");

		do {

			System.out.println("\n1. Add Contact.");
			System.out.println("2. View Contact.");
			System.out.println("3. Search Contact.");
			System.out.println("4. Delete Contact.");
			System.out.println("5. Save permanently and Exit.");

			System.out.println("\n\nEnter your Choice: ");
			choice = s.nextInt();
			s.nextLine();

			switch (choice) {
			case 1:
				addContact();
				break;
			case 2:
				displayContact();
				break;
			case 3:
				searchContact();
				break;
			case 4:
				deleteContact();
				break;
			case 5:
				saveContactToFile();
				System.out.println("Contact Saved permanently.");
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice!!!\nPlease enter valid choice.");
			}
		} while (flag);
	}

	private static void saveContactToFile() throws IOException {

		File file = new File("ContactStorage");

		if (file.exists()) {

		} else {
			file.mkdir();
		}

		FileWriter fw = new FileWriter("ContactStorage\\contactList.txt", true);
		PrintWriter pw = new PrintWriter(fw);

		if (contactList.isEmpty()) {
			System.out.println("Sorry, Can't add contact to file because contact list is Empty!!!!!");
		} else {
			for (Contact contact : contactList) {
				pw.println(contact.getName());
				pw.println(contact.getPhNo());
			}
		}
		pw.flush();
		pw.close();
		fw.close();
	}

	private static void addContact() {

		String name, mob;
		System.out.println("Enter Your Name: ");
		name = s.nextLine();
		System.out.println("Enter Your Mob No: ");
		mob = s.nextLine();

		Contact contact = new Contact(name, mob);
		contactList.add(contact);
	}

	private static void displayContact() {

		System.out.println("========Total Contact List: ==========\n\n");
		Iterator<Contact> itr = contactList.iterator();

		if (!itr.hasNext()) {
			System.out.println("Sorry, Your Contact List is Empty!!!");
		}

		for (Contact contact : contactList) {
			System.out.println("Name:\t" + contact.getName());
			System.out.println("Mobile Number: " + contact.getPhNo());
			System.out.println("---------------------------------");
		}
	}

	private static void searchContact() {

		System.out.println("Enter Name to search in contact list: ");
		String name = s.nextLine();
		boolean flag = false;

		for (Contact contact : contactList) {
			if (contact.getName().equalsIgnoreCase(name)) {
				System.out
						.println("Yes, Contact found: \nName: " + contact.getName() + " Mobile: " + contact.getPhNo());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Contact not found.");
		}
	}

	private static void deleteContact() {

		System.out.println("Enter Contact name to delete: ");
		String name = s.nextLine();

		boolean flag = false;

		for (Contact contact : contactList) {
			if (contact.getName().equalsIgnoreCase(name)) {

				boolean remove = contactList.remove(contact);
				if (remove) {
					System.out.println("Contact deleted Successfully.");
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("Can't delete because given contact is not available.");
		}
	}
}