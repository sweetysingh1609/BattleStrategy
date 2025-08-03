import java.util.*;

public class BattleStrategyTest {

    public static void main(String[] args) {
        testHasAdvantage();
        testBattleResult();
        System.out.println("All tests passed.");
    }

    // Represents a platoon (copied from your main code)
    static class Platoon {
        String unitClass;
        int soldiers;

        public Platoon(String unitClass, int soldiers) {
            this.unitClass = unitClass;
            this.soldiers = soldiers;
        }
    }

    // Class advantage map
    static Map<String, List<String>> advantageMap = new HashMap<>();

    static {
        advantageMap.put("Militia", Arrays.asList("Spearmen", "LightCavalry"));
        advantageMap.put("Spearmen", Arrays.asList("LightCavalry", "HeavyCavalry"));
        advantageMap.put("LightCavalry", Arrays.asList("FootArcher", "CavalryArcher"));
        advantageMap.put("HeavyCavalry", Arrays.asList("Militia", "FootArcher", "LightCavalry"));
        advantageMap.put("CavalryArcher", Arrays.asList("Spearmen", "HeavyCavalry"));
        advantageMap.put("FootArcher", Arrays.asList("Militia", "CavalryArcher"));
    }

    static boolean hasAdvantage(String attacker, String defender) {
        return advantageMap.getOrDefault(attacker, new ArrayList<>()).contains(defender);
    }

    static int getBattleResult(Platoon myPlatoon, Platoon enemyPlatoon) {
        int myPower = myPlatoon.soldiers;
        int enemyPower = enemyPlatoon.soldiers;

        if (hasAdvantage(myPlatoon.unitClass, enemyPlatoon.unitClass)) {
            myPower *= 2;
        }

        if (myPower > enemyPower) return 1;
        else if (myPower == enemyPower) return 0;
        else return -1;
    }

    private static void testHasAdvantage() {
        System.out.println("Running testHasAdvantage...");

        assert hasAdvantage("Militia", "Spearmen") : "Militia should beat Spearmen";
        assert hasAdvantage("HeavyCavalry", "FootArcher") : "HeavyCavalry should beat FootArcher";
        assert !hasAdvantage("Spearmen", "Militia") : "Spearmen should not beat Militia";
        assert !hasAdvantage("LightCavalry", "Militia") : "LightCavalry should not beat Militia";

        System.out.println("testHasAdvantage passed.");
    }

    private static void testBattleResult() {
        System.out.println("Running testBattleResult...");

        Platoon my1 = new Platoon("Militia", 50);
        Platoon enemy1 = new Platoon("Spearmen", 90);
        assert getBattleResult(my1, enemy1) == 1 : "Militia(50) vs Spearmen(90) should win (2x)";

        Platoon my2 = new Platoon("FootArcher", 100);
        Platoon enemy2 = new Platoon("FootArcher", 100);
        assert getBattleResult(my2, enemy2) == 0 : "Should be draw";

        Platoon my3 = new Platoon("Spearmen", 40);
        Platoon enemy3 = new Platoon("HeavyCavalry", 90);
        assert getBattleResult(my3, enemy3) == -1 : "Should lose";

        Platoon my4 = new Platoon("HeavyCavalry", 100);
        Platoon enemy4 = new Platoon("Militia", 190);
        assert getBattleResult(my4, enemy4) == 1 : "HeavyCavalry(100) vs Militia(190) => 2x win";

        System.out.println("testBattleResult passed.");
    }
}
