package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import db.inn2power.be.Company;
import db.inn2power.bll.CompanyManager;
import db.inn2power.bll.CompanySearcher;


@RunWith(value = Parameterized.class)
public class DataDrivenJ4 {

	private static CompanyManager cm;

	private String website;
	private Boolean isValid;
	
	public DataDrivenJ4(String website, Boolean isValid) {
		this.website = website;
		this.isValid = isValid;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
            { "https://www.apple.com", true }, {"orange. com" , false}
    });
	}

	@Test
	public void test() {
		Boolean result = cm.isCompanyWebsiteValidURL(website);
		assertEquals(isValid, result);
	}

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cm = new CompanyManager();
	}
}
