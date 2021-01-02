package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.exception.Inn2PowerException;
import db.inn2power.dal.CompanyDAL;

class MockitoExample {

	@Test
	void getAllCompanies() throws SQLException, Inn2PowerException {
		  CompanyDAL companyDao = mock(CompanyDAL.class);
		  CompanyManager companyManager = new CompanyManager(companyDao);
		  List<Company> companies = new ArrayList<Company>();
		  for(int i = 0; i < 10;i++)
		  {
			  companies.add(new Company(i, "Fred&Husso" + i, "Denmark" + i , "Kirkvej" + i + ", " + "th",
						"frH.dk" + i , "KK" + i , "Date" + i , 50 + i, 20 + i, 20 + i));
		  }
		  when(companyDao.getAllCompanies()).thenReturn(companies);
		  List<Company> companiesReceivedFromMethod = companyManager.getAllCompanies();
		  assertTrue(companies.equals(companiesReceivedFromMethod));
		  
	}
}
