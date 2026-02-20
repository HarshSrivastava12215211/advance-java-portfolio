package com.prac;

import java.util.List;

public class ServiceLayer {
	
	public UserDAO userdao;
	public OrderDAO orderdao;
	public  PayementDAO paymentdao;
	
	public ServiceLayer(UserDAO userdao, OrderDAO orderdao, PayementDAO paymentdao)
	{
		this.orderdao = orderdao;
		this.paymentdao = paymentdao;
		this.userdao = userdao;
	}
	
	public void registerUser(User u, Profile p)
	{
		u.setProfile(p);
		
		userdao.saveUser(u);
	}
	
	public void addOrderUser(int id, List<PurchaseOrder> order)
	{
		User u = userdao.findUser(id);
		if(u == null)
		{
			return ;
		}
		
		u.getPurchaseOrder().addAll(order);
		
		userdao.updateUser(u);
	}
	
	public void addPayementToOrder(long OrderId, Payment p)
	{
		PurchaseOrder o = orderdao.findOrder(OrderId);
		if(p ==null || o == null)
		{
			return;
		}
		p.setOrder(o);
		
		paymentdao.savePayement(p);
		
	}
	
	public User FetchwithOrders(int id)
	{
		return userdao.findUser(id);
	}
	
	public void deleteUser(int id)
	{
		userdao.deleteUser(id);
	}
	
	public void updateOrderAmount(long id,int amnt)
	{
		PurchaseOrder o = orderdao.findOrder(id);
		o.setTotalAmount(amnt);
		orderdao.UpdateOrder(o);
	}

}
