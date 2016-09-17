package databaseLayer;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Skills {
    @XmlElement(name="skillID")
	 private int skillID; 
 @XmlElement(name="skillName")
	 private ArrayList<String>  skillName;
    @XmlElement(name="skill")
	 private String skill;
    @XmlElement(name="seligibility")
	 private boolean seligibility;
	
     public ArrayList<String> getSkillName() {
		return skillName;
	}
        
	 public void setSkillName(ArrayList<String> skillName) {
		this.skillName = skillName;

	 }
	 public boolean getSeligibility() {
		return seligibility;
	}
	 public void setSeligibility(boolean seligibility) {
		this.seligibility = seligibility;
	}
	 
	 public String getSkill() {
		return skill;
	}
	 public void setSkill(String skill) {
		this.skill = skill;
	}

	 public int getSkillID() {
		return skillID;
	}
	 public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
	 
	



}


