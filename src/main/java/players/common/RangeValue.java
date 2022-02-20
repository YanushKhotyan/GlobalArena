package players.common;

public final class RangeValue {
    private final static int MIN_HEALTH = 0;

    private final Integer maxHealth;

    private final Integer attackResistance;

    private final Integer heal;

    private Integer currentHealth;

    public RangeValue(Integer health, Integer attackResistance, Integer heal) {
        this.maxHealth = health;
        this.currentHealth = health;
        this.attackResistance = attackResistance;
        this.heal = heal;
    }

    public void increaseCurrentHealth(Integer damage) {
        this.currentHealth = Math.min(currentHealth + damage, maxHealth);
    }

    public void decreaseCurrentHealth(Integer damage) {
        if(damage > attackResistance){
            this.currentHealth = Math.max(this.currentHealth - (damage - attackResistance) , MIN_HEALTH);
        }
    }

    public Boolean isDead(){
        return currentHealth <= MIN_HEALTH;
    }
}
