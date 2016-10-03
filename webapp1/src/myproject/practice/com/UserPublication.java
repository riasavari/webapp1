package myproject.practice.com;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class UserPublication {
	
	@PrimaryKey
    @Persistent
    private String key;

	@Persistent
	private List<Integer> publicationList;
	
	@Persistent
	private List<Integer> abstractList;
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Integer> getPublicationList() {
		return publicationList;
	}

	public void setPublicationList(List<Integer> publicationList) {
		this.publicationList = publicationList;
	}

	public List<Integer> getAbstractList() {
		return abstractList;
	}

	public void setAbstractList(List<Integer> abstractList) {
		this.abstractList = abstractList;
	}

}
