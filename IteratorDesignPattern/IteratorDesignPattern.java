package IteratorDesignPattern;
import java.util.*;

class Main{
    public static void main(String [] args){
        System.out.println("hello");
        MyLinkedList list = new MyLinkedList();
        
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        
        System.out.println(list.size());
        
        for(int val : list){
            System.out.print(val + " -> ");
        }
        System.out.println(".");
        
    }
    
    // implements Iterable<Integer>
    
    static class MyLinkedList implements Iterable<Integer>{
        static class Node{
            int data;
            Node next;
        }
        
        Node head;
        Node tail;
        int size;
        
        int size(){
            return size;
        }
        void addLast(int data){
            Node node = new Node();
            node.data = data;
            node.next = null;
            
            if(size == 0){
                head = tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
            size++;
        }
        
        public Iterator<Integer> iterator(){
            return new LinkedListIterator(head);
        }
        
        static class LinkedListIterator implements Iterator<Integer>{
            Node temp;
            LinkedListIterator(Node temp){
                this.temp = temp;
            }
            
            public boolean hasNext(){
                if(temp == null){
                    return false;
                }else{
                    return true;
                }
            }
            
            public Integer next(){
                int rv = temp.data;
                temp = temp.next;
                return rv;
            }
        }
    }
}