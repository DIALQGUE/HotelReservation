from Amenity import *

class Food(Amenity):
    def __init__(self):
        super().__init__()
        self.price = 200
    
    def getDescription(self):
        return "Food amenity at 200 baht per time"

class FoodPlus(Amenity):
    def __init__(self):
        super().__init__()
        self.price = 300
    
    def getDescription(self):
        return "FoodPlus amenity at 300 baht per time"