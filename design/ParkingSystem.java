package LeetCode.design;

class ParkingSystem {
    private final Integer[] counts;

    public ParkingSystem(int big, int medium, int small) {
        counts = new Integer[4];
        counts[1] = big;
        counts[2] = medium;
        counts[3] = small;
    }

    public boolean addCar(int carType) {
        synchronized (counts[carType]) {
            if (counts[carType] == 0) {
                return false;
            } else counts[carType]--;
            return true;
        }
    }

    public static void main(String[] args) {

    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */