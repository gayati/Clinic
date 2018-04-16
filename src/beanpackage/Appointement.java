package beanpackage;

public class Appointement {
 
	private String doctorName;
	private Patient patient;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
//	private int availability;
//	private int numberOfpatient;
//	
//	public int getNumberOfpatient() {
//		return numberOfpatient;
//	}
//	public void setNumberOfpatient(int numberOfpatient) {
//		this.numberOfpatient = numberOfpatient;
//	}

	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
//	public int getAvailability() {
//		return availability;
//	}
//	public void setAvailability(int availability) {
//		this.availability = availability;
//	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Appointement [doctorName=" + doctorName + ", patient=" + patient + ", date=" + date + "]";
	}
	
	
	
	
	
	
}
