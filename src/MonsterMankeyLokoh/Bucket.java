package MonsterMankeyLokoh;

public class Bucket {
    private BinaryTree tree;
    public Bucket() {
        tree = new BinaryTree();
    }
    public void Add(int key, int value) {
        tree.insert(new Registry(key, value));
    }
    public Registry Search(int n) {
        return tree.search(n);
    }
    public void Remove(int n) {
        tree.remove(n);
    }
}
