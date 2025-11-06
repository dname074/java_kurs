public class Main {
    public static void main(String[] args) {
        BinaryTree treeTest = new BinaryTree();

        treeTest.insert(5);
        treeTest.insert(7);
        treeTest.insert(3);
        treeTest.insert(4);
        treeTest.insert(9);
        treeTest.insert(1);
        treeTest.insert(6);

        System.out.println(treeTest.contains(9));
        System.out.println(treeTest.contains(4));

        treeTest.print();

        //        5
        //    3       7
        //  1   4   6   9
    }
}
