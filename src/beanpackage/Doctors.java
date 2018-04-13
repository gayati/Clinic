package beanpackage;

public class Doctors 
{
	private String doctorname;
	private int id;
	private String specialisation;
	private int availability;
	private int noOfPatient;
//	private int noOfAppointement;
//	
//	public int getNoOfAppointement() {
//		return noOfAppointement;
//	}
//	public void setNoOfAppointement(int noOfAppointement) {
//		this.noOfAppointement = noOfAppointement;
//	}
//	public int getCount() {
//		return noOfPatient;
//	}
//	public void setCount(int count) {
//		this.noOfPatient = count;
//	}
	public String getDoctorname() {
		return doctorname;
	}
	@Override
	public String toString() {
		return "Doctors [doctorname=" + doctorname + ", id=" + id + ", specialisation=" + specialisation
				+ ", availability=" + availability + ", noOfPatient=" + noOfPatient + "]";
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public int getNoOfPatient() {
		return noOfPatient;
	}
	public void setNoOfPatient(int noOfPatient) {
		this.noOfPatient = noOfPatient;
	}
	

}
