package ai;

import arenas.ArenaPVP;
import players.Player;
import skills.Skill;

import java.util.Random;

public class AI {
    public Skill getNextSkill(Player player, ArenaPVP arena){
        return player.getSkill().get(new Random().nextInt(player.getSkill().size()));
    }

}
