package databaseLayer;

import java.util.ArrayList;

public class Skills {
	 private int skillID; 
	 private ArrayList<String>  skillName;
	 private String skill;
	 
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
	 
	 public ArrayList<String> getSkillName() {
		return skillName;
	}
	 public void setSkillName(ArrayList<String> skillName) {
		this.skillName = skillName;

	 }



}


