import java.util.*;

// Represents a platoon with its class type and number of soldiers
class Platoon {
    String unitClass;
    int soldiers;

    public Platoon(String unitClass, int soldiers) {
        this.unitClass = unitClass;
        this.soldiers = soldiers;
    }

    @Override
    public String toString() {
        return unitClass + "#" + soldiers;
    }
}

// Main class with logic to determine battle outcomes
public class BattleStrategy {

    // Advantage mapping
    static Map<String, List<String>> advantageMap = new HashMap<>();

    // Setup the advantage relationships as per the problem
    static {
        advantageMap.put("Militia", Arrays.asList("Spearmen", "LightCavalry"));
        advantageMap.put("Spearmen", Arrays.asList("LightCavalry", "HeavyCavalry"));
        advantageMap.put("LightCavalry", Arrays.asList("FootArcher", "CavalryArcher"));
        advantageMap.put("HeavyCavalry", Arrays.asList("Militia", "FootArcher", "LightCavalry"));
        advantageMap.put("CavalryArcher", Arrays.asList("Spearmen", "HeavyCavalry"));
        advantageMap.put("FootArcher", Arrays.asList("Militia", "CavalryArcher"));
    }

    // Check if one unit class has advantage over another
    private static boolean hasAdvantage(String attacker, String defender) {
        return advantageMap.getOrDefault(attacker, new ArrayList<>()).contains(defender);
    }

    // Parse the input string into list of Platoon objects
    private static List<Platoon> parseInput(String input) {
        List<Platoon> result = new ArrayList<>();
        String[] parts = input.split(";");
        for (String part : parts) {
            String[] split = part.split("#");
            result.add(new Platoon(split[0], Integer.parseInt(split[1])));
        }
        return result;
    }

    // Determines the winner of a single battle
    private static int getBattleResult(Platoon myPlatoon, Platoon enemyPlatoon) {
        int myPower = myPlatoon.soldiers;
        int enemyPower = enemyPlatoon.soldiers;

        // Double power if class advantage
        if (hasAdvantage(myPlatoon.unitClass, enemyPlatoon.unitClass)) {
            myPower *= 2;
        }

        if (myPower > enemyPower) return 1;     // Win
        else if (myPower == enemyPower) return 0; // Draw
        else return -1;                         // Loss
    }

    // Try all permutations of player's platoons to find at least 3 wins
    private static boolean findWinningArrangement(List<Platoon> myPlatoons, List<Platoon> enemyPlatoons) {
        List<List<Platoon>> allPermutations = new ArrayList<>();
        permute(myPlatoons, 0, allPermutations);

        for (List<Platoon> permutation : allPermutations) {
            int wins = 0;
            for (int i = 0; i < 5; i++) {
                int result = getBattleResult(permutation.get(i), enemyPlatoons.get(i));
                if (result == 1) wins++;
            }
            if (wins >= 3) {
                // Found winning arrangement
                for (int i = 0; i < 5; i++) {
                    System.out.print(permutation.get(i));
                    if (i < 4) System.out.print(";");
                }
                System.out.println();
                return true;
            }
        }
        return false;
    }

    // Generate all permutations of my platoons
    private static void permute(List<Platoon> list, int index, List<List<Platoon>> result) {
        if (index == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, i, index);
            permute(list, index + 1, result);
            Collections.swap(list, i, index);
        }
    }

    // Main method to run the console application
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input line for own platoons
        String myInput = sc.nextLine();

        // Input line for enemy platoons
        String enemyInput = sc.nextLine();

        List<Platoon> myPlatoons = parseInput(myInput);
        List<Platoon> enemyPlatoons = parseInput(enemyInput);

        boolean hasWinning = findWinningArrangement(myPlatoons, enemyPlatoons);

        if (!hasWinning) {
            System.out.println("There is no chance of winning");
        }
    }
}
