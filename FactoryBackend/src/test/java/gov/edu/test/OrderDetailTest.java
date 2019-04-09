package gov.edu.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.OrderDao;
import gov.edu.model.OrderDetail;

public class OrderDetailTest 
{
    static OrderDao orderDao;
    
    @BeforeClass    
    public static void executeFirst()
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("gov.edu");
	    context.refresh();
	    
	    orderDao=(OrderDao) context.getBean("orderDao");
    }
   
    @Ignore
	@Test
	public void saveOrdertest() 
	{
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(109);
		orderDetail.setShippingAddr("Mumbai");
		orderDetail.setFinalAmount(50000);
		orderDetail.setTranType("COD");
		orderDetail.setUsername("Akshay");
		
		assertTrue("Problem in saving order",orderDao.saveOrder(orderDetail));
	}
    @Ignore
	@Test
	public void updateCartTest()
	{
		assertTrue("Problem in updating Cart",orderDao.updateCart("Akshay"));
		
	}
}
