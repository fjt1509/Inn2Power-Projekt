package TestNG;

import org.testng.annotations.Test;

import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.CompanySearcher;
import db.inn2power.bll.exception.Inn2PowerException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DataDriven {
	
	
	private static CompanyManager cm;
	private static CompanySearcher cs;

	
  @BeforeClass
  public void beforeClass() throws Exception {
	  cm = new CompanyManager();
	  cs = new CompanySearcher();
  }

	
	
  @Test(dataProvider = "data")
  public void f(String search, int amount, List<Company> companies) {
	  List<Company> result = cs.searchByCompanyName(companies, search);
	  assertEquals(amount, result.size());
  }
  
  @DataProvider
  public Object[][] data() {
	  
  	List<Company> companies = Arrays.asList(
			new Company(1, "AppleComputers", null, null, null, null, null, 0, 0, 0), 
			new Company(2, "AppleJuiceCompany", null, null, null, null, null, 0, 0, 0),
			new Company(3, "BananaCompany", null, null, null, null, null, 0, 0, 0));
  	
      return new Object[][] { 
    	  { "Apple", 2, companies},
    	  { "Banana", 1, companies},
          { "InvalidName", 0, companies } };
  }
  
  
  
  
  
  @DataProvider(name = "companyWebsites")
  public Iterator<Object []> provider( ) throws InterruptedException, IOException
  {
      List<Object []> testCases = new ArrayList<>();
      String[] data= null;

      BufferedReader br = new BufferedReader(new FileReader("../companies.csv"));
      String line;
	while ((line = br.readLine()) != null) {
          data= line.split(",");
          testCases.add(data);
      }
		br.close();

      return testCases.iterator();
  }
  
  @Test(dataProvider = "companyWebsites")
  public void userLoginTest(String companyWebsite, Boolean isValid){
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }




  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
