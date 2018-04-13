package com.bridgelabz.controller;

import beanpackage.Doctors;
import beanpackage.Patient;

public interface SearchDetailsInterface {
	
	 void searchDetails();
	 void searchDoctors();
	 void searchDoctorByName();
	 void searchDoctorById();
	 void searchDoctorBySpecialisation();
	 void displayDoctors(Doctors d);
	 
	 void searchPatient();
	 void searchPatientByName();
	 void searchPatientById();
	 void displayPatient(Patient patient);
	
}
