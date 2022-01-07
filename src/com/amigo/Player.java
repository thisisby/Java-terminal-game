package com.amigo;

import java.util.Random;

public class Player {

  private String name, weapon;
  private int health;
  private int level = 1;
  Random rand = new Random();

  public int getHealth() {
    return health;
  };
  public int getLevel() { return level; };

  public void setHealth(int health) {
    this.health = health;
  };
  public Player(String name, String weapon, int health) {
    this.name = name;
    this.weapon = weapon;
    if(health > 100 || health < 0) {
      this.health = 100;
    } else{
      this.health = health;
    };
  };

  public void getDamage() {
    int randDamage = rand.nextInt(15, 30);
    this.health -= randDamage;
    if (this.health <= 0) {
      this.health = 0;
    }
    System.out.println("You got damage by "+randDamage+" xp. Your health is " + this.health);
    if (this.health == 0) {
      System.out.println("You're dead");
    }
  }

  public void levelUp() {
    this.level++;
    System.out.println("Wow, level up!! \nCurrent level is " + getLevel());
    if (this.health+20 > 100 || this.health > 100) {
      this.health = 100;
      System.out.println("Your health is 100");
    } else  {
      this.health += 20;
      System.out.println("You've gained +20 to your health. \nYour health is "+ this.health);
    }
  }


}
