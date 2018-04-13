package com.bridgelabz.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import beanpackage.Doctors;
import beanpackage.Patient;
import utility.Utility;

public class SearchDetails implements SearchDetailsInterface{

	@Override
	public void searchDetails() {
		boolean flag = true;

		while (flag) {
			System.out.println("\t\t\t\t 1. SEARCH DOCTORS\t\t\t\t\n");
			System.out.println("\t\t\t\t 2. SEARCH PATIENT\t\t\t\t\n");
			System.out.println("\t\t\t\t 3. BACK\t\t\t\t\n");
			System.out.println("Enter your choice");
			int choice = Utility.readInteger();

			switch (choice) {
			case 1:
				searchDoctors();
				break;
			case 2:
				searchPatient();
				break;
		
			case 3:
				flag = false;
				
			}
		}
	}

	@Override
	public void searchDoctors() {
		System.out.println("\t\t\t\t\t Search Doctor by:        ");
		System.out.println("\t\t\t\t\t 1.Doctor Name:  ");
		System.out.println("\t\t\t\t\t 2.Doctor Id:  ");
		System.out.println("\t\t\t\t\t 3.Doctor Specialization: ");
		
		int choice = Utility.readInteger();
		switch (choice) {
		case 1:searchDoctorByName();
			
			break;
	   
       case 2:searchDoctorById();
			
			break;
	  
       case 3:searchDoctorBySpecialisation();
			
			break;

		default:
			break;
		}
		
	}

	@Override
	public void searchPatient() {
		System.out.println("\t\t\t\t Search Patient by:        ");
		System.out.println("\t\t\t\t 1.Patient Name:         ");
		System.out.println("\t\t\t\t 2.Patient Id:   ");
	
		int choice = Utility.readInteger();
		switch (choice) {
		case 1:searchPatientByName();
			
			break;
	   
       case 2:searchPatientById();
			
			break;
	  

		default:System.out.println("Invalid Choice");
			break;
		}
	}
     
	
	@Override
	public void searchDoctorByName() {
		boolean found =false;
		System.out.println("Enter the doctor name: ");
		String name = Utility.readString();
		
		List<Doctors> doctorList = Utility.readFile("doctor.json", Doctors[].class);
		
		 for(int i = 0; i<doctorList.size();i++)
		 {
		   Doctors d = doctorList.get(i);
		   if(d.getDoctorname().equals(name))
		   {
			     System.out.println(d.toString());
				 //displayDoctors(d); 
				 found=true;
		   }
		   }
		 if(found==false)
		 {
			 System.out.println("Doctor is not available.");
		 }	
	    }

	@Override
	public void searchDoctorById() {
		boolean found =false;
		System.out.println("Enter the doctor ID: ");
		int id = Utility.readInteger();
		
		List<Doctors> doctorList = Utility.readFile("doctor.json", Doctors[].class);
		
		 for(int i = 0; i<doctorList.size();i++)
		 {
		   Doctors d = doctorList.get(i);
		   if(d.getId()==id)
		   {
			    
				 displayDoctors(d);   
				 found=true;
		   }
		   }
		 if(found==false)
		 {
			 System.out.println("Doctor is not available.");
		 }	
	    }

	@Override
	public void searchDoctorBySpecialisation() {
		boolean found =false;
		
		System.out.println("Enter the doctor ID: ");
		int id = Utility.readInteger();
		
		 List<Doctors> doctorList = Utility.readFile("doctor.json", Doctors[].class);
		 
		 for(int i = 0; i<doctorList.size();i++)
		 {
		   Doctors doctor = doctorList.get(i);
		   if(doctor.getId()==id)
		   {
			   
				 displayDoctors(doctor);   
				 found=true;
		   }
		   }
		 if(found==false)
		 {
			 System.out.println("Doctor is not available.");
		 }	
	    }

	
	@Override
	public void displayDoctors(Doctors doctor ) {
		
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


	@Override
	public void searchPatientByName() {
		
		boolean found = false;
		System.out.println("Enter the patientname: ");
		String patientName = Utility.readString();
		
		List<Patient> patientlist = Utility.readFile("patient.json",Patient[].class);
		
		 for(int i = 0; i<patientlist.size();i++)
		 {
		   Patient patient = patientlist.get(i);
		   if(patient.getPatientname().equals(patientName))
		   {
			   System.out.println("Patient is present ");  
				 //displayPatient(patient);  
			   System.out.println(patient.toString());
				 found = true;
				 
		   }}	 
				 if(found==false)
				 {
					 System.out.println("Patient Not Found");
				 }		
		   }
	
	@Override
	public void searchPatientById() {
		boolean found = false;
		System.out.println("Enter the patientId: ");
		int id = Utility.readInteger();
		
		List<Patient> patientList = Utility.readFile("patient.json",Patient[].class);
		
		 for(int i = 0; i<patientList.size();i++)
		 {
		   Patient patient = patientList.get(i);
		   if(patient.getId()==id)
		   {
			   
				 displayPatient(patient);   
				 found = true;
				 
		   }
		   }	 
				 if(found==false)
				 {
					 System.out.println("Patient Not Found");
				 }		
		   }

	
	@Override
	public void displayPatient(Patient patient)
	{
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
	
	public void searchPopularDoctor()
	{
		List<Doctors> doctorList = Utility.readFile("doctor.json", Doctors[].class);
		
		 for(int i = 0; i<doctorList.size();i++)
		 {
		   Doctors doctor = doctorList.get(i);
		   if(doctor.getNoOfPatient() ==5) {
			   displayDoctors(doctor);
		   }
		 }
	}
}
