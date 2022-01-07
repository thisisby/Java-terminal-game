package com.amigo;

import java.util.Random;

public class CPU {
  private int health = 100;
  private Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  Random rand = new Random();

  public int getRandLetter(){
    return rand.nextInt(alphabet.length);
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
