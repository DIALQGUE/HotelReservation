from Hotel import Hotel

def showMenu():
    print("============================================================")
    print("================== Welcome to Laork Hotel ==================")
    print("============================================================")
    print("===    What you want to do today?                        ===")
    print("===    1. See list of available rooms                    ===")
    print("===    2. See description of each room type              ===")
    print("===    3. Book a room                                    ===")
    print("===    4. Give feedback                                  ===")
    print("============================================================")

def getMenu():
    while True:
        showMenu()
        print("Please input menu number: ", end="")
        menu = int(input())
        if menu in [1, 2, 3]:
            return menu
        input("Wrong menu! Please try again...\n")

def main():
    hotel = Hotel()

    menu = getMenu()
    if menu == 1:
        hotel.showEmptyRoom()
    elif menu == 2:
        hotel.showRoomDescription()
    elif menu == 3:
        booking = hotel.getBookingInformation()
        hotel.addBooking(booking)
    elif menu == 4:
        print("Tell us anything :)")
        input()

def testRoom():
    from Room import PremiumRoom, DeluxeRoom, GrandSuiteRoom
    print(PremiumRoom(100).description)
    print(DeluxeRoom(100).getTotalPrice())
    print(GrandSuiteRoom(100).getTotalPrice())

testRoom()
