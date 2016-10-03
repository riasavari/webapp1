package myproject.practice.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

public class PublicationService {
	public static int  getPublicationNo(String emailId,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception
	{
		int publicationNo=0;
		
		//querying the total number of publications from Publication Table
		System.out.println("getPublicationNo in PublicationService");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Publication.class);  
		
		try {
			List<Publication> results =  (List<Publication>) q.execute();
			String number=String.format("%1$04d",(results.size()+1));
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
		System.out.println("publicationNo----------------> "+publicationNo);
		return publicationNo;
	}
	
	
	public static String  updatePublicationDetails(String emailId,int publicationId,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception
	{ 
		PersistenceManager pm = PMF.get().getPersistenceManager();
		System.out.println("in updatePublicationDetails");
		HashMap<String, String> hash = new HashMap<>();
		String nextpage="newpublication";
		Query q = pm.newQuery(Publication.class);
		
		q.setFilter("publicationId == filterParameter");
		q.setOrdering("date desc");
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
