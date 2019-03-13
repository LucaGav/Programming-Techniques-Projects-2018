package bll;

import java.util.NoSuchElementException;

import dao.OrderDAO;
import model.Order;

public class OrderBll {
	
	private static OrderDAO o1;
	
	public OrderBll() {
		o1 = new OrderDAO();
	}
	
	public static int selectQ(int cusid, int prodid) {
		int q = o1.selectQ(cusid, prodid);
		if(q==0) {
			throw new NoSuchElementException("The quantity of order = " + cusid + " " + prodid + " was not found");
		}
		return q;
	}
	public static void insertO(Order order) throws Exception {//validate insert from order
		if(order.getCustomerID()<0 || order.getProductID()<0 || order.getQuantity()<1) {
			throw new Exception("Cannot insert order");
		}else {
			o1.insertO(order);
		}
	}
	
	public static void deleteO(int idcus,int idprod) throws Exception {//validate delete from order
		if(idcus<0 || idprod<0) {
			throw new Exception("Cannot delete order");
		}
		else {
			o1.deleteO(idcus, idprod);
		}
	}
	
	

}

