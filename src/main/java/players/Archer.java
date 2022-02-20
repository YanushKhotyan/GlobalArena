package players;

import players.common.RangeValue;
import skills.Damage;
import skills.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static players.common.Characteristic.*;

public class Archer implements Player {

    private List<Skill> skills;
    private RangeValue rangeValue;

    // TODO: Change the array type from Integer to RangeValue;
    private ArrayList<Integer> characteristics;

    public Archer() {
        characteristics = new ArrayList<>();

        characteristics.add(MAX_HEALTH_INDEX.ordinal(), 100);
        characteristics.add(DAMAGE_INDEX.ordinal(), 15);
        characteristics.add(HEAL_INDEX.ordinal(), 0);
        characteristics.add(ATTACK_RESISTANCE_INDEX.ordinal(), 0);

        rangeValue = new RangeValue(
                characteristics.get(MAX_HEALTH_INDEX.ordinal()),
                characteristics.get(ATTACK_RESISTANCE_INDEX.ordinal()),
                characteristics.get(HEAL_INDEX.ordinal()));

        skills = new ArrayList<>();
        skills.add(new Damage(this, DAMAGE_INDEX.ordinal()));
    }

    @Override
    public void takeDamage(Integer damageValue) {
        int randValue = new Random().nextInt(100);
        int damage = randValue > 20 ? damageValue : 0;
        rangeValue.decreaseCurrentHealth(damage);
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
