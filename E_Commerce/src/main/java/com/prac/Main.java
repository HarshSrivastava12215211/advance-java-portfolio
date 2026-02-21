package com.prac;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		UserDAO ud=new UserDAO();
		OrderDAO od = new OrderDAO();
		PayementDAO pd = new PayementDAO();
		ServiceLayer s = new ServiceLayer(ud, od, pd);
		
		System.out.println("Register user with profile");
		
		Profile p = new Profile();
		p.setId(1);
		p.setPhone(8090374077L);
		p.setAddress("Jalandhar");
		
		User u = new User();
		u.setId(1);
		u.setName("Saras");
		u.setEmail("saras9@gmail.com");
		
		s.registerUser(u,p);
		
		
		System.out.println("Add Order to User");
		PurchaseOrder o1 = new PurchaseOrder();
		o1.setId(101);
		o1.setOrderDate("2026-02-14");
		o1.setTotalAmount(2000);
		
		PurchaseOrder o2 = new PurchaseOrder();
		o2.setId(102);
		o2.setTotalAmount(3004);
		o2.setOrderDate("2026-02-13");
		
		List<PurchaseOrder> ls = new ArrayList<>();
		ls.add(o1);
		ls.add(o2);
		
		s.addOrderUser(1, ls);
		
		System.out.println("Add Payment Method");
		
		Payment pay  = new Payment();
		pay.setId(50001);
		pay.setMode("UPI");
		pay.setAmounbt(2000);
		
		s.addPayementToOrder(101, pay);
		
		System.out.println("Fetch User with Order");
		User fetched = s.FetchwithOrders(1);
		if(fetched != null)
		{
			System.out.println("User: "+ fetched.getName());
			
			for(PurchaseOrder po :fetched.getPurchaseOrder())
			{
				System.out.println("Order: "+po.getId()+ " Amount : "+po.getTotalAmount());
				
			}
		}
		
		
		System.out.println("Update Order Amount");
		s.updateOrderAmount(101, 25000);
		
		System.out.println("Delete User");
		s.deleteUser(1);
		System.out.println("Done");
	}
	
}
