package de.hfu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentStubTest {

	@Test
	public void testGetFilteredResidentsList() {
		BaseResidentService brs = new BaseResidentService();
		Resident f = new Resident();
		ResidentRepositoryStub r = new ResidentRepositoryStub();
		brs.setResidentRepository(r);
		
		f.setGivenName("Helga");
		assertEquals(1, brs.getFilteredResidentsList(f).size());
		f = new Resident();
		f.setFamilyName("Fleig");
		assertEquals(3, brs.getFilteredResidentsList(f).size());
		f = new Resident();
		f.setStreet("Uhlandstrasse");
		assertEquals(1, brs.getFilteredResidentsList(f).size());
	}
	
	@Test
	public void testGetUniqueResident() throws ResidentServiceException {
		BaseResidentService brs = new BaseResidentService();
		ResidentRepositoryStub r = new ResidentRepositoryStub();
		
		Resident f = new Resident();
		f.setGivenName("Leon");
		Resident test = new Resident("Leon", "Fleig", "Uhlandstrasse", "Deilingen", new Date(123456));
		
		brs.setResidentRepository(r);
		
		Resident erg = brs.getUniqueResident(f);
		assertEquals(test, erg);
		
	}

	@Test(expected=ResidentServiceException.class)
	public void testWildcard() throws ResidentServiceException {
		BaseResidentService brs = new BaseResidentService();
		ResidentRepositoryStub r = new ResidentRepositoryStub();
		
		Resident f = new Resident();
		f.setGivenName("*");
		Resident test = new Resident("Leon", "Fleig", "Uhlandstrasse", "Deilingen", new Date(123456));
		
		brs.setResidentRepository(r);
		
		Resident erg = brs.getUniqueResident(f);
		assertEquals(test, erg);
	}
	
	@Test(expected=ResidentServiceException.class)
	public void testUnique() throws ResidentServiceException {
		BaseResidentService brs = new BaseResidentService();
		ResidentRepositoryStub r = new ResidentRepositoryStub();
		
		Resident f = new Resident();
		f.setGivenName("Sina");
		
		Resident test = new Resident("Sina", "Fleig", "Uhlandstrasse", "Deilingen", new Date(123456));
		
		brs.setResidentRepository(r);
		
		Resident erg = brs.getUniqueResident(f);
		assertEquals(test, erg);
	}
	
}
