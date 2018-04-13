package com.bridgelabz.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import beanpackage.Patient;

public interface AddDetailsInterface {
	
	 void addDetails() throws FileNotFoundException;
	 void addDoctors();
     Patient addPatient();
	 void takeAppointment();
}
