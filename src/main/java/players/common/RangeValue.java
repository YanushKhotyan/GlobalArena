package players.common;

import skills.Skill;

import java.util.List;

public final class RangeValue {
    private final int MIN_HEALTH = 0;

    private final int maxHealth;

    private int currentHealth;

    private List<Skill> skills;

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void increaseCurrentHealth(Integer damage) {
        this.currentHealth = Math.min(this.currentHealth + damage, maxHealth);
    }

    public void decreaseCurrentHealth(Integer damage) {
        this.currentHealth = Math.max(this.currentHealth - damage, MIN_HEALTH);
    }

    public RangeValue(Integer health) {
        this.maxHealth = health;
        // On init step maxHealth equals currentHealth.
        this.currentHealth = health;
    }

    public Boolean isDead(){
        return currentHealth <= 0;
    }
}
