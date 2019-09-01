public class Faculty {
	
	private String Id;
	private String Dept;
	private String Pswd;
	private String Email;
	private String Phno;
	public void setID(String id) {
		Id = id;
	}
	
	public void setDept(String dept) {
		Dept = dept;
	}
	
	public void setPassword(String pswd) {
		Pswd = pswd;
	}
	
	public void setEmail(String email) {
		Email=email;
	}
	
	public void setPhno(String phno) {
		Phno=phno;
	}
	
	public String getID() {
		return Id;
	}
	
	public String getDept() {
		return Dept;
	}
	
	public String getPassword() {
		return Pswd;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getPhno() {
		return Phno;
	}
}
