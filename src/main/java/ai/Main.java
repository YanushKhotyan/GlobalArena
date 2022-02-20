package ai;

import arenas.Arena;
import arenas.ArenaPVP;
import players.Archer;
import players.Mage;
import players.Player;
import skills.Skill;

public class Main {
    public static void main(String[] args) {
        Player archer = new Archer();
        Player mage = new Mage();

        ArenaPVP arena = new ArenaPVP(archer, mage);

        AI ai = new AI();

        while(!(arena.getPlayer_1().isDead() || arena.getPlayer_2().isDead())){
            Skill player_1 = ai.getNextSkill(arena.getPlayer_1(), arena);
            Skill player_2 = ai.getNextSkill(arena.getPlayer_2(), arena);

            player_1.perform(arena);
            player_2.perform(arena);
        }

        if(arena.getPlayer_1().isDead()){
            System.out.println("Player 1 is dead");
        } else {
            System.out.println("Player 1 win");
        }

        if(arena.getPlayer_2().isDead()){
            System.out.println("Player 2 is dead");
        } else {
            System.out.println("Player 2 win");
        }
    }
}
