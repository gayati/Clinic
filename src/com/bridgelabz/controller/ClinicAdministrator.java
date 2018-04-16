package com.bridgelabz.controller;



import java.util.List;
import java.util.regex.Pattern;

import beanpackage.Appointement;
import beanpackage.Doctors;
import beanpackage.Patient;
import utility.Utility;

public class ClinicAdministrator<T> {
	
	private List<Doctors> doctorlist ;
	private List<Patient> patientlist;
    private  List<Appointement> appointementlist;
    
	public void addDetails() {
		
		boolean flag = true;

		while (flag) {
			System.out.println("\t\t\t\t 1. ADD DOCTORS\t\t\t\t\n");
			
			
			System.out.println("\t\t\t\t 2. BACK\t\t\t\t");
			System.out.println("Enter your choice");
			int choice = Utility.readInteger();

			switch (choice) {
			case 1:
				addDoctors();
				break;
		
			case 2:
				flag = false;
				System.out.println();

			}
		}
	}

	public void addDoctors() {
        
		doctorlist = Utility.readFile("doctor.json", Doctors[].class);
		System.out.println(doctorlist);
		Doctors doctor = new Doctors();

		System.out.println("Enter the doctor name:");
		String doctorname = Utility.readString();
		doctor.setDoctorname(doctorname);

		System.out.println("the doctor Id: " + (doctorlist.size()+1));
		doctor.setId(doctorlist.size()+1);

		System.out.println("Enter the Doctors Specialization:");
		String specialisation = Utility.readString();
		doctor.setSpecialisation(specialisation);

		System.out.println("Enter the Availability:(1.AM 2.PM 3.Both)");
		String availability = Utility.readString().toUpperCase();
		doctor.setAvailability(availability);
	
		doctorlist.add(doctor);
		System.out.println(doctorlist);
		Utility.saveDetails("doctor.json", doctorlist);
	}

	public Patient addPatient() {

		patientlist =Utility.readFile("patient.json", Patient[].class);
		Patient patient = new Patient();
		System.out.println("Enter the name of patient");
		String patientname = Utility.readString();
		patient.setPatientname(patientname);

		 System.out.println("the patient Id: " +(patientlist.size()+1));
		 patient.setId(patientlist.size()+1);
		
		
		System.out.println("Enter the mobile number:");
		long mobileno = Utility.readLong();
		String mobilepattern = "(0/91)?[7-9][0-9]{9}";
	    while(Pattern.matches(mobilepattern,String.valueOf(mobileno))==false)
	    {
	    	System.out.println("Please enter proper mobile number: ");
	    	mobileno = Utility.readLong();
	    }
		patient.setMobileno(mobileno);

		System.out.println("Enter the age of patient");
		int age = Utility.readInteger();
		patient.setAge(age);

		patientlist.add(patient);
		
		System.out.println(patientlist);
		Utility.saveDetails("patient.json", patientlist);
        return patient;
	}
     
	
	
