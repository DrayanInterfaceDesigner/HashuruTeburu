package MonsterMankeyLokoh;

public class Bucket {
    private BinaryTree tree;
    public Bucket() {
        tree = new BinaryTree();
    }
    public void Add(int n) {
        tree.insert(new Registry(n));
    }
    public Registry Search(int n) {
        return tree.search(n);
    }
    public void Remove(int n) {
        tree.remove(n);
    }
}
