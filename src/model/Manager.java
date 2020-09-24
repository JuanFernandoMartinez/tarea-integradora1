package model;
import java.util.List;

import comparators.OrderComparator;
import exceptions.ClientNotFoundException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
				x.setClientId(clientCode);
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
	
	public void exportOrders(String filePath,String separator) throws IOException {
		OrderComparator comparator = new OrderComparator();
		Collections.sort(orders, comparator);
		
		PrintWriter writer = new PrintWriter(filePath);
		String line;
		line = "Restaurant nit"+separator+"Client ID"+separator+"Date"+separator+"Order Code\n";
		writer.println(line);
		for (Order o:orders) {
			line = o.getRestaurantNit()+separator+o.getClientId()+separator+o.getDate()+separator+o.getCode();
			writer.println(line);
		}
		
		writer.close();
		
		
	}
	
	public String listRestaurants() {
		for (int i = restaurants.size(); i>0; i--) {
			for (int j = 0; j<i; j++) {
				if (restaurants.get(j).getName().compareTo(restaurants.get(j+1).getName()) == 1) {
					Restaurant aux = restaurants.get(j);
					restaurants.set(j, restaurants.get(j+1));
					restaurants.set(j+1, aux);
				}
			}
		}
		String list = "";
		for (Restaurant x: restaurants) {
			list+= x.getName()+"\n";
		}
		
		return list;
	}
	
	public String listClients() {
		LinkedList<Client> clientsAux = (LinkedList<Client>)clients;
		for (int i = 0; i<clientsAux.size(); i++) {
			int max = i;
			for (int j = 0; j<clientsAux.size();j++) {
				if (clientsAux.get(j).getPhone().compareTo(clientsAux.get(max).getPhone())==-1) {
					max = j;
				}
				
			}
			Client cl = clients.get(i);
			clients.set(i, clients.get(max));
			clients.set(max, cl);
		}
		String clientsString = "";
		for (Client x:clients) {
			clientsString += x.getFirstName()+" "+x.getLastName()+"\n";
		}
		
		return clientsString;
	}
	
	public Client searchClient(String name) throws ClientNotFoundException{
		int index = -1;
		for (int i = 0;i<clients.size(); i++) {
			if (clients.get(i).getFirstName().equals(name)) {
				index = i;
			}
		}
		if (index == -1) {
			throw new ClientNotFoundException();
		}else {
			return clients.get(index);
		}
		
	}
	
	
		
	
	
}
