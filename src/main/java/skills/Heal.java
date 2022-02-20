package skills;

import arenas.ArenaPVP;
import players.Player;

public final class Heal implements Skill {
    private final Integer heal;

    private final Player owner;

    public Heal(Player owner, Integer heal) {
        this.owner = owner;
        this.heal = heal;
    }

    @Override
    public void perform(ArenaPVP arena) {
        owner.takeHeal(heal);
    }
}
