package databaseLayer;

public class Experience {

	private String organization ;
	private String Post;
	private  boolean exeligibility;
	private int duration;
	private boolean ueeligibility;
	private int expid;
	
	public int getExpid() {
		return expid;
	}
	
	public void setExpid(int expid) {
		this.expid = expid;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getOrganization() {
		return organization;
	}
	
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	public boolean getExeligibility() {
		return exeligibility;
	}
	
	public void setExeligibility(boolean exeligibility) {
		this.exeligibility = exeligibility;
	}
	
	public boolean getUeeligibility() {
		return ueeligibility;
	}
	
	public void setUeeligibility(boolean ueeligibility) {
		this.ueeligibility = ueeligibility;
	}
	
	public String getPost() {
		return Post;
	}
	
	public void setPost(String post) {
		Post = post;
	}
	

	
	
	
	
	
}
