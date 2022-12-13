from abc import ABC, abstractmethod

class Amenity(ABC):
    @property
    def price(self):
        return self.__price
    @price.setter
    def price(self, price):
        self.__price = price
    
    def __init__(self):
        self.__price = 0

    @abstractmethod
    def getDescription(self):
        pass
