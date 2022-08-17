package solvd.projects.collections.customlinkedlist;

public class Node <T>{
    T data;
    Node next;

    Node(){

    }

    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNextNode() {
        return next;
    }

    public void setNextNode(Node next) {
        this.next = next;
    }
}