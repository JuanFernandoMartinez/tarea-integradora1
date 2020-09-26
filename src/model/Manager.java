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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class Manager {
	
	// serial files
	private final static String RESTAURANTSFILE = "Data/restaurants.king";
	private final static String CLIENTSFILE = "Data/clients.king";
	private final static String PRODUCTSFILE = "Data/products.king";
	private final static String ORDERSFILE = "Data/orders.king";
	
	// csv Files
	private final static String RESTAURANTSCSV = "Data/restaurantsCSV.csv";
	private final static String PRODUCTSCSV = "Data/productssCSV.csv";
	private final static String CLIENTSCSV = "Data/clientsCSV.csv";
	private final static String ORDERSCSV = "Data/ordersCSV.csv";
	
	private List<Restaurant> restaurants;
	private List<Client> clients;
	private List<Order> orders;
	private List<Product> products;
	
	/**
	 * creates a new Manager Object
	 */
	public Manager()throws IOException, ClassNotFoundException {
		loadStatus();
	}
	
	/**
	 * load previous program status
	 * <b>pre:</b> this object must be initialized 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadStatus()throws IOException, ClassNotFoundException  {
		loadClients();
		loadOrders();
		loadProducts();
		loadRestaurants();
	}
	
	
	/**
	 * loads clients list from serial file <br>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadClients() throws IOException, ClassNotFoundException {
		File file = new File(CLIENTSFILE);
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			clients = (LinkedList)ois.readObject();
			ois.close();
		}else {
			restaurants = new LinkedList<>();
			products = new LinkedList<>();
			clients = new LinkedList<>();
			orders = new LinkedList<>();
		}
	}
	
	/**
	 * loads products list form serial file <br>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadProducts() throws IOException, ClassNotFoundException {
		File file = new File(PRODUCTSFILE);
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			products = (LinkedList)ois.readObject();
			ois.close();
		}else {
			products = new LinkedList<Product>();
		}
	}
	
	
	/**
	 * loads orders file from serial file <br>
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadOrders() throws IOException, ClassNotFoundException {
		File file = new File(ORDERSFILE);
		if (file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			orders = (LinkedList)ois.readObject();
			ois.close();
		}else {
			orders = new LinkedList<Order>();
		}
	}
	
	
	/**
	 * loads restaurants list from serial file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadRestaurants() throws IOException, ClassNotFoundException {
		File file = new File(RESTAURANTSFILE);
		ObjectInputStream ois;
		if (file.exists()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			restaurants = (LinkedList<Restaurant>) ois.readObject();
			ois.close();
			
		}else {
			restaurants = new LinkedList<Restaurant>();
		}
	}
	
	
	public void orderProducts() {
		Collections.sort(products);
	}
	
	
	
	/**
	 * register a new restaurant to the restaurants list
	 * @param r Restaurant object !null
	 */
	public void registerRestaurants(Restaurant r) {
		restaurants.add(r);
	}
	
	/**
	 * register a new Product to the products list
	 * @param p Product object !null
	 */
	public void registerProduct(Product p) {
		products.add(p);
		orderProducts();
	}
	
	/**
	 * register a new client to the clients list
	 * @param c Client object !null
	 */
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
	
	/**
	 * register a new order to the orders list
	 * @param o a Ordero object !null
	 */
	public void registerOrder(Order o) {
			orders.add(o);
		
	}
	
	
	/**
	 * update a restaurant given the nit 
	 * @param nit String !null
	 * @param name String !null
	 * @param admin String !null
	 * @return true if the operation was successful false in other case 
	 */
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
	
	/**
	 * update product given a code
	 * @param code String !null
	 * @param name String !null
	 * @param info String !null
	 * @param nit String !null
	 * @param cost double > 0
	 * @return true if the operation was successful false in other case 
	 */
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
	
	
	/**
	 * update client object given an id
	 * @param id String !null
	 * @param firstName String !null
	 * @param lastName String !null
	 * @param phone String !null
	 * @param adress String !null
	 * @param type IdType
	 * @return true if the operation was successful false in other case 
	 */
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
	
	
	/**
	 * update Order object
	 * @param code String !null
	 * @param clientCode String !null
	 * @param nit String !null
	 * @return true if the operation was successful false in other case 
	 */
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
	
	/**
	 * save status application to serial files
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
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
		oos.writeObject(orders);
		oos.close();
		
		file = new File(CLIENTSFILE);
		oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(clients);
		
		oos.close();
			
	}
	
	/**
	 * export orders list info to csv file separated by String given
	 * @param filePath
	 * @param separator
	 * @throws IOException
	 */
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
	
	/**
	 * gets the String with restaurants list names
	 * @return String !null
	 */
	public String listRestaurants() {
		for (int i = restaurants.size(); i>0; i--) {
			for (int j = 0; j<i; j++) {
				if (restaurants.get(j).compareTo(restaurants.get(j+1))==0) {
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
	
	/**
	 * gets the clients list names in a String variable
	 * @return String !null
	 */
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
	
	/**
	 * search client given a firstName
	 * @param name String !null
	 * @return if the client is found return Client !null in other case return null
	 * @throws ClientNotFoundException
	 */
	public Client searchClient(String name) throws ClientNotFoundException{
		int min = 0;
		int max = clients.size()-1;
		int index = (max+min)/2;
		boolean found = false;
		while (min<=max && !found) {
			if (clients.get(index).getFirstName().equals(name)) {
				found = true;
			}else if (clients.get(index).getFirstName().compareTo(name)== 1) {
				min = index+1;
				index = (max+min)/2;
			}else {
				max = index-1;
				index = (max+min)/2;
			}
		}
		if (found) {
			return clients.get(index);
		}else {
			return null;
		}
		
		
	}
	
	/**
	 * import data from csv files 
	 * @param separator
	 * @throws IOException
	 */
	public void importData(String separator) throws IOException {
		//import restaurants
		BufferedReader reader = new BufferedReader(new FileReader(RESTAURANTSCSV));
		String line = reader.readLine();
		line = reader.readLine();
		while (line != null) {
			String[] prt = line.split(separator);
			Restaurant restaurant = new Restaurant(prt[0],prt[1],prt[2]);
			restaurants.add(restaurant);
			line = reader.readLine();
		}
		reader.close();
		
		// import products
		
		reader = new BufferedReader(new FileReader(PRODUCTSCSV));
		line = reader.readLine();
		line = reader.readLine();
		while (line !=null) {
			String[] prt = line.split(separator);
			Product product = new Product(prt[0],prt[1],prt[2],prt[3],Double.parseDouble(prt[4]));
			products.add(product);
			
			line = reader.readLine();
		}
		reader.close();
		
		// import orders
		reader = new BufferedReader(new FileReader(ORDERSCSV));
		line = reader.readLine();
		line = reader.readLine();
		
		while (line != null) {
			String[] prt = line.split(separator);
			Order order = new Order(prt[0],prt[1]);
			orders.add(order);
			line = reader.readLine();
		}
		reader.close();
		
		// import clients
		
		reader = new BufferedReader(new FileReader(CLIENTSCSV));
		line = reader.readLine();
		line = reader.readLine();
		
		while (line != null) {
			String[] prt = line.split(separator);
			Client client = new Client(createIdType(prt[0]), prt[1], prt[2], prt[3], prt[4], prt[5]);
			registerClient(client);
			line = reader.readLine();
		}
		reader.close();
		
	}
	
	/**
	 * parse String to idType
	 * @param type String !null
	 * @return IdType !null 
	 */
	private IdType createIdType(String type) {
		if (type.equalsIgnoreCase("CC")) {
			return IdType.CC;
		}else if(type.equalsIgnoreCase("TI")) {
			return IdType.TI;
		}else if (type.equalsIgnoreCase("CE")) {
			return IdType.CE;
		}else if (type.equalsIgnoreCase("PP")) {
			return IdType.PP;
		}
		return IdType.CC;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
		
	
	
}
