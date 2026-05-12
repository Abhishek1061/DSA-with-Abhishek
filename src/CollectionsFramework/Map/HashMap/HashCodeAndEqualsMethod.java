package CollectionsFramework.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        System.out.println("=== Scenario 1: With equals() overridden ===");
        scenarioWithEquals();

        System.out.println("\n=== Scenario 2: Without equals() overridden ===");
        scenarioWithoutEquals();
    }

    // ✅ Scenario 1: Properly overriding hashCode() and equals()
    private static void scenarioWithEquals() {
        HashMap<PersonWithEquals, String> map = new HashMap<>();

        PersonWithEquals p1 = new PersonWithEquals("Alice", 1);
        PersonWithEquals p2 = new PersonWithEquals("Bob", 2);
        PersonWithEquals p3 = new PersonWithEquals("Alice", 1); // logically same as p1

        map.put(p1, "Engineer");
        map.put(p2, "Designer");
        map.put(p3, "Manager"); // replaces p1’s value because equals() says p1 == p3

        System.out.println("HashMap Size: " + map.size()); // 2
        System.out.println("Value for p1: " + map.get(p1)); // Manager
        System.out.println("Value for p3: " + map.get(p3)); // Manager
    }

    // ❌ Scenario 2: Only hashCode() overridden, equals() NOT overridden
    private static void scenarioWithoutEquals() {
        HashMap<PersonWithoutEquals, String> map = new HashMap<>();

        PersonWithoutEquals p1 = new PersonWithoutEquals("Alice", 1);
        PersonWithoutEquals p2 = new PersonWithoutEquals("Bob", 2);
        PersonWithoutEquals p3 = new PersonWithoutEquals("Alice", 1); // same data as p1, but different object

        map.put(p1, "Engineer");
        map.put(p2, "Designer");
        map.put(p3, "Manager"); // treated as a different key because equals() not overridden

        System.out.println("HashMap Size: " + map.size()); // 3
        System.out.println("Value for p1: " + map.get(p1)); // Engineer
        System.out.println("Value for p3: " + map.get(p3)); // Manager
    }
}

// ✅ Person class with proper equals() and hashCode()
class PersonWithEquals {
    private String name;
    private int id;

    public PersonWithEquals(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        PersonWithEquals other = (PersonWithEquals) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}

// ❌ Person class with ONLY hashCode(), no equals()
class PersonWithoutEquals {
    private String name;
    private int id;

    public PersonWithoutEquals(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // equals() not overridden → default Object.equals() (reference equality)

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
