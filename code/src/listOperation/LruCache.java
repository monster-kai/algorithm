package listOperation;

/**
 * @author Ryan
 * @data 2020/02/16 - 周日
 * 实现LRU( Least Recently Used)最近最少使用策略——链表(最左边head表示最近使用的，越靠近尾部越是旧数据)实现
 * 有数据需要从LRU缓存中读取时，遍历链表查找，找到返回并更新位置，未找到添加到head
 * API：构造函数
 */
public class LruCache<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private Integer capacity ;                       //缓存所允许的容量
    private Integer length;                          //当前所占长度
    private  Node head;                           //哨兵简化代码

    public LruCache(){
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;                             //
        head = new Node<>();
    }

    public LruCache(int capacity){
        this.capacity = capacity;
        this.length = 0;
        head = new Node<>();
    }

    public void add(T data){
        Node pre = findPreNode(data);
        if(pre==null){
            if(isFull()) deleteElemAtEnd();
            addElementInHead(data);
        }else{
            deleteNextElem(pre);
            addElementInHead(data);
        }
    }


    private Node findPreNode(T data){
        Node pre = head;
        while(pre.getNext()!=null){
            if(data.equals(pre.getNext().getData())){
                return pre;
            }
            pre = pre.getNext();
        }
        return null;
    }

    public boolean isFull(){
        return length==capacity;
    }

    private void deleteNextElem(Node curr){
        Node temp = curr.getNext();
        curr.setNext(curr.getNext().getNext());
        temp = null;
        length--;
    }


    public void addElementInHead(T data){
        Node<T> next = new Node<>(data);
        next.setNext(head.getNext());
        head.setNext(next);

        length++;
    }

    private void deleteElemAtEnd(){
        if(head.next==null) return;
        Node pre = head;
        while(pre.getNext().getNext()!=null){
            pre = pre.getNext();
        }
        Node temp = pre.getNext();
        pre.setNext(null);
        temp = null;
        length--;
    }

    public void printLRU(){
        Node iter = head;
        while(iter.getNext()!=null){
            iter = iter.getNext();
            System.out.print(iter.getData()+", ");
        }
        System.out.println();
    }

    private class Node<T>{                             //单向链表,链表中存储的数据类型为泛型表示
        private Node next;
        private T element;

        public Node(){ }

        public Node(T element){
            this.element = element;
        }

        public Node(T element, Node next){
            this.next = next;
            this.element = element;
        }

        public Node getNext(){
            return next;
        }

        public T getData(){
            return element;
        }

        public void setData(T element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
