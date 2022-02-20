package skills;

import arenas.ArenaPVP;
import players.Player;

public final class Heal implements Skill {
    private final Integer heal = 20;
    private final Player owner;

    public Heal(Player owner) {
        this.owner = owner;
    }

    @Override
    public void perform(ArenaPVP arena) {
        owner.takeHeal(heal);
    }
}
