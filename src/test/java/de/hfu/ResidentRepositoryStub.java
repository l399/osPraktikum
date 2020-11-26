package de.hfu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository {

	private List<Resident> einwohner = new ArrayList<Resident>();

	public ResidentRepositoryStub() {
		super();
		einwohner.add(new Resident("Leon", "Fleig", "Uhlandstrasse", "Deilingen", new Date()));
		einwohner.add(new Resident("Leon", "Fleig", "Ringstrasse", "Deilingen", new Date()));
	}

	@Override
	public List<Resident> getResidents() {
		return einwohner;
	}

}