package com.company;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String message = scanner.nextLine();
            Pattern pattern = Pattern.compile("!(?<command>[A-Z]{1}[a-z]+)!:[\\[](?<string>[A-z]+)[\\]]");
            Matcher matcher = pattern.matcher(message);
            if(matcher.find()){
                String code = matcher.group("string");
                String command = matcher.group("command");
                List<Integer> numbers = new ArrayList<>();
                int number = 0;
                char k ;
                for (int j = 0; j < code.length(); j++) {
                    k = code.charAt(j);
                    number = k;
                    numbers.add(number);
                }
                System.out.printf("%s: ", command);
                numbers.forEach(el-> System.out.print(el + " "));
                System.out.println();
            }else{
                System.out.println("The message is invalid");
            }
        }
    }
}
