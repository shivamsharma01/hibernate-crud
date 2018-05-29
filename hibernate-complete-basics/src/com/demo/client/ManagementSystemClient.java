package com.demo.client;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.demo.entity.Assets;
import com.demo.entity.Employee;
import com.demo.service.AssetsService;
import com.demo.service.AssetsServiceImpl;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;
import com.demo.util.HibernateUtil;

public class ManagementSystemClient {
	private static EmployeeService empService = new EmployeeServiceImpl();
	private static AssetsService assetsService = new AssetsServiceImpl();

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Employee emp = (Employee) session.load(Employee.class, 1001);
		session.evict(emp);
		Employee emp2 = (Employee) session.load(Employee.class, new Integer(1001));
		System.out.println(emp2.getEmpName());
		// menu();
	}

	private static void menu() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to Asset Management System");
			System.out.println("Select 1 to create a new  Employee");
			System.out.println("Select 2 to create a new  Asset");

			System.out.println("Select 3 to get Asset Details");
			System.out.println("Select 4 to Asset with max price");
			System.out.println("Select 5 to get Total number of Employees");
			System.out.println("Select 6 to Retrieve all the Employees");
			System.out.println("Select 7 to Retrieve Emp and Asset Details for a given id");
			System.out.println("Select 8 to Get Average Price per location");
			System.out.println("Select 9 to update the password for an Employee");
			System.out.println("Select 10 to Delete and Employee And Asset for a given id");
			System.out.println("Select 0 to exit");
			byte selection = scan.nextByte();
			switch (selection) {
			case 1:
			case 2:
				add(selection);
				break;
			case 3:
				search();
				break;
			case 4:
				max();
				break;
			case 5:
				count();
				break;
			case 6:
				getAll();
				break;
			case 7:
				get();
				break;
			case 8:
				findAverage();
				break;
			case 9:
				update();
				break;
			case 10:
				delete();
				break;
			case 0:
				System.out.println("That's All Folks");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		}
	}

	private static void add(int selection) {
		Scanner scan = new Scanner(System.in);
		if (selection == 1) {
			Employee emp = new Employee();
			System.out.println("Enter ID");
			emp.setEmpId(scan.nextInt());
			System.out.println("Enter Asset ID");
			emp.setAssetId(scan.nextInt());
			System.out.println("Enter Name");
			emp.setEmpName(scan.next());
			System.out.println("Enter password");
			emp.setPassword(scan.next());
			empService.add(emp);
		} else {
			Assets asset = new Assets();
			System.out.println("Enter ID");
			asset.setAssetId(scan.nextInt());
			System.out.println("Enter Serial No.");
			asset.setSerialNo(scan.nextInt());
			System.out.println("Enter Asset Type");
			asset.setAssetType(scan.next());
			System.out.println("Enter PR No.");
			asset.setPrNo(scan.nextInt());
			System.out.println("Enter Price ");
			asset.setAssetPrice(scan.nextInt());
			System.out.println("Enter Location");
			asset.setAssetLocation(scan.next());
			assetsService.add(asset);
		}

	}

	private static void search() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Asset id");
		int id = scan.nextInt();
		Assets asset = assetsService.get(id);
		if (asset != null) {
			System.out.println("Displaying Asset details for assetId :" + id);
			System.out.println("Serial No. :" + asset.getSerialNo() + " ,Asset Type: " + asset.getAssetType()
					+ " ,PR No. :" + asset.getPrNo() + " ,Price :" + asset.getAssetPrice() + " ,Location :"
					+ asset.getAssetLocation());
		} else {
			System.out.println("We don't have an Asset with assetId :" + id);
		}
	}

	private static void max() {
		Assets asset = assetsService.getCostliestAsset();
		if (asset != null) {
			System.out.println("Displaying Asset with max price :");
			System.out.print("Asset id :" + asset.getAssetId() + "Serial No. :" + asset.getSerialNo() + " ,Asset Type: "
					+ asset.getAssetType() + " ,PR No. :" + asset.getPrNo() + " ,Price :" + asset.getAssetPrice()
					+ " ,Location :" + asset.getAssetLocation());
		} else {
			System.out.println("We don't have any asset yet :");
		}
	}

	private static void count() {
		System.out.println(empService.getCount());
	}

	private static void getAll() {
		List<Employee> list = empService.getAll();
		for (Employee emp : list) {
			System.out.println(emp.getEmpId() + " : " + emp.getEmpName());
		}
	}

	private static void get() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int empId = scan.nextInt();
		List<Object> empAndAsset = empService.getEmployeeAndAsset(empId);
		for (Object obj : empAndAsset) {
			if (obj != null && obj instanceof Employee) {
				Employee emp = (Employee) obj;
				System.out.println("Employee Details");
				System.out.println(emp.getEmpName());
			} else if (obj != null && obj instanceof Assets) {
				Assets asset = (Assets) obj;
				System.out.println("Asset Details");
				System.out.println("Asset Id :" + asset.getAssetId() + " : " + asset.getAssetLocation());
			}
		}
	}

	private static void findAverage() {
		List<Assets> assets = assetsService.getPricePerLocation();
		for (Assets asset : assets) {
			System.out.println(asset.getAssetLocation() + " avg is " + asset.getAssetPrice());
		}
	}

	private static void update() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int empId = scan.nextInt();
		System.out.println("Enter new Password");
		String password = scan.next();
		empService.updatePassword(empId, password);
	}

	private static void delete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id");
		int empId = scan.nextInt();
		empService.deleteEmployeeAndAsset(empId);
	}
}
