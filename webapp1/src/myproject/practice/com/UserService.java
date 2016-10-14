package myproject.practice.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class UserService {
	
	public static String  getUserData(String emailId,HttpServletRequest request,HttpServletResponse response,ModelMap model,HttpSession session) throws Exception
	{ 
		PersistenceManager pm = PMF.get().getPersistenceManager();
		System.out.println("in getUserData");
		String nextpage = "editprofile";
		if(session.getAttribute("email").equals(Constants.adminEmailId))
			nextpage="userActivation";
		
		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			System.out.println(results.get(0).getOrganisation().toString());
			if (!results.isEmpty()) {
				System.out.println(results.get(0).getCategory().toString());

				request.setAttribute("firstName", results.get(0).getFirstname().toString());
				request.setAttribute("lastName", results.get(0).getLastname().toString());
				request.setAttribute("title", results.get(0).getTitle().toString());
				request.setAttribute("position", results.get(0).getPosition().toString());
				request.setAttribute("organisation", results.get(0).getOrganisation().toString());
				request.setAttribute("category", results.get(0).getCategory().toString());
				request.setAttribute("active", results.get(0).getActive().toString());
				request.setAttribute("newUserAcc", results.get(0).getEmail().toString());
			}
		} catch (Exception e) {

		} finally {
			q.closeAll();
			pm.close();
		}
		return nextpage;
			
	}
	
public static String activateUser(String useremail,String userStatus,ModelMap model,HttpSession session)
{System.out.println("in activateUser "+userStatus);
String nextpage="expiry";
	if(session.getAttribute("email").equals(Constants.adminEmailId))
	{
	if(!Strings.isNullOrEmpty(useremail))
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(User.class);
		q.setFilter("email == emailParameter");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(useremail);
			System.out.println(results.get(0).getOrganisation().toString());
			if (!results.isEmpty()) {
				System.out.println(results.get(0).getActive());
				if(userStatus.equals("false"))
					results.get(0).setActive(true);
				else
					results.get(0).setActive(false);
				nextpage="userStatusChanged";
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


	public static String  getUserSubscriptions(String emailId,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		System.out.println("getUserSubscriptions");
		String subslist = "";
		String nextpage = "mailinglist";
		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			System.out.println(results.size());
			if (!results.isEmpty()) {
				System.out.println(results.get(0).getEmail());

				if (Strings.isNullOrEmpty(results.get(0).getMailLists().toString())) {
					System.out.println("Its NUll here...");
				}

				else {
					subslist = results.get(0).getMailLists().toString();
					if (!Strings.isNullOrEmpty(subslist)) {
						System.out.println(subslist + " contents sublist");
						request.setAttribute("subslist", subslist);

					} else {
						System.out.println(" empty sublist");
						request.setAttribute("subslist", null);
					}
				}
			}
		} catch (Exception e) {

		} finally {
			q.closeAll();
			pm.close();
		}
		return nextpage;
			
	}
	public static void sendNewPubDeatilsToUser(String receiverEmail,String number,String aticleTitle)
	{
		System.out.println("came to /sendNewPubDeatilsToUser");
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		Email mm = (Email) context.getBean("Email");
		if (!(Strings.isNullOrEmpty(number)) && !(Strings.isNullOrEmpty(aticleTitle)) ) {
			mm.sendMail(Constants.adminEmailId,receiverEmail, "Your new QuakeCoRE publication number",
					"Your QuakeCoRE publication number for the article entitled '" +aticleTitle+  "' is "+number+". Please forward this message to your coauthors. Please add the following statement in your acknowledgement - 'This project was (partially) supported by QuakeCoRE, a New Zealand Tertiary Education Commission-funded Centre. This is QuakeCoRE publication number "+number+"'.");
		}
	}
	
	public static String hashPassword(String password)
	{
		if (Strings.isNullOrEmpty(password))
			return null;
		else
			return Hashing.sha256().newHasher().putString(password.trim(), Charsets.UTF_8).hash().toString();
	}
	
	public static int randInt( int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt(max);
		// System.out.println(randomNum);
		return randomNum;
	}
	
	public static String randString() {
		String randomStr=new String();
	    String alphabets= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  
	   int max=26;
	   for (int i=0;i<4;i++)
		{
		  
			randomStr=randomStr+alphabets.charAt(randInt(max) );
		}
	   randomStr=randomStr+randInt(10)+randInt(10);
	 //  System.out.println(randomStr);
	   
	    return randomStr;
	}
	
	//.instance().hasher(UUID.randomUUID().toString());

	public String generateKey(User user) {
		if (user == null)	
		return null;
		return Hashing.sha1().newHasher().putString(user.getEmail(), Charsets.UTF_8).hash().toString();

	}

}
