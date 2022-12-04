from abc import ABC, abstractmethod
from datetime import datetime

class HotelRoom(ABC):
    def __init__(self, number):
        self.__number = number
    
    @property
    def number(self):
        return self.__number
    @number.setter
    def number(self, number):
        self.__number = number

    @property
    def price(self):
        return self.__price
    @price.setter
    def price(self, price):
        self.__price = price

    @property
    def roomSize(self):
        return self.__roomSize
    @roomSize.setter
    def roomSize(self, size):
        self.__roomSize = size

    @property
    def bedList(self):
        return self.__bedList
    @bedList.setter
    def bedList(self, beds):
        self.__bedList = beds
    
    @property
    def description(self):
        return self.__description
    @number.setter
    def number(self, description):
        self.__description = description

    @abstractmethod
    def getPrice(self):
        pass
    
class PremiumRoom(HotelRoom):
    def __init__(self, number):
        super().__init__(number)
        self.price = 1500
        self.roomSize = 30
        self.bedList = [SingleBedFactory().createBed()]
        self.description = "Premium Room come with single bed in room size 30 square feet at 1500 baht base price per night, cannot add extra bed or add amenities"
    
    def getPrice(self):
        return self.price

class DeluxeRoom(HotelRoom):
    def __init__(self, number):
        super().__init__(number)
        self.price = 2500
        self.roomSize = 40
        self.bedList = [DoubleBedFactory().createBed()]
        self.description = "Deluxe Room come with double bed in room size 40 square feet at 2500 baht base price per night, can add extra bed but cannot add amenities"
        self.__additionalBed = False
        self.__amenityList = []
    
    @property
    def additionalBed(self):
        return self.__additionalBed
    @additionalBed.setter
    def additionalBed(self, value):
        self.__additionalBed = value
    
    def addBed(self):
        if self.additionalBed == False:
            self.bedList.append(SingleBedFactory().createBed())
            self.additionalBed = True
        else:
            print("Room already has an additional bed, cannot add more bed")
            
    def removeBed(self):
        if self.additionalBed == True:
            self.bedList.pop()
            self.additionalBed = False
        else:
            print("Room does not have an additional bed, cannot remove bed")
    
    def getPrice(self):
        if self.additionalBed == True:
            return self.price + 500
        else:
            return self.price

class GrandSuiteRoom(HotelRoom):
    def __init__(self, number):
        super().__init__(number)
        self.price = 4000
        self.roomSize = 60
        self.bedList = [SingleBedFactory().createBed(), DoubleBedFactory().createBed()]
        self.description = "Grand Suite Room come with single bed and double bed in room size 60 square feet at 4000 baht base price per night, can add extra bed and amenities"
        self.__additionalBed = False
        self.__amenityList = [FoodAmenityFactory().createAmenity()]
    
    @property
    def additionalBed(self):
        return self.__additionalBed
    @additionalBed.setter
    def additionalBed(self, value):
        self.__additionalBed = value
    
    @property
    def amenityList(self):
        return self.__amenityList
    @amenityList.setter
    def amenityList(self, value):
        self.__amenityList = value
    
    def addBed(self):
        if self.additionalBed == False:
            self.bedList.append(SingleBedFactory().createBed())
            self.additionalBed = True
        else:
            print("Room already has an additional bed, cannot add more bed")
    def removeBed(self):
        if self.additionalBed == True:
            self.bedList.pop()
            self.additionalBed = False
        else:
            print("Room does not have an additional bed, cannot remove bed")
    
    def addAmenity(self, amenity):
        self.amenityList.append(amenity)
    def removeAmenity(self, amenity):
        if amenity in self.amenityList:
            self.amenityList.remove(amenity)
        else:
            print("Amenity not found")


class BedFactory(ABC):
    @abstractmethod
    def createBed(self):
        pass

class SingleBedFactory(BedFactory):
    def createBed(self):
        return SingleBed()

class DoubleBedFactory(BedFactory):
    def createBed(self):
        return DoubleBed()

class amenityFactory(ABC):
    @abstractmethod
    def createAmenity(self):
        pass

class FoodAmenityFactory(amenityFactory):
    def createAmenity(self):
        return FoodAmenity()
class CleaningAmenityFactory(amenityFactory):
    def createAmenity(self):
        return CleaningAmenity()
    
class Bed(ABC):
    def __init__(self):
        self.__size = 0
    
    @property
    def size(self):
        return self.__size
    @size.setter
    def size(self, size):
        self.__size = size

class SingleBed(Bed):
    def __init__(self):
        super().__init__()
        self.__size = 1

class DoubleBed(Bed):
    def __init__(self):
        super().__init__()
        self.__size = 2

class Amenity(ABC):
    def __init__(self):
        self.__price = 0
    
    @property
    def price(self):
        return self.__price
    @price.setter
    def price(self, price):
        self.__price = price
    
    @abstractmethod
    def getDescription(self):
        pass

class FoodAmenity(Amenity):
    def __init__(self):
        super().__init__()
        self.price = 200
    
    def getDescription(self):
        return "Food amenity at 200 baht per time"

class CleaningAmenity(Amenity):
    def __init__(self):
        super().__init__()
        self.price = 500
        self.__time = datetime.datetime(0, 0, 0, 12, 0, 0)
    
    @property
    def time(self):
        return self.__time
    @time.setter
    def time(self, time):
        self.__time = time
    
    def getDescription(self):
        return "Cleaning amenity at 500 baht per time at " + self.time.strftime("%H:%M:%S")