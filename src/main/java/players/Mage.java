package players;

import players.common.Characteristic;
import players.common.RangeValue;
import skills.Damage;
import skills.Heal;
import skills.Skill;

import java.util.ArrayList;
import java.util.List;

import static players.common.Characteristic.*;

public class Mage implements Player{
    private List<Skill> skills;
    private RangeValue rangeValue;

    // TODO: Change the array type from Integer to RangeValue;
    private ArrayList<Integer> characteristics;

    public Mage() {
        characteristics = new ArrayList<>();

        characteristics.add(MAX_HEALTH_INDEX.ordinal(), 100);
        characteristics.add(ATTACK_RESISTANCE_INDEX.ordinal(), 3);
        characteristics.add(DAMAGE_INDEX.ordinal(), 15);
        characteristics.add(HEAL_INDEX.ordinal(), 20);

        rangeValue = new RangeValue(
                characteristics.get(MAX_HEALTH_INDEX.ordinal()),
                characteristics.get(ATTACK_RESISTANCE_INDEX.ordinal()),
                characteristics.get(HEAL_INDEX.ordinal()));

        skills = new ArrayList<>();
        skills.add(new Damage(this,characteristics.get(ATTACK_RESISTANCE_INDEX.ordinal())));
        skills.add(new Heal(this, characteristics.get(HEAL_INDEX.ordinal())));

    }

    @Override
    public void takeDamage(Integer damageValue) {
        rangeValue.decreaseCurrentHealth(damageValue);
    }

    @Override
    public void takeHeal(Integer amount) {
        rangeValue.increaseCurrentHealth(amount);
    }

    @Override
    public Boolean isDead() {
        return rangeValue.isDead();
    }

    @Override
    public List<Skill> getSkill() {
        return skills;
    }
}
