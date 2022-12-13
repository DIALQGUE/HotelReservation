class Bed:
    def __init__(self, size):
        self.__size = size
    
    @property
    def size(self):
        return self.__size
    @size.setter
    def size(self, value):
        self.__size = value

"""
from abc import ABC, abstractmethod

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
"""