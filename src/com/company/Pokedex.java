package com.company;

public class Pokedex implements PokedexInterface {
    private int arrayLength;
    private static Pokemon[] pokemonArray;
    private static String [] names; // holds the pokemon names
    private int counter = 0; // counts # of pokemon in the array


    public Pokedex() {
        arrayLength = 0;
        pokemonArray = new Pokemon[arrayLength];
    }

    public Pokedex(int length) {

        this.arrayLength = length;
        pokemonArray = new Pokemon[arrayLength]; // array that will hold & manipulate pokemon
        names = new String[arrayLength]; // array that will hold the Pokemon names

    }

    public String[] listPokemon() {
        String[] list = new String[counter]; // makes the array size = amount of pokemon
        if(counter == 0){
            System.out.println("Empty");
            return list = null;
        }
        for(int i = 0; i < counter; i++){ //fills list[] with pokemon names
            list[i] = names[i];
        }
        return list;
    }


    public boolean addPokemon(String species) {
        if (counter != pokemonArray.length) { // make sure that the pokemon array isn't maxed
            for (int i = 0; i < counter; i++) {
                if (pokemonArray[i].getSpecies().equalsIgnoreCase(species)) {
                    System.out.println("Duplicate");
                    System.out.println();
                    return false;
                }
            }
            pokemonArray[counter] = new Pokemon(species);
            names[counter] = species; // adds the pokemon string name to the name[]
            counter++; // keeps track of # pokemon
            System.out.println();
            return true;

        }
        System.out.println("MAX");
        return false;
    }

    public int[] checkStats(String species) {

        int stats[] = new int[3]; // fixed array because there will only be 3 fields
        boolean nextStep;


        for (int i = 0; i < counter; i++) { // makes sure that the array has input and species matches an object
            if (pokemonArray != null && species.equalsIgnoreCase(pokemonArray[i].getSpecies())) {
                nextStep = true;

                if (nextStep) {

                    for (int j = 0; j < counter; j++) {
                        if (pokemonArray[i].getSpecies().equalsIgnoreCase(species)) {
                            stats = new int[]{
                                    stats[0] = pokemonArray[i].getAttack(),
                                    stats[1] = pokemonArray[i].getDefense(),
                                    stats[2] = pokemonArray[i].getSpeed()
                            };
                            System.out.println("The stats for " + species + " are:");
                            System.out.println("Attack: " + stats[0]);
                            System.out.println("Defense: " + stats[1]);
                            System.out.println("Speed: " + stats[2]);
                            break;

                        }

                    }

                    return stats;
                }


            }
        }
        if (counter == 0) {
            System.out.println("Missing");
        } else
            System.out.println("Missing");
        return null;
    }


    public void sortPokedex() {

        String temp;
        int i, j;

        for (i = 0; i < names.length - 1; i++) {
            for (j = i + 1; j < names.length; j++) {
                if (names[j] != null && names[i].compareToIgnoreCase(names[j]) > 0) {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;


                }
            }
        }
    }

    public boolean evolvePokemon(String species) {
        boolean nextStep;

        for (int i = 0; i < counter; i++) { // makes sure that the array has input and species matches an object
            if (pokemonArray != null && species.equalsIgnoreCase(pokemonArray[i].getSpecies())) {
                nextStep = true;


                //if (counter != pokemonArray.length) {
                for (int j = 0; j < counter; i++) {
                    if (pokemonArray[i].getSpecies().equalsIgnoreCase(species)) {
                        pokemonArray[i].setAttack(pokemonArray[i].getAttack() * 2);
                        pokemonArray[i].setDefense(pokemonArray[i].getDefense() * 4);
                        pokemonArray[i].setSpeed(pokemonArray[i].getSpeed() * 3);
                        pokemonArray[i].getAttack();
                        pokemonArray[i].getDefense();
                        pokemonArray[i].getSpeed();

                        System.out.println(species + " has evolved!");
                        return true;
                    } else {
                        System.out.println("Missing");
                        return false;
                    }

                }

            }
        }
        System.out.println("Missing");
        return false;
    }
}

