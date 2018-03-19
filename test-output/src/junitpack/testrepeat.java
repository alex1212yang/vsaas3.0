package junitpack;

import org.junit.Assert;  

import junit.extensions.RepeatedTest;  
import junit.framework.Test;  
import junit.framework.TestCase;  
import junit.framework.TestSuite;  
  
public class testrepeat extends TestCase  
{  
    public testrepeat()  
    {  
        super();  
    }  
  
    public testrepeat(String name)  
    {  
        super(name);  
    }  
  
    public static Test suite()  
    {  
        TestSuite suite = new TestSuite();  
        suite.addTest(new RepeatedTest(new testrepeat("test"), 20));  
        return suite;  
    }  
  
    public void test() throws Exception  
    {  
        Linkin test = new Linkin();  
        String str = test.test("LinkinPark");  
        Assert.assertEquals("LinkinPark¡C¡C¡C", str);  
    }  

    public class Linkin  
    {  
        public String test(String str)  
        {  
            return str + "¡C¡C¡C";  
        }  
      
    }  
}  
