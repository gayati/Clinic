package com.bridgelabz.controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import beanpackage.Appointement;
import beanpackage.Doctors;
import beanpackage.Patient;
import utility.Utility;

public class AddDetails<T> implements AddDetailsInterface {
	private List<Doctors> doctorlist ;
	private List<Patient> patientlist;
    private  List<Appointement> appointementlist;
    
	public void addDetails() {
		boolean flag = true;

		while (flag) {
			System.out.println("\t\t\t\t 1. ADD DOCTORS\t\t\t\t\n");
			
			//System.out.println("\t\t\t\t 2. TAKE APPOINTEMENT\t\t\t\t\n");
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
		int availability = Utility.readInteger();
		doctor.setAvailability(availability);
		
		
		
		doctorlist.add(doctor);
		System.out.println(doctorlist);
		Utility.saveDetails("doctor.json", doctorlist);
	}

	@Override
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
		patient.setMobileno(mobileno);

		System.out.println("Enter the age of patient");
		int age = Utility.readInteger();
		patient.setAge(age);

		patientlist.add(patient);
		System.out.println(patientlist);
		Utility.saveDetails("patient.json", patientlist);
        return patient;
	}
     
	
	
	@Override
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
			   
			   if(doctor.getNoOfPatient()==0)
			   {
				   System.out.println("Enter date");
				   String date= Utility.readString();
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
			   else if(doctor.getNoOfPatient()>0 && doctor.getNoOfPatient()<5)
			   {
				   System.out.println("Enter date");
				   String date= Utility.readString();
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