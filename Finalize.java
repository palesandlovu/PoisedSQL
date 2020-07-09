import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Finalize {

		//Finalize Projects and get invoice
		public static void finalizeProjects(Statement statement) {
			
			Scanner input = new Scanner(System.in);
			String customerName= "";
			
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date today = new Date();
			
			//Input project number or project name
			System.out.println("Enter Project Number or Project Name: ");
			String project = input.nextLine();
			
			try {
				/*
				 * query the projectmanager database
				 * If the projects Total Fee is not yet fully paid
				 * An Invoice is created
				 */
				String query = "SELECT * FROM projectmanager WHERE projectNum = " + "'" + project + "'" + "OR ProjectName = "
						+ "'" + project + "'";
				
				System.out.println("----------------------------------------------------------------");
				
				ResultSet result =statement.executeQuery(query);
				
				while (result.next()) {
					
					//Calculate projects remaining amount
					float remaining = result.getFloat("TotalFee" ) - result.getFloat("TotalAmout");
					
					/*
					 * If user didn't pay full amount
					 * An invoice is generated
					 */
					if (remaining != 0) {
						System.out.println("\n\t\t\tINVOICE\n");
						
						System.out.println("Project Number: " + result.getString("ProjectNum")
						+ "\nCustomer Name: " + (customerName = result.getString("CustomerName"))
						+ "\nRemaining Amount: R" + (remaining));
					}
					/*
					 * If the total fee is not paid fully
					 * The project will be finalized
					 */
					if (remaining == 0){
						System.out.println("FINALIZED - " + result.getString("ProjectName")
						+ "\nDate: " + format.format(today));
					}
				}
				//Query the customer database
				String customerQuery = "SELECT * FROM  customer WHERE Name = " + "'" + customerName + "'" ;
				ResultSet customerResult = statement.executeQuery(customerQuery);
				
				while (customerResult.next()) {
					//return user phone number and get current date
					System.out.println("Customer Telephone Number: " + customerResult.getString("TelephoneNum")
							+ "\nDate: " + format.format(today));
				}
				
				//Mark the project as completed
				String finalize = "UPDATE projectmanager SET Completed = 'yes' WHERE ProjectNum = " + "'" + project + "'";
				
				int countFinalize = statement.executeUpdate(finalize);
				System.out.println( "\n" + countFinalize + " record/s finalised");
				
				
				
				System.out.println("----------------------------------------------------------------");
				Poised.main();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
}
