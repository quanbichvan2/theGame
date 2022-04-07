package com.company;
import java.util.ArrayList;
public class Hero {

    private int hp;
    private int damgeDefault;
    private  String[] item = {"woodSword","woodSword","woodSword","sword","hammer","ribbonBow"};
    ArrayList<String> bag = new ArrayList<String>();
    public  Hero(){
        this.hp = 100;
        this.damgeDefault = 20;
        int[] random = random_code(0,item.length-1,item.length);
        for(int i = 0; i < item.length; i++){
            bag.add(item[random[i]]);
        }
    }
    public  void  showBag(){
        System.out.println(bag);
    }

    public void hitDamage(int damageHit){
        this.hp = this.hp - damageHit;
    }

    public int getDamage(String weapons){
        if (weapons.equals("woodSword")){
            return 50;
        }
        else{
            return 20;
        }

    }
    public int getHP(){
        return this.hp;
    }

    public  String getWeapon(int index){
        return bag.get(index);
    }

    public  int bagSize(){
        return bag.size();
    }

    public void WeaponsDestroy(int item){
        bag.remove(item);
    }


    public static int[] random_code(int min , int max, int count){
        int random_code;
        int[] past_random = new int[count];
        boolean status = false;
        for (int i = 0; i < count ; i++) {
            random_code = (int)(Math.random()*((max-min+1)+min));
            past_random[i] = random_code;
            for (int j = 0 ; j < i ; j++) {
                if (random_code == past_random[j]){
                    status = true;
                    break;
                }
            }
            if (status){
                status = false;
                i--;
            }
        }
        return past_random;
    }
}
