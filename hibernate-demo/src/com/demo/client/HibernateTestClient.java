package com.demo.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.demo.entity.Customer;
import com.demo.service.CustomerService;
import com.demo.service.CustomerServiceImpl;

public class HibernateTestClient {
	private static CustomerService customerService = new CustomerServiceImpl();
	public static void main(String[] args) {
		menu();
	}
	
	private static void menu() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to Hibernate Demo");
			System.out.println("Select 1 to add a customer");
			System.out.println("Select 2 to search a customer");
			System.out.println("Select 3 to remove a customer");
			System.out.println("Select 4 to update a customer");
			System.out.println("Select 5 to exit");
			byte selection = scan.nextByte();
			switch(selection) {
			case 1:
				save();
				break;
			case 2:
				search();
				break;
			case 3:
				delete();
				break;
			case 4:
				updateCustomer();
				break;
			case 5:
				System.out.println("That's All Folks");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}
	}
	
	private static void save() {
		Scanner scan = new Scanner(System.in);
		Customer cust = new Customer();
		System.out.println("Enter Customer id");
		cust.setCustomerId(scan.nextInt());
		System.out.println("Enter Customer Name");
		cust.setCustomerName(scan.next());
		System.out.println("Enter Customer DOB in DD/MM/YYYY Format");
		cust.setDateOfBirth(stringToCalendar(scan.next()));
		customerService.saveCustomer(cust);
	}

	private static Calendar stringToCalendar(String stringDate) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("DD/MM/YYYY").parse(stringDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cal;
	}
	
	private static void search() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Customer id");
		int id = scan.nextInt();
		Customer cust = customerService.getCustomer(id);
		if (cust != null) {
			System.out.println("Displaying Customer details for customerid :"+id);
			System.out.println("Customer Name : "+cust.getCustomerName());
			System.out.println("Customer DOB : "+cust.getDateOfBirth().getTime());
		} else {
			System.out.println("We don't have a customer with customerId :"+id);
		}
	}
	
	private static void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Customer id to delete");
		int id = scan.nextInt();
		customerService.removeCustomer(id);
	}
	
	private static void updateCustomer() {
		Scanner scan = new Scanner(System.in);
		Customer cust = new Customer();
		System.out.println("Enter customer id");
		cust.setCustomerId(scan.nextInt());
		System.out.println("Enter Customer Name");
		cust.setCustomerName(scan.next());
		System.out.println("Enter Customer DOB in DD/MM/YYYY Format");
		cust.setDateOfBirth(stringToCalendar(scan.next()));
		customerService.updateCustomer(cust);
	}

}
