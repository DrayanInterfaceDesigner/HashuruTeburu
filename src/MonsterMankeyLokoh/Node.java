package MonsterMankeyLokoh;

public class Node {
    private Registry value;
    private Node left;
    private Node right;
    private Boolean visited;
    private int height = 1;
    public Node (Registry value){
        this.value = value;
    }

    public Registry getValue() {
        return value;
    }

    public void setValue(Registry value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}