import java.sql.*;

public class ViewAll { 
	
	public static void ViewProjects(Statement statement) throws SQLException{
		
		//View all projects from the projectmanager database 
		try {
			//query the projectmanager database
			String query = "SELECT * FROM projectmanager";
			
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
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
						+ "\nCompleted? " + result.getString("Completed")
						+"\n");
			}
			System.out.println("----------------------------------------------------------------");
			//Back to the main menu
			Poised.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ViewCustomer(Statement statement) throws SQLException{
		
		//View all projects from the customer database 
		try {
			//query the customer database
			String query = "SELECT * FROM customer";
			
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				System.out.println("Name: " + result.getString("Name")
				+ "\nTelephone Number: " + result.getString("TelephoneNum")
				+ "\nEmail Address: " + result.getString("EmailAddress")
				+ "\nPhysical Adress: " + result.getString("PhysicalAddress") + "\n" );
			}
			System.out.println("----------------------------------------------------------------");
			//Back to the main menu
			Poised.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ViewArchitect(Statement statement) throws SQLException{
		
		//View all projects from the architect database 
		try {
			//query the architect database
			String query = "SELECT * FROM architect";
			
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				System.out.println("Name: " + result.getString("Name")
				+ "\nTelephone Number: " + result.getString("TelephoneNum")
				+ "\nEmail Address: " + result.getString("EmailAddress")
				+ "\nPhysical Adress: " + result.getString("PhysicalAdress") + "\n");
			}
			System.out.println("----------------------------------------------------------------");
			//Back to the main
			Poised.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void ViewContractor(Statement statement) throws SQLException{
		
		//View all projects from the structuralengineer database 
		try {
			//querythe structuralmanager database 
			String query = "SELECT * FROM structuralengineer";
			
			ResultSet result = statement.executeQuery(query);
			
			while (result.next()) {
				System.out.println("Name: " + result.getString("Name")
				+ "\nTelephone Number: " + result.getString("TelephoneNum")
				+ "\nEmail Address: " + result.getString("EmailAddress")
				+ "\nPhysical Address: " + result.getString("PhysicalAddress") + "\n");
			}
			System.out.println("----------------------------------------------------------------");
			//Back to the main
			Poised.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
}
