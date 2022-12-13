from Room import *
from Booking import *

class Hotel:
    @property
    def emptyRoomList(self):
        return self.__emptyRoomList

    @property
    def occupiedRoomList(self):
        return self.__occupiedRoomList
    
    @property
    def bookingList(self):
        return self.__bookingList
    
    def __init__(self):
        self.__emptyRoomList = [
            PremiumRoom(100),
            PremiumRoom(101),
            DeluxeRoom(102),
            DeluxeRoom(103),
            GrandSuiteRoom(104)
        ]
        self.__occupiedRoomList = []
        self.__bookingList = []
    
    def searchRoom(self, roomNo):
        for room in self.__emptyRoomList:
            if roomNo == room.number:
                return room
    
    def showEmptyRoom(self):
        for room in self.emptyRoomList:
            print(room.number)

    def showRoomDescription(self):
        print(PremiumRoom().description)
        print(DeluxeRoom().description)
        print(GrandSuiteRoom().description)

    def addBooking(self, booking):
        self.__bookingList.append(booking)
    
    def getBookingInformation(self):
        print("How many guest(s) are you booking for: ", end="")
        guestCount = int(input())

        #get Guest(s) information
        guestList = []
        for i in range(guestCount):
            print("Guest no.%d" % (i+1))
            print("Please input your full name: ", end="")
            inputFullName = input()
            print("Please input your phone: ", end="")
            inputPhone = input()
            print("Please input your email: ", end="")
            inputEmail = input()
            guestList.append(Guest(inputFullName,inputPhone,inputEmail))

        #get Check-in Check-out information
        print("Please input check-in date: ", end="")
        dateCheckIn = input()
        print("Please input check-out date: ", end="")
        dateCheckOut = input()

        #get room object
        print("There are %d rooms available:" % len(self.emptyRoomList))
        for i, room in enumerate(self.emptyRoomList):
            print(str(i) + ". Room Number " + str(room.number))
        print()
        print("Please choose your room number: ", end="")
        roomNo = int(input())
        room = self.searchRoom(roomNo)

        #get price from room
        totalPrice = room.getTotalPrice()
        print("Total price will be " + str(totalPrice) + " baht.")

        #get payment method
        print("Please choose your payment method: ", end="")
        paymentMethod = "soul"
        transaction = Transaction(totalPrice, paymentMethod)

        #summary
        print(guestList)
        print(dateCheckIn)
        print(dateCheckOut)
        print(room)
        print(totalPrice)
        print(paymentMethod)

        return Booking(guestList, dateCheckIn, dateCheckOut, room, transaction)



