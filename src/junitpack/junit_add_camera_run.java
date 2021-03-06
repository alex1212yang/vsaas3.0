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
public class junit_add_camera_run {
	 private boolean result;
	 private String casename;

	 public junit_add_camera_run(String casename, boolean result) {
	  this.casename = casename;
	  this.result = result;
	 }

	 @Parameters(name = "{0}")
	 public static Collection primeNumbers() throws Exception {
		 junit_add_camera x = new junit_add_camera();
		 
		 ArrayList<ArrayList> ResultList = x.junit_add_camera();
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