package com.bridgelabz.controller;

import java.util.List;
import beanpackage.*;
import beanpackage.Doctors;
import beanpackage.Patient;
import utility.Utility;

public class DisplayDetails implements DisplayIDetailsInterface {

	@Override
	public void printPopulardoctor() {
				
	}

	@Override
	public void displayDetails() {
		boolean flag = true;

		while (flag) {
			System.out.println("\t\t\t\t 1. DISPLAY DOCTORS \t\t\t\t\n");
			System.out.println("\t\t\t\t 1. DISPLAY PATIENTS \t\t\t\t\n");
			System.out.println("\t\t\t\t 3. DISPLAY APPOINTEMENTS \t\t\t\t\n");
			System.out.println("\t\t\t\t 4. BACK \t\t\t\t");
			System.out.println("Enter your choice");
			int choice = Utility.readInteger();

			switch (choice) {
			case 1:
				displayDoctors();
				break;
			
			case 2:
				displayPatient();
				break;
		   
			case 3:
				displayAppointements();
				break;
				
			case 4:
				flag = false;
				System.out.println();

			}
		}
		
	}

	@Override
	public void displayDoctors() {
		
		List<Doctors> doctorlist = Utility.readFile("doctor.json", Doctors[].class);
		
		 for(int i = 0; i<doctorlist.size();i++)
		 {
		 Doctors doctor = doctorlist.get(i);
		 String doctorName = doctor.getDoctorname();
		 int availability =  doctor.getAvailability();
		 String specialisation = doctor.getSpecialisation(); 
		 int id = doctor.getId();
		 System.out.println("The Doctor Details are as follows: ");
	   
		 System.out.println("\t\t\t\t************* Doctor ***************\t\t\t\t");
		 System.out.println("\t\t\t\t Doctor Name:  " + doctorName);
		 System.out.println("\t\t\t\t Doctor Id:  "  + id);
		 System.out.println("\t\t\t\t Doctor Specialisation:" + specialisation);

		
		 if(availability == 1)
		 {
		 System.out.println("\t\t\t\t Availability: " +availability+ " (AM)");
		 }
		 else if (availability==2)
		 {
			 System.out.println("\t\t\t\t Availability: " +availability+ " (PM)");
		 }
		 else
		 {
			 System.out.println("\t\t\t\t Availability: " +availability+ " (BOTH)");
		 }
		 System.out.println("\t\t\t\t*****************************************");
		 System.out.println();	
	}
	}
	
	@Override
	public void displayPatient() {
		
		List<Patient> patientlist = Utility.readFile("patient.json",Patient[].class);
		
		 for(int i = 0; i<patientlist.size();i++)
		 {
		   Patient patient = patientlist.get(i);
		   String patientName = patient.getPatientname();
		   int patientId = patient.getId();
	      long mobilenumber = patient.getMobileno();
		  int age = patient.getAge();
		 
		 System.out.println("\t\t\t\t************* Patient ***************");
		 System.out.println("\t\t\t\t Patient Name:  " + patientName);
		 System.out.println("\t\t\t\t Patient Id:  "  + patientId );
		 System.out.println("\t\t\t\t Mobile Number:" + mobilenumber);
		 System.out.println("\t\t\t\t Patient Age: " + age);
		 System.out.println("\t\t\t\t*****************************************");
		 System.out.println();	
	}
	}
	
	
	@Override
	public void displayAppointements() {

		List<Appointement> appointementlist = Utility.readFile("appointement.json", Appointement[].class);
		
		 for(int i = 0; i<appointementlist.size();i++)
		 {
		   Appointement appointement = appointementlist.get(i);	
		   System.out.println(appointement.toString());
		   System.out.println();
		 }
	}
	
	
}
