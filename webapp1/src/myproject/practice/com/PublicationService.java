package myproject.practice.com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Strings;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class PublicationService {
	public static synchronized ModelAndView  getPublicationNo(JSONObject pubJson,String emailId,HttpServletRequest request,HttpServletResponse response,ModelMap model,HttpSession session) throws Exception
	{
		int publicationNo=0;String number="";
		if (session != null && session.getAttribute("email") != null && emailId.equals(session.getAttribute("email"))) {
		//querying the total number of publications from Publication Table
		System.out.println("getPublicationNo in PublicationService");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Publication.class);  
		
		try {
			List<Publication> results =  (List<Publication>) q.execute();
			number=String.format("%1$04d",(results.size()+1));
			publicationNo=Integer.parseInt(number);
			if (results.isEmpty()) {
				model.addAttribute("allPublicationList", null);
			} else {
				model.addAttribute("allPublicationList", results);
			}

		} finally {
			q.closeAll();
			pm.close();
		}
		if(publicationNo > 0)
		{
			String aticleTitle=pubJson.get("title").toString();
		System.out.println(pubJson.get("year") + " -- " + pubJson.get("fund")+ "-- " + pubJson.get("project"));
		System.out.println(pubJson.get("venueName") + "-- " +pubJson.get("status")+ "-- " + pubJson.get("descOutputOther"));
		System.out.println(pubJson.get("volume") + "-- " + pubJson.get("article"));
		System.out.println(pubJson.get("page")+ "-- " + pubJson.get("title"));
		System.out.println(pubJson.get("location") + "-- " + pubJson.get("author"));
		System.out.println(pubJson.get("url") + "-- " + pubJson.get("dates") + " -- " + pubJson.get("publisher"));
		if (!Strings.isNullOrEmpty(pubJson.get("title").toString()) && !Strings.isNullOrEmpty(pubJson.get("author").toString())) {
			Publication newpub = new Publication();
			String uuid = UUID.randomUUID().toString();
			newpub.setKey(uuid);
			newpub.setfirstEnteredDate(new Date());
			newpub.setlastModifiedDate(new Date());
			newpub.setpublicationId(publicationNo);
			newpub.setpubIdStr4digit(number);
			newpub.setIsVisible(true);
			newpub.setYear(pubJson.get("year").toString());
			newpub.setFund(pubJson.get("fund").toString());
			newpub.setStatus(pubJson.get("status").toString());
			newpub.setArticle(pubJson.get("article").toString());
			newpub.setAuthor(pubJson.get("author").toString());
			newpub.setTitle(pubJson.get("title").toString());
			if (!Strings.isNullOrEmpty(pubJson.get("project").toString()))
				newpub.setProject(pubJson.get("project").toString());
			else
				newpub.setProject("");
			if (!Strings.isNullOrEmpty(pubJson.get("venueName").toString()))
				newpub.setVenueName(pubJson.get("venueName").toString());
			else
				newpub.setVenueName("");
			if (!Strings.isNullOrEmpty(pubJson.get("descOutputOther").toString()))
				newpub.setdescOutputOther(pubJson.get("descOutputOther").toString());
			else
				newpub.setdescOutputOther("");
			if (!Strings.isNullOrEmpty(pubJson.get("volume").toString()))
				newpub.setVolume(pubJson.get("volume").toString());
			else
				newpub.setVolume("");
			if (!Strings.isNullOrEmpty(pubJson.get("page").toString()))
				newpub.setPage(pubJson.get("page").toString());
			else
				newpub.setPage("");
			if (!Strings.isNullOrEmpty(pubJson.get("location").toString()))
				newpub.setLocation(pubJson.get("location").toString());
			else
				newpub.setLocation("");
			if (!Strings.isNullOrEmpty(pubJson.get("url").toString()))
				newpub.setUrl(pubJson.get("url").toString());
			else
				newpub.setUrl("");
			if (!Strings.isNullOrEmpty(pubJson.get("dates").toString()))
				newpub.setpublishDate(pubJson.get("dates").toString());
			else
				newpub.setpublishDate("");
			if (!Strings.isNullOrEmpty(pubJson.get("publisher").toString()))
				newpub.setPublisher(pubJson.get("publisher").toString());
			else
				newpub.setPublisher("");
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			try {
				pmf.makePersistent(newpub);
				saveNewUserPublication(emailId, publicationNo);// stores
																// into
																// the
																// UserPublication
																// table
				System.out.println(" ****************  " + number);
				request.setAttribute("pubNo", number);
				
				//To send email to user with publication number
				UserService.sendNewPubDeatilsToUser(emailId,number,aticleTitle);
				
				//return new ModelAndView("changed");
			} finally {
				pmf.close();
			}
		}
		}
		}
		else
		{
			if(session.getAttribute("email").equals(Constants.adminEmailId))
				return new ModelAndView("adminInvalidrequest");
			else
				return new ModelAndView("expiry");
		}
		return new ModelAndView("changed");
		
	}
	//to change the visibility of a publication by admin only
	public static String publicationVisibility(String pubId,ModelMap model,HttpSession session)
	{System.out.println("in publicationVisibility "+pubId);
	String nextpage="expiry";
	if (session != null && session.getAttribute("email") != null && session.getAttribute("email").equals(Constants.adminEmailId))
		{
		if(!Strings.isNullOrEmpty(pubId))
		{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(Publication.class);
			q.setFilter("publicationId == idParameter");
			q.declareParameters("String idParameter");
			try {
				List<Publication> results = (List<Publication>) q.execute(Integer.parseInt(pubId));
				
				if (!results.isEmpty()) {
					System.out.println(results.get(0).getIsVisible());
					Boolean pubStatus=results.get(0).getIsVisible();
					if(pubStatus)
						results.get(0).setIsVisible(false);
					else
						results.get(0).setIsVisible(true);
					nextpage="visibilityChanged";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				q.closeAll();
				pm.close();
			}
			
		}
		
		}
		return nextpage;
	}
	public static void saveNewUserPublication(String email, int displayNo) {
		System.out.println("coming to save a publication");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(UserPublication.class);
		q.setFilter("key == emailParameter");
		q.declareParameters("String emailParameter");

		try {
			List<UserPublication> results = (List<UserPublication>) q.execute(email);
			List<Integer> newlist = new ArrayList<Integer>();
			System.out.println(results.hashCode());
			if (!results.isEmpty()) {

				newlist = results.get(0).getPublicationList();
				newlist.add(displayNo);
				results.get(0).setPublicationList(newlist);

			} else {

				UserPublication userpub = new UserPublication();

				newlist.add(displayNo);

				userpub.setKey(email);
				userpub.setPublicationList(newlist);
				pm.makePersistent(userpub);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			q.closeAll();
			pm.close();
		}

	}

	public static void saveNewUserAbstract(String email, int absNo) {
		System.out.println("coming to save an abstract in saveUserAbstract()");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(UserPublication.class);
		q.setFilter("key == emailParameter");
		q.declareParameters("String emailParameter");

		try {
			List<UserPublication> results = (List<UserPublication>) q.execute(email);
			List<Integer> newlist = new ArrayList<Integer>();
			System.out.println(results.hashCode());
			if (!results.isEmpty()) {

				newlist = results.get(0).getAbstractList();
				newlist.add(absNo);
				results.get(0).setAbstractList(newlist);

			} else {

				UserPublication userpub = new UserPublication();

				newlist.add(absNo);

				userpub.setKey(email);
				userpub.setAbstractList(newlist);
				pm.makePersistent(userpub);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			q.closeAll();
			pm.close();
		}

	}
	
	public static String  updatePublicationDetails(String emailId,int publicationId,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception
	{ 
		PersistenceManager pm = PMF.get().getPersistenceManager();
		System.out.println("in updatePublicationDetails");
		HashMap<String, String> hash = new HashMap<>();
		String nextpage="newpublication";
		Query q = pm.newQuery(Publication.class);
		
		q.setFilter("publicationId == filterParameter");
		//q.setOrdering("date desc");
		q.declareParameters("int filterParameter");
		try {
			List<Publication> results = (List<Publication>) q.execute(publicationId);
			System.out.println(results.get(0).getKey());
			if (!results.isEmpty()) {
				
					request.setAttribute("pub",results);
					//request.setAttribute("lastName",results.get(0).getLastname().toString());
					
			}
		}
		catch (Exception e) {
			
		}
		finally {
			q.closeAll();
			pm.close();
		}
		return nextpage;
			
	}
	
	

}
