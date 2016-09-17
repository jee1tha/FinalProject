package databaseLayer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Job {
        @XmlElement(name="jobid")
	public int jobid;
         @XmlElement(name="name")
	private String name;
          @XmlElement(name="jobDescription")
	public String jobDescription;
           @XmlElement(name="eligibility")
	public double eligibility;
            @XmlElement(name="skillScore")
	public double skillScore;
             @XmlElement(name="expQuaScore")
	public double expQuaScore;
              @XmlElement(name="finalScore")
	public double finalScore;
          @XmlElement(name="applicantID")
	public int applicantID;
	
	public int getApplicantID() {
		return applicantID;
	}
	
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	
	public double getSkillScore() {
		return skillScore;
	}
	public void setSkillScore(double skillScore) {
		this.skillScore = skillScore;
	}
	public double getExpQuaScore() {
		return expQuaScore;
	}
	public void setExpQuaScore(double expQuaScore) {
		this.expQuaScore = expQuaScore;
	}
	
	public double getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}
	
	public double geteligibility() {
		return eligibility;
	}
	
	public void seteligibility(double eligibility) {
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
