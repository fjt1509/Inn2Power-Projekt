package TestNG;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import db.inn2power.be.Company;
import db.inn2power.bll.CompanySearcher;
import db.inn2power.bll.exception.Inn2PowerException;

public class DependencyTest {
	private CompanySearcher companySearcher = null;

	@BeforeClass
	public void beforeClass() throws Inn2PowerException {
		companySearcher = new CompanySearcher();
	}

	@Test()
	public void searchByCompanyName() {
		Company firstCompany = new Company(1, "Fred&Husso", "Denmark", "Kirkvej 1, th",
				"frH.dk", "KK", "Date", 50, 20, 20);
		List<Company> companies = new ArrayList<Company>();
		companies.add(firstCompany);
		companySearcher.searchByCompanyName(companies, "Fred&Husso");
	}

	@Test(dependsOnMethods = { "searchByCompanyName" })
	public void stopSearchByCompanyName() {
		companySearcher.stopSearchByCompanyName();

	}
}
