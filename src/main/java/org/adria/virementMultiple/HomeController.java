package org.adria.virementMultiple;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.adria.virementMultiple.service.IBanqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IBanqueService banqueService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public  @ResponseBody  Beneficiary check(){
		
		return banqueService.getBeneficiaryById(new Long(1));
	}
	
	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public  @ResponseBody  List<Account> comptes(){
		Subscriber subscriber =new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		subscriber.setId(new Long(1));
		return banqueService.getAccountBySubscriber(subscriber);
	}
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public  @ResponseBody  Beneficiary auth(@RequestBody  Test auth,HttpServletRequest request){
		
		
		String username=auth.getUsername();
		String password = auth.getPassword();
		
		System.out.println(username+" "+password);
		return banqueService.getBeneficiaryById(new Long(1));
	}
	
	
	
	
}
