class Booking:
    @property
    def host(self):
        return self.__host
    @host.setter
    def host(self, newHost):
        self.__host = newHost
    
    @property
    def dateCheckIn(self):
        return self.__dateCheckIn
    @dateCheckIn.setter
    def dateCheckIn(self, newDateCheckIn):
        self.__dateCheckIn = newDateCheckIn

    @property
    def dateCheckOut(self):
        return self.__dateCheckOut
    @dateCheckOut.setter
    def dateCheckOut(self, newDateCheckOut):
        self.__dateCheckOut = newDateCheckOut

    @property
    def room(self):
        return self.__room
    @room.setter
    def room(self, newRoom):
        self.__room = newRoom

    @property
    def transaction(self):
        return self.__transaction
    @transaction.setter
    def transaction(self, newTransaction):
        self.__transaction = newTransaction

    def __init__(self, host, dateCheckIn, dateCheckOut, room, transaction):
        self.__host = host
        self.__dateCheckIn = dateCheckIn
        self.__dateCheckOut = dateCheckOut
        self.__room = room
        self.__transaction = transaction
    
class Guest:
    @property
    def fullName(self):
        return self.__fullName
    @fullName.setter
    def fullName(self, newFullName):
        self.__fullName = newFullName

    @property
    def phone(self):
        return self.__phone
    @phone.setter
    def phone(self, newPhone):
        self.__phone = newPhone
    
    @property
    def email(self):
        return self.__email
    @email.setter
    def email(self, newEmail):
        self.__email = newEmail

    def __init__(self, fullName, phone, email):
        self.__fullName = fullName
        self.__phone = phone
        self.__email = email

class Transaction:
    @property
    def totalPrice(self):
        return self.__totalPrice
    @totalPrice.setter
    def totalPrice(self, newTotalPrice):
        self.__totalPrice = newTotalPrice
    
    @property
    def paymentMethod(self):
        return self.__paymentMethod
    @paymentMethod.setter
    def paymentMethod(self, newPaymentMethod):
        self.__paymentMethod = newPaymentMethod

    def __init__(self, totalPrice, paymentMethod):
        self.__totalPrice = totalPrice
        self.__paymentMethod = paymentMethod