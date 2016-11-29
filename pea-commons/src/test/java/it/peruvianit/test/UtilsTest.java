package it.peruvianit.test;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;

import it.peruvianit.dto.UserDetailsDTO;
import it.peruvianit.utils.PopulatorUtil;

public class UtilsTest {
	@Test
	public void CreazioneComponentiTest() {		
		UserDetailsDTO userDetailsDTO = PopulatorUtil.populateBean(UserDetailsDTO.class);
		assertTrue("Problemi con l'utilizzo della libreria util PopulatorUtil.populateBean", (Objects.nonNull(userDetailsDTO) || Objects.nonNull(userDetailsDTO.getId())));
	}
}
