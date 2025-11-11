public class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        insertKey(root, key);
    }

    private void insertKey(Node root, int key) {
        if (key == root.getKey()) {
            return;
        }

        if (key > root.getKey()) {
            if (root.hasRightChild()) {
                insertKey(root.getRightChild(), key);
            } else {
                root.setRightChild(new Node(key));
            }
            return;
        }

        if (root.hasLeftChild()) {
            insertKey(root.getLeftChild(), key);
        } else {
            root.setLeftChild(new Node(key));
        }
    }

    public void insertByIteration(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node temp = root;
        Node parent = null;
        while (temp != null) {
            parent = temp;
            if (temp.getKey() == key) {
                break;
            }
            if (temp.getKey() > key) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
        }
        if (key < parent.getKey()) {
            parent.setLeftChild(new Node(key));
        } else {
            parent.setRightChild(new Node(key));
        }
//        Node temp = root;
//        while (true) {
//            if (root.getKey() == key) {
//                break;
//            }
//            if (temp.getKey() > key) {
//                if (temp.hasLeftChild()) {
//                    temp = temp.getLeftChild();
//                } else {
//                    temp.setLeftChild(new Node(key));
//                    break;
//                }
//            } else {
//                if (temp.hasRightChild()) {
//                    temp = temp.getRightChild();
//                } else {
//                    temp.setRightChild(new Node(key));
//                    break;
//                }
//            }
//        }
    }

    public boolean contains(int key) {
        if (root == null) {
            return false;
        }

        return containsKey(root, key);
    }

    private boolean containsKey(Node root, int key) {
        if (key == root.getKey()) {
            return true;
        }

        if (key > root.getKey()) {
            if (root.hasRightChild()) {
                return containsKey(root.getRightChild(), key);
            }
            return false;
        }

        if (root.hasLeftChild()) {
            return containsKey(root.getLeftChild(), key);
        }
        return false;
    }

    public boolean containsKeyByIteration(int key) {
        Node temp = root;
        while (temp != null) {
            if (temp.getKey() == key) {
                return true;
            }
            if (temp.getKey() > key) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
        }
        return false;
//        Node temp = root;
//        while (temp.getKey() != key) {
//            if (temp.getKey() > key) {
//                if (temp.hasLeftChild()) {
//                    temp = temp.getLeftChild();
//                } else {
//                    return false;
//                }
//            } else {
//                if (temp.hasRightChild()) {
//                    temp = temp.getRightChild();
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
    }

    public void print() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node != null) {
            printTree(node.getLeftChild());
            System.out.println(node.getKey());
            printTree(node.getRightChild());
        }
    }

    public void inOrderIterate() {
        MyStack<Node> treeStack = new MyStack<>();
        Node temp = root;
        while (temp != null || !treeStack.isStackEmpty()) {
            while (temp != null) {
                treeStack.push(temp);
                // problemem byla klasa Node, która w obu modulach byla nazwana tak samo, rozwiazanie: zmiana nazwy klasy Node dla Stacka
                temp = temp.getLeftChild();
            }
            temp = treeStack.pop();
            System.out.println(temp.getKey());

            temp = temp.getRightChild();
        }
    }
}
