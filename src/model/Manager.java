package model;
import java.util.List;

import comparators.OrderComparator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
public class Manager {
	
	// serial files
	private final static String RESTAURANTSFILE = "Data/restaurants.king";
	private final static String CLIENTSFILE = "Data/clients.king";
	private final static String PRODUCTSFILE = "Data/products.king";
	private final static String ORDERSFILE = "Data/orders.king";
	
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
	
	
	public void loadStatus()throws IOException, ClassNotFoundException  {
		File file = new File(RESTAURANTSFILE);
		ObjectInputStream ois;
		if (file.exists()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			restaurants = (LinkedList<Restaurant>)ois.readObject();
			ois.close();
			
		}
		file = new File(PRODUCTSFILE);
		if (file.exists()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			products = (LinkedList<Product>)ois.readObject();
			ois.close();
		}
		file = new File(ORDERSFILE);
		if (file.exists()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			orders = (LinkedList<Order>)ois.readObject();
			ois.close();
		}
		file = new File(CLIENTSFILE);
		if (file.exists()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			clients = (LinkedList<Client>)ois.readObject();
			ois.close();
		}
			
	}
	
	
	
	
	// register methods
	
	public void registerRestaurants(Restaurant r) {
		restaurants.add(r);
	}
	
	public void registerProduct(Product p) {
		products.add(p);
	}
	
	public void registerClient(Client c) {
		if (clients.isEmpty()) {
			clients.add(c);
		}else {
			int i = 0;
			while (clients.get(i).getLastName().compareTo(c.getLastName()) == 1 && clients.get(i).getFirstName().compareTo(c.getFirstName()) == 1) {
				i++;
			}
			clients.add(i, c);
			
		}
	}
	
	public void registerOrder(Order o) {
			orders.add(o);
		
	}
	
	
	public boolean updateRestaurant(String nit, String name, String admin) {
		for (Restaurant x:restaurants) {
			if (x.getNit().equals(nit)) {
				x.setAdmin(admin);
				x.setName(name);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateProduct(String code, String name, String info, String nit,double cost) {
		for (Product x:products) {
			if (x.getCode().equals(code)) {
				x.setCost(cost);
				x.setInfo(info);
				x.setName(name);
				x.setNit(nit);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateClient(String id, String firstName,String lastName, String phone, String adress, IdType type) {
		for (Client x:clients) {
			if (x.getId().equals(id)) {
				x.setAdress(adress);
				x.setFirstName(firstName);
				x.setLastName(lastName);
				x.setPhone(phone);
				x.setIdType(type);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateOrder(String code, String clientCode, String nit) {
		for (Order x:orders) {
			if (x.getCode().equals(code)) {
				x.setClientCode(clientCode);
				x.setRestaurantNit(nit);
				return true;
			}
		}
		return false;
	}
	
	public void saveStatus()throws IOException, ClassNotFoundException {
		File file = new File(RESTAURANTSFILE);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(restaurants);
		oos.close();
		
		file = new File(PRODUCTSFILE);
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(products);
		oos.close();
		
		file = new File(ORDERSFILE);
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(ORDERSFILE);
		oos.close();
		
		file = new File(CLIENTSFILE);
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(clients);
		
		oos.close();
			
	}
	
	public void bigOrder(String filePath) throws IOException {
		OrderComparator comparator = new OrderComparator();
		Collections.sort(orders, comparator);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
		for (Order o:orders) {
			String line;
			line = "Restaurant nit,Client ID,Date,Product Code\n";
			line+= ""
			
		}
		
		
	}
		
	
	
}
