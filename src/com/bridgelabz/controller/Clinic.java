package com.bridgelabz.controller;

import java.io.FileNotFoundException;

import utility.Utility;

public class Clinic {

	public static void main(String[] args) throws FileNotFoundException {
		
		boolean flag =true;
		while(flag)
		{
		AddDetailsInterface adddetails = new AddDetails();
		SearchDetails searchdetails = new SearchDetails();
		DisplayDetails displaydetails = new DisplayDetails();
		
		System.out.println("\t======================SHREE CLINIC=============================\t\n");
		System.out.println("\t\t\t\t 1. ADD DETAILS \t\t\n");
		System.out.println("\t\t\t\t 2. SEARCH DEATAILS\t\t\n");
		System.out.println("\t\t\t\t 3. TAKE APPOINTEMENTS\t\t\n");
		System.out.println("\t\t\t\t 4. DISPLAY DETAILS\t\t\n");
		System.out.println("\t\t\t\t 5. SEARCH POPULAR DOCTOR\t\t\t\t\t");
		
		System.out.println("Enter your choice: ");
		int choice = Utility.readInteger();
		
		switch (choice) {
		case 1:adddetails.addDetails();
			   break;
			   
		case 2:searchdetails.searchDetails();
		       break;
		       
        case 3:adddetails.takeAppointment();
    	       break;
	
		
        case 4:displaydetails.displayDetails();
 		       break;
     
        case 5:searchdetails.searchPopularDoctor();
	       break;

		default:flag =false;
			
		}
		}
	}

}
