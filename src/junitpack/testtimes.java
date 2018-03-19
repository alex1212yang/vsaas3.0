package junitpack;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class testtimes {
	 private boolean result;
	 private String casename;

	 public testtimes(String casename, boolean result) {
	  this.casename = casename;
	  this.result = result;
	 }

	 @Parameters(name = "{0}")
	 public static Collection primeNumbers() throws Exception {
		 junit_oauth_login T = new junit_oauth_login();
		 
		 ArrayList<ArrayList> ResultList = T.junit_oauth_login();
		  Object obj[][] = new Object[ResultList.size()][ResultList.get(0).size()];
		  for (int i = 0; i < ResultList.size(); i++) {
		   for (int j = 0; j < ResultList.get(i).size(); j++) {
		    obj[i][j] = ResultList.get(i).get(j);
		   }
		  }
		  List list = Arrays.asList(obj);

		  return list;
	  //return Arrays.asList(new Object[][] { { "login", true }, { "logout", false } });
	 }
	 
	 @Test
	 public void Case() {
	  assertTrue(result);
	 }
}