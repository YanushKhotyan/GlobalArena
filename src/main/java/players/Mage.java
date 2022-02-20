package players;

import players.common.Characteristic;
import players.common.RangeValue;
import skills.Damage;
import skills.Heal;
import skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class Mage implements Player{
    private RangeValue rangeValue;
    private final int attackResistance = 3;

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

    public Mage() {
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
        int damage = damageValue - attackResistance;
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
