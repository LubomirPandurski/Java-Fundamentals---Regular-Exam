package com.company;

import java.util.*;

public class DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> guests = new LinkedHashMap<>();
        String [] command = scanner.nextLine().split("-");
        int unlikedMealsCount = 0;
        while(!command[0].equals("Stop")){
            if(command[0].equals("Like")){
                    guests.putIfAbsent(command[1], new ArrayList<>());
                    if(!guests.get(command[1]).contains(command[2])) {
                        guests.get(command[1]).add(command[2]);
                    }

            }

            else if(command[0].equals("Dislike")){

                if(!guests.containsKey(command[1])){
                    System.out.printf("%s is not at the party.%n", command[1]);
                }
                else if(guests.get(command[1]).contains(command[2])){
                    unlikedMealsCount++;
                    guests.get(command[1]).remove(command[2]);
                    System.out.printf("%s doesn't like the %s.%n", command[1], command[2]);
                }else{
                    System.out.printf("%s doesn't have the %s in his/her collection.%n", command[1], command[2]);
                }
            }
            command = scanner.nextLine().split("-");
        }

        guests.forEach((key, value) ->System.out.printf("%s: %s%n", key, Arrays.toString(value.toString().split(", "))
                .replaceAll("[\\[\\]\"]", "")));
        System.out.println("Unliked meals: " + unlikedMealsCount);
    }
}
