package com.company;

public class Pokemon {

    private String species = "Ditto";
    private int attack;
    private int defense;
    private int speed;

    public Pokemon (){ //default pokemon object
        this.attack = (species.length() * 7)+9;
        this.defense = (species.length()* 5)+ 17;
        this.speed = (species.length() * 6) + 13;
    }
    public Pokemon (String species){ //Pokemon object with name initialized by the user
        this.species = species;
        this.attack = (species.length() * 7)+9;
        this.defense = (species.length()* 5)+ 17;
        this.speed = (species.length() * 6) + 13;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String name){
        this.species = name;
    }

    public int getAttack(){
        return attack;
    }
    public void setAttack (int attack){
        this.attack = attack;
    }
    public int getDefense (){
       return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
}
