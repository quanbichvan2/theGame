package com.company;
import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] monsters = {"cerberus","minotaur","medusa"};
        int[] monster_hp = {40,50,100};
        int[] monster_damage = {20,15,10};
        String[] monsterCounter = {"ribbonBow","sword","hammer"};
        // Khai báo hero
        Hero hero = new Hero();

        Scanner input = new Scanner(System.in);
        // Khai báo monster
        Monster []monster = new Monster[monsters.length];
        for (int i = 0 ; i < monsters.length ; i++) {
            monster[i] = new Monster(monsters[i], monster_hp[i], monster_damage[i], monsterCounter[i]);
        }
        int monster_count = 0;
        while (true) {
            boolean check = true;
            int index_monster = 0;
            while (check) {
                System.out.print("\nEnter monster name: ");
                String monster_input = input.nextLine().toLowerCase(Locale.ROOT);
                for (int i = 0; i < monsters.length; i++) {
                    if (monster_input.equals(monster[i].getName())) {
                        if(monster[i].getlife()) {
                            check = false;
                            index_monster = i;
                        }else {
                            System.out.println("Nó lên dĩa rồi uWu !!\n");
                        }
                    }
                }
            }
//            hero.showBag();
            String MonsterCounter = monster[index_monster].getCounter();
            String heroCurrentWeapon = hero.getWeapon(hero.bagSize() - 1);
            if (heroCurrentWeapon.equals(MonsterCounter)) {
                System.out.println("Hero HP: " + hero.getHP());
                System.out.println("Hero Weapon: " + heroCurrentWeapon);
                System.out.println("Monster Counter Weapon: " + MonsterCounter);
                System.out.println("Monster HP: 0");
                monster_count++;
                System.out.println("Monster DIE " + monster_count);
                monster[index_monster].isDie();
                hero.WeaponsDestroy(hero.bagSize() - 1);

            } else {
                hero.hitDamage(monster[index_monster].getDamage());
                String currenWeapon = hero.getWeapon(hero.bagSize() - 1);
                monster[index_monster].hitDamage(hero.getDamage(currenWeapon));
                System.out.println("Hero HP: " + hero.getHP());
                System.out.println("Hero Weapon: " + heroCurrentWeapon);
                System.out.println("Monster Counter Weapon: " + MonsterCounter);
                if(monster[index_monster].getHP()<=0){
                    System.out.println("monster HP: 0");
                }
                else {
                System.out.println("Monster HP: " + monster[index_monster].getHP());}
                hero.WeaponsDestroy(hero.bagSize() - 1);
                if (hero.getHP() <= 0 || hero.bagSize() <=0) {
                    System.out.println("HERO LOSER");
                    break;
                }
                if (monster[index_monster].getHP() <= 0) {
                    monster_count++;
                    System.out.println("Monster DIE " + monster_count);
                    monster[index_monster].isDie();
                }
            }
//            hero.showBag();
            if(monster_count == monsters.length){
                System.out.println("Hero WIN!!");
                break;
            }
        }
    }
}
