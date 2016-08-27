package databaseLayer;

public class Job {

	public int jobid;
	private String name;
	public String jobDescription;
	public boolean eligibility;
	
	public boolean geteligibility() {
		return eligibility;
	}
	
	public void seteligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}
	
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	
	public int getJobid() {
		return jobid;
	}
	
	public String getJobDescription() {
		return jobDescription;
	}
	
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
