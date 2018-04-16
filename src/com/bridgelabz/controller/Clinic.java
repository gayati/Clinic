package com.bridgelabz.controller;

import java.io.FileNotFoundException;

import utility.Utility;

public class Clinic {

	public static void main(String[] args) throws FileNotFoundException {
		
		boolean flag =true;
		while(flag)
		{
		@SuppressWarnings("rawtypes")
		ClinicAdministrator clinicAdministrator = new ClinicAdministrator();

		System.out.println("\n\t======================SHREE CLINIC=============================\t\n");
		System.out.println("\t\t\t\t 1. ADD DETAILS \t\t\n");
		System.out.println("\t\t\t\t 2. SEARCH DEATAILS\t\t\n");
		System.out.println("\t\t\t\t 3. TAKE APPOINTEMENTS\t\t\n");
		System.out.println("\t\t\t\t 4. DISPLAY DETAILS\t\t\n");
		System.out.println("\t\t\t\t 5. SEARCH POPULAR DOCTOR\t\t\t\t\n");
		System.out.println("\t\t\t\t 6. CLOSE");
		
		System.out.println("Enter your choice: ");
		int choice = Utility.readInteger();
		
		switch (choice) {
		case 1:clinicAdministrator.addDetails();
			   break;
			   
		case 2:clinicAdministrator.searchDetails();
		       break;
		       
        case 3:clinicAdministrator.takeAppointment();
    	       break;
	
		
        case 4:clinicAdministrator.displayDetails();
 		       break;
     
        case 5:clinicAdministrator.searchPopularDoctor();
	       break;
       
        case 6:System.exit(0);
        
		default:flag =false;
			
		}
		}
	}

}
