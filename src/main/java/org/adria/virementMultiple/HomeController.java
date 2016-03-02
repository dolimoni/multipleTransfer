package org.adria.virementMultiple;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.adria.virementMultiple.dto.BeneficiaireIdMontantDTO;
import org.adria.virementMultiple.dto.MultipleTransferDTO;
import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.Beneficiary;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.entities.MultipleTransfersBeneficiary;
import org.adria.virementMultiple.entities.Subscriber;
import org.adria.virementMultiple.service.IBanqueService;
import org.adria.virementMultiple.service.JSonToObject;
import org.adria.virementMultiple.util.GenericResponse;
import org.codehaus.jackson.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value = "/")
@Controller
public class HomeController { 

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	IBanqueService banqueService; 

	@Autowired
	JSonToObject jSonToObject;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/signe", method = RequestMethod.GET)
	public String signe(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "signe";
	}
	
	@RequestMapping(value = "/confirme", method = RequestMethod.POST)
	public @ResponseBody String confirme(@RequestParam("password") String password) {
		GenericResponse genericResponse =new GenericResponse();
		if(password.equals("12345")){
			genericResponse.setSuccess(true);
		}else{
			genericResponse.setSuccess(false);
		}
		
		genericResponse.setMsg("list");
		
		Gson gson = new Gson();
		return gson.toJson(genericResponse);
		
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public  String list(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "list";
	}

	@RequestMapping(value = "/beneficiaries", method = RequestMethod.GET)
	public @ResponseBody List<Beneficiary> beneficiaries() {
		Subscriber subscriber = new Subscriber("jira", "ensa", "abdelghafor", "Atlas");
		subscriber.setId(new Long(1));
		return banqueService.getBeneficiaries(subscriber);
	}

	@RequestMapping(value = "/beneficiary", method = RequestMethod.POST)
	public @ResponseBody Beneficiary beneficiary(@RequestParam("beneficiaryId") Long beneficiaryId) {

		System.out.println("id beneficiarie" + beneficiaryId);
		return banqueService.getBeneficiaryById(beneficiaryId);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String save(HttpServletRequest request,
			@ModelAttribute("multipleTransferDTO") final MultipleTransferDTO multipleTransferDTO)
					throws JsonProcessingException, IOException {
		GenericResponse genericResponse = new GenericResponse();
		Gson gson = new Gson();
		genericResponse.setMsg("/virementMultiple/signe");
		genericResponse.setSuccess(true);

		MultipleTransfers multipleTransfers = new MultipleTransfers();
		multipleTransfers.setMotif(multipleTransferDTO.getMotif());
		multipleTransfers.setBalance(multipleTransferDTO.getBalancing());
		multipleTransfers.setCreationDate(new Date());
		multipleTransfers.setExecutionDate(multipleTransfers.getExecutionDate());
		multipleTransfers.setStatus("saved");

		System.out.println(multipleTransferDTO.getBeneficiariesBalancing());
		List<BeneficiaireIdMontantDTO> beneficiaireIdMontantDTOs = jSonToObject
				.jsonToBeneficiaireIdMontantDTOList(multipleTransferDTO.getBeneficiariesBalancing());
		List<MultipleTransfersBeneficiary> virementMultipleBeneficiaires = new ArrayList<MultipleTransfersBeneficiary>();

		for (BeneficiaireIdMontantDTO beneficiaireIdMontantDTO : beneficiaireIdMontantDTOs) {
			Beneficiary beneficiary = banqueService.getBeneficiaryById(beneficiaireIdMontantDTO.getIdBeneficiaire());
			MultipleTransfersBeneficiary multipleTransfersBeneficiary = new MultipleTransfersBeneficiary();
			multipleTransfersBeneficiary.setBeneficiary(beneficiary);
			multipleTransfersBeneficiary.setMontant(new Long(beneficiaireIdMontantDTO.getMontant()));
			virementMultipleBeneficiaires.add(multipleTransfersBeneficiary);
		}

		multipleTransfers.setMtb(virementMultipleBeneficiaires);
		banqueService.save(multipleTransfers);

		return gson.toJson(genericResponse);
	}

	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public @ResponseBody List<Account> comptes() {
		Subscriber subscriber = new Subscriber("jira", "ensa", "Atlas", "abdelghafor");
		subscriber.setId(new Long(1));
		System.out.println(banqueService.getAccountBySubscriber(subscriber));
		return banqueService.getAccountBySubscriber(subscriber);
	}
	
	

}
