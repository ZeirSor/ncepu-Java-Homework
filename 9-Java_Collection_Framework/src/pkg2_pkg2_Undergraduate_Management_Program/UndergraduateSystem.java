package pkg2_pkg2_Undergraduate_Management_Program;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UndergraduateSystem {

	private HashMap<String, Undergraduate> undergraduate_map = new HashMap<>();
	private Set<Map.Entry<String, Undergraduate>> entry_set = undergraduate_map.entrySet();
	private Undergraduate undergraduate;
	private Scanner sc = new Scanner(System.in);

	public void runSystem() {
		showMainMenu();
		while (true) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("please enter your option: ");
			Scanner sc = new Scanner(System.in);
			String choose = sc.next();
			switch (choose) {
			case "1" -> {
				addUndergraduateInfo();
			}
			case "2" -> {
				removeUndergraduateInfo();
			}
			case "3" -> {
				modifyUndergraduateInfo();
			}
			case "4" -> {
				queryUndergraduateInfo();
			}
			case "5" -> {
				printAllInfo();
			}
			case "6" -> {
				System.out.println("exit!");
				System.exit(0);
			}
			default -> System.out.println("No such option, please enter again! ");
			}
			System.out.println("--------------------------------------------------------------");
			showMenu();
		}
	}

	public void addUndergraduateInfo() {
		undergraduate = new Undergraduate();

		System.out.println("Add Students Information");
		setName(undergraduate);
		String id = setId(undergraduate);
		setAge(undergraduate);
		setGender(undergraduate);

		checkInformation(undergraduate, id);
	}

	public void checkInformation(Undergraduate undergraduate, String id) {
		while (true) {
			System.out.println("please check the information:(y/n)");
			System.out.println(undergraduate.toString());
			String check = sc.nextLine();
			if (check.equalsIgnoreCase("y") || check.equalsIgnoreCase("yes")) {
				undergraduate_map.put(id, undergraduate);
				break;
			} else {
				System.out.println("check...");
			}
		}
	}

	public void setName(Undergraduate undergraduate) {
		System.out.println("Please enter student's name");
		String name = sc.nextLine();
		undergraduate.setName(name);
	}

	public String setId(Undergraduate undergraduate) {
		System.out.println("Please enter student's ID");
		String id = sc.nextLine();
		while (true) {
			if (isIdContains(id)) {
				System.out.println("This student ID already exists, please re-enter");
				id = sc.nextLine();
			} else
				break;
		}
		undergraduate.setId(id);
		return id;
	}

	public void setAge(Undergraduate undergraduate) {
		System.out.println("Please enter student's age");
		int age = sc.nextInt();
		undergraduate.setAge(age);
		sc.nextLine();
	}

	public void setGender(Undergraduate undergraduate) {
		System.out.println("Please enter student's gender(m/w)");
		while (true) {
			String gender = sc.nextLine();
			if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("man")) {
				undergraduate.setGender(Undergraduate.Gender.MAN);
				break;
			} else if (gender.equalsIgnoreCase("w") || gender.equalsIgnoreCase("woman")) {
				undergraduate.setGender(Undergraduate.Gender.WOMEN);
				break;
			} else
				System.out.println("Gender error, please enter again.");
		}
	}

	public void removeUndergraduateInfo() {
		System.out.println("Remove Student Information");
		System.out.println("Please enter the student's id you want to remove:");
		String remove_id = sc.nextLine();

		if (remove_id.equalsIgnoreCase("exit"))
			return;
		else {
			Map.Entry remove_entry = getUndergraduateEntry(remove_id);
			undergraduate_map.remove(remove_entry.getKey());
		}
	}

	public void modifyUndergraduateInfo() {
		System.out.println("Modify Student Information");
		System.out.println("Please enter the student's id you want to modify:");
		String modify_id = sc.nextLine();

		if (modify_id.equalsIgnoreCase("exit"))
			return;
		else {
//            Map.Entry<String, Undergraduate> entry = getUndergraduateEntry(modify_id);
			Undergraduate modify_stu = getUndergraduateObject(modify_id);
			if (isInfoNull(modify_stu)) {
				System.out.println("The student does not exist!");
				return;
			} else {
				System.out.println("The student's informations are as follows.");
				System.out.println(modify_stu);
				System.out.println("please enter the infortion you want to modify:(name/id/age/gender/all)");
				String choose = sc.nextLine();
				if (choose.equalsIgnoreCase("name"))
					setName(modify_stu);
				else if (choose.equals("id")) {
					String id = setId(modify_stu);
					undergraduate_map.put(id, undergraduate_map.remove(modify_id));
				} else if (choose.equals("age"))
					setAge(modify_stu);
				else if (choose.equals("gender"))
					Undergraduate.Gender.changeGender(modify_stu);
				else if (choose.equals("all")) {
					setName(modify_stu);
					setId(modify_stu);
					setAge(modify_stu);
					setGender(modify_stu);
				}

				System.out.println("Information is modified successfully!");
				return;
			}
		}

	}

	public void queryUndergraduateInfo() {
		System.out.println("Query Student Information");
		System.out.println("Please enter the student's id you want to query:(enter \"exit\" to exit current option)");
		String query_id = sc.nextLine();

		if (query_id.equalsIgnoreCase("exit"))
			return;
		else {
			Undergraduate query_stu = getUndergraduateObject(query_id);
			if (isInfoNull(query_stu)) {
				System.out.println("The student does not exist!");
				return;
			} else {
				System.out.println("The student's informations are as follows.");
				System.out.println(query_stu);
				return;
			}
		}
	}

	public boolean isInfoNull(Undergraduate undergraduate) {
		return undergraduate == null
				|| (undergraduate.getId() == null && undergraduate.getName() == null && undergraduate.getAge() == 0);
	}

	public void printAllInfo() {
		System.out.println("Print All Students' Information");
		System.out.println("id\t\tname\t\tgender\t\tage");
		Iterator iterator_entry_set = entry_set.iterator();
		while (iterator_entry_set.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator_entry_set.next();
			Undergraduate stu = (Undergraduate) entry.getValue();
			System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getGender() + "\t\t\t" + stu.getAge());
		}
	}

	public static void showMainMenu() {
		System.out.println("----------Welcome to Undergraduate Management System----------");
		showMenu();
		System.out.println("--------------------------------------------------------------");
	}

	public static void showMenu() {
		System.out.println("1. Add Students Information");
		System.out.println("2. Remove Student Information");
		System.out.println("3. Modify Student Information");
		System.out.println("4. Query Student Information");
		System.out.println("5. Print All Students' Information");
		System.out.println("6. EXIT");
	}

	// Find student objects according to student ID
	public Undergraduate getUndergraduateObject(String id) {
		Iterator iterator_entry_set = entry_set.iterator();
		while (iterator_entry_set.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator_entry_set.next();
			if (entry.getKey().equals(id))
				return (Undergraduate) entry.getValue();
		}
		return null;
	}

	public Map.Entry getUndergraduateEntry(String id) {
		Iterator iterator_entry_set = entry_set.iterator();
		while (iterator_entry_set.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator_entry_set.next();
			if (entry.getKey().equals(id))
				return entry;
		}
		return null;
	}

	public boolean isIdContains(String id) {
		Iterator iterator_entry_set = entry_set.iterator();
		while (iterator_entry_set.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator_entry_set.next();
			if (entry.getKey().equals(id)) {
				return true;
			}
		}
		return false;
	}

}