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
	    private String title; 
	 	
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
	    private long date;
	    
	    @Persistent
	    private long lastLoginDate;
	  
	    @Persistent
		private List<String> mailLists;

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
			this.firstname = firstname.substring(0, 1).toUpperCase()+firstname.substring(1).toLowerCase();
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
			this.lastname = lastname.substring(0, 1).toUpperCase()+lastname.substring(1).toLowerCase();
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email.toLowerCase();
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = UserService.hashPassword(password);
		}

		public long getDate() {
			return date;
		}

		public void setDate(long date) {
			this.date = date;
		}
	    public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getPosition() {
				return position;
			}

			public void setPosition(String position) {
				this.position = position.substring(0, 1).toUpperCase()+position.substring(1).toLowerCase();
			}
			
			public String getOrganisation() {
				return organisation;
			}

			public void setOrganisation(String organisation) {
				this.organisation = organisation.substring(0, 1).toUpperCase()+organisation.substring(1).toLowerCase();
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
