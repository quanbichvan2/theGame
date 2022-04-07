package com.company;

public class Monster {
    private  String name;
    private int hp;
    private int damage;
    private String counter;
    private boolean life;
    public Monster(String name,int hp,int damage,String counter){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.counter = counter;
        this.life = true;
    }

    public  boolean getlife(){
        return this.life;
    }
    public String getName(){
        return this.name;
    }
    public int getHP(){
        return this.hp;
    }
    public String getCounter(){
        return this.counter;
    }
    public int getDamage(){
        return this.damage;
    }
    public void isDie(){
        this.life = false;
    }
    public void hitDamage(int damageHit){
        this.hp = this.hp - damageHit;
    }

}
