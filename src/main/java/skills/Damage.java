package skills;

import arenas.ArenaPVP;
import players.Player;

public final class Damage implements Skill {
    private final Integer damage;
    private final Player owner;

    public Damage(Player owner, Integer damage) {
        this.owner = owner;
        this.damage = damage;
    }

    @Override
    public void perform(ArenaPVP arena) {
        if(arena.getPlayer_1() == owner){
            arena.getPlayer_2().takeDamage(damage);
        } else {
            arena.getPlayer_1().takeDamage(damage);
        }
    }
}
