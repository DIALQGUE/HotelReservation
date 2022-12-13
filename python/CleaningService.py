from datetime import datetime
from Amenity import *

class CleaningService(Amenity):
    def __init__(self):
        super().__init__()
        self.price = 500
        self.__time = datetime(2022, 1, 30, 12, 0, 0)
    
    @property
    def time(self):
        return self.__time
    @time.setter
    def time(self, time):
        self.__time = time
    
    def getDescription(self):
        return "Cleaning amenity at 500 baht per time at " + self.time.strftime("%H:%M:%S")

class CleaningServicePlus(Amenity):
    def __init__(self):
        super().__init__()
        self.price = 600
        self.__time = datetime(0, 0, 0, 12, 0, 0)
    
    @property
    def time(self):
        return self.__time
    @time.setter
    def time(self, time):
        self.__time = time
    
    def getDescription(self):
        return "Cleaning amenity at 600 baht per time at " + self.time.strftime("%H:%M:%S")