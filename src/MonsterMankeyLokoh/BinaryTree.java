package MonsterMankeyLokoh;

public class BinaryTree {
    private Node root;
    private int COUNT = 0;
    public BinaryTree() {}

    public void insert(Registry value) {
        this.COUNT++;
        this.insert(this.root, value);
    }
    public void remove(int value) {
        this.__delete__(this.root, value);
    }
    public Registry search(int key) {
        return __search__(this.root, key).getValue();
    }

    public void watchTree() {
        this.__watchTree__(this.root);
    }

    // Insertion algorithm
    private Node insert(Node root, Registry value) {
        // If this.root is null, just set it to the value.
        if (this.isEmpty()) {
            this.root = new Node(value);
            return root;
        }
        // If current root is null, just set it to the value.
        if (root == null) {
            root = new Node(value);
            return root;
        }
        // Else, make the logic for adding following the three
        if (value.getValue() < root.getValue().getValue()) {
            root.setLeft(this.insert(root.getLeft(), value));
        } else {
            root.setRight(this.insert(root.getRight(), value));
        }
        // Always return the root
        return root;
    }

    // Deletion algorithm
    private Node __delete__(Node root, int value) {
        //basically same logic with extra steps
        if(root == null) return null;

        if(value < root.getValue().getValue()) {
            root.setLeft(this.__delete__(root.getLeft(), value));
        }
        else if (value > root.getValue().getValue()) {
            root.setRight(this.__delete__(root.getRight(), value));
        }
        else {
            if(root.getLeft() == null) return root.getRight();
            if(root.getRight() == null) return root.getLeft();

            Node lesser = this.__findLesserNode__(root.getRight());
            root.setValue(lesser.getValue());
            root.setRight(__delete__(root.getRight(), lesser.getValue().getValue()));
        }


        return root;
    }
    // Search algorithm
    private Node __search__(Node root, int key) {
        // curr root is null, return null
        if(root == null) return null;
        // value is equals to the curr root value
        if(root.getValue().getKey() == key) {
            return root;
        }
        // else, test val < root -> l || r
        if(key < root.getValue().getValue())
            return __search__(root.getLeft(), key);
        else return __search__(root.getRight(), key);
    }

    private Node __findLesserNode__(Node base) {
        if(base.getLeft() == null) return base;
        return __findLesserNode__(base.getLeft());
    }

    public void __watchTree__(Node root) {
        if(root != null) {
            __watchTree__(root.getLeft());
            System.out.println(root.getValue().getValue());
            __watchTree__(root.getRight());
        }
    }

    public Boolean isEmpty() {
        return this.root == null;
    }

    public void print() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        __print__(root, "", true);
    }

    private void __print__(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue().getValue());
            __print__(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            __print__(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }
    }
}

