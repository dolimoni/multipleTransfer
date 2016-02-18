package org.adria.virementMultiple.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.adria.virementMultiple.dto.BeneficiaireIdMontantDTO;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JSonToObjectImp implements JSonToObject
{
	
	
	@Override
	public List<BeneficiaireIdMontantDTO> jsonToBeneficiaireIdMontantDTOList(
			String benefJsonList) throws JsonProcessingException, IOException {
		List<BeneficiaireIdMontantDTO> beneficiaireIdMontants = new ArrayList<BeneficiaireIdMontantDTO>();
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode jsonNode = mapper.readTree(benefJsonList);
		
		Iterator<JsonNode> iterator = jsonNode.getElements();
		while (iterator.hasNext()) {
			JsonNode elem = iterator.next();
			JsonNode idBeneficiaireNode = elem.path("j_idBeneficiaire");
			JsonNode montantNode = elem.path("j_montant");
			Long id = idBeneficiaireNode.asLong();
			int montant = montantNode.asInt();
			
			
			BeneficiaireIdMontantDTO beneficiaireIdMontant = new BeneficiaireIdMontantDTO(id,montant);
			beneficiaireIdMontants.add(beneficiaireIdMontant);
		}
		return beneficiaireIdMontants;
	}

}
