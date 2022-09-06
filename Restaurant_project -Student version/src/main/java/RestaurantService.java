import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        //checks the restaurant in the list and returns the restaurant if it is present in the list.
            //throws restaurantNotFoundException
        boolean restaurantPresent = false;
        Restaurant searchedRestaurant = null;
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName() == restaurantName){
                searchedRestaurant = restaurant;
                restaurantPresent = true;
                break;
            }
        }
        if(restaurantPresent){
            return searchedRestaurant;
        }
        else{
            throw new restaurantNotFoundException("Error: Restaurant could not be found");
        }
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    //The method will return the String needs to be displayed to user with total amount of items passed to it

    public String totalAmount(ArrayList<Item> itemsSelected) {
        String outputString = "Your order will cost: $";
        int sum = 0;
        for(Item item: itemsSelected){
            sum += item.getPrice();
        }
        outputString += sum;
        return  outputString;
    }
}
