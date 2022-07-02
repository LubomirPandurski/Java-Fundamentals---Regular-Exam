package com.company;


import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] command = scanner.nextLine().split(" ");
        while(!command[0].equals("Finish")){
            if(command[0].equals("Replace")){
                String replaced = input.replace(command[1], command[2]);
                input=replaced;
                System.out.println(replaced);
            }
            else if(command[0].equals("Cut")){
                if(Integer.parseInt(command[1])<0 || Integer.parseInt(command[2])>=input.length()){
                    System.out.println("Invalid indices!");
                }else{
                    String cutted = input.substring(Integer.parseInt(command[1]), Integer.parseInt(command[2])+1);
                    input = input.replace(cutted, "");
                    System.out.println(input);
                }
            }
            else if(command[0].equals("Make")){
                if(command[1].equals("Lower")){
                    String lower = input.toLowerCase();
                    input = lower;
                    System.out.println(lower);
                }
                else if(command[1].equals("Upper")){
                    String upper = input.toUpperCase();
                    input = upper;
                    System.out.println(upper);
                }
            }
            else if(command[0].contains("Check")){
                if(input.contains(command[1])){
                    System.out.println("Message contains " + command[1]);
                }
                else{
                    System.out.println("Message doesn't contain " + command[1]);
                }
            }
            else if(command[0].equals("Sum")) {
                if (Integer.parseInt(command[1]) < 0 || Integer.parseInt(command[2]) >= input.length()) {
                    System.out.println("Invalid indices!");
                } else {
                    String summed = input.substring(Integer.parseInt(command[1]), Integer.parseInt(command[2]) + 1);
                    int total = 0;
                    for (int i = 0; i < summed.length(); i++) {
                        char symbol = summed.charAt(i);
                        total += symbol;
                    }
                    System.out.println(total);
                }
            }
             command = scanner.nextLine().split(" ");
        }
    }
}
