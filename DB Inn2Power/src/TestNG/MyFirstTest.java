package TestNG;

import org.testng.annotations.Test;
	import static org.testng.Assert.assertEquals;
public class MyFirstTest {
	
	
	
  @Test
  public void f() {
	  String str = "TestNG is working fine";
      assertEquals("TestNG is working fine", str);
  }
}
