
public class PersonalInformation {
	
	//Customer class
	public static class Customer {
		//cutomer attributes
		static String customerName;
		static String customerTelnum;
		static String customerEmailAddr;
		static String customerPhysicalAddr; 

		//Customer constructor to assign all attributes
		public Customer(String custName, String custTel, String custEmail, String custPhysicalAdd) {
			Customer.customerName = custName;
			Customer.customerTelnum = custTel;
			Customer.customerEmailAddr = custEmail;
			Customer.customerPhysicalAddr = custPhysicalAdd;
		}
		
		//toString to Display Object
		public String toString() {
			String output = "Customer Details:\n";
			output += "\nName : " + customerName;
			output += "\nTelephone number: " + customerTelnum;
			output += "\nEmail Address: " + customerEmailAddr;
			output += "\nPhysical Address: " + customerPhysicalAddr;
			
			return output;
		}
	}
	
	//Architect class
	public static class Architect {
		
		//architect attributes
		static String architectName;
		static String architectTelnum;
		static String architectEmailAddr;
		static String architectPhysicalAddr; 
		
		//Architect constructor to assign attributes
		public Architect(String archName, String archTel, String archEmail, String archPhysicalAdd) {
			Architect.architectName = archName;
			Architect.architectTelnum = archTel;
			Architect.architectEmailAddr = archEmail;
			Architect.architectPhysicalAddr = archPhysicalAdd;
		}
		//toString to Display
		public String toString() {
			String output = "Architect Details:\n";
			output += "\nName : " + architectName;
			output += "\nTelephone number: " + architectTelnum;
			output += "\nEmail Address: " + architectEmailAddr;
			output += "\nPhysical Address: " + architectPhysicalAddr;
			
			return output;
		}
	}
	
	//Contractor class
	public static class Contractor {
		
		//Contractor attributes
		static String contractorName;
		static String contractorTelnum;
		static String contractorEmailAddr;
		static String contractorPhysicalAddr; 
		
		//Contractor constructor to assign attributes
		public Contractor(String contrName, String contrTel, String contrEmail, String contrPhysicalAdd) {
			Contractor.contractorName = contrName;
			Contractor.contractorTelnum = contrTel;
			Contractor.contractorEmailAddr = contrEmail;
			Contractor.contractorPhysicalAddr = contrPhysicalAdd;
		}
		
		//toString to Display
		public String toString() {
			String output = "Contractor Details:\n";
			output += "\nName : " + contractorName;
			output += "\nTelephone number: " + contractorTelnum;
			output += "\nEmail Address: " + contractorEmailAddr;
			output += "\nPhysical Address: " + contractorPhysicalAddr;
			
			return output;
		}
	}
}
