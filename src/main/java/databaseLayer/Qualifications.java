package databaseLayer;

public class Qualifications {

	private int id;
	private String Institute;
	private String Name;
	private boolean qualificationsEligibility;
	private String qClass;
	
	public String getqClass() {
		return qClass;
	}
	public void setqClass(String qClass) {
		this.qClass = qClass;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getInstitute() {
		return Institute;
	}
	
	public void setInstitute(String institute) {
		Institute = institute;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public boolean getQualificationsEligibility() {
		return qualificationsEligibility;
	}
	
	public void setQualificationsEligibility(boolean qualificationsEligibility) {
		this.qualificationsEligibility = qualificationsEligibility;
	}
	
	
	
}
