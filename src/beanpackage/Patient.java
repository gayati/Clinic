package beanpackage;

public class Patient {
  
	private String patientname;
	private int id;
	private long  mobileno;
	private int age;
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Patient [patientname=" + patientname + ", patientid=" + id + ", mobileno=" + mobileno + ", age="
				+ age + "]";
	}
	
}
