package ai;

import arenas.Arena;
import players.Player;
import skills.Skill;

import java.util.Random;

public class AI {
    public Skill getNextSkill(Player player, Arena arena){
        return player.getSkill().get(new Random().nextInt(player.getSkill().size()));
    }

}
