package gov.edu.dao;

import java.util.List;

import gov.edu.model.OrderDetail;

public interface OrderDao 
{
	public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String username);
    
}
