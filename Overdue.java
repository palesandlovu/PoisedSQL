import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Overdue {

	//Overdue projects
	public static void overdueProjects(Statement statement) throws ParseException  {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		try {
			//query the projectmanager database
			String query = "SELECT * FROM projectmanager";
			ResultSet result = statement.executeQuery(query);
		
			while (result.next()) {
				
				String dueDate = result.getString("DueDate");
				/*
				 * If there are projects that are overdue
				 * Project information will be displayed.
				 */
				if (format.parse(dueDate).before(date)) {
					
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
				//If there are no over due projects a message will be displayed.
				else {
					System.out.println("NO OVERDUE PROJECTS!");
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
