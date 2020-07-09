import java.sql.*;

public class Uncompleted {

	public static void UncompletedProjects(Statement statement) {
		
		try {
			//query the projectmanager database
			String query = "SELECT * FROM projectmanager WHERE Completed = 'No' ";
			ResultSet result = statement.executeQuery(query);
		
			while (result.next()) {
				
				String completed = result.getString("Completed");
				
				/*
				 * If the projects are not yet completed
				 * The projects details will be displayed
				 */
				if (completed.equalsIgnoreCase("No")) {
					
					System.out.println("Project Number: " + result.getString("ProjectNum")
					+ "\nProject Name: " + result.getString("ProjectName")
					+ "\nBuilding Type: " + result.getString("BuildingType")
					+ "\nPhysical Address: " + result.getString("PhysicalAddress")
					+ "\nERF Number: " + result.getString("ERFNum")
					+ "\nTotal Fee: R" + result.getFloat("TotalFee")
					+ "\nTotal Amount Paid: R" + result.getFloat("TotalAmout")
					+ "\nDeadline: " + result.getString("DueDate") 
					+ "\nCustomerName: " + result.getString("CustomerName")
					+ "\nArchitect Name: " + result.getString("ArchitectName")
					+ "\nContractor Name: " + result.getString("ContractorName")
					+"\n");
				}
				//Else a message will be displayed
				else {
					System.out.println("ALL PROJECTS ARE COMPLETED!");
				}
			}
			
			System.out.println("----------------------------------------------------------------");
			//return to the main menu
			Poised.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
