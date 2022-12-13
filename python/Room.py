from abc import ABC, abstractmethod
from Bed import *
from AmenityFactory import *

class Room(ABC):
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
    @description.setter
    def description(self, description):
        self.__description = description

    def __init__(self, number):
        self.__number = number

    @abstractmethod
    def getTotalPrice(self):
        pass
    
class PremiumRoom(Room):
    def __init__(self, number):
        super().__init__(number)
        self.price = 1500
        self.roomSize = 30
        self.bedList = [Bed("Single")]
        self.description = "Premium Room come with single bed in room size 30 square feet at 1500 baht base price per night, cannot add extra bed or add amenities"
    
    def getTotalPrice(self):
        return self.price

class DeluxeRoom(Room):
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
    
    def __init__(self, number):
        super().__init__(number)
        self.price = 2500
        self.roomSize = 40
        self.bedList = [Bed("Double")]
        self.description = "Deluxe Room come with double bed in room size 40 square feet at 2500 baht base price per night, can add extra bed but cannot add amenities"
        self.__additionalBed = False
        self.__amenityList = [NormalAmenityFactory().createFoodAmenity()]
    
    def addBed(self):
        if self.additionalBed == False:
            self.bedList.append(Bed("Single"))
            self.additionalBed = True
        else:
            print("Room already has an additional bed, cannot add more bed")
        
    def removeBed(self):
        if self.additionalBed == True:
            self.bedList.pop()
            self.additionalBed = False
        else:
            print("Room does not have an additional bed, cannot remove bed")
    
    def getTotalPrice(self):
        totalPrice = self.price
        if self.additionalBed == True:
            totalPrice = totalPrice + 500
        if self.__amenityList != []:
            for amenity in self.__amenityList:
                totalPrice = totalPrice + amenity.price
        return totalPrice

class GrandSuiteRoom(Room):
    def __init__(self, number):
        super().__init__(number)
        self.price = 4000
        self.roomSize = 60
        self.bedList = [Bed("Single"), Bed("Double")]
        self.description = "Grand Suite Room come with single bed and double bed in room size 60 square feet at 4000 baht base price per night, can add extra bed and amenities"
        self.__additionalBed = False
        self.__amenityList = [
            NormalAmenityFactory().createFoodAmenity(),
            NormalAmenityFactory().createCleaningAmenity()
        ]
    
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
            self.bedList.append(Bed("Single"))
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

    def getTotalPrice(self):
        totalPrice = self.price
        if self.additionalBed == True:
            totalPrice = totalPrice + 500
        if self.__amenityList != []:
            for amenity in self.__amenityList:
                totalPrice = totalPrice + amenity.price
        return totalPrice