	public void takeAppointment() {
		
		Appointement appointement = new Appointement();
		appointementlist = Utility.readFile("appointement.json", Appointement[].class);
		boolean found=false;
	    Patient patient = new Patient();
		System.out.println("Enter the doctor name:");
		String doctorname = Utility.readString();
		
		doctorlist = Utility.readFile("doctor.json", Doctors[].class);
		
		
		 for(int i = 0; i<doctorlist.size();i++)
		 {
		   Doctors doctor = doctorlist.get(i);
		   	   
		   if((doctor.getDoctorname().equals(doctorname)))
		   {   
			   System.out.println("Enter date");
			   String date= Utility.readString();
			   
			   for(i=0; i<appointementlist.size(); i++)
			     {
				   appointement = appointementlist.get(i);
			   
			   if((appointement.getDoctorName().equals(doctorname)) && (appointement.getDate().equals(date)) && (doctor.getNoOfPatient()==0))
			   {
				   
				   patient = addPatient();
				   doctor.setNoOfPatient(1);
				   
				   Utility.saveDetails("doctor.json",doctorlist );
				   appointement.setDoctorName(doctorname);
				   appointement.setPatient(patient);
				   appointement.setDate(date);
				   appointementlist.add(appointement);
				   Utility.saveDetails("appointement.json", appointementlist);
				   System.out.println("Appointement is fixed");
				   found=true;
				   break;
			   }
			   else if(appointement.getDoctorName().equals(doctorname) && (appointement.getDate().equals(date)) && (doctor.getNoOfPatient()>0 && doctor.getNoOfPatient()<5))
			   {
//				   
				   patient = addPatient();
				   doctor.setNoOfPatient(doctor.getNoOfPatient() +1);
				   
				   Utility.saveDetails("doctor.json",doctorlist );
				   appointement.setDoctorName(doctorname);
				   appointement.setPatient(patient);
				   appointement.setDate(date);
				   appointementlist.add(appointement);
				   Utility.saveDetails("appointement.json", appointementlist);
				   System.out.println("Appointement is fixed");
				   found=true;
				   break;
			   }
			   else
			   {
				   System.out.println("The doctor with name " +doctorname +" is not available" );
			   }
		   }
		 }
		 }
		 
	}
				   
	
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

	
	public void displayDoctors() {
		
		List<Doctors> doctorlist = Utility.readFile("doctor.json", Doctors[].class);
		
		 for(int i = 0; i<doctorlist.size();i++)
		 {
		 Doctors doctor = doctorlist.get(i);
		 String doctorName = doctor.getDoctorname();
		 String availability =  doctor.getAvailability();
		 String specialisation = doctor.getSpecialisation(); 
		 int id = doctor.getId();
		 System.out.println("The Doctor Details are as follows: ");
	   
		 System.out.println("\t\t\t\t************* Doctor ***************\t\t\t\t");
		 System.out.println("\t\t\t\t Doctor Name:  " + doctorName);
		 System.out.println("\t\t\t\t Doctor Id:  "  + id);
		 System.out.println("\t\t\t\t Doctor Specialisation:" + specialisation);
		 System.out.println("\t\t\t\t Availability: " +availability); 

		
//		 if(availability == 1)
//		 {
//		 System.out.println("\t\t\t\t Availability: " +availability+ " (AM)");
//		 }
//		 else if (availability==2)
//		 {
//			 System.out.println("\t\t\t\t Availability: " +availability+ " (PM)");
//		 }
//		 else
//		 {
//			 System.out.println("\t\t\t\t Availability: " +availability+ " (BOTH)");
//		 }
		 System.out.println("\t\t\t\t*****************************************");
		 System.out.println();	
	}
	}
	
	
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
	
	
	
	public void displayAppointements() {

		List<Appointement> appointementlist = Utility.readFile("appointement.json", Appointement[].class);
		
		 for(int i = 0; i<appointementlist.size();i++)
		 {
		   Appointement appointement = appointementlist.get(i);	
		   System.out.println(appointement.toString());
		   System.out.println();
		 }
	}
	
	       
	public void searchDetails() {
		boolean flag = true;

		while (flag) {
			System.out.println("\t\t\t\t 1. SEARCH DOCTORS\t\t\t\t\n");
			System.out.println("\t\t\t\t 2. SEARCH PATIENT\t\t\t\t\n");
			System.out.println("\t\t\t\t 3. BACK \t\t\t\t\n");
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

	
	
	public void displayDoctors(Doctors doctor ) {
		
		String doctorName = doctor.getDoctorname();
		 String availability =  doctor.getAvailability();
		 String specialisation = doctor.getSpecialisation(); 
		 int id = doctor.getId();
		System.out.println("The Doctor Details are as follows: ");
	   
		 System.out.println("\t\t\t\t************* Doctor ***************\t\t\t\t");
		 System.out.println("\t\t\t\t Doctor Name:  " + doctorName);
		 System.out.println("\t\t\t\t Doctor Id:  "  + id);
		 System.out.println("\t\t\t\t Doctor Specialisation:" + specialisation);
		 System.out.println("\t\t\t\t Availability: " +availability); 

		
//		 if(availability == 1)
//		 {
//		 System.out.println("\t\t\t\t Availability: " +availability+ " (AM)");
//		 }
//		 else if (availability==2)
//		 {
//			 System.out.println("\t\t\t\t Availability: " +availability+ " (PM)");
//		 }
//		 else
//		 {
//			 System.out.println("\t\t\t\t Availability: " +availability+ " (BOTH)");
//		 }
		 System.out.println("\t\t\t\t*****************************************");
		 System.out.println();			
	}


	
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