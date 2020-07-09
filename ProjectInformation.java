
public class ProjectInformation {
	
	//attribues
	static String projectNum;
	static String projectName;
	static String buildingType;
	static String physicalAdd;
	static String erfNum;
	static double totalFee;
	static double totalPaid;
	static String deadline;
	static String customerName;
	static String architectName;
	static String contractorName;
	static String completed;
	
	//Constructor method to set all the attributes.
	public ProjectInformation(String projectNum, String projectName, String type, String physicalAdd, String erfNum, double totalFee, double totalPaid, String deadline, String customerName, String architectName, String contratorName, String completed) {
		ProjectInformation.projectNum = projectNum;
		ProjectInformation.projectName = projectName;
		ProjectInformation.buildingType = type;
		ProjectInformation.physicalAdd = physicalAdd;
		ProjectInformation.erfNum = erfNum;
		ProjectInformation.totalFee = totalFee;
		ProjectInformation.totalPaid = totalPaid;
		ProjectInformation.deadline = deadline;
		ProjectInformation.customerName = customerName;
		ProjectInformation.architectName = architectName;
		ProjectInformation.contractorName = contratorName;
		ProjectInformation.completed = completed;
	}
	
	//toString to Display Object
	public String toString() {
		
		String output = "\nProject Details:\n";
		output += "";
		output += "\nProject Number: " + projectNum;
		output += "\nProject Name: " + projectName;
		//If there is no user name, create one using customer last name and tyoe of building
		if (projectName.isEmpty()) {
			String[] newName = PersonalInformation.Customer.customerName.split(" ");
			String[] newBuildingname = buildingType.split("");
			projectName = newBuildingname[0]
					+ " " + newName[1];
			output += "\nProject Name: " + projectName;
		}
		output += "\nBuilding Type: " + buildingType;
		output += "\nPhysical Address: " + physicalAdd;
		output += "\nERF Number: " + erfNum;
		output += "\nTotal Fee: R" + totalFee;
		output += "\nTotal Amount Paid To Date: R" + totalPaid;
		output += "\nDue Date: " + deadline;
		output += "\nCustomer Name: " + customerName;
		output += "\nArchitect Name: " + architectName;
		output += "\nContractor Name: " + contractorName;
		
		return output;
	}

}
