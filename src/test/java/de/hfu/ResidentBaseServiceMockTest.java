package de.hfu;

import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentBaseServiceMockTest implements ResidentRepository{
	private List<Resident> einwohner = new ArrayList<Resident>();
	
	
	public ResidentBaseServiceMockTest() {
		super();
		einwohner.add(new Resident("Leon", "Fleig", "Uhlandstrasse", "Gosheim", new Date(123456)));
		einwohner.add(new Resident("Sina", "Fleig", "Ringstrasse", "Gosheim", new Date()));
		einwohner.add(new Resident("Sina", "Schätzle", "Mühlstrasse", "Gosheim", new Date()));
		einwohner.add(new Resident("Helga", "Fleig", "Silcherstrasse", "Gosheim", new Date()));
	}
	
	@Test
	public void test() throws ResidentServiceException {
		
		Resident residentMock = createMock(Resident.class);
		expect(residentMock.getCity().equals("Gosheim"));
		//expect(residentMock.getGivenName().equals("Fleig"));
		residentMock.setCity("Gosheim");
		
		replay(residentMock);
		BaseResidentService service = new BaseResidentService();
		
	}

	@Override
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		return einwohner;
	}
}
