package de.hfu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;

public class ResidentStubTest {

	@Test
	public void testGetFilteredResidentsList() {
		BaseResidentService brs = new BaseResidentService();
		Resident f = new Resident();
		f.setGivenName("Leon");
		ResidentRepositoryStub r = new ResidentRepositoryStub();
		brs.setResidentRepository(r);
		assertEquals(2, brs.getFilteredResidentsList(f).size());
		f.setFamilyName("Fleig");
		assertEquals(2, brs.getFilteredResidentsList(f).size());
	}

}
