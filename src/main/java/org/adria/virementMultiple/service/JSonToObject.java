package org.adria.virementMultiple.service;

import java.io.IOException;
import java.util.List;

import org.adria.virementMultiple.dto.BeneficiaireIdMontantDTO;
import org.codehaus.jackson.JsonProcessingException;
import org.springframework.stereotype.Component;


@Component
public interface JSonToObject {

	public List<BeneficiaireIdMontantDTO> jsonToBeneficiaireIdMontantDTOList(String benefJsonList) throws JsonProcessingException, IOException ;
}
