package myproject.practice.com;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Publication {
	
    
   // @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@PrimaryKey
    @Persistent
    private String key;
	
	@Persistent
	private Date lastModifiedDate;
	
	@Persistent
	private Date firstEnteredDate;
	
    @Persistent
    private int publicationId;
    
    @Persistent
    private String pubIdStr4digit; 
    
    @Persistent
    private Boolean isVisible; 
	
 	@Persistent
    private String year; 
 	
 	@Persistent
    private String fund; 
 	
 	@Persistent
    private String status; 
 	
 	@Persistent
    private String article; 
 	
 	@Persistent
    private String author; 
 	
 	@Persistent
    private String title; 
 	
 	@Persistent
    private String venueName; 
 	
 	@Persistent
    private String descOutputOther;//currently holds description of output for peerreviewd and nonpeerreviewed articles 
 	
 	@Persistent
    private String page;
 	
 	@Persistent
    private String location; 
 	
 	@Persistent
    private String url; 
 	
 	@Persistent
    private String volume;

 	@Persistent
    private String publishDate; 
 	
 	@Persistent
    private String publisher;
 	
 	@Persistent
    private String project;

 	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public Date getlastModifiedDate() {
		return lastModifiedDate;
	}

	public void setlastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Date getfirstEnteredDate() {
		return firstEnteredDate;
	}

	public void setfirstEnteredDate(Date firstEnteredDate) {
		this.firstEnteredDate = firstEnteredDate;
	}
	public int getpublicationId() {
	    return publicationId;
	}
	public void setpublicationId(int publicationId) 
	{
	   this.publicationId=publicationId;
	}
	public String getpubIdStr4digit() {
	    return pubIdStr4digit;
	}
	public void setpubIdStr4digit(String pubIdStr4digit) 
	{
	   this.pubIdStr4digit=pubIdStr4digit;
	}
	public String getTitle() {
	    return title;
	}
	public void setTitle(String title) {
	    this.title = title.substring(0, 1).toUpperCase()+title.substring(1);
	}
	
	public Boolean getIsVisible() {
	    return isVisible;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getFund() {
		return fund;
	}
	
	public String getStatus() {
		return status;
	}
	public String getArticle() {
		return article;
	}
	public String getAuthor() {
		return author;
	}
	public String getVenueName() {
		return venueName;
	}
	public String getdescOutputOther() {
		return descOutputOther;
	}
	public String getPage() {
		return page;
	}
	public String getLocation() {
		return location;
	}
	public String getUrl() {
		return url;
	}
	public String getVolume() {
		return volume;
	}
	public String getpublishDate() {
		return publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getProject() {
		return project;
	}
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public void setAuthor(String author) {
		this.author = author.toUpperCase();
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName.substring(0, 1).toUpperCase()+venueName.substring(1);
	}
	public void setdescOutputOther(String descOutputOther) {
		this.descOutputOther = descOutputOther;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public void setpublishDate(String date) {
		this.publishDate = date;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setProject(String project) {
		this.project = project;
	}

}
