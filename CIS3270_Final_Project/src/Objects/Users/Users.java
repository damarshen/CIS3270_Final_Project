package Objects.Users;

public class Users {
		private String firstName;
		private String lastName;
		private String Address;
		private int zipCode;
		private String state;
		private String username;
		private String password;
		private String email;
		private String ssn;
		private String securityQuestion;
		private String securityAnswer;
		private boolean adminStatus;

		public boolean isAdminStatus() {
			return adminStatus;
		}
		public void setAdminStatus(boolean adminStatus) {
			this.adminStatus = adminStatus;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		public int getZipCode() {
			return zipCode;
		}
		public void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public String getSecurityQuestion() {
			return securityQuestion;
		}
		public void setSecurityQuestion(String securityQuestion) {
			this.securityQuestion = securityQuestion;
		}
		public String getSecurityAnswer() {
			return securityAnswer;
		}
		public void setSecurityAnswer(String securityAnswer) {
			this.securityAnswer = securityAnswer;
		}



}

