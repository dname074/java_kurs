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

        System.out.println(treeTest.contains(5));
        System.out.println(treeTest.contains(8));

        treeTest.print();

        //        5
        //    3       7
        //  1   4   6   9

        BinaryTree treeTest2 = new BinaryTree();

        treeTest2.insertByIteration(5);
        treeTest2.insertByIteration(7);
        treeTest2.insertByIteration(3);
        treeTest2.insertByIteration(4);
        treeTest2.insertByIteration(9);
        treeTest2.insertByIteration(1);
        treeTest2.insertByIteration(6);
        System.out.println("tree Test 2 done");

        System.out.println(treeTest2.containsKeyByIteration(5));
        System.out.println(treeTest2.containsKeyByIteration(8));

        treeTest2.inOrderIterate();
    }
}
