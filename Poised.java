import java.util.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 * 
 * @author Palesa Ndlovu
 *
 */
public class Poised {

	public static void main(String[] args) {
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("\t\t\tPOISED PROJECT");
		System.out.println("----------------------------------------------------------------");
		
		main();
	}
	
	//Main menu to access Project options
	public static void main() {
		
		try {
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("\nOPTIONS: \n"
					+ "\n1. View all Projects"
					+ "\n2. Register new Project"
					+ "\n3. Update Project"
					+ "\n4. Finalize Project"
					+ "\n5. View Uncompleted Projects"
					+ "\n6. View Overdue Projects"
					+ "\n0. Exit");
			
			System.out.print("\nEnter Option: ");
			String userchoice = userInput.nextLine();
			
			System.out.println("----------------------------------------------------------------");
			
			options(userchoice);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//Assigning every number to an option.
	public static void options(String choice) throws ParseException {
		try {
			Connection connection;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poisedpms?useSSL=false"
			 		, "root"
			 		, "MBALI_daisy03");
			
			Statement statement = connection.createStatement();
			
			Scanner project = new Scanner(System.in);
			
			switch (choice) {
			
			//1-View Project Information
			case "1": {
				//Information to view
				System.out.println("VIEW ALL PROJECTS \n"
						+ "\n1. View Project Information"
						+ "\n2. View Customer Information"
						+ "\n3. View Architect Information"
						+ "\n4. View Contractor information"
						+ "\n0. Back");
				
				System.out.print("\nEnter Option: ");
				choice = project.nextLine();
				System.out.println("----------------------------------------------------------------");
				
				//View project information
				if (choice.equals("1")) {
					System.out.println("\nPROJECT INFORMATION:\n");
					ViewAll.ViewProjects(statement); 
				}
				
				//View customer information
				else if (choice.equals("2")) {
					System.out.println("\nCUSTOMER INFORMATION:\n");
					ViewAll.ViewCustomer(statement);
					break;
				}
				
				//View architect information
				else if (choice.equals("3")) {
					System.out.println("\nARCHITECT INFORMATION:\n");
					ViewAll.ViewArchitect(statement);
					break;
				}
				
				//View contractor information
				else if (choice.equals("4")) {
					System.out.println("\nCONTRACTOR INFORMATION:\n");
					ViewAll.ViewContractor(statement);
					break;
				}
				else if (choice.equals("0")) {
					main();
				}
				break;
			}
			
			//2-Register new Project
			case "2": {
				System.out.println("NEW PROJECT \n");
				UserInput.Customer(statement); //call updateProjectInfo function
				break;
			}
			
			//3-Update Personal Information
			case "3": {
				System.out.println("UPDATE PROJECT\n"
						+ "\n1. Update Project Information"
						+ "\n2. Update Customer Information"
						+ "\n3. Update Architect Information"
						+ "\n4. Update Contractor Information"
						+ "\n0. Back to Main Menu");
				
				System.out.print("\nEnter Option: ");
				choice = project.nextLine();
				
				if (choice.equals("1")) {
					Update.ProjectUpdate(statement);
					main();
				}
				
				if (choice.equals("2")) {
					Update.CustomerUpdate(statement);
					main();
				}
				
				if (choice.equals("3")) {
					Update.ArchitectUpdate(statement);
					main();
				}
				
				if (choice.equals("4")) {
					Update.ContractorUpdate(statement);
					main();
				}
				
				if (choice.equals("0")) {
					main();
				}
				break;
			}
			
			//4-Finalize Project
			case "4":{
				System.out.println("FINALIZE PROJECT\n");
				Finalize.finalizeProjects(statement);
				break;
			}
			
			//5-View uncompleted projects
			case "5":{
				System.out.println("UNCOMPLETED PROJECTS\n");
				Uncompleted.UncompletedProjects(statement);;//call unCompleteProjects
				break;
			}
			
			//6-View overdue projects
		    case "6":{
		    	System.out.println("OVERDUE PROJECTS\n");
		    	Overdue.overdueProjects(statement);//call overdueProjects
		    	break;
		    }
		    
		    //8-Exit the Project
		    case "0": {
		    	System.out.println("THANK YOU FOR USING POISED!");
		    	System.out.println("----------------------------------------------------------------");
		    	break;
		    }
		    
			}
		//catch Exception error
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
				
}
