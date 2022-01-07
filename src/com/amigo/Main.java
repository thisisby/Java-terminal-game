package com.amigo;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CPU cpu = new CPU();
        Random rand = new Random();
        int levelCounter = 0;
        String[] weapons = {"Sword", "Gun", "Arrow"};
        Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        System.out.println("Welcome to 'Fast battle', here you have to find the given letter to win CPU. \nFor each 3rd correct answer you will get level up. \nEach level gives you a health. However, if your answer is wrong the CPU will damage you. \nSo, good luck!!!");
        System.out.println("Please, enter your name: ");
        String name = scan.nextLine();
        System.out.println("Please, choose your weapon: ");
        for (int i = 0; i < weapons.length; i++) {
            System.out.println(weapons[i] + " - " + i);
        };
        int weaponNumber = scan.nextInt();
        String userWeapon = weapons[weaponNumber];

        Player user = new Player(name, userWeapon, 100);
        System.out.println("Hello " + name + ". Your gun is " + userWeapon + ". Your health is "+user.getHealth()+". Good luck!!!");

        while (user.getHealth() > 0) {
            int randAttack = rand.nextInt(15, 30);
            int cpuTask = cpu.getRandLetter();
            char answer = alphabet[cpuTask];
            System.out.println("Find character " + answer);
            char userGuess = scan.next().charAt(0);
            if (answer == userGuess) {
                if(cpu.getHealth() - randAttack <= 0) {
                    System.out.println("You won");
                    break;
                } else {
                    cpu.setHealth(cpu.getHealth() - randAttack);
                    System.out.println("Attack damage is " + randAttack);
                    System.out.println("CPU's health " + cpu.getHealth());
                    levelCounter++;
                    if (levelCounter == 3) {
                        user.levelUp();
                        levelCounter = 0;
                    }
                    ;
                }

            } else{
                System.out.println("Oops!");
                user.getDamage();
            }
      }
    }


}
