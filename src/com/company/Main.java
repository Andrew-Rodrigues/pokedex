package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


   static  Scanner option; // global scanner used for user inputs
    public static void main(String[] args) {

        boolean start = true;
        option = new Scanner(System.in);
        int userInput = 0;
        Pokedex myPokedex = new Pokedex();

        System.out.println("Welcome to your new PokeDex!");

        while (start) {
            System.out.println("How many Pokemon are in your region?: ");

            try {

                int input = option.nextInt();
                System.out.println("Your new Pokedex can hold " + input + " Pokemon. Let's start using it!");
                System.out.println();


                myPokedex = new Pokedex(input); // creates the static pokedex array size


            }
            catch (Exception e) {
                option.next();
                System.out.println("That is not a valid choice. Try again.");
                System.out.println();
                continue;
            }


            boolean endOptions = false;

            while (!endOptions) {

                printMenu();
                int choice = getSafeInt();

                    switch (choice) {

                        case 1:

                           if(myPokedex.listPokemon() == null)
                           {
                              System.out.println();
                           }
                           else{
                               int counter = 1;
                               String list [] = myPokedex.listPokemon();
                               for(String i : list){
                                   System.out.println(counter + ". " + i);
                                   counter++;
                               }
                               System.out.println();
                           }
                            break;

                        case 2:

                            System.out.println("Please enter the Pokemon's Species: ");
                            String speciesInput = option.next();
                            myPokedex.addPokemon(speciesInput);
                           break;

                        case 3:

                            System.out.println("Please enter the Pokemon of interest: ");
                            String pokemonStats = option.next();
                             myPokedex.checkStats(pokemonStats);
                             System.out.println();
                            break;


                        case 4:
                            System.out.println("Please enter the Pokemon of interest: ");
                            String evolvePokemon = option.next();
                            myPokedex.evolvePokemon(evolvePokemon);
                            System.out.println();
                            break;

                        case 5:
                           myPokedex.sortPokedex();
                            break;

                        case 6:
                            start = false;
                            endOptions = true;
                            break;

                        default:
                            System.out.println("That is not a valid choice. Try again.");
                            System.out.println();
                            break;
                    }

                }

            }


        }

        public static int getSafeInt(){ // Method checks to make sure the inputs are valid
            boolean invalidInput = true;
            int num = 0;


            while(invalidInput){
            invalidInput = false;
            try{
                num = option.nextInt();

            }catch (InputMismatchException e){
                System.out.println("That is not a valid choice. Try again.");
                System.out.println();
                option.nextLine();
                printMenu();
                invalidInput = true;
            }
        }
            return num;
        }

        public static void printMenu(){ // method for the menu

            System.out.println("1. List Pokemon");
            System.out.println("2. Add Pokemon");
            System.out.println("3. Check a Pokemon's Stats");
            System.out.println("4. Evolve Pokemon");
            System.out.println("5. Sort Pokemon");
            System.out.println("6. Exit");
            System.out.println("What would you like to do? ");

        }


    }

