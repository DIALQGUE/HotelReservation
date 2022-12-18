import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class Hotel {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Room> roomList;
    private ArrayList<Booking> bookingList;

    // Initialize the hotel with 3 rooms
    public Hotel() {
        this.roomList = new ArrayList<Room>();
        this.roomList.add(new PremiumRoom(101));
        this.roomList.add(new DeluxeRoom(102));
        this.roomList.add(new GrandSuiteRoom(103));
        this.bookingList = new ArrayList<Booking>();
    }

    // Search for a room by room number. Return empty room if not found.
    private Room searchRoom(int roomNumber) {
        for (Room room : roomList) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null; //null room
    }

    // Get list of empty rooms.
    private ArrayList<Room> getEmptyRoomList() {
        ArrayList<Room> emptyRoomList = new ArrayList<Room>();
        for (Room room : roomList) {
            if (!room.isReserved()) {
                emptyRoomList.add(room);
            }
        }
        return emptyRoomList;
    }

    // Print list of empty rooms.
    private void printEmptyRoom() {
        for (Room room : roomList) {
            if (!room.isReserved()) {
                System.out.println("Room number " + room.getNumber() + " : " + room.getRoomType());
            }
        }
        System.out.println("");
    }

    // Print each rooms' description.
    private void printRoomDescription() {
        System.out.println("- " + (new PremiumRoom()).getDescription());
        System.out.println("- " + (new DeluxeRoom()).getDescription());
        System.out.println("- " + (new GrandSuiteRoom()).getDescription());
    }

    // Add a booking to the booking list.
    private void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

    // Remove a booking from the booking list.
    private void removeBooking(Booking booking) {
        this.bookingList.remove(booking);
    }

    // Get all guests' info from user. 
    private ArrayList<Guest> getGuestInformation(int guestCount) {
        ArrayList<Guest> guestList = new ArrayList<Guest>();

        for (int i = 0; i < guestCount; i++) {
            System.out.println("============================");
            System.out.printf("Guest No.%d\n", i + 1);
            System.out.print("Please input your full name:\t");
            String inputFullName = scanner.nextLine();
            System.out.print("Please input your phone:\t");
            String inputPhone = scanner.nextLine();
            System.out.print("Please input your email:\t");
            String inputEmail = scanner.nextLine();
            Guest newGuest = new Guest(inputFullName, inputPhone, inputEmail);
            guestList.add(newGuest);
        }
        return guestList;
    }

    // Validate checkin and checkout date info.
    private boolean validateDate(Date dateCheckIn, Date dateCheckOut) {
        Date currentDate = new Date();
        if (dateCheckIn.compareTo(currentDate) < 0) {
            System.out.println("Sorry, you have to book in advance atleast 1 day.");
            return false;
        }
        if (dateCheckOut.compareTo(dateCheckIn) < 0) {
            System.out.println("Sorry, minimum stay period is 1 day.");
            return false;
        }
        return true;
    }

    // Get date info from user.
    private ArrayList<Date> getDateInformation() {
        Date dateCheckIn = new Date();
        Date dateCheckOut = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMMM yyyy", new Locale("en", "TH"));
        while (true) {
            System.out.print("\nPlease input check-in date (dd/MM/yyyy): ");
            dateCheckIn = Input.getDate();
            System.out.print("\nPlease input check-out date (dd/MM/yyyy): ");
            dateCheckOut = Input.getDate();
            System.out.println("\nYour check-in date is\t" + dateFormat.format(dateCheckIn));
            System.out.println("Your check-out date is\t" + dateFormat.format(dateCheckOut));
            if (validateDate(dateCheckIn, dateCheckOut)) {
                break;
            }
            else
                System.out.println("Please enter your check-in/out date again.\n");
        }
        ArrayList<Date> dateInfo = new ArrayList<Date>();
        dateInfo.add(dateCheckIn);
        dateInfo.add(dateCheckOut);
        return dateInfo;
    }

    // Get selected room info from user.
    private Room getRoomInformation() {
        ArrayList<Room> emptyRoomList = getEmptyRoomList();
        System.out.printf("\nThere are %d rooms available:\n", emptyRoomList.size());
        for (Room room : emptyRoomList) {
            System.out.printf("Room Number " + room.getNumber());
            if (room instanceof PremiumRoom) {
                System.out.println(" | Room Type: Premium Room");
            }
            else if (room instanceof DeluxeRoom) {
                System.out.println(" | Room Type: Deluxe Room");
            }
            else if (room instanceof GrandSuiteRoom) {
                System.out.println(" | Room Type: Grand Suite Room");
            }
        }
        while (true) {
            System.out.print("\nPlease choose your room number: ");
            int roomNumber = scanner.nextInt();
            Room room = searchRoom(roomNumber);
            if (emptyRoomList.contains(room)) {
                return room;
            }
            else {
                System.out.println("Invalid room number");
            }
        }
    }

    //// NEW added method : using to get payment information
    // Get payment method from user.
    private String getPaymentMethodInformation() {
        System.out.print("Please select your payment method (1 = Cash | 2 = Credit/Debit Card): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 1 && choice != 2) {
            System.out.println("Please enter '1' or '2' (1 = Cash | 2 = Credit/Debit Card)");
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        if(choice == 1) return "Cash";
        else return "Credit/Debit Card";
    }

    // Get all booking info from user.
    private Booking getBookingInformation() {
        System.out.print("How many guest(s) are you booking for: ");
        int guestCount = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Guest> guestList = getGuestInformation(guestCount);
        ArrayList<Date> dateInfo = getDateInformation();
        Room room = getRoomInformation();

        // Check room type and ask for additional amenities if needed.
        if (room instanceof DeluxeRoom) {
            DeluxeRoom deluxeRoom = (DeluxeRoom)room;
            if (Input.getYN("Do you want an additional single-sized bed (y/n): ")) deluxeRoom.addBed();
            
            for (Amenity amenity : deluxeRoom.getAmenityList()) {
                if (amenity instanceof CleaningService) {
                    ((CleaningService)amenity).makeAppointment();
                }
            }
        }
        // getYN("Do you want FoodPlus (y/n): ")
        else if (room instanceof GrandSuiteRoom) {
            GrandSuiteRoom grandSuiteRoom = (GrandSuiteRoom)room;
            if (Input.getYN("Do you want additional single-sized bed (y/n): ")) grandSuiteRoom.addBed();

            scanner.nextLine();
            if (Input.getYN("Do you want FoodPlus (y/n): "))
                grandSuiteRoom.addFoodPlusAmenity();
                
            if (Input.getYN("Do you want CleaningPlus (y/n): "))
                grandSuiteRoom.addCleaningPlusAmenity();

            for (Amenity amenity : grandSuiteRoom.getAmenityList()) {
                if (amenity instanceof CleaningService) {
                    ((CleaningService)amenity).makeAppointment();
                }
            }
            
        }
        // Calculating total price and get payment method.
        int stayDay = (int)TimeUnit.DAYS.convert(dateInfo.get(1).getTime() - dateInfo.get(0).getTime(), TimeUnit.MILLISECONDS);
        float totalPrice = room.getTotalPrice(stayDay);
        System.out.println("Total price will be: " + totalPrice);
        String paymentMethod = getPaymentMethodInformation();
        Transaction transaction = new Transaction(totalPrice, paymentMethod);
        return new Booking(guestList, dateInfo.get(0), dateInfo.get(1), room, transaction);
    }

    // Menu interface for application.
    private void showMenu() {
        System.out.println("============================================================");
        System.out.println("================== Welcome to Laork Hotel ==================");
        System.out.println("============================================================");
        System.out.println("===    What you want to do today?                        ===");
        System.out.println("===    1. See list of available rooms                    ===");
        System.out.println("===    2. See description of each room type              ===");
        System.out.println("===    3. Book a room                                    ===");
        System.out.println("===    4. Checkout                                       ===");
        System.out.println("============================================================");
    }

    // Get menu number from user.
    private int getMenu() {
        while(true) {
            showMenu();
            System.out.print("Please input menu number: ");
            //int menu = Integer.parseInt(scanner.nextLine());
            int menu = scanner.nextInt();
            //System.out.println(menu);
            if (menu >= 1 && menu <= 4) {
                return menu;
            }
        }
    }

    // Hotel booking application.
    public void startService() {
        while(true) {
            int menu = getMenu();
            if (menu == 1)
                printEmptyRoom();
            else if (menu == 2)
                printRoomDescription();
            else if (menu == 3) {
                Booking booking = getBookingInformation();
                booking.print();
                Transaction transaction = booking.getTransaction();
                if (transaction.confirm()) {
                    addBooking(booking);
                    booking.getRoom().reserve();
                }
                // System.out.println(bookingList);
            }
            else if (menu == 4) {
                Booking targetBooking = null;
                System.out.print("What is your room number: ");
                int roomNo = scanner.nextInt();
                for (Booking booking : bookingList) {
                    if (roomNo == booking.getRoom().getNumber()) {
                        targetBooking = booking;
                    }
                }
                // If room number is correct. Verify email address to checkout.
                if (targetBooking != null) {
                    scanner.nextLine();
                    System.out.print("PLease enter your email address: ");
                    String hostEmail = scanner.nextLine();
                    boolean verify = false;

                    for (Guest guest : targetBooking.getGuestList()) {
                        if(hostEmail.equals(guest.getEmail())) {
                            verify = true;
                        }
                    }

                    if (verify) {
                        targetBooking.getRoom().unReserve();
                        removeBooking(targetBooking);
                        System.out.println("Verification completed. Checkout completed.");
                        System.out.println("Thank you for staying with us. Hope to see you again.");
                    }
                    else {
                        System.out.println("Verification failed. Can't Checkout.");
                    }
                }
                else {
                    System.out.println("Wrong room number. No booking found.");
                }
            }
        }
    }
}
