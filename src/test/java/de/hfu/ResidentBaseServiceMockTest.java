package de.hfu;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentBaseServiceMockTest{
	private List<Resident> einwohner = new ArrayList<Resident>();
	ResidentRepository residentMock = createMock(ResidentRepository.class);
	
	@Before
	public void setup() {
		einwohner.add(new Resident("Leon", "Fleig", "Uhlandstrasse", "Gosheim", new Date(123456)));
		einwohner.add(new Resident("Sina", "Fleig", "Ringstrasse", "Gosheim", new Date(123456)));
		einwohner.add(new Resident("Sina", "Schätzle", "Mühlstrasse", "Gosheim", new Date()));
		einwohner.add(new Resident("Helga", "Fleig", "Silcherstrasse", "Gosheim", new Date(123456)));
	}
	
	@Test
	public void testGetFilteredResidentsListMock() {
		expect(residentMock.getResidents()).andReturn(einwohner).times(3);
		replay(residentMock);
		
		BaseResidentService brs = new BaseResidentService();
		brs.setResidentRepository(residentMock);
		
		Resident f = new Resident();
		f.setFamilyName("Fleig");
		f.setDateOfBirth(new Date (123456));
		assertEquals(3, brs.getFilteredResidentsList(f).size());
		assertEquals(4, brs.getFilteredResidentsList(new Resident()).size());
		f.setStreet("U*");
		assertThat(1, equalTo(brs.getFilteredResidentsList(f).size()));
		verify(residentMock);
	}
	
	@Test
	public void testGetUniqueResidentMock() throws ResidentServiceException {
		expect(residentMock.getResidents()).andReturn(einwohner).times(1);
		replay(residentMock);
		
		BaseResidentService brs = new BaseResidentService();
		Resident f = new Resident();
		f.setGivenName("Leon");
		Resident check = new Resident("Leon", "Fleig", "Uhlandstrasse", "Gosheim", new Date (123456));
		brs.setResidentRepository(residentMock);
		
		Resident erg = brs.getUniqueResident(f);
		assertEquals(check, erg);
		verify(residentMock);
	}
	
	@Test(expected = ResidentServiceException.class, timeout = 1000)
	public void testGetUniqueResidentExceptionMock() throws ResidentServiceException {
		expect(residentMock.getResidents()).andReturn(einwohner).times(1);
		replay(residentMock);
		
		BaseResidentService brs = new BaseResidentService();
		brs.setResidentRepository(residentMock);
		Resident f = new Resident();
		
		f.setStreet("U*");
		brs.getUniqueResident(f);
	}
}
