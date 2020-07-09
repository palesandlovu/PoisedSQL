import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInput {
	
	/*
	 * Create a new Project
	 * Get new Project Information from the user.
	 */
	public static void newProject(Statement statement) {
		
		try {
		
		Scanner newProject = new Scanner(System.in);
		
		System.out.print("Project Number: " );
		
		String projectNum = newProject.nextLine();
		
		System.out.print("Project Name: ");
		String projectName = newProject.nextLine();
		
		System.out.print("Building Type: ");
		String buildingType = newProject.nextLine();
		
		System.out.print("Physical Address: ");
		String physicalAddr = newProject.nextLine();
		
		System.out.print("ERF Number: ");
		String erfNum = newProject.nextLine();
		
		System.out.print("Total Fee: R");
		Scanner totalFeeInput = new Scanner(System.in);
		double totalFee = totalFeeInput.nextDouble();
		
		System.out.print("Total Amount Paid To Date: R");
		Scanner totalAmountInput = new Scanner(System.in);
		double totalAmount = totalAmountInput.nextDouble();
		
		//If the amount paid to date is greater than the Project fee, try again.
		while (totalAmount > totalFee) {
			System.out.println("Total Amount paid is greater than Total Fee... Try again!");
			System.out.print("\nTotal Amount Paid To Date: R");
			totalAmount = totalAmountInput.nextDouble();
		}
		
		System.out.print("Due Date (dd/MM/yyyy): ");
		String dueDate = newProject.nextLine();
		
		System.out.print("Customer Name: ");
		String customerName = newProject.nextLine();
		
		System.out.print("Architect Name: ");
		String architectName = newProject.nextLine();
		
		System.out.print("Contractor Name: ");
		String contractorName = newProject.nextLine();
		
		//The project is initially uncomplete
		String completed = "No";
		
		System.out.println("----------------------------------------------------------------");
			
		//Display user input
		ProjectInformation project = new ProjectInformation(projectNum, projectName, buildingType, physicalAddr, erfNum, totalFee, totalAmount, dueDate, customerName, architectName, contractorName, completed);
		System.out.println(project);
		
		//Write user input to the projectmanager database.
		String enterProject = "INSERT INTO projectmanager VALUES (" + "'" + projectNum + "'" + "," + "'" + projectName + "'" + "," + "'" + buildingType + "'" + ","  + "'" + physicalAddr + "'"  + "," + "'" + erfNum + "'" + ","
				+ totalFee + "," + totalAmount + "," + "'" + dueDate + "'" + "," + "'" + customerName + "'" + "," + "'" + architectName + "'" + "," + "'" + contractorName + "'" + "," + "'" + completed + "'" + ");";
		System.out.println("\nThe SQL query is: " + enterProject);
		
		//Number of lines input by the user to the database.
		int	countProject = statement.executeUpdate(enterProject);
		System.out.println(countProject + " records inserted.\n");
		
		System.out.println("----------------------------------------------------------------");
		
		//Enter Architect information after entering new project information.
		System.out.println("Enter Architect Information: \n");
		Architect(statement);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	/*
	 * Create new Customer
	 * Get customer information from the user.
	 */
	public static void Customer(Statement statement) {
	
		try {
		
		Scanner customer = new Scanner(System.in);
		
		System.out.println("Enter Customer Information: \n");
		
		System.out.print("Name: ");
		String customerName = customer.nextLine();
		
		System.out.print("Telephone Number: ");
		String customerTel = customer.nextLine();
		
		//If the number length entered by the user is not equal 10, the number is invalid.
		while (customerTel.length() != 10) {
			System.out.print("Invalid Number... Try again!");
			System.out.print("\nTelephone Number: ");
			customerTel = customer.nextLine();
			
		}
		
		System.out.print("Email Address: ");
		String customerEmail = customer.nextLine();
		
		System.out.print("Physical Address: ");
		String customerPhysical = customer.nextLine();
		
		System.out.println("----------------------------------------------------------------");
	
		//Display user input
		System.out.println();
		PersonalInformation.Customer newCustomer = new PersonalInformation.Customer(customerName, customerTel, customerEmail, customerPhysical);
		System.out.println(newCustomer);
		
		//Write user input to the customer database
		String enterCustomer = "INSERT INTO customer VALUES (" + "'" + customerName + "'" + "," + "'" + customerTel + "'" + "," +  "'" + customerEmail + "'" + "," + "'" + customerPhysical + "'" + ");";
		System.out.println("\nThe SQL query is: " + enterCustomer);
		
		//Number of record being insert to the database.
		int countCustomer = statement.executeUpdate(enterCustomer);
		System.out.println(countCustomer + " records inserted.\n");
		
		System.out.println("----------------------------------------------------------------");
		
		//After entering customer info, enter project information.
		System.out.println("Enter New Project Information: \n");
		newProject(statement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Enter Architect information.
	public static void Architect(Statement statement) {
		
		try {
		Scanner architect = new Scanner(System.in);

		System.out.print("Name: ");
		String architectName = architect.nextLine();
		
		System.out.print("Telephone Number: ");
		String architectTel = architect.nextLine();
		
		//If the number length is not equal to 10, it is invalid.
		while (architectTel.length() != 10) {
			System.out.print("Invalid Number... Try again!");
			System.out.print("\nTelephone Number: "); 
			architectTel = architect.nextLine();
			
		}
		
		System.out.print("Email Address: ");
		String architectEmail = architect.nextLine();
		
		System.out.print("Physical Address: ");
		String architectPhysical = architect.nextLine();
		
		System.out.println("----------------------------------------------------------------");
		
		//Display architect new information.
		PersonalInformation.Architect newArchitect = new PersonalInformation.Architect(architectName, architectTel, architectEmail, architectPhysical);
		System.out.println(newArchitect);
		
		//Insert architect information to the architect database.
		String enterArchitect = "INSERT INTO architect VALUES (" + "'" + architectName + "'" + "," + "'" + architectTel + "'" + "," + "'" + architectEmail + "'" + "," + "'" +architectPhysical + "'" + ");";
		System.out.println("\nThe SQL query is: " + enterArchitect);
		
		//Number of record being insert to the database.
		int count = statement.executeUpdate(enterArchitect);
		System.out.println(count + " records inserted.\n");

		System.out.println("----------------------------------------------------------------");
		
		//Enter Contractor's information after.
		System.out.println("Enter Contractor Information: \n");
		Contractor(statement);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
 	
	}
	
	//Enter Contractor information.
	public static void Contractor(Statement statement) {
		
		try {
		Scanner contractor = new Scanner(System.in);
		
		System.out.print("Name: ");
		String contractorName = contractor.nextLine();
		
		System.out.print("Telephone Number: ");
		String contractorTel = contractor.nextLine();
		
		///If the number length entered by the user is not equal to 10, it is invalid.
		while (contractorTel.length() != 10) {
			System.out.print("Invalid Number... Try again!");
			System.out.print("\nTelephone Number: ");
			contractorTel = contractor.nextLine();
		}
		
		System.out.print("Email Address: ");
		String contractorEmail = contractor.nextLine();
		
		System.out.print("Physical Address: ");
		String contractorPhysical = contractor.nextLine();
		
		System.out.println("----------------------------------------------------------------");
		
		//Display new Contractor Info
		PersonalInformation.Contractor newContractor = new PersonalInformation.Contractor(contractorName, contractorTel, contractorEmail, contractorPhysical);
		System.out.println(newContractor);
		
		//Insert contractor information to the contractor database.
		String enterContractor = "INSERT INTO structuralengineer VALUES (" + "'" + contractorName + "'" + "," + "'" + contractorTel + "'" + "," + "'" + contractorEmail + "'" + "," + "'" + contractorPhysical + "'" + ");";
		System.out.println("\nThe SQL query is: " + enterContractor);
		
		//Number of record being insert to the database.
		int countContractor = statement.executeUpdate(enterContractor);
		System.out.println(countContractor + " records inserted.\n");
		
		System.out.println("----------------------------------------------------------------");
		//Back to the main menu
		Poised.main();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		
}
