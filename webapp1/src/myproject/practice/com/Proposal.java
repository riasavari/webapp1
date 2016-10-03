package myproject.practice.com;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class Proposal {
	 @PrimaryKey
	  // @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private String key;

	    @Persistent
	    private int abstractId;
		
	 	@Persistent
	    private String year; 
	 	
	 	@Persistent
	    private String title; 
	 	
	 	@Persistent
	    private String category; 
	 	
	 	@Persistent
	    private String abstractDescription; 
	 	
	 	@Persistent
	    private String author; 
	 	
	 	@Persistent
	    private String url;
	 	
	 	@Persistent
	    private String project;


		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
		
		public String getProject() {
			return project;
		}

		public void setProject(String project) {
			this.project = project;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getAbstractId() {
			return abstractId;
		}

		public void setAbstractId(int abstractId) {
			this.abstractId = abstractId;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAbstractDescription() {
			return abstractDescription;
		}

		public void setAbstractDescription(String abstractDescription) {
			this.abstractDescription = abstractDescription;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		} 
	 	
	 	
	 	

}
