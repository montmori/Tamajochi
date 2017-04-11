package tamagotchi_klassen;

//Existiert nur um z.B. Nahrung, Schlafensorte und spielsachen über ein Interface abrufbar zu machen
public interface TamagotchiUsable {
	
	public abstract int getTimeTillUnlock();
	public abstract void setTimeTillUnlock(int timeTollUnlock);
	
	public abstract boolean isUnlocked();
	public abstract void setUnlocked(boolean isUnlocked);
	
	public abstract void use();
}
