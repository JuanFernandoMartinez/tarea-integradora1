package model;
import java.util.List;
import java.util.LinkedList;
public class Manager {
	private List<Restaurant> restaurants;
	private List<Client> clients;
	private List<Order> orders;
	private List<Product> products;
	
	public Manager() {
		this.clients = new LinkedList<>();
		this.restaurants = new LinkedList<>();
		this.orders = new LinkedList<>();
		this.products = new LinkedList<>();
	}
	
	public boolean updateRestaurant(String nit, String name, String admin) {
		for (int i = 0; i < restaurants.size(); i++) {
			if (restaurants.get(i).getNit().equals(nit)) {
				restaurants.get(i).setAdmin(admin);
				restaurants.get(i).setName(name);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateProduct(String code, String name, String info, String nit,double cost) {
		for (int i = 0; i<products.size(); i++) {
			if (products.get(i).getCode().equals(code)) {
				products.get(i).setCost(cost);
				products.get(i).setInfo(info);
				products.get(i).setName(name);
				products.get(i).setNit(nit);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateClient(IdType type,String id, String name, String phone, String adress) {
		for (int i = 0; i<clients.size(); i++) {
			
		}
		
		return false;
	}
}
