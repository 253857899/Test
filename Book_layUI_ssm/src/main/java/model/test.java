package model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.TypeDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class test {
	@Autowired
	TypeDao t ;
	
 @Test
 public void ee() {
	 System.out.println(t.select().get(0).getName());
 }
}
