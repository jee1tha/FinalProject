package databaseLayer;

public class Applicants extends Users{

	private String nicNo = null;
	private String birthDate = null;
	private int appID = 0;
	
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	
	public String getNicNo() {
		return nicNo;
	}
	
	public void setNicNo(String nicNo) {
		this.nicNo = nicNo;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
