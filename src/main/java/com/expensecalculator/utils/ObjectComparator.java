package com.expensecalculator.utils;

import java.util.Iterator;
import java.util.List;
import com.expensecalculator.dao.impl.NameDaoImpl;
import com.expensecalculator.dao.impl.OrganizationDaoImpl;
import com.expensecalculator.domain.Name;
import com.expensecalculator.domain.Organization;

public class ObjectComparator {
	public Name isNameAlreadyDefined(Name name) {
		List<Name> names = new NameDaoImpl().findAll();
		Iterator<Name> it = names.iterator();
		while (it.hasNext()) {
			Name definedName = it.next();
			if (definedName.equals(name)) {
				return name;
			}
		}
		return null;
	}
	public Organization isOrganizationAlreadyDefined(Organization organization) {
		List<Organization> organizations = new OrganizationDaoImpl().findAll();
		Iterator<Organization> it = organizations.iterator();
		while (it.hasNext()) {
			Organization definedOrganization = it.next();
			if (definedOrganization.equals(organization)) {
				return organization;
			}
		}
		return null;
	}
}
