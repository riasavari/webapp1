package myproject.practice.com;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Admin {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
    @Persistent
    private String msg;
	
    @Persistent
    private String password;
    
    @Persistent
    private String email;
   
	public Key getKey() {
		return key;
	}

	public String getMsg() {
		return msg;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}