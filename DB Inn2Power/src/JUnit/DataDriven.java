package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.CompanySearcher;

class DataDriven {
	
	private static CompanyManager cm;
	private static CompanySearcher cs;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cm = new CompanyManager();
		cs = new CompanySearcher();
	}


    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @MethodSource("companiesToSearchProvider")
	void testSearchCompanyByName(String str, int amount, List<Company> companies) {    	
		List<Company> result = cs.searchByCompanyName(companies, str);
		assertEquals(amount, result.size());
	}
    
    
    static Stream<Arguments> companiesToSearchProvider(){ 	
    	List<Company> companies = Arrays.asList(
    			new Company(1, "AppleComputers", null, null, null, null, null, 0, 0, 0), 
    			new Company(2, "AppleJuiceCompany", null, null, null, null, null, 0, 0, 0),
    			new Company(3, "BananaCompany", null, null, null, null, null, 0, 0, 0));
    	    	
    	return Stream.of(
    			arguments("Apple", 2, companies),
    			arguments("Banana", 1, companies),
    			arguments("InvalidName", 0, companies));
    }
    
    
    @ParameterizedTest
    @CsvFileSource(resources = "../companies.csv", numLinesToSkip = 0)
    public void testFromCSVCompanyWebsites(String companyWebsite, Boolean isValid) {
		Boolean result = cm.isCompanyWebsiteValidURL(companyWebsite);
		assertEquals(isValid, result);
    }
    
    
    


}
