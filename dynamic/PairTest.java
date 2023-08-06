package LeetCode.dynamic;


public class PairTest {
    private static class Pair<T1, T2> {
        T1 object1;
        T2 object2;

        Pair(T1 one, T2 two) {
            object1 = one;
            object2 = two;
        }

        public T1 getFirst() {
            return object1;
        }

        public T2 getSecond() {
            return object2;
        }
    }

    public static void main(String[] args) {
        Pair<Integer, String> worldCup = new Pair<>(2023, "Ukraine");
        System.out.println(worldCup.getFirst() + "asdf" + worldCup.getSecond());
    }
}
