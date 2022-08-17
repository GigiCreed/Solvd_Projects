package solvd.projects.collections.customlinkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList <V>{
    Logger logger = LogManager.getLogger(CustomLinkedList.class);
    Node head;

    public void insert(V data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }else {
            Node currentNode = head;
            while(currentNode.next != null) {
                currentNode= currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void insertAtStart(V data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public void insertAtLast(V data)
    {
        if (head == null)
        {
            head = new Node();

            head.data = data;
            head.next = null;
        }
        else
        {
            Node toAdd = new Node();
            toAdd.data = data;

            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }

            current.next = toAdd;
        }
    }
    public void insertAt(int index, V data) {
        if(index == 0){
            insertAtStart(data);
        }else{
            Node newNode = new Node(data);

            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public void deleteAt(int index) {
        if(index == 0) {
            head = head.next;
        }else{
            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public void show() {
        Node currentNode = head;
        if(currentNode == null){
            logger.info("Linked list is empty");
        }
        else {
            while(currentNode != null) {
                logger.info(currentNode.data + "\n");
                currentNode = currentNode.next;
            }
        }

    }
}