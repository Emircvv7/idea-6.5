
enum WeaponType {
    SWORD, AXE, BOW
}
class Weapon {
    private WeaponType type;
    private String name;
    public Weapon(WeaponType type, String name) {
        this.type = type;
        this.name = name;
    }

    public WeaponType getType() {
        return type;
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class GameEntity {
    private String name;
    private int health;
    private int damage;

    public GameEntity(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

class Boss extends GameEntity {
    private Weapon weapon;
    public Boss(String name, int health, int damage, Weapon weapon) {
        super(name, health, damage);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public String printInfo() {
        return "Имя: " + getName() + "\nЗдоровье: " + getHealth() + "\nУрон: " + getDamage() +
                "\nТип оружия: " + weapon.getType() + "\nНазвание оружия: " + weapon.getName();
    }
}

class Skeleton extends Boss {
    private int arrowCount;

    public Skeleton(String name, int health, int damage, Weapon weapon, int arrowCount) {
        super(name, health, damage, weapon);
        this.arrowCount = arrowCount;
    }
    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    @Override
    public String printInfo() {
        return super.printInfo() + "\nКоличество стрел: " + arrowCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Weapon bossWeapon = new Weapon(WeaponType.SWORD, "Огненный меч");
        Boss boss = new Boss("Грозный Босс", 1000, 50, bossWeapon);
        System.out.println("Информация о боссе:");
        System.out.println(boss.printInfo());

        Weapon skeletonWeapon1 = new Weapon(WeaponType.BOW, "Лук скелета 1");
        Skeleton skeleton1 = new Skeleton("Скелет1", 100, 10, skeletonWeapon1, 20);

        Weapon skeletonWeapon2 = new Weapon(WeaponType.AXE, "Топор скелета 2");
        Skeleton skeleton2 = new Skeleton("Скелет2", 80, 8, skeletonWeapon2, 15);
        System.out.println("\nИнформация о скелете 1:");
        System.out.println(skeleton1.printInfo());

        System.out.println("\nИнформация о скелете 2:");
        System.out.println(skeleton2.printInfo());
    }
}


