package com.model;

import java.util.ArrayList;

public class Database {
	//Creating the arraylists that will hold all the users
	private static ArrayList<Users> allUsers = new ArrayList<>();
	
	//Creating the arraylists for the different users
	private static ArrayList<Admin> adminsArray = new ArrayList<>();
	private static ArrayList<Manager> managersArray = new ArrayList<>();
	private static ArrayList<DeliveryMan> deliverymansArray = new ArrayList<>();
	private static ArrayList<Dispatch> dispatchArray = new ArrayList<>();
	private static ArrayList<Client> clientsArray = new ArrayList<>();
	
	//Creating the different users
	Admin admin = new Admin(1, "jean", "jean123", "Jean-Loup", "Davidson", "jean@gmail.com", "(514)111-0000", "123 Fake Street", 1, "Active");
	Manager manager = new Manager(2, "manager", "manager123", "John", "Doe", "john_doe@gmail.com", "(514)222-1111", "456 Fake Avenue", 2, "Active");
	DeliveryMan deliveryMan = new DeliveryMan(3, "delivery", "delivery123", "Jane", "Smith", "(514)000-3333", "A1A,B2B", 3, "Active");
	Dispatch dispatch = new Dispatch(4, "dispatch", "dispatch123", "Jeanne", "David", "jeannedavid@hotmail.com", "(514)999-3214", "789 Unknown Boulevard", 4, "Active");
	Client client = new Client(5, "client", "client123", "Joe", "Bloe", "jobloe321@gmail.com", "(514)789-6543", "8528 This Street", 5, "Active");
	
	//Constructor
	public Database() {
		adminsArray.add(admin);
		managersArray.add(manager); 
		deliverymansArray.add(deliveryMan);
		dispatchArray.add(dispatch);
		clientsArray.add(client);
		
		//Adding every arraylist inside the users arraylist
		allUsers.addAll(adminsArray);
		allUsers.addAll(managersArray);
		allUsers.addAll(deliverymansArray);
		allUsers.addAll(dispatchArray);
		allUsers.addAll(clientsArray);
		
	}
	
	 /************************** All Users Section **************************/
	 
	 //Add inside the all users arraylist
	 public static void addInsideUsers(Users user) {
		 allUsers.add(user);
	 }
	 
	 //Edit inside the all users arraylist
	 public static void editInsideUsers(Users user, int index) {
		 allUsers.set(index, user);
	 }
	 
	 //Remove inside the all users arraylist
	 public static void deleteInsideUsers(int index) {
		 allUsers.remove(index);
	 }
	 
	 /************************ End All Users Section ************************/
	
	/**************************** Admin Section ***************************/
	
	 //Create Admin
	 public static void addAdmin(Admin admin) {
	 	adminsArray.add(admin);
	 }
	 	
	 //Edit Admin
	 public static void editAdmin(Admin admin, int index) {
		adminsArray.set(index, admin);
	 }
		 
	//Delete Admin
	 public static void deleteAdmin(int index) {
		 adminsArray.remove(index);
	 }
	 
	 /************************** End Admin Section **************************/
	 
	 /*************************** Manager Section ***************************/
	 
	 //Create Manager
	 public static void addManager(Manager manager) {
		 managersArray.add(manager);
	 }
	 	
	 //Edit Manager
	 public static void editManager(Manager manager, int index) {
		 managersArray.set(index, manager);
	 }
		 
	//Delete Manager
	 public static void deleteManager(int index) {
		 managersArray.remove(index);
	 }
	 
	 /************************* End Manager Section *************************/
	 
	 /************************ Delivery Man Section *************************/
	 
	 //Create Delivery Man
	 public static void addDeliveryMan(DeliveryMan deliveryMan) {
		 deliverymansArray.add(deliveryMan);
	 }
	 
	 //Edit Delivery Man
	 public static void editDeliveryMan(DeliveryMan deliveryMan, int index) {
		 deliverymansArray.set(index, deliveryMan);
	 }
	 
	 //Delete Delivery Man
	 public static void deleteDeliveryMan(int index) {
		 deliverymansArray.remove(index);
	 }
	 
	 /********************** End Delivery Man Section ***********************/
	 
	 /*************************** Client Section ****************************/
	 
	 //Create Client
	 public static void addNewClient(Client newClient) {
		 clientsArray.add(newClient);
	 }
	 
	 //Edit Client
	 public static void editClient(Client editClient, int index) {
		 clientsArray.set(index, editClient);
	 }
	 
	 //Delete Client
	 public static void deleteClient(int index) {
		 clientsArray.remove(index);
	 }
	 
	 /************************ End of Client Section ************************/
	 

	 /*
	  * Getters and Setters for the users array
	  * */
	public static ArrayList<Users> getAllUsers() {
		return allUsers;
	}

	public static void setAllUsers(ArrayList<Users> allUsers) {
		Database.allUsers = allUsers;
	}

	 /*
	  * Getters and Setters for the admin array
	  * */
	public static ArrayList<Admin> getAdminsArray() {
		return adminsArray;
	}

	public static void setAdminsArray(ArrayList<Admin> adminsArray) {
		Database.adminsArray = adminsArray;
	}

	 /*
	  * Getters and Setters for the manager array
	  * */
	public static ArrayList<Manager> getManagersArray() {
		return managersArray;
	}

	public static void setManagersArray(ArrayList<Manager> managersArray) {
		Database.managersArray = managersArray;
	}

	 /*
	  * Getters and Setters for the delivery man array
	  * */
	public static ArrayList<DeliveryMan> getDeliverymansArray() {
		return deliverymansArray;
	}

	public static void setDeliverymansArray(ArrayList<DeliveryMan> deliverymansArray) {
		Database.deliverymansArray = deliverymansArray;
	}

	 /*
	  * Getters and Setters for the dispatch array
	  * */
	public static ArrayList<Dispatch> getDispatchArray() {
		return dispatchArray;
	}

	public static void setDispatchArray(ArrayList<Dispatch> dispatchArray) {
		Database.dispatchArray = dispatchArray;
	}

	 /*
	  * Getters and Setters for the clients array
	  * */
	public static ArrayList<Client> getClientsArray() {
		return clientsArray;
	}

	public static void setClientsArray(ArrayList<Client> clientsArray) {
		Database.clientsArray = clientsArray;
	}
	 
	 
		
}
