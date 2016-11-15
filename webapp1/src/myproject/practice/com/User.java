package myproject.practice.com;


import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class User {
		@PrimaryKey
	    @Persistent
	    private String key;
		
		@Persistent
	    private String orcId; 
	 	
	 	@Persistent
	    private Boolean active; 
	 	
	    @Persistent
	    private String firstname;
	    
	    @Persistent
	    private String lastname;
		
		@Persistent
	    private String position;
		
		@Persistent
	    private String organisation;
		
		@Persistent
		private String category; 
	    
	    @Persistent
	    private String email;
	    
	    @Persistent
	    private String password;
		
	    @Persistent
	    private Date signupdate;
	    
	    @Persistent
	    private Date lastLoginDate;
	  
	    @Persistent
		private List<String> mailLists;
	    
	    @Persistent
	    private String comments;
	    
	    @Persistent
	    private String gender;
	    
	    @Persistent
	    private String country;
	    
	    @Persistent
	    private String ethnicity;
	    
	    @Persistent
	    private String iwi;
	    
	    
	    
		public String getCountry() {
			return country;
		}
		public String getEthnicity() {
			return ethnicity;
		}
		public String getIwi() {
			return iwi;
		}
		
		
		public void setCountry(String country) {
			this.country = country;
		}
		public void setEthnicity(String ethnicity) {
			this.ethnicity = ethnicity;
		}
		public void setIwi(String iwi) {
			this.iwi = iwi;
		}
		
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname.substring(0, 1).toUpperCase()+firstname.substring(1);
		}

		public String getLastname() {
			return lastname;
		}
		
		public Boolean getActive() {
			return active;
		}

		public void setActive(Boolean active) {
			this.active = active;
		}
		
		public void setLastname(String lastname) {
			this.lastname = lastname.substring(0, 1).toUpperCase()+lastname.substring(1);
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email.toLowerCase();
		}
		
		public String getOrcId() {
			return orcId;
		}

		public void setOrcId(String orcId) {
			this.orcId = orcId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = UserService.hashPassword(password);
		}

		public Date getSignupdate() {
			return signupdate;
		}

	    public void setSignupdate(Date signupdate) {
			this.signupdate = signupdate;
		}

			public Date getLastLoginDate() {
				return lastLoginDate;
			}
			public void setLastLoginDate(Date lastLoginDate) {
				this.lastLoginDate = lastLoginDate;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position.substring(0, 1).toUpperCase()+position.substring(1);
			}
			
			public String getOrganisation() {
				return organisation;
			}

			public void setOrganisation(String organisation) {
				this.organisation = organisation.substring(0, 1).toUpperCase()+organisation.substring(1);
			}

			public String getCategory() {
				return category;
			}

			public void setCategory(String category) {
				this.category = category;
			}

			public List<String> getMailLists() {
				return mailLists;
			}

			public void setMailLists(List<String> mailLists) {
				this.mailLists = mailLists;
			}
	    
	    
}
