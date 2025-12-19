/**
 * Interface para entidades con capacidad de golpe crítico.
 */
public interface CriticalStrike {
    float getCriticalChance();

    float getCriticalBonus();

    void setCriticalBonus(float bonus);
}
