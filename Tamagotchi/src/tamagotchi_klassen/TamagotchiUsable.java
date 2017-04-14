package tamagotchi_klassen;

/**
 * Existiert nur um z.B. Nahrung, Schlafensorte und Spielsachen über ein Interface abrufbar zu machen
 * Implemented von allem, was das Tamagotchi benutzen kann.
 */
public interface TamagotchiUsable {
	
	public abstract int getTimeTillUnlock();
	public abstract void setTimeTillUnlock(int timeTillUnlock);
	
	public abstract boolean isUnlocked();
	public abstract void setUnlocked(boolean isUnlocked);
	
	public abstract void use();
}
