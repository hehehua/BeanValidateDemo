package com.maxwell.hibernate.validation;

import java.util.Date;

import com.maxwell.BeanValidateDemoApplication;
import com.maxwell.hibernate.validation.extend.ExtendEntity;
import com.maxwell.hibernate.validation.simple.SimpleEntity;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BeanValidateDemoApplication.class)
@WebAppConfiguration
public class ValidationUtilsTest extends TestCase{

	@Test
  public void validateSimpleEntity() {
	  SimpleEntity se = new SimpleEntity();
	  se.setDate(new Date());
	  se.setEmail("123");
	  se.setName("123");
	  se.setPassword("123");
	  se.setValid(false);
	  ValidationResult result = ValidationUtils.validateEntity(se);
	  System.out.println("--------------------------");
	  System.out.println(result);
	  Assert.assertTrue(result.isHasErrors());
  }

	@Test
  public void validateSimpleProperty() {
	  SimpleEntity se = new SimpleEntity();
	  ValidationResult result = ValidationUtils.validateProperty(se,"name");
	  System.out.println("--------------------------");
	  System.out.println(result);
//	  Assert.assertTrue(result.isHasErrors());
  }

	@Test
  public void validateExtendEntity() {
	  ExtendEntity ee = new ExtendEntity();
	  ee.setPassword("123456gxz");
	  ValidationResult result = ValidationUtils.validateProperty(ee,"password");
	  System.out.println("--------------------------");
	  System.out.println(result);
	  //Assert.assertTrue(result.isHasErrors());
  }
}
