package LeetCode.string;

class MyOuter {
    private int x = 7;

    public void makeInner() {
        MyInner in = new MyInner();
        in.seeOuter();
    }

    class MyInner {
        private int x = 8;

        public void seeOuter() {
            System.out.println("x is " + x);
        }
    }

    public static void main(String[] args) {
        MyInner inner = new MyOuter().new MyInner();
        inner.seeOuter();
    }
}