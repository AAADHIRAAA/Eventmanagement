import java.util.*;
import java.util.Locale.Category;

class User{
    private int userId;
    private String userName;
    private String password;
    private String address;
    private String phone;
    
    public User(int userId, String userName, String password, String address, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
    
    
   
}

class Admins{

    private int adminId;
    private String name;
    private String password;
    private String address;
    private String phone;

    public Admins(int adminId, String name, String password, String address, String phone) {
        this.adminId = adminId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    
    
}

class Events{

    private int eventId;
    private String title;
    private String date;
    private String time;
    private String location;
    private String description;
    private String category;
    private int availableTickets;
    private Admins admin;

    public Events(int eventId, String title, String date, String time, String location, String description,
            String category, int availableTickets, Admins admin) {
        this.eventId = eventId;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.category = category;
        this.availableTickets = availableTickets;
        this.admin = admin;
    }

    public int getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public Admins getAdmin() {
        return admin;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }


}


class Booking{

    private int bookingId;
    private Events eventId;
    private User userId;
    private String paymentMethod;
    private String cvv;
    private String month;
    private String year;
    private int amount;
    private String time;
    private String status;

    public Booking(int bookingId, Events eventId, User userId, String paymentMethod, String cvv, String month,
            String year, int amount, String time, String status) {
        this.bookingId = bookingId;
        this.eventId = eventId;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.cvv = cvv;
        this.month = month;
        this.year = year;
        this.amount = amount;
        this.time = time;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Events getEventId() {
        return eventId;
    }

    public User getUserId() {
        return userId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCvv() {
        return cvv;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public int getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    
    
}

class Tickets{
    private int ticketId;
    private Booking bookingId;
    private String description;
    
    public Tickets(int ticketId, Booking bookingId, String description) {
        this.ticketId = ticketId;
        this.bookingId = bookingId;
        this.description = description;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Booking getBookingId() {
        return bookingId;
    }

    public String getDescription() {
        return description;
    }

    
}

class EventManagementPortal{

    private List<Admins> admins;
    private List<User> users;
    private List<Events> events;
    private Queue<Booking> bookings;
    private Queue<Tickets> tickets;
    private Scanner sc=new Scanner(System.in);

    public EventManagementPortal() {
        this.admins = new ArrayList<>();
        this.users = new ArrayList<>();
        this.events = new ArrayList<>();
      
    }

    public List<Admins> getAdmins() {
        return admins;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Events> getEvents() {
        return events;
    }

    public Queue<Booking> getBookings() {
        return bookings;
    }

    public Queue<Tickets> getTickets() {
        return tickets;
    }

    public void createEvent(Events event, Admins admin){
            if(validate(admin.getAdminId())){
                events.add(event);
            }
     
    }
   
    public boolean validate(int adminId){
        for(Admins admin: admins){
            if(admin.getAdminId()== adminId){
                return true;
            }
        }
        return false;
    }

    public void addAdmin(Admins admin){
        admins.add(admin);
        System.out.println("Admin registered successfully");
    }
    public void addUser(User user){
        users.add(user);
        System.out.println("User registered successfully");
    }
    public void displayEvents(){
        for(Events event: events){
            System.out.println("EventName: " + event.getTitle());
            System.out.println("EventDate: "+event.getDate());
            System.out.println("EventTime: "+ event.getTime());
            System.out.println("Location: "+event.getLocation());
            System.out.println("Description: "+ event.getDescription());
            System.out.println("Category: "+event.getCategory());
            System.out.println("Available Tickets: "+ event.getAvailableTickets());
        }
    }
   
    public User validateUser(int userId){
        for(User user: users){
            if(user.getUserId()==userId){
               
                return user;
            }
        }
        return null;
    
    
    }

    public void searchEvents(String category){
        for(Events event: events){
            if(event.getCategory().equalsIgnoreCase(category)){
            System.out.println("EventName: " + event.getTitle());
            System.out.println("EventDate: "+event.getDate());
            System.out.println("EventTime: "+ event.getTime());
            System.out.println("Location: "+event.getLocation());
            System.out.println("Description: "+ event.getDescription());
            System.out.println("Category: "+event.getCategory());
            System.out.println("Available Tickets: "+ event.getAvailableTickets());
            }
        }
    }
    public void userPanel(User loggedInUser){
        while(loggedInUser!=null){
            System.out.println("1. View Events");
            System.out.println("2.Search Events");
            System.out.println("3.Register Events");
            System.out.println("4.exit");
            System.out.println("Enter choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayEvents();
                    break;
                case 2:
                    System.out.println("Enter category");
                    sc.nextLine();
                    String category= sc.nextLine();
                    searchEvents(category);
                    break;
                case 3:
                    break;
                    
                case 4:
                    loggedInUser=null;
                    break;
                
                
                default:
                    break;
            }
        }
    }
      
    
}

public class EventManagement{

    public static void main(String[] args) {


        EventManagementPortal portal = new EventManagementPortal();
        Admins admin = new Admins(1, "john", "john@123", "chennai", "9898989898");
        portal.addAdmin(admin);

        Events event1 = new Events(1, "poetry", "2024-06-22","11.00AM", "chennai", "literature event","literature", 20, admin);
        portal.createEvent(event1,admin);
        Events event2 = new Events(2, "poetry", "2024-06-22","11.00AM", "chennai", "literature event","singing", 20, admin);
        portal.createEvent(event2,admin);
        portal.displayEvents();

        User user = new User(1,"priya","priya@email.com","priya@123","9090909090");
        portal.addUser(user);
        User loggedInUser = portal.validateUser(user.getUserId());
        if(loggedInUser!=null){
            portal.userPanel(loggedInUser);
        }
        
    }
}