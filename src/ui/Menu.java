package ui;

import java.io.IOException;
import java.util.Scanner;

import exceptions.ClientNotFoundException;
import model.Client;
import model.IdType;
import model.Manager;
import model.Order;
import model.Product;
import model.Restaurant;

/**
 * creates the Menu class
 * @author Juan Fernando
 *
 */
public class Menu {
	static Scanner sc = new Scanner(System.in); 
	private Manager manager;
	public Menu() {
		try {
			this.manager = new Manager();
		}catch (IOException e) {
			System.out.println("no fue posible cargar el estado de la aplicacion");
		}catch (ClassNotFoundException c) {
			System.out.println("no fue posible cargar el estado de la aplicacion");
		}
		
	}
	
	/**
	 * stars menu flow
	 */
	public void menu() {
		boolean onUse = true;
		while (onUse) {
			System.out.println(viewMenuOptions());
			
			onUse = manageMenuChoice();
		}
		
	}
	
	/**
	 * gets String with options
	 * @return String with menu options
	 */
	private String viewMenuOptions() {
		String options;
		options = "======================\n";
		options+= "      Main Menu\n";
		options+= "======================\n";
		options+= "1.Registrar Datos\n";
		options+= "2.Actualizar Datos\n";
		options+= "3.Listas\n";
		options+= "4.Buscar Cliente\n";
		options+= "5.Exportar/Importar Datos\n";
		options+= "6.salir\n";
		return options;
	}
	
