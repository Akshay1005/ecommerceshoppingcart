package gov.edu.test;
	
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gov.edu.dao.CartDao;
import gov.edu.model.CartItem;

public class CartUnitTest 
{
	static CartDao cartDao;
	
	@BeforeClass
	public static void executeFirst()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    context.scan("gov.edu");
	    context.refresh();
	    
	    cartDao=(CartDao)context.getBean("cartDao");
	}
	@Ignore
	@Test
	public void addCartItemtest() 
	{
		CartItem cartItem=new CartItem();
		cartItem.setProId(103);
		cartItem.setProName("Lenovo");
		cartItem.setQuantity(1);
		cartItem.setProprice(25000);
		cartItem.setPaymentStatus("NP");
		cartItem.setUsername("Akshay");
		
		assertTrue("problem in adding Item into Cart",cartDao.addCartItem(cartItem));
	}
	
	//@Ignore
	@Test
	public void listAllCartItems()
	{
		
		List<CartItem> listCartItems=cartDao.listCartItems("Akshay");
		
		assertTrue("Problem in listing the CartItems",listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProId()+"\t");
			System.out.print(cartItem.getProName()+"\t");
			System.out.print(cartItem.getProprice()+"\t");
			System.out.print(cartItem.getQuantity()+"\t");	
		}	
	}
	//@Ignore
	@Test
	public void updateCartItemTest()
	{
		CartItem cartItem=cartDao.getCartItem(109);
		cartItem.setQuantity(2);
		assertTrue("Problem occured while updating cartItem",cartDao.updateCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		CartItem cartItem=cartDao.getCartItem(449);
		
		assertTrue("Problem occured while deleting cartItem",cartDao.deleteCartItem(cartItem));
	}
}

