package myproject.practice.com;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;



@Controller
public class UserController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(ModelMap model) {
		//System.out.println("home :) ");
		return "home";

	}

	@RequestMapping(value = "/narrow", method = RequestMethod.GET)
	public String getnarrowJumboPage(ModelMap model) {
		//System.out.println("narrow :) ");
		return "narrowJumbo";

	}

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String sample(ModelMap model) {
		//System.out.println("sample :) ");
		return "sample";

	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getSignUpPage(ModelMap model) {
		//System.out.println("got here for /signup");
		return "signup";

	}

	@RequestMapping(value = "/done", method = RequestMethod.GET)
	public String savedOrmodified(ModelMap model) {
		//System.out.println("came to /done");
		return "thankyou";
	}

	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String selectMailingList(ModelMap model) {
		//System.out.println("came to /select");
		return "select";
	}

	@RequestMapping(value = "/userStatusChanged", method = RequestMethod.GET)
	public String userStatusChangedPage(ModelMap model) {
		//System.out.println("came to /userStatusChanged");
		return "userStatusChanged";
	}
	
	@RequestMapping(value = "/visibilityChanged", method = RequestMethod.GET)
	public String pubvisibilityChangedPage(ModelMap model) {
		//System.out.println("came to /visibilityChanged");
		return "visibilityChanged";
	}
	
	@RequestMapping(value = "/exusersignup", method = RequestMethod.GET)
	public String getExUserSignUpPage(ModelMap model) {
		//System.out.println("got here for /exusersignup");
		return "exusersignup";

	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public String getForgotPasswordPage(ModelMap model) {
		//System.out.println("got here for /forgotpassword");
		return "forgotpassword";

	}
	//Admin related pages-start
	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public String homeAdminPage(ModelMap model,HttpSession session) {
		//System.out.println("got here for /homeAdmin");
		String page="expiry";
		if(session == null || session.getAttribute("email") == null)
			return page;
		else
		{
		if(session.getAttribute("email").equals(Constants.adminEmailId) )
			return "homeAdmin";
		else
			return "invalidrequest";
			}

	}
	@RequestMapping(value = "/getmailSubscriptions", method = RequestMethod.GET)
	public String getmailSubscriptions(ModelMap model,HttpSession session) {
		//System.out.println("got here for /getmailSubscriptions");
		
			String page="expiry";
			if(session == null || session.getAttribute("email") == null)
				return page;
			else
			{
			if(session.getAttribute("email").equals(Constants.adminEmailId) )
				return "getmailSubscriptions";
			else
				return "invalidrequest";
				}
		
	}
	
	@RequestMapping(value = "/showbanner", method = RequestMethod.GET)
	public String getshowbannerPage(ModelMap model,HttpSession session) {
		//System.out.println("got here for /showbanner ");
		String page="expiry";
		if(session == null || session.getAttribute("email") == null)
			return page;
		else
		{
		if(session.getAttribute("email").equals(Constants.adminEmailId) )
		return "showbanner";
		else
		return "invalidrequest";
		}

	}
	@RequestMapping(value = "/sent", method = RequestMethod.GET)
	public String sent(ModelMap model,HttpSession session) {
		//System.out.println("got here for /sent");
		String page="expiry";
		if(session == null || session.getAttribute("email") == null)
			return page;
		else
		{
		if(session.getAttribute("email").equals(Constants.adminEmailId) )
			return "sent";
		else
			return "invalidrequest";
		}

	}
	@RequestMapping(value = "/banner", method = RequestMethod.GET)
	public String banner(ModelMap model,HttpSession session) {
		//System.out.println("got here for /banner");
		String page="expiry";
		if(session == null || session.getAttribute("email") == null)
			return page;
		else
		{
		if(session.getAttribute("email").equals(Constants.adminEmailId) )
			return "banner";
		else
			return "invalidrequest";
		}

	}
	//Admin related pages-end
	
	@RequestMapping(value = "/changed", method = RequestMethod.POST)
	public String postchanged(ModelMap model) {
		//System.out.println("got here for /changed POST");
		return "thankyou";

	}

	@RequestMapping(value = "/thankyou", method = RequestMethod.GET)
	public String thankyou(ModelMap model) {
		//System.out.println("got here for /thankyou " + model);
		return "thankyou";

	}

	@RequestMapping(value = "/newpublication", method = RequestMethod.GET)
	public ModelAndView editPublicationPage(@RequestParam(value = "id", required = false) String pubid,
			ModelMap model,HttpSession session) {
		//System.out.println("got here for EDIT /newpublication GET");
		 if(session == null || session.getAttribute("email") == null)
			 return new ModelAndView( "expiry");
			else
			{
				if(session.getAttribute("email").equals(Constants.adminEmailId))
					return new ModelAndView("adminInvalidrequest");
				else
				{
					if (pubid != null && !pubid.isEmpty())
						model.addAttribute("singlePub", pubid);

					return new ModelAndView("newpublication");
				}
			}

	}

	
	@RequestMapping(value = "/rechangepassword", method = RequestMethod.GET)
	public String getreChangePasswordPage(ModelMap model) {
		//System.out.println("got here for /rechangepassword");
		return "rechangepassword";

	}

	

	@RequestMapping(value = "/contactlist", method = RequestMethod.POST)
	public String contactlistAdminPage(ModelMap model) {
		//System.out.println("got here for /contactlist");
		return "contactlist";

	}
	@RequestMapping(value = "/newsignup", method = RequestMethod.POST)
	public String newsignupPage(ModelMap model) {
		//System.out.println("got here for /newsignup POST ");
		return "newsignup";

	}
	//Start:user related pages
	@RequestMapping(value = "/homeuser", method = RequestMethod.POST)
	public String homeUserPage(ModelMap model,HttpSession session) {
		//System.out.println("got here for /homeuser  POST");
		 if(session == null || session.getAttribute("email") == null)
				return "expiry";
			else
			{
				if(session.getAttribute("email").equals(Constants.adminEmailId))
				return "adminInvalidrequest";
				else
					return "homeuser";
			}

	}

	@RequestMapping(value = "/homeuser", method = RequestMethod.GET)
	public String gethomeUserPage(ModelMap model,HttpSession session) {
		//System.out.println("got here for /gethomeuser GET");
		 if(session == null || session.getAttribute("email") == null)
				return "expiry";
			else
			{
				if(session.getAttribute("email").equals(Constants.adminEmailId))
				return "adminInvalidrequest";
				else
					return "homeuser";
			}

	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String getChangePasswordPage(ModelMap model,HttpSession session) {
		//System.out.println("got here for /changepassword " + model);
		if((session != null && session.getAttribute("email") != null )&& !(session.getAttribute("email").equals(Constants.adminEmailId)))
			return "changepassword";
			else if(session == null || session.getAttribute("email") == null)
				return "expiry";
			else
				return "adminInvalidrequest";
	}

	@RequestMapping(value = "/userActivation", method = RequestMethod.GET)
	public String getuserActivationPage(ModelMap model) {
		//System.out.println("got here for /userActivation ");
		return "userActivation";

	}
	
	@RequestMapping(value = "/invalidrequest", method = RequestMethod.GET)
	public String invalidrequest(ModelMap model) {
		//System.out.println("/invalidrequest");
		return "invalidrequest";

	}
	@RequestMapping(value = "/adminInvalidrequest", method = RequestMethod.GET)
	public String adminInvalidrequest(ModelMap model) {
		//System.out.println("/adminInvalidrequest");
		return "adminInvalidrequest";

	}
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String postHomePage(ModelMap model) {
		//System.out.println("home :) POST");
		return "home";

	}
	@RequestMapping(value = "/banner", method = RequestMethod.POST)
	public String getshowbannerPage(ModelMap model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		//System.out.println("got here for /banner POST");
		//System.out.println(request.getParameter("msg"));
		String displayMsg=request.getParameter("msg");
		
		String page="expiry";
		if(session != null && session.getAttribute("email") != null) {
			String currentSessionEmail=session.getAttribute("email").toString();
			if(currentSessionEmail.equals(Constants.adminEmailId))
			{
		PersistenceManager pm = PMF.get().getPersistenceManager();

        Query q = pm.newQuery(Admin.class);
        q.setFilter("email == nameParameter");
        q.declareParameters("String nameParameter");

        try {
               List<Admin> results = (List<Admin>) q.execute(currentSessionEmail);

               if (!results.isEmpty()) {
                     
                     results.get(0).setMsg(displayMsg);
                     page="banner";
               }
        } finally {
               q.closeAll();
               pm.close();
        }
			}
			else
				return "invalidrequest";
		}
		return page;

	}
	@RequestMapping(value = "/activated", method = RequestMethod.GET)
	public String getuseractivatedPage(ModelMap model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		//System.out.println("got here for /activated ");
		String page="expiry";
		if (session != null && session.getAttribute("email") != null) {
			if(!(session.getAttribute("email").equals(Constants.adminEmailId)))
				return "invalidrequest";
		//System.out.println(request.getParameter("useremail"));
		String useremail=request.getParameter("useremail");
		String activeStatus=request.getParameter("activeStatus");
		page=UserService.activateUser(useremail,activeStatus,model,session);
		if(page.equals("userStatusChanged"))
		{
			String url=request.getScheme() + "://"	+ request.getServerName() + request.getContextPath();
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

			Email mm = (Email) context.getBean("Email");
			if(activeStatus.equals("false"))
			{

				StringBuilder bodyText = new StringBuilder();
				
				bodyText.append("Hello,"+"\r\n\n ");
				bodyText.append("Thank you for signing up to the QuakeCoRE user portal, your profile is now active.You can log onto the portal using the following "+url+"\r\n\n ");
				
				bodyText.append("After you have logged in, please take a moment to review your mailing list subscription options and confirm that your profile information is correct"+"\r\n\n");
				
				bodyText.append("Thank you,"+"\r\n ");
				bodyText.append("The QuakeCoRE Team");
				mm.sendMail(Constants.adminEmailId, useremail, "Account Activated for QuakeCoRE User Portal",
						bodyText.toString());
			}
			/*else
				mm.sendMail(Constants.adminEmailId, useremail, "Account Deactivated for QuakeCoRE User Portal",
						"Sorry, your account has been deactivated.");*/
			
		}
		
		}
		return page;
	}
	@RequestMapping(value = "/changeVisibility", method = RequestMethod.GET)
	public String getchangeVisibilityPage(ModelMap model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		//System.out.println("got here for /changeVisibility ");
		String page="expiry";
		if (session != null && session.getAttribute("email") != null) {
			if(!(session.getAttribute("email").equals(Constants.adminEmailId)))
				return "invalidrequest";
		//System.out.println(request.getParameter("useremail"));
		String pubId=request.getParameter("pubno");
		
		page=PublicationService.publicationVisibility(pubId,model,session);
		}
		return page;
	}
	
	@RequestMapping(value = "/changed", method = RequestMethod.GET)
	public String changed(ModelMap model) {
		//System.out.println("got here for /changed");
		return "thankyou";

	}

	

	@RequestMapping(value = "/editthisAbstract", method = RequestMethod.POST)
	public String geteditAbstractPage(@RequestParam(value = "absId", required = false) String absId,
			HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) {

		//System.out.println("got here for /editthisAbstract" + absId);
		// get the details of an abstract from this absId, then set the abstract
		// details in request attribute ->to front jsp to display

		return "abstractSubmission";

	}

	@RequestMapping(value = "/popup", method = RequestMethod.GET)
	public String getPopup(ModelMap model) {
		//System.out.println("got here for /popup");
		return "popup";

	}

	@RequestMapping(value = "/abstractSubmitted", method = RequestMethod.GET)
	public String getabstractSubmissionPage(ModelMap model) {
		//System.out.println("got here for /abstractSubmitted");
		return "abstractSubmitted";

	}

	@RequestMapping(value = "/abstractSubmission", method = RequestMethod.GET)
	public String abstractSubmission(ModelMap model) {
		//System.out.println("got here for GET /abstractSubmission");
		return "abstractSubmission";

	}

	@RequestMapping(value = "/confirmpopup", method = RequestMethod.GET)
	public String getconfirmPopup(ModelMap model) {
		//System.out.println("got here for /confirmpopup");
		return "confirmpopup";

	}

	@RequestMapping(value = "/abstractSubmission", method = RequestMethod.POST)
	public ModelAndView abstractSubmissionSave(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, ModelMap model) {
		//System.out.println("got here for POST  /abstractSubmission");
		String emailId = "";
		int absNo = 0;
		if (session != null && session.getAttribute("email") != null) {
			emailId = session.getAttribute("email").toString();
		} else
			return new ModelAndView("expiry");
		String year = request.getParameter("year");
		String category = request.getParameter("category");
		String abstractDesc = request.getParameter("abstractDescription");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String project = request.getParameter("project");
		String url = request.getParameter("url");

		//System.out.println(year + "-- " + category);
		//System.out.println(abstractDesc + "-- " + author);
		//System.out.println(title + "-- " + project + " --- " + url);

		try {
			absNo = AbstractService.getAbstractNo(emailId, request, response, model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Proposal abs = new Proposal();
		String uuid = UUID.randomUUID().toString();
		abs.setKey(uuid);
		abs.setAbstractId(absNo);
		abs.setYear(year);
		abs.setCategory(category);
		abs.setAbstractDescription(abstractDesc);
		abs.setAuthor(author);
		abs.setTitle(title);
		abs.setProject(project);
		abs.setUrl(url);

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(abs);
			//System.out.println(" ****************  " + absNo);
			PublicationService.saveNewUserAbstract(emailId, absNo);
		} finally {
			pm.close();
		}

		request.setAttribute("absNo", absNo);
		return new ModelAndView("abstractSubmitted");

	}

	// for viewing all QuakeCoRE publications which has visibility true
	@RequestMapping(value = "/viewpublication", method = RequestMethod.GET)
	public String getviewpublicationsPage(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			ModelMap model) {
		//System.out.println("got here for GET /viewpublication " + model.toString());
		String emailId = "";
		if (session != null && session.getAttribute("email") != null) {
			emailId = session.getAttribute("email").toString();
		} else
			return "expiry";
		Boolean visible=true;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Publication.class);
		q.setOrdering("publicationId");
		q.setFilter("isVisible == nameParameter");
		q.declareParameters("int nameParameter");
		try {
			List<Publication> results = (List<Publication>) q.execute(visible);
			//System.out.println("result size " + results.size());
			if (results.isEmpty()) {
				model.addAttribute("allPublicationList", null);
			} else {
				model.addAttribute("allPublicationList", results);
			}

		} finally {
			q.closeAll();
			pm.close();
		}

		return "viewpublication";

	}
	// for viewing all QuakeCoRE publications which has visibility true
		@RequestMapping(value = "/viewpeople", method = RequestMethod.GET)
		public String getviewpeoplePage(HttpServletRequest request, HttpServletResponse response, HttpSession session,
				ModelMap model) {
			//System.out.println("got here for GET /viewpeople " + model.toString());
			String emailId = "";
			if (session != null && session.getAttribute("email") != null) {
				emailId = session.getAttribute("email").toString();
			} else
				return "expiry";
			Boolean isActiveMember=true;
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(User.class);
			q.setOrdering("firstname");
			q.setFilter("active == nameParameter");
			q.declareParameters("int nameParameter");
			try {
				List<User> results = (List<User>) q.execute(isActiveMember);
				//System.out.println("result size " + results.size());
				if (results.isEmpty()) {
					model.addAttribute("peopleList", null);
				} else {
					model.addAttribute("peopleList", results);
				}

			} finally {
				q.closeAll();
				pm.close();
			}

			return "viewpeople";

		}
	@RequestMapping(value = "/selectpublication", method = RequestMethod.GET)
	public  String getAllPubsforAdmin(HttpServletRequest request, HttpServletResponse response,
			ModelMap model,HttpSession session )
	{//System.out.println("/selectpublication");
		String emailId = "";
		if (session != null && session.getAttribute("email") != null) {
			emailId = session.getAttribute("email").toString();
			if(!(emailId.equals(Constants.adminEmailId)))
				return "invalidrequest";
		} else
			return "expiry";
		Boolean visible=true;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Publication.class);
		q.setOrdering("publicationId");
		try {
			List<Publication> results = (List<Publication>) q.execute();
			//System.out.println("result size " + results.size());
			if (results.isEmpty()) {
				model.addAttribute("allPubsList", null);
			} else {
				model.addAttribute("allPubsList", results);
			}

		} finally {
			q.closeAll();
			pm.close();
		}

		return "selectpublication";
	}
	
	public ModelAndView getPublication(String emailId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model, int publicationId) throws Exception {
		List<Integer> user_pubList=getUserPublicationList(emailId);
		if(!user_pubList.contains(publicationId))
		{
			return new ModelAndView("expiry");
		}
		String nextpage = "newpublication";
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Publication> results = new ArrayList<Publication>();
		Query q = pm.newQuery(Publication.class);
		q.setFilter("publicationId == nameParameter");
		// q.setOrdering("date desc");
		q.declareParameters("int nameParameter");

		try {
			results = (List<Publication>) q.execute(publicationId);
			if (!results.isEmpty()) {
				//System.out.println(results.get(0).getAuthor());

				request.setAttribute("editPub", "edit");
				request.setAttribute("year", results.get(0).getYear());
				request.setAttribute("fund", results.get(0).getFund());
				request.setAttribute("status", results.get(0).getStatus());
				request.setAttribute("article", results.get(0).getArticle());
				request.setAttribute("author", results.get(0).getAuthor());
				request.setAttribute("title", results.get(0).getTitle());
				request.setAttribute("venueName", results.get(0).getVenueName());
				request.setAttribute("volume", results.get(0).getVolume());
				request.setAttribute("page", results.get(0).getPage());
				request.setAttribute("location", results.get(0).getLocation());
				request.setAttribute("url", results.get(0).getUrl());
				request.setAttribute("publishDate", results.get(0).getpublishDate());
				request.setAttribute("publisher", results.get(0).getPublisher());
				request.setAttribute("publicationNo", publicationId);
				request.setAttribute("descOutputOther", results.get(0).getdescOutputOther());
				request.setAttribute("project", results.get(0).getProject());
			}
		} catch (Exception e) {

		} finally {
			q.closeAll();
			pm.close();
		}
		//System.out.println("IT DOES");
		return new ModelAndView(nextpage);
	}

	@RequestMapping(value = "/newpublication", method = RequestMethod.POST)
	public ModelAndView getPublicationId(@RequestParam(value = "id", required = false) String pub,
			HttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) {
		
		String buttonValue = request.getParameter("actionBtn");

		
		String pubNo = request.getParameter("editNo");
		//System.out.println(pubNo + " *** POST *** " + buttonValue);
		if (buttonValue != null) {
			//System.out.println(" *** ONE *** ");
			//To get publication details based on button value 
			if (session != null && session.getAttribute("email") != null) {
				if(session.getAttribute("email").equals(Constants.adminEmailId))
					return new ModelAndView("adminInvalidrequest");
					
				String emailId = session.getAttribute("email").toString();
				int id = Integer.parseInt(buttonValue);
				try {

					return getPublication(emailId, request, response, model, id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				return new ModelAndView("expiry");
			}
		} else if (buttonValue == null && !(pubNo.isEmpty())) {//displays the page with a particular publications's  details for editing
			//System.out.println(" *** TWO *** ");
			int no = Integer.parseInt(pubNo);
			//System.out.println(" *** TWO *** no " + no);
			
			if (session != null && session.getAttribute("email") != null) {
				if(session.getAttribute("email").equals(Constants.adminEmailId))
					return new ModelAndView("adminInvalidrequest");
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(Publication.class);
			q.setFilter("publicationId == idParameter");
			q.declareParameters("String idParameter");
			try {
				List<Publication> results = (List<Publication>) q.execute(no);
				//System.out.println("result size " + results.size());
				if (results.isEmpty()) {
					//System.out.println("no records found" + no);

				} else {
					//System.out.println("to save the edited pubdetails");
					String year = request.getParameter("year");
					String fund = request.getParameter("fund");
					String status = request.getParameter("status");
					String article = request.getParameter("article");
					String author = request.getParameter("author");
					String title = request.getParameter("title");
					String venueName = request.getParameter("venueName");
					String descOutputOther= request.getParameter("descOutputOther");
					String volume = request.getParameter("volume");
					String page = request.getParameter("page");
					String location = request.getParameter("location");
					String url = request.getParameter("url");
					String dates = request.getParameter("dates");
					String publisher = request.getParameter("publisher");
					String project = request.getParameter("project");
					
					try {
						results.get(0).setlastModifiedDate(new Date());
						results.get(0).setYear(year);
						results.get(0).setFund(fund);
						results.get(0).setStatus(status);
						results.get(0).setArticle(article);
						results.get(0).setAuthor(author);
						results.get(0).setTitle(title);
						if (!Strings.isNullOrEmpty(project))
							results.get(0).setProject(project);
						else
							results.get(0).setProject("");
						if (!Strings.isNullOrEmpty(venueName))
							results.get(0).setVenueName(venueName);
						else
							results.get(0).setVenueName("");
						if (!Strings.isNullOrEmpty(descOutputOther))
							results.get(0).setdescOutputOther(descOutputOther);
						else
							results.get(0).setdescOutputOther("");
						if (!Strings.isNullOrEmpty(volume))
							results.get(0).setVolume(volume);
						else
							results.get(0).setVolume("");
						if (!Strings.isNullOrEmpty(page))
							results.get(0).setPage(page);
						else
							results.get(0).setPage("");
						if (!Strings.isNullOrEmpty(location))
							results.get(0).setLocation(location);
						else
							results.get(0).setLocation("");
						if (!Strings.isNullOrEmpty(url))
							results.get(0).setUrl(url);
						else
							results.get(0).setUrl("");
						if (!Strings.isNullOrEmpty(dates))
							results.get(0).setpublishDate(dates);
						else
							results.get(0).setpublishDate("");
						if (!Strings.isNullOrEmpty(publisher))
							results.get(0).setPublisher(publisher);
						else
							results.get(0).setPublisher("");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return new ModelAndView("changed");
				}

			} finally {
				q.closeAll();
				pm.close();
			}
			}else {
				return new ModelAndView("expiry");
			}
		} else if (buttonValue == null && pubNo.isEmpty())//To sava a new publication

		{
			//System.out.println(" *** THREE *** ");
			if (session != null && session.getAttribute("email") != null) {
				if(session.getAttribute("email").equals(Constants.adminEmailId))
					return new ModelAndView("adminInvalidrequest");
				String year = request.getParameter("year");
				String fund = request.getParameter("fund");
				String status = request.getParameter("status");
				String article = request.getParameter("article");
				String author = request.getParameter("author");
				String title = request.getParameter("title");
				String venueName = request.getParameter("venueName");
				String descOutputOther= request.getParameter("descOutputOther");
				String volume = request.getParameter("volume");
				String page = request.getParameter("page");
				String location = request.getParameter("location");
				String url = request.getParameter("url");
				String dates = request.getParameter("dates");
				String publisher = request.getParameter("publisher");
				String project = request.getParameter("project");
				JSONObject pub_detailsJson = new JSONObject();
				try {
					pub_detailsJson.put("year", year);
					pub_detailsJson.put("fund", fund);
					pub_detailsJson.put("status", status);
					pub_detailsJson.put("article", article);
					pub_detailsJson.put("author", author);
					pub_detailsJson.put("title", title);
					pub_detailsJson.put("venueName", venueName);
					pub_detailsJson.put("descOutputOther", descOutputOther);
					pub_detailsJson.put("volume", volume);
					pub_detailsJson.put("page", page);
					pub_detailsJson.put("location", location);
					pub_detailsJson.put("url", url);
					pub_detailsJson.put("dates", dates);
					pub_detailsJson.put("publisher", publisher);
					pub_detailsJson.put("project", project);
					String emailAddress = session.getAttribute("email").toString();
					
						try {
							return PublicationService.getPublicationNo(pub_detailsJson,emailAddress, request, response, model,session);//it gets saved and gets a publication No
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
			}else {
				return new ModelAndView("expiry");
			}

			

		} else {
			//System.out.println(" *** FOUR *** ");
		}
		return new ModelAndView("changed");

	}

	
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, ModelMap model) {
		//System.out.println("got here for /logout");
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			session.removeAttribute("email");
			session.removeAttribute("name");
			session.removeAttribute("userKey");
			session.invalidate();
		}
		return "logout";

	}
	@RequestMapping(value = "/expiry", method = RequestMethod.GET)
	public String expiry(ModelMap model,HttpServletRequest request) {
		//System.out.println("got here for /expiry");
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			session.removeAttribute("email");
			session.removeAttribute("name");
			session.removeAttribute("userKey");
			session.invalidate();
		}
		return "expiry";

	}

	@RequestMapping(value = "/getpasswordchanged", method = RequestMethod.POST)
	public ModelAndView getpasswordchanged(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, ModelMap model) {

		if (session != null && session.getAttribute("email") != null) {
			String oldPassword = request.getParameter("password");
			String newPassword = request.getParameter("newpassword");
			String emailId = session.getAttribute("email").toString();
			String isMatched = checkpLoginDetails(emailId, oldPassword, request, response, session).toString();
			//System.out.println("1.matched got in " + isMatched);
			if (isMatched.equals("userMatched")) {
				//System.out.println(emailId + " 2.matched got in " + newPassword);
				saveTempEntry(emailId, newPassword);
			} else if (isMatched.equals("userMismatched")) {
				//System.out.println(emailId + " 3.wrong password  " + newPassword);

				return new ModelAndView("rechangepassword");
			}
		} else {
			return new ModelAndView("expiry");
		}

		return new ModelAndView("thankyou");

	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.GET)
	public String editprofilePage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {

		String page = "expiry";

		if (session != null && session.getAttribute("email") != null) {
			//System.out.println("got here for /editprofile GET");
			if(session.getAttribute("email").equals(Constants.adminEmailId))
				return "adminInvalidrequest";
			String email = session.getAttribute("email").toString();

			try {
				page = UserService.getUserData(email, request, response, model,session);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return page;
	}
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String activate(HttpServletRequest request, HttpServletResponse response, HttpSession session,ModelMap model) {
		String newuserAcc=request.getParameter("acc");
		//System.out.println("MAILID "+newuserAcc);
		
		String page = "expiry";

		if (session != null && session.getAttribute("email") != null && session.getAttribute("email").equals(Constants.adminEmailId)) {
			//System.out.println("got here for /activate GET");
			
			try {
				page = UserService.getUserData(newuserAcc, request, response, model,session);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return page;
		//return "userActivation";
	}
	@RequestMapping(value = "/updatePublication", method = RequestMethod.GET)
	public String updateThisPublication(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		String number = request.getParameter("actionBtn");
		//System.out.println(" /updatePublication " + number);
		String page = "newpublication";
		/*
		 * if (session != null && session.getAttribute("email") != null) {
		 * String emailId=session.getAttribute("email").toString(); int
		 * id=Integer.parseInt(number); try {
		 * page=PublicationService.getPublication(emailId,request,response,model
		 * ,id); } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */

		return page;

	}

	@RequestMapping(value = "/mailinglist", method = RequestMethod.GET)
	public String mailingListPage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		String page = "expiry";
		if (session != null && session.getAttribute("email") != null) {
			//System.out.println("got here for /mailingList");
			String email = session.getAttribute("email").toString();
			if (email.equalsIgnoreCase(Constants.adminEmailId)) 
				return "adminInvalidrequest";
			try {
				page = UserService.getUserSubscriptions(email, request, response, model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return page;
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public @ResponseBody String checkpLoginDetails(@RequestParam(value = "id", required = false) String emailId,
			@RequestParam(value = "pwd", required = false) String password, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		//System.out.println("into /checklogin");

		String hashedPassword = UserService.hashPassword(password);
		//System.out.println(emailId + " - " + password + " - " + hashedPassword);
		
		String adminemail=Constants.adminEmailId;
		String msg="";
		String adminPwd="";
		
		PersistenceManager pmf = PMF.get().getPersistenceManager();

        Query que = pmf.newQuery(Admin.class);
        que.setFilter("email == nameParameter");
        que.declareParameters("String nameParameter");

        try {
               List<Admin> results = (List<Admin>) que.execute(adminemail);

               if (!results.isEmpty()) {
            	   adminPwd= results.get(0).getPassword();
                   msg=results.get(0).getMsg();
               }
        } finally {
               que.closeAll();
               pmf.close();
        }

		if (emailId.equalsIgnoreCase(adminemail)) {
			if (hashedPassword.equals(adminPwd)) {
				//System.out.println("matched");
				session.setAttribute("email", emailId);
				session.setAttribute("msg", msg);
				return "adminMatched";

			} else {
				//System.out.println("adminMismatched");
				return "adminMismatched";

			}
		} else {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			//System.out.println("check for normal user loggin");
			Query q = pm.newQuery(User.class);

			q.setFilter("email == emailParameter");
			//q.setOrdering("date desc");
			q.declareParameters("String emailParameter");
			try {
				List<User> results = (List<User>) q.execute(emailId);
				//System.out.println(results.size());
				if (results.isEmpty()) {
					//System.out.println("no account");
					return "noAccount";
				} else {
					//System.out.println(results.get(0).getEmail() + " - " + results.get(0).getPassword());
					String receivedPassword = results.get(0).getPassword().toString();
					String active=results.get(0).getActive().toString();
					//System.out.println("active ot not "+active);
					//System.out.println(receivedPassword + " = " + hashedPassword);
					if(active.equals("false"))
					{
						return "notActive";
					}
					if (receivedPassword.equals(hashedPassword)) {
						//System.out.println("user matched");
						results.get(0).setLastLoginDate(new Date());
						session.setAttribute("email", emailId);
						session.setAttribute("userKey", results.get(0).getKey().toString());
						session.setAttribute("name", results.get(0).getFirstname().toString());
						session.setAttribute("msg", msg);
						return "userMatched";
					} else {
						//System.out.println("user mismatched");
						return "userMismatched";

					}

				}

			}

			finally {
				q.closeAll();
				pm.close();
			}
		}
	}

	public Boolean repeatPassword(String emailId, String newPassword) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//System.out.println("check for normal user loggin");
		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			if (results.isEmpty()) {
				//System.out.println("no account");
				return false;
			} else {
				//System.out.println(results.get(0).getEmail() + " - " + results.get(0).getPassword());
				String receivedPassword = results.get(0).getPassword().toString();
				String hashedPassword = (UserService.hashPassword(newPassword));
				//System.out.println(receivedPassword + " = " + hashedPassword);
				if (receivedPassword.equals(hashedPassword)) {
					//System.out.println("old-new same : false");

					return false;
				} else {
					//System.out.println("old-new not same :true");
					return true;

				}

			}

		} finally {
			q.closeAll();
			pm.close();
		}
	}

	public void saveUser(JSONObject userInfo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		//System.out.println("got here for /save..........." + userInfo);
		User user = new User();
		String uuid = UUID.randomUUID().toString();
		List<String> mailSubs=new<String> ArrayList();
		mailSubs.add("m1,");//To add monthly newsletter as default mailing list subscription while they signup
		try {
			user.setKey(uuid);
			user.setActive(false);
			user.setFirstname(userInfo.getString("firstname"));
			user.setLastname(userInfo.getString("lastname"));
			user.setEmail(userInfo.getString("email"));
			user.setPassword(userInfo.getString("password"));
			user.setTitle(userInfo.getString("title"));
			user.setPosition(userInfo.getString("position"));
			user.setOrganisation(userInfo.getString("organisation"));
			if (!Strings.isNullOrEmpty(userInfo.getString("orcId")))
			user.setOrcId(userInfo.getString("orcId"));
			else
				user.setOrcId("");
			user.setCategory(userInfo.getString("category"));
			user.setCountry(userInfo.getString("country"));
			if (!Strings.isNullOrEmpty(userInfo.getString("ethnicity")))
			user.setEthnicity(userInfo.getString("ethnicity"));
			else
				user.setEthnicity("");
			if (!Strings.isNullOrEmpty(userInfo.getString("iwi")))
			user.setIwi(userInfo.getString("iwi"));
			else
				user.setIwi("");
			user.setGender(userInfo.getString("gender"));
			if (!Strings.isNullOrEmpty(userInfo.getString("comments")))
			user.setComments(userInfo.getString("comments"));
			else
				user.setComments("");
			user.setMailLists(mailSubs);
			Date now = new Date();
			user.setSignupdate(new Date());

			//session.setAttribute("email", userInfo.getString("email"));
			//session.setAttribute("name", userInfo.getString("firstname"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(user);
		} finally {
			pm.close();
		}

	}

	@RequestMapping(value = "/viewMyAbstractSubmissions", method = RequestMethod.GET)
	public String getviewMyAbstractSubmissionsPage(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		//System.out.println("got here for GET /viewMyAbstractSubmissions");
		String emailId = "";
		List<Integer> abs;
		if (session != null && session.getAttribute("email") != null) {
			emailId = session.getAttribute("email").toString();
			//System.out.println("my email id " + emailId);
		} else
			return "expiry";

		PersistenceManager pm = PMF.get().getPersistenceManager();
		UserPublication userAbs = pm.getObjectById(UserPublication.class, emailId);
		try {

			if (userAbs == null) {
				//System.out.println("no publications yet");
			} else {
				try {
					//System.out.println("His abstracts are : " + userAbs.getAbstractList().toString());
					abs = userAbs.getAbstractList();
					List<Proposal> absDetailedlist = getAbsDetailedlist(abs);

					request.setAttribute("myabs", absDetailedlist);
					// GET EACH PUBLICATION AND ITS DETAILS -> NEED TO SHOW IN
					// THE FRONTEND
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} finally {

			pm.close();
		}

		return "viewMyAbstractSubmissions";

	}
	
	public List<Integer> getUserPublicationList(String emailId)
	{//System.out.println("getUserPublicationListgetUserPublicationListgetUserPublicationListgetUserPublicationListgetUserPublicationList");
		List<Integer> absList=new ArrayList<Integer>();
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UserPublication userAbs = pm.getObjectById(UserPublication.class, emailId);
		try {

			if (userAbs == null) {
				//System.out.println("no publications yet");
			} else {
				try {
					//System.out.println("His abstracts are : " + userAbs.getPublicationList().toString());
					absList = userAbs.getPublicationList();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} finally {

			pm.close();
		}
		//System.out.println(absList);
		return absList;

		
	}

	@RequestMapping(value = "/viewmypublications", method = RequestMethod.GET)
	public String getViewMyPublicationPage(ModelMap model, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		//System.out.println("got here for GET /viewmypublications");
		String emailId = "";
		
		List<Integer> pubs;
		if (session != null && session.getAttribute("email") != null) {
			emailId = session.getAttribute("email").toString();
			if(emailId.equals(Constants.adminEmailId))
				return "adminInvalidrequest";
			//System.out.println("my email id " + emailId);
		} else
			return "expiry";

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			UserPublication userPubs = pm.getObjectById(UserPublication.class, emailId);
			if (userPubs == null) {
				//System.out.println("no publications yet");
			} else {
				try {
					//System.out.println("His publications are : " + userPubs.getPublicationList().toString());
					pubs = userPubs.getPublicationList();
					
					List<Publication> pubDetailedlist = getPubDetailedlist(pubs);//gets only the pubs with visibility true

					request.setAttribute("mypubs", pubDetailedlist);
					// GET EACH PUBLICATION AND ITS DETAILS -> NEED TO SHOW IN
					// THE FRONTEND
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			pm.close();
		}

		return "viewmypublications";

	}

	public List<Proposal> getAbsDetailedlist(List<Integer> abs) {
		//System.out.println(" getAbsDetailedlist ");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Proposal> another = new ArrayList<Proposal>();
		List<Proposal> results = new ArrayList<Proposal>();
		Query q = pm.newQuery(Proposal.class);
		q.setFilter("abstractId == nameParameter");
		// q.setOrdering("date desc");
		q.declareParameters("int nameParameter");

		try {
			for (int a : abs) {
				Integer no = a;
				results = (List<Proposal>) q.execute(no);
				//System.out.println(results.get(0).getAbstractId());
				another.addAll(results);
			}

			//System.out.println(" RESULT SIZE of Abstracts" + another.size());

		} finally {
			q.closeAll();
			pm.close();
		}
		return another;
	}

	public List<Publication> getPubDetailedlist(List<Integer> pubs) {
		//System.out.println(" getPubDetailedlist " + pubs.size());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Publication> another = new ArrayList<Publication>();
		List<Publication> results = new ArrayList<Publication>();
		Query q = pm.newQuery(Publication.class);
		q.setFilter("publicationId == nameParameter");
		// q.setOrdering("date desc");
		q.declareParameters("int nameParameter");

		try {
			for (int a : pubs) {
				Integer no = a;

				results = (List<Publication>) q.execute(no);
				//System.out.println(results.get(0).getpublicationId());
				if(results.get(0).getIsVisible())//only displays visible publications
				another.addAll(results);
				// results.add(p)
				// Publication p=(Publication)q.execute(no);
				// session.setAttribute("loggedInUserJson", user.toJson());

				// results.add(p);
			}

			//System.out.println(" RESULT SIZE of Publications" + another.size());

		} finally {
			q.closeAll();
			pm.close();
		}
		return another;
	}

	@RequestMapping(value = "/editUserDetails", method = RequestMethod.POST)
	public @ResponseBody String editingUserDetails(
			@RequestParam(value = "userInfo", required = false) String userdetails, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		//System.out.println("comes to /editUserDetails thru ajax call" + userdetails);
		String emailId = "";
		JSONObject user_detailsJson = new JSONObject();
		try {
			user_detailsJson = new JSONObject(userdetails);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!Strings.isNullOrEmpty(userdetails)) {
			//System.out.println("from SESSION " + session.getAttribute("email"));
			if (session != null && session.getAttribute("email") != null) {
				emailId = session.getAttribute("email").toString();
			} else
				return "expiry";

		} else
			return "noAccount";

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(User.class);
		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			//System.out.println("result size " + results.size());
			if (results.isEmpty()) {
				//System.out.println("no account so proceed" + emailId);
				return "noAccount";
			} else {
				//System.out.println("to save the edited details");
				try {
					results.get(0).setTitle(user_detailsJson.getString("title"));
					results.get(0).setFirstname(user_detailsJson.getString("firstname"));
					results.get(0).setLastname(user_detailsJson.getString("lastname"));
					results.get(0).setCategory(user_detailsJson.getString("category"));
					results.get(0).setPosition(user_detailsJson.getString("position"));
					results.get(0).setOrganisation(user_detailsJson.getString("organisation"));
					if (!Strings.isNullOrEmpty(user_detailsJson.getString("orcId")))
					results.get(0).setOrcId(user_detailsJson.getString("orcId"));
					else
						results.get(0).setOrcId("");
					if (!Strings.isNullOrEmpty(user_detailsJson.getString("comments")))
					results.get(0).setComments(user_detailsJson.getString("comments"));
					else
						results.get(0).setComments("");
					results.get(0).setCountry(user_detailsJson.getString("country"));
					if (!Strings.isNullOrEmpty(user_detailsJson.getString("ethnicity")))
					results.get(0).setEthnicity(user_detailsJson.getString("ethnicity"));
					else
						results.get(0).setEthnicity("");
					if (!Strings.isNullOrEmpty(user_detailsJson.getString("iwi")))
					results.get(0).setIwi(user_detailsJson.getString("iwi"));
					else
						results.get(0).setIwi("");
					results.get(0).setGender(user_detailsJson.getString("gender"));
					
					session.setAttribute("name", user_detailsJson.getString("firstname"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return "saved";
			}

		} finally {
			q.closeAll();
			pm.close();
		}
	}
	
	
	@RequestMapping(value = "/ifExistingUser", method = RequestMethod.POST)
	public @ResponseBody String ifExistingUser(@RequestParam(value = "userInfo", required = false) String userdetails,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String emailId = "";
		JSONObject user_detailsJson = new JSONObject();
		if (!Strings.isNullOrEmpty(userdetails)) {
			try {
				user_detailsJson = new JSONObject(userdetails);
				if (user_detailsJson.has("email")) {
					emailId = user_detailsJson.getString("email").toLowerCase();
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(emailId.equals(Constants.adminEmailId))
			return "existingUser";
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			//System.out.println(results.hashCode());
			if (results.isEmpty()) {
				//System.out.println("no account so proceed" + emailId);
				saveUser(user_detailsJson, request, response, session);// Saves
																		// User
																		// details
																		// into
																		// User
				activateEmailReqToAdmin(emailId,request);													// table
				return "noAccount";

			} else {
				//System.out.println("you are an existing user");
				return "existingUser";
			}

		} finally {
			q.closeAll();
			pm.close();
		}
	}

	@RequestMapping(value = "/ifExistingUserForgot", method = RequestMethod.GET)
	public @ResponseBody String ifExistingUserForgot(@RequestParam(value = "id", required = false) String emailId,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//System.out.println("checking if user exists.." + emailId);
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			//System.out.println(results.hashCode());
			if (results.isEmpty()) {
				//System.out.println("no account so proceed" + emailId);
				return "noAccount";

			} else {
				//System.out.println("you are an existing user");
				return "existingUser";
			}

		} finally {
			q.closeAll();
			pm.close();
		}
	}

	@RequestMapping(value = "/getContactList", method = RequestMethod.POST)
	public @ResponseBody String getContactList(@RequestParam(value = "maillist", required = false) String contactList,
			@RequestParam(value = "listname", required = false) String listname,
			@RequestParam(value = "emailid", required = false) String emailid, HttpServletRequest request,
			ModelMap model, HttpSession session) {
		String nextpage = "expiry";
		if (session != null && session.getAttribute("email") != null && session.getAttribute("email").equals(Constants.adminEmailId)) {

			//System.out.println("getContactList " + contactList);
			PersistenceManager pm = PMF.get().getPersistenceManager();

			Query q = pm.newQuery(User.class);
			// List<String> subsList=null;
			String subsList = "";
			String contacts = "";
			try {
				List<User> results = (List<User>) q.execute();
				//System.out.println(results + "--- " + results.size());
				if (!results.isEmpty()) {
					for (User u : results) {
						//System.out.println("before sublist");
						subsList = u.getMailLists().toString();
						if (!Strings.isNullOrEmpty(subsList)) {

							//System.out.println(contactList + " contactList | after sublist" + subsList);
							//System.out.println(" what is subsList.indexOf(contactList) =  " + subsList.indexOf(contactList));
							if (subsList.indexOf(contactList) != -1) {
								//System.out.println("inside sublist");
								String email = u.getEmail();
								contacts = contacts + email + ";";

							}
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				q.closeAll();
				pm.close();
			}
			//System.out.println(contacts);
			model.addAttribute("contacts", contacts);
			sendContactsToAdmin(contacts, listname, emailid, session);
			nextpage = "sent";
		}
		return nextpage;
	}

	public void sendContactsToAdmin(String contacts, String listname, String senderEmailid, HttpSession session) {
		//System.out.println("came to /sendContactsToAdmin " + senderEmailid);
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

		Email mm = (Email) context.getBean("Email");
		if (Strings.isNullOrEmpty(contacts)) {
			mm.sendMail(Constants.adminEmailId, senderEmailid, "Subscription list for " + listname + "",
					"Sorry, people have not subscribed to this mailing list yet. It is currently empty.");
		} else {
			mm.sendMail(Constants.adminEmailId, senderEmailid, "Subscription list for " + listname + "",
					"" + contacts + "");
		}

	}
	
	public void activateEmailReqToAdmin(String senderEmailid,HttpServletRequest request) {
		//System.out.println("came to /activateEmailToAdmin " + senderEmailid);
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		String url 				= 	request.getScheme() + "://"	+ request.getServerName() + request.getContextPath()+"/activate?acc="+senderEmailid;
		
		Email mm = (Email) context.getBean("Email");
		
			if (!Strings.isNullOrEmpty(senderEmailid)) {
				
				
				mm.sendMail(senderEmailid,Constants.adminEmailId, "Account activation request from QC user portal",
						"New signup from QC user portal. Click here to activate:"+url);
			
			}
		
		
	}
	//For the first time to add admin to the backend.It creates the table there
	@RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public void addAdmin(HttpServletRequest request, ModelMap model) {
           //System.out.println("/addAdmin GET");
           Admin a=new Admin();
           String msg="QuakeCoRE 2017 Annual Meeting 4-6 September,2017";
           String pwd="admin007";
           
           a.setMsg(msg);
           a.setPassword(UserService.hashPassword(pwd));
           a.setEmail("quakecore.nz@gmail.com");

           PersistenceManager pm = PMF.get().getPersistenceManager();
           try {
                  pm.makePersistent(a);
           } finally {
                  pm.close();
           }
    }
	//After the table was created, if we need to change details
	@RequestMapping(value = "/changeCredential", method = RequestMethod.GET)
    public void changeCredentials(HttpServletRequest request, ModelMap model) {
           //System.out.println("/changeCredential");
           String searchAdminTable=Constants.adminEmailId;
           PersistenceManager pm = PMF.get().getPersistenceManager();

           Query q = pm.newQuery(Admin.class);
           q.setFilter("email == nameParameter");
           q.declareParameters("String nameParameter");

           try {
                  List<Admin> results = (List<Admin>) q.execute(searchAdminTable);

                  if (!results.isEmpty()) {
                        results.get(0).setPassword(UserService.hashPassword("orange"));
                        results.get(0).setMsg("QuakeCoRE website www.quakecore.nz");
                  }
           } finally {
                  q.closeAll();
                  pm.close();
           }
    }

	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	public ModelAndView sendMail(HttpServletRequest request, ModelMap model) {
		 //System.out.println("came to /sendmail"+request.getContextPath());
		String email = request.getParameter("email");
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		String requestURL 				= 	request.getScheme() + "://"	+ request.getServerName() + request.getContextPath();

		Email mm = (Email) context.getBean("Email");

		String tempString = UserService.randString();
		saveTempEntry(email, tempString);
		mm.sendMail(Constants.adminEmailId, email, "QuakeCoRE account reset information",
				"Your temporary password is " + tempString + ". Please login and change your password.");
		// //System.out.println("emailed");
		return new ModelAndView("select");
	}

	public void saveTempEntry(String email, String tempString) {
		//System.out.println("saveTempEntry " + email);
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");
		//q.setOrdering("date desc");
		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(email);
			//System.out.println(results.hashCode());
			if (!results.isEmpty()) {
				results.get(0).setPassword(tempString);
				//System.out.println("password changed to " + tempString);

			} else {

			}

		}

		finally {
			q.closeAll();
			pm.close();
		}

	}

	@RequestMapping(value = "/saveEmailList", method = RequestMethod.POST)
	public @ResponseBody String saveEmailList(@RequestParam(value = "maillist", required = false) String list,
			@RequestParam(value = "old", required = false) String ticked, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		String page = "expiry";
		if (session != null && session.getAttribute("email") != null) {
			String emailId = session.getAttribute("email").toString();

			// saves all data that comes from js into User Table
			//System.out.println("inside /saveEmailList" + list);

			String subscriptions = "";
			JSONObject mail_details = new JSONObject();
			if (!Strings.isNullOrEmpty(list)) {
				try {
					mail_details = new JSONObject(list);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				for (String c : Constants.emailSubscribe) {
					if (mail_details.has(c)) {
						subscriptions = subscriptions.concat(c);
						// commented this for now since it is saving in seperate
						// maillist table
						// MailListService.save(c,emailId);
						subscriptions = subscriptions.concat(",");
					}

				}
			}
			saveUserSubscription(subscriptions, emailId);// saving the
															// subscription into
															// User table itself
			page = "thankyou";
		}
		return page;

	}

	public void saveUserSubscription(String list, String emailId) {
		List<String> newlist = Lists.newArrayList(Splitter.on(" , ").split(list));
		//System.out.println("newlist " + newlist);
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(User.class);

		q.setFilter("email == emailParameter");

		q.declareParameters("String emailParameter");
		try {
			List<User> results = (List<User>) q.execute(emailId);
			//System.out.println(results.toString());
			if (!results.isEmpty()) {
				results.get(0).setMailLists(newlist);
				//System.out.println("saved ");

			} else {

			}

		}

		finally {
			q.closeAll();
			pm.close();
		}
	}
}