	/**
	 * manage the main menu flow
	 * @return true if the flow must continue and false if the flow must finish
	 */
	private boolean manageMenuChoice() {
		int choice;
		do {
			choice = Integer.parseInt(sc.nextLine());
		}while (choice <1 || choice > 6 );
		
		switch (choice) {
		case 1: registeData(); break;
		case 2: updateData(); break;
		case 3: lists(); break;
		case 4: searchClient(); break;
		case 5: manageData(); break; 
		case 6: 
			try {
				manager.saveStatus();
				return false;
				
			}catch (IOException e) {
				System.out.println("no fue posible guardar el estado");
			}catch (ClassNotFoundException c) {
				System.out.println("no fue posible guardar el estado");
			}
			
			break;
		}
		return true;
	}

	
	/**
	 * import and import and export data
	 */
	private void manageData() {
		System.out.println("1. exportar datos de ordenes  2. importar datos");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		
		case 1:
			try {
				System.out.println("Escriba el nombre del archivo(sin extencion)");
				String filePath = "data/"+sc.nextLine()+".csv";
				System.out.println("Escriba el separador con el cual desea ordenar la informacion");
				String separator = sc.nextLine();
				manager.exportOrders(filePath, separator);
			}catch (IOException e) {
				System.out.println("no fue posible Exportar la informacion");
			}
			
			break;
		case 2:
			try {
				System.out.println("Escriba el separador que se usa en los archivos");
				String separator = sc.nextLine();
				manager.importData(separator);
			}catch (IOException e) {
				System.out.println("no fue posible importar los datos");
			}
			
		}
		
	}

	/**
	 * search client given the first Name
	 */
	private void searchClient() {
		System.out.println("Escriba el nombre del cliente que desea buscar");
		String name = sc.nextLine();
		try {
			Client  client = manager.searchClient(name);
			System.out.println("Nombre: "+client.getFirstName()+" "+client.getLastName());
			System.out.println("Identificacion: "+client.getId());
			System.out.println("Numero de telfono: "+client.getPhone());
			System.out.println("Direccion: "+client.getAdress());
		}catch (ClientNotFoundException e) {
			System.err.println("El cliente no fue encontrado");
		}
		
		
	}

	/**
	 * list restaurants and clients 
	 */
	private void lists() {
		System.out.println("1. lista de clientes  2. lista de restaurantes");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1: System.out.println(manager.listClients()); break;
		case 2: System.out.println(manager.listRestaurants());break;
		default: System.out.println("La opcion ingresada no es valida");
		}
		
	}

	/**
	 * manage update data flow 
	 */
	private void updateData() {
		int choice = updatingMenu();
		switch (choice) {
		case 1: updateRestaurant(); break;
		case 2: updateProduct(); break;
		case 3: updateClient(); break;
		case 4: updateOrder(); break;
		default: System.out.println("ninguna opcion valida fue ingresada");
		}
		
	}
	
	/**
	 * manage the updating choices 
	 * @return Integer between 1 and 5
	 */
	private int updatingMenu() {
		String options;
		options = "=====================================\n";
		options+= "1.Actualizar datos de restaurante\n";
		options+= "2.Actualizar datos de producto\n";
		options+= "3.Actualizar datos de Pedido\n";
		options+= "4.Actualizar datos de cliente\n";
		options+= "5.Actualizar estado de pedido\n";
		
		System.out.println(options);
		int choice = Integer.parseInt(sc.nextLine());
		return choice;
	}
	
	/**
	 * update restaurant object from manager restaurants list
	 */
	private void updateRestaurant() {
		System.out.println("Escriba el nit del restaurante a actualizar");
		String nit = sc.nextLine();
		System.out.println("Escriba el nuevo nombre del restaurante");
		String name = sc.nextLine();
		System.out.println("Escriba el nombre del nuevo administrador del restaurante");
		String admin = sc.nextLine();
		manager.updateRestaurant(nit, name, admin);
	}
	
	/**
	 * update product object form manager products list
	 */
	private void updateProduct() {
		System.out.println("Escriba el codigo del producto a modificar");
		String code = sc.nextLine();
		System.out.println("Escriba el nuevo nombre del producto");
		String name = sc.nextLine();
		System.out.println("Escriba la nueva descripcion del producto");
		String info = sc.nextLine();
		System.out.println("Escriba el nit del restaurante que lo ofrece");
		String nit = sc.nextLine();
		System.out.println("Escriba el nuevo costo del producto");
		double cost = Double.parseDouble(sc.nextLine());
		manager.updateProduct(code, name, info, nit, cost);
	}
	
	/**
	 * update client object from manager clients list
	 */
	private void updateClient() {
		System.out.println("Escriba el numero de identificaion del cliente que desea actualizar");
		String id = sc.nextLine();
		System.out.println("Escriba el nuevo nombre del cliente");
		String firstName = sc.nextLine();
		System.out.println("Escriba el nuevo apellido del cliente");
		String lastName = sc.nextLine();
		System.out.println("Escriba el nuevo numero de telefono del clientente");
		String phone = sc.nextLine();
		System.out.println("Escriba la direccion del cliente");
		String adress = sc.nextLine();
		
		if (manager.updateClient(id, firstName, lastName, phone, adress, createIdType())) {
			System.out.println("Operacion completada con exito");
		}else {
			System.out.println("No fue posible actualizar la informacion ");
		}
	}
	
	/**
	 * update order object from manager orders list
	 */
	private void updateOrder() {
		System.out.println("Escriba el codigo de la orden que desea actualizar");
		String code = sc.nextLine();
		System.out.println("Escriba el nuevo codigo del cliente que ha hecho el pedido");
		String clientCode = sc.nextLine();
		System.out.println("Escriba el nuevo nit del restaurante donde se hace el pedido");
		String nit = sc.nextLine();
		if (manager.updateOrder(code, clientCode, nit)) {
			System.out.println("Informacion actualizada con exito");
		}else {
			System.out.println("No fue posible actualizar la informacion");
		}
	}

	/**
	 * manage the register options flow
	 */
	private void registeData() {
		System.out.println(registerDataMenu());
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1: 
			// register a new Restaurant
			manager.registerRestaurants(createRestaurant()); break;
		case 2: 
			// register a new Product
			manager.registerProduct(createProduct()); break;
		case 3:
			// register a new order 
			manager.registerOrder(createOrder()); break;
		case 4: 
			// register a new Client
			manager.registerClient(createClient()); break;
		}
		
	}
	
	/**
	 * creates a restaurant object with user specifications 
	 * @return Restaurant !null
	 */
	private Restaurant createRestaurant() {
		System.out.println("Escriba el nombre del restaurante");
		String name = sc.nextLine();
		System.out.println("Escriba el nit del restaurante");
		String nit = sc.nextLine();
		System.out.println("Escriba el nombre del administrador del restaurante");
		String admin = sc.nextLine();
		Restaurant restaurant = new Restaurant(name, nit, admin);
		return restaurant;
	}
	
	/**
	 * creates a client object with user specifacations
	 * @return Client !null
	 */
	public Client createClient() {
		
		System.out.println("Escriba el numero de identidad");
		String id = sc.nextLine();
		System.out.println("Escriba el nombre del cliente");
		String firstName = sc.nextLine();
		System.out.println("Escriba el apellido del cliente");
		String lastName = sc.nextLine();
		System.out.println("Escriba el numero de telefono del cliente");
		String phone = sc.nextLine();
		System.out.println("Escriba la direccion del cliente");
		String adress = sc.nextLine();
		Client client = new Client(createIdType(), id, firstName, lastName, phone, adress);
		return client;
	}
	
	/**
	 * parse String given by user to IdType
	 * @return IdType !null
	 */
	private IdType createIdType() {
			System.out.println("Escriba el tipo de documento: TI || CC || CE || PP , recuerde usar mayusculas");
			String choice = sc.nextLine();
			switch (choice) {
			case "CC": return IdType.CC; 
			case "TI": return IdType.TI; 
			case "CE": return IdType.CE; 
			case "PP": return IdType.PP; 
			default: System.out.println("Eleccion invalida");
			}
			return IdType.CC;
		}
		
	/**
	 * creates a product object with user specifications 
	 * @return Products !null
	 */
	private Product createProduct() {
		System.out.println("Escriba el codigo del producto");
		String code = sc.nextLine();
		System.out.println("Escriba el nombre del producto");
		String name = sc.nextLine();
		System.out.println("Escriba la descricion del producto");
		String info = sc.nextLine();
		System.out.println("Escriba el nit del restaurante");
		String nit = sc.nextLine();
		System.out.println("Escriba el costo del producto");
		double cost = Double.parseDouble(sc.nextLine());
		Product product = new Product(code, name, info, nit, cost);
		
		return product;
	}
	
	/**
	 * creates Order object with user specifications
	 * @return Order !null
	 */
	private Order createOrder() {
		
		System.out.println("Escriba el codigo del cliente");
		String clientCode = sc.nextLine();
		System.out.println("Escriba el nit del restaurante");
		String restaurantNit = sc.nextLine();
		Order order = new Order(clientCode, restaurantNit);
		System.out.println("El codigo de pedido es: "+order.getCode());
		return order;
	}
	
	/**
	 * gets the options of the register menu
	 * @return String with options
	 */
	private String registerDataMenu() {
		String options;
		options = "====================\n";
		options+= "1. Registrar nuevo Restaurante\n";
		options+= "2. Registrar nuevo Producto\n";
		options+= "3. Registrar nuevo Pedido\n";
		options+= "4. Registrar nuevo Cliente\n";
		
		return options;
	}
	
	
}
