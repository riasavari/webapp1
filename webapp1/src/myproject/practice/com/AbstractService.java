package myproject.practice.com;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

public class AbstractService {

	public static int  getAbstractNo(String emailId,HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception
	{
		int absNo=0;
		
		//querying the total number of abstracts from Abstract Table
		System.out.println("getAbstractNo in AbstractService");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Proposal.class);  
		
		try {
			List<Proposal> results =  (List<Proposal>) q.execute();
			String number=String.format("%1$04d",(results.size()+1));
			absNo=Integer.parseInt(number);
			if (results.isEmpty()) {
				model.addAttribute("allAbstractList", null);
			} else {
				model.addAttribute("allAbstractList", results);
			}

		} finally {
			q.closeAll();
			pm.close();
		}
		System.out.println("AbstractNo----------------> "+absNo);
		return absNo;
	}
}
