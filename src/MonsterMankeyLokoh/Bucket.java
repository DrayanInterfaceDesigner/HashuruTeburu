package MonsterMankeyLokoh;

public class Bucket {
    private BinaryTree tree;
    public Bucket() {
        tree = new BinaryTree();
    }
    public void Add(int n) {
        tree.insert(new Registry(n));
    }
    public void Search(int n) {
        tree.remove(n);
    }
}
