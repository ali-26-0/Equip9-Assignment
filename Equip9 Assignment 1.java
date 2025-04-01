
//Equip9 Assignment 1

import java.util.*;

public class EquipAssignment1 {

     public static List<Integer> matchRequestsToSellers(List<String[]> requests, List<String[]> sellers) {
        // Here i am Organizing the sellers by equipment type
        Map<String, List<Integer>> sellerMap = new HashMap<>();
        
        
        for (String[] seller : sellers) {
            String equipmentType = seller[0];
            int price = Integer.parseInt(seller[1]);
            
            // Here I am adding the price if the equipment type is aready in the map
            sellerMap.putIfAbsent(equipmentType, new ArrayList<>());
            sellerMap.get(equipmentType).add(price);
        }

       
        List<Integer> result = new ArrayList<>();
        
        for (String[] request : requests) {
            String equipmentType = request[0];
            int maxPrice = Integer.parseInt(request[1]);
            
        
            List<Integer> availablePrices = sellerMap.getOrDefault(equipmentType, new ArrayList<>());
            
           
            Integer lowestPrice = null;
            for (int price : availablePrices) {
                if (price <= maxPrice) {
                    if (lowestPrice == null || price < lowestPrice) {
                        lowestPrice = price;
                    }
                }
            }
            
          
            result.add(lowestPrice != null ? lowestPrice : null);
        }
        
        return result;
    }

    public static void main(String[] args) {
        
        List<String[]> requests = Arrays.asList(
                new String[]{"excavator", "50000"},
                new String[]{"bulldozer", "70000"}
        );

        List<String[]> sellers = Arrays.asList(
                new String[]{"excavator", "45000"},
                new String[]{"bulldozer", "68000"},
                new String[]{"excavator", "48000"}
        );

        List<Integer> output = matchRequestsToSellers(requests, sellers);
        System.out.println(output);  // Output: [45000, 68000]
    }
}
