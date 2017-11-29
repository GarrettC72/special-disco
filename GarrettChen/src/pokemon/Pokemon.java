package pokemon;

public class Pokemon {

	private String name;
	private int level;
	int hp;
	boolean poisoned;

	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		hp = 100;
		poisoned = false;
	}

	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHp();
				target.setHp(hp/2);
			}
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {
			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
	}


	public void iChooseYou() {
		System.out.println(name + " " + name);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int newHP) {
		this.hp = newHP;
	}

	public String getName() {
		return name;
	}

	public void setPoisoned(boolean b) {
		this.poisoned = b;
	}

	public void lapse() {
		if(poisoned) {
			hp -= 15;
		}
	}

	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		}
		else{
			System.out.println("The attack missed");
		}
	}

	public static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName() + ", HP = " + p1.getHp());
		System.out.println(p2.getName() + ", HP = " + p2.getHp());
	}

	public void levelUp(Effect e) {
		this.level++;
		e.happens();
	}
}
