package org.adria.virementMultiple;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.adria.virementMultiple.dao.MutipleTransferRepo;
import org.adria.virementMultiple.dto.MultipleTransferSearchDTO;
import org.adria.virementMultiple.entities.Account;
import org.adria.virementMultiple.entities.MultipleTransfers;
import org.adria.virementMultiple.service.IBanqueService;
import org.adria.virementMultiple.specification.VirementMultipleSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/search")
public class Search {

	@Autowired
	IBanqueService banqueService;
	
	@Autowired
	MutipleTransferRepo mtr;
	
	
	@RequestMapping(value = "/multipleTransfers", method = RequestMethod.GET)
	public @ResponseBody List<MultipleTransfers> comptes(Locale locale, Model model) {
		
		List<Account> accounts=banqueService.getAccountBySubscriberId(new Long(1));
		
		
		List<MultipleTransfers> multipleTransfers= banqueService.getTransfersByAccount(accounts);

		return multipleTransfers;
	}
	

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public  @ResponseBody  List<MultipleTransfers> search(HttpServletRequest request,
			@ModelAttribute("multipleTransferSearchDTO") final MultipleTransferSearchDTO multipleTransferSearchDTO) {
		
		Specification<MultipleTransfers> specification =VirementMultipleSpecification.virementMultipleList(new Long(1), multipleTransferSearchDTO);
        List<MultipleTransfers> multipleTransfers=mtr.findAll(specification);
		
        System.out.println(multipleTransfers.size());
       
      
        
		return multipleTransfers;
	}
	
	

}
