package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryMaxHeap<T> {


    int capacity;
    private List<Node> allNodes = new ArrayList<Node>();

    public BinaryMaxHeap( int k) {
        this.capacity =k;
    }
    static class Node {
        int weight;
        int data;

        public Node(int weight,int data) {
            this.weight=weight;
            this.data=data;
        }

        public Node(int weight, String tushar) {

        }
    }

    public void add(int weight,int data) {

        Node node = new Node(weight,data);
        
        if(allNodes.size() == capacity) {
            extractMap();
        }
        allNodes.add(node);
        int size = allNodes.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;

        while (parentIndex >= 0) {
            Node parentNode = allNodes.get(parentIndex);
            Node currentNode = allNodes.get(current);
            if (parentNode.weight < currentNode.weight) {
                swap(parentNode,currentNode);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }

    }

    private void swap(Node node1,Node node2){
        int weight = node1.weight;
        int data = node1.data;

        node1.data = node2.data;
        node1.weight = node2.weight;

        node2.data = data;
        node2.weight = weight;
    }

    public int max(){
        if(allNodes.size()>0)
        return allNodes.get(0).weight;
        else
            return -1;
    }

    public boolean empty(){
        return allNodes.size() == 0;
    }


    public int extractMap(){
        int size = allNodes.size() -1;
        int max = allNodes.get(0).data;
        int lastNodeWeight = allNodes.get(size).weight;
        allNodes.get(0).weight = lastNodeWeight;
        allNodes.get(0).data = allNodes.get(size).data;
        allNodes.remove(size);

        int currentIndex = 0;
        size--;
        while(true){
            int left = 2*currentIndex + 1;
            int right = 2*currentIndex + 2;
            if(left > size){
                break;
            }
            if(right > size){
                right = left;
            }
            int largerIndex = allNodes.get(left).weight >= allNodes.get(right).weight ? left : right;
            if(allNodes.get(currentIndex).weight < allNodes.get(largerIndex).weight){
                swap(allNodes.get(currentIndex),allNodes.get(largerIndex));
                currentIndex = largerIndex;
            }else{
                break;
            }
        }
        return max;
    }

    public void printHeap(){
        for(Node n : allNodes){
            System.out.println(n.weight + " " + n.data);
        }
    }

    public void findksmallest(ArrayList<Node> list,BinaryMaxHeap heap) {

        for(Node node : list) {

            if(heap.max() > node.weight) {
                heap.add(node.weight, node.data);
            }
        }
    }

    public static void main(String args[]){
        ArrayList<Node> list = new ArrayList();
        list.add(new Node(7, "Tushar"));
        list.add(new Node(10, "Ani"));
        list.add(new Node(4, "Vijay"));
        list.add(new Node(3, "Pramila"));
        list.add(new Node(20, "Roy"));
        list.add(new Node(15, "NTF"));
        BinaryMaxHeap heap = new BinaryMaxHeap(3);
        heap.findksmallest(list,heap);
        heap.printHeap();
    }
}

