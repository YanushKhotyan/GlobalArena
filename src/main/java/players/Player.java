package players;

import skills.Skill;

import java.util.List;

public interface Player {
    void takeDamage(Integer damageValue);
    void takeHeal(Integer amount);
    Boolean isDead();
    List<Skill> getSkill();
}
