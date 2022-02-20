package players;

import players.common.Characteristic;
import players.common.RangeValue;
import skills.Damage;
import skills.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Archer implements Player {

    private RangeValue rangeValue;

    private ArrayList<Object> characteristics;

    public RangeValue getRangeValue() {
        return rangeValue;
    }

    public void setRangeValue(RangeValue rangeValue) {
        this.rangeValue = rangeValue;
    }

    public ArrayList getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(ArrayList characteristics) {
        this.characteristics = characteristics;
    }

    public Archer() {
        rangeValue = new RangeValue(100);

        List<Skill> skills = new ArrayList<>();
        skills.add(new Damage(this,15));

        rangeValue.setSkills(skills);
        characteristics = new ArrayList<>();
        characteristics.add(Characteristic.MAX_HEALTH_INDEX.ordinal(), 100);
        characteristics.add(Characteristic.CURRENT_HEALTH_INDEX.ordinal(), rangeValue.getCurrentHealth());
        characteristics.add(Characteristic.SKILLS_INDEX.ordinal(), rangeValue.getSkills());
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
        return rangeValue.getSkills();
    }
}
