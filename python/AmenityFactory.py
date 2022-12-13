from Amenity import *
from Food import *
from CleaningService import *

class AmenityFactory(ABC):
    @abstractmethod
    def createFoodAmenity(self):
        pass

    @abstractmethod
    def createCleaningAmenity(self):
        pass

class NormalAmenityFactory(AmenityFactory):
    def createFoodAmenity(self):
        return Food()

    def createCleaningAmenity(self):
        return CleaningService()

class PlusAmenityFactory(AmenityFactory):
    def createFoodAmenity(self):
        return FoodPlus()
        
    def createCleaningAmenity(self):
        return CleaningServicePlus()