package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testing3 {
	SoftAssert softAssert= new SoftAssert();
	
  @Test(priority=1)
  public void createUser() {
  
  System.out.println("home Test");
  System.out.println("Before assertion");
  Assert.assertTrue(4>3, "Verifying Element");// we use this regular Assert in the industry
  System.out.println("After 1st Assert");
  Assert.assertEquals("abc", "abc");
  System.out.println("After 2nd Assert");
   }
  
  @Test(priority=2, dependsOnMethods="createUser")// if createUser fails this will skip 
  public void editUser() {
	System.out.println("Before the Assertion");
	softAssert.assertTrue(2>3, "Verifying the Element");
	System.out.println("After assertion");
	softAssert.assertAll();         // this is like error collector in the junit(we used try catch and error collector )
	// this is simple in testNG only with this SoftAssert with the AssertAll
	
	  
	  
  }
  
  
  @Test(priority=3, dependsOnMethods="editUser")     
  //selenium.testing3.deletUser() depends on nonexistent method edit User
  //if the dependson Method value is different
  public void deletUser() {
	  System.out.println("Iam in end Test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(4>3, "Verifying Element1");
	  System.out.println("After assertiuon");
	  softAssert.assertEquals("abc", "abc1");
System.out.println("aftersecond Assert");	 
softAssert.assertAll();
	  
	  
  }
  
  
  
}
