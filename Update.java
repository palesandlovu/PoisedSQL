import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	
	//Project Manager Information Main Options.
	public static String ProjectMenu() {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("UPDATE PROJECTS\n"
				+ "\n1. Project Name"
				+ "\n2. Building Type"
				+ "\n3. Physical Address"
				+ "\n4. ERF Number"
				+ "\n5. Total Fee"
				+ "\n6. Total Paid"
				+ "\n7. Deadline"
				+ "\n8. Customer Name"
				+ "\n9. Architect Name"
				+ "\n10. Contractor Name"
				+ "\n11. Completed?"
				+ "\n0. Back");
		
		System.out.print("\nEnter Option: ");
		String update = userInput .nextLine();
		
		System.out.println("----------------------------------------------------------------");
		
		//Return user Input
		return update;
	}
	
	//Project Manager Information Options to update
	public static String UpdateProjectInfo(String update) {
		
		Scanner userInput = new Scanner(System.in);
		String updated = "";
		
		switch (update) {
		
		//Update Project Name
		case "1": {
			System.out.print("\nEnter new Project Name: ");
			String updateName = userInput.nextLine();
			
			updated = "ProjectName = " + "'" + updateName + "'";
			break;
		}
		//Update Building type
		case "2": {
			System.out.print("\nEnter new Building Type: ");
			String updateBuilding = userInput.nextLine();
			
			updated = "BuildingType = " + "'" + updateBuilding + "'";
			break;
		}
		//Update Physical Address
		case "3": {
			System.out.print("\nEnter new PhysicalAddress: ");
			String updatePhysicalAddress = userInput.nextLine();
			
			updated = "PhysicalAddress = " + "'" + updatePhysicalAddress + "'";
		}
		//Update ERF Number
		case "4": {
			System.out.print("\nEnter new ERF Number: ");
			String updateErfNum = userInput.nextLine();
			
			updated = "ERFNum = " + "'" + updateErfNum + "'";
			break;
		}
		//Update Total Fee
		case "5": {
			System.out.print("\nEnter new Total Fee: ");
			Scanner newTotalFee = new Scanner(System.in);
			float updateTotalFee = newTotalFee.nextFloat();
			
			updated = "TotalFee = " + "'" + updateTotalFee; 
			break;
		}
		//Update Amount Paid
		case "6": {
			System.out.print("\nEnter new Amount Paid: ");
			Scanner newAmount = new Scanner(System.in);
			float updateAmountPaid = newAmount.nextFloat();
			
			updated = "TotalAmout = " + "'" + updateAmountPaid + "'";
			break;
		}
		//Update Due Date
		case "7": {
			System.out.print("\nEnter new Due date (dd/mm/yyyy): ");
			String updatedDuedate = userInput.nextLine();
			
			updated = "DueDate = " + "'" + updatedDuedate + "'";
			break;
		}
		
		case "8": {
			System.out.print("\nEnter new Customer Name: ");
			String updatedCustomerName = userInput.nextLine();
			
			updated = "CustomerName = " + "'" + updatedCustomerName + "'";
			break;
		}
		case "9": {
			System.out.print("\nEnter new Architect Name: ");
			String updatedArchitectName = userInput.nextLine();
			
			updated = "ArchitectName = " + "'" + updatedArchitectName + "'";
			break;
		}
		case "10": {
			System.out.print("\nEnter new Contractor Name: ");
			String updatedContractorName = userInput.nextLine();
			
			updated = "ContractorName = " + "'" + updatedContractorName + "'";
			break;
		}
		case "11": {
			System.out.print("\nCompleted? ");
			String updatedComplete = userInput.nextLine();
			
			updated = "Completed = " + "'" + updatedComplete + "'";
			break;
		}
		//Go back to the main menu
		case "0": {
			Poised.main();
			break;
		}
		}
		//return updated
		return updated;
	}
	
	
	/*
	 * Update Project chosen field
	 * Enter Project Number or Project Name
	 * Update field's chosen project number or project name.
	 */
	public static void ProjectUpdate(Statement statement) {
		
		try {
			Scanner input = new Scanner(System.in);
			
			System.out.print("Enter Project Number or Project Name: ");
			String project = input.nextLine();
			
			String choice = ProjectMenu();

			String updateChoice = UpdateProjectInfo(choice);
			
			//Update where the projectNum is equal to the user input
			String update = "UPDATE projectmanager SET " + updateChoice + " WHERE ProjectNum = " + "'" + project + "'"
					+ "OR ProjectName = " + "'" + project + "'";
			System.out.println("The SQL query is: " + update);
			
			System.out.println("----------------------------------------------------------------");
		
			int countProject = statement.executeUpdate(update); 
			System.out.println(countProject + "records affected");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Personal Information Menu
	 * Choose which column you want to edit
	 */
	public static String PersonalMenu() {
		
		System.out.println("\n1. Name"
				+ "\n2. Telephone Number"
				+ "\n3. Email Address"
				+ "\n4. Physical Address"
				+ "\n0. Back To Main Menu");
		
		System.out.print("\nEnter Option: ");
		Scanner userInput = new Scanner(System.in);
		String update = userInput .nextLine();
		
		System.out.println("----------------------------------------------------------------");
		
		return update;
	}

	//Customer Information Options to update
	public static String UpdateCustomerInfo(String update) {
		
		Scanner userInput = new Scanner(System.in);	
		
		String updated = "";
		
		switch (update) {
		
		//Customer Name
		case "1": {
			System.out.print("\nEnter new Name: ");
			String updateName = userInput.nextLine();
			
			updated = "Name = " + "'" + updated + "'";
			break;
		}
		//Customer Telephone Number
		case "2": {
			System.out.print("\nEnter new Telephone Number: ");
			String updatedTelNum = userInput.nextLine();
			
			updated = "TelephoneNum = " + "'" + updatedTelNum +  "'"; 
			break;
		}
		//Customer Email Address
		case "3": {
			System.out.print("\nEnter new Email Address: ");
			String updatedEmail = userInput.nextLine();
			
			updated = "EmailAddress = " + "'" + updatedEmail + "'";
		}
		//Customer Physical Address
		case "4": {
			System.out.println("\nEnter new Physical Address: ");
			String updatedPhysical = userInput.nextLine();
			
			updated = "PhysicalAddress = " + "'" + updatedPhysical + "'";
			break;
		}
		//Go back to the main menu
		case "0": {
			Poised.main();
		}
		}
		//return updated
		return updated;
	}
	
	/*
	 * Update Customer's chosen row
	 * Where the Customer's name is equal to user input
	 */
	public static void CustomerUpdate(Statement statement) {
		
		try {
			Scanner userInput = new Scanner(System.in);
			
			System.out.print("\nEnter Project Name: ");
			String customerName = userInput.nextLine();
			
			System.out.println("----------------------------------------------------------------");
			
			String choice = PersonalMenu();
			
			String updateChoice = UpdateCustomerInfo(choice);
			
			String update = "UPDATE customer SET " + updateChoice + " WHERE Name = " + "'" + customerName + "'";
			System.out.println("The SQL query is: " + update);
		
			System.out.println("----------------------------------------------------------------");
		
			int countCustomer = statement.executeUpdate(update); 
			System.out.println(countCustomer + " record/s affected");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Update Architect's information
	public static String UpdateArchitectInfo(String update) {
		
		Scanner userInput = new Scanner(System.in);
		
		String updated = "";
		
		switch (update) {
		
		//Architect Name
		case "1": {
			System.out.print("\nEnter new Name: ");
			String updateName = userInput.nextLine();
			
			updated = "Name = " + "'" + updateName + "'";
			break;
		}
		//Architect Telephone Number
		case "2": {
			System.out.print("\nEnter new Telephone Number: ");
			String updatedTelNum = userInput.nextLine();
			
			updated = "TelephoneNum = " + "'" + updatedTelNum +  "'"; 
			break;
		}
		//Architect Email Address
		case "3": {
			System.out.print("\nEnter new Email Address: ");
			String updatedEmail = userInput.nextLine();
			
			updated = "EmailAddress = " + "'" + updatedEmail + "'";
			break;
		}
		//Architect Physical Address
		case "4": {
			System.out.println("\nEnter new Physical Address: ");
			String updatedPhysical = userInput.nextLine();
			
			updated = "PhysicalAdress = " + "'" + updatedPhysical + "'";
			break;
		}
		//Go back to the main menu
		case "0": {
			Poised.main();
		}
		}
		return updated;
	}
	
	/*
	 * Update Architect's chosen row
	 * Where the Architect's name is equal to user input
	 */
	public static void ArchitectUpdate(Statement statement) {
		
		try {
			Scanner userInput = new Scanner(System.in);
			
			System.out.print("\nEnter Architect Name: ");
			String architectName = userInput.nextLine();
			
			System.out.println("----------------------------------------------------------------");
				
			String choice = PersonalMenu();
			
			String updateChoice = UpdateArchitectInfo(choice);
			
			String update = "UPDATE architect SET " + updateChoice + " WHERE Name = " + "'" + architectName + "'";
			System.out.println("The SQL query is: " + update);
			
			System.out.println("----------------------------------------------------------------");
		
			int countArchitect = statement.executeUpdate(update); 
			System.out.println(countArchitect + " record/s affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Update Contractor Information
	public static String UpdateContractorInfo(String update) {
		
		Scanner userInput = new Scanner(System.in);
		
		String updated = "";
		
		switch (update) {
		
		//Contractor Name
		case "1": {
			System.out.print("\nEnter new Name: ");
			String updateName = userInput.nextLine();
			
			updated = "Name = " + "'" + updateName + "'";
			break;
		}
		//Contractor Telephone Number
		case "2": {
			System.out.print("\nEnter new Telephone Number: ");
			String updatedTelNum = userInput.nextLine();
			
			updated = "TelephoneNum = " + "'" + updatedTelNum +  "'"; 
			break;
		}
		//Comtractor Email Address
		case "3": {
			System.out.print("\nEnter new Email Address: ");
			String updatedEmail = userInput.nextLine();
			
			updated = "EmailAddress = " + "'" + updatedEmail + "'";
			break;
		}
		//Contractor Physical Address
		case "4": {
			System.out.println("\nEnter new Physical Address: ");
			String updatedPhysical = userInput.nextLine();
			
			updated = "PhysicalAddress = " + "'" + updatedPhysical + "'";
			break;
		}
		//Go back to the main menu
		case "0": {
			Poised.main();
		}
		}
		//return updated
		return updated;
	}
	
	/*
	 * Update Customer's chosen row
	 * Where the Customer's name is equal to user input
	 */
	public static void ContractorUpdate(Statement statement) {
		
		try {
			
			Scanner userInput = new Scanner(System.in);
			
			System.out.print("\nEnter Contractor Name: ");
			String contractorName = userInput.nextLine();
			
			System.out.println("----------------------------------------------------------------");
			
			String choice = PersonalMenu();
			
			String updateChoice = UpdateContractorInfo(choice);
			
			String update = "UPDATE structuralengineer SET " + updateChoice + " WHERE Name = " + "'" + contractorName + "'";
			System.out.println("The SQL query is: " + update);
			
			System.out.println("----------------------------------------------------------------");
		
			int countContractor = statement.executeUpdate(update); 
			System.out.println(countContractor + " record/s affected");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
