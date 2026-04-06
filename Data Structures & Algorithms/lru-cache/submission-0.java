class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
      
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);

        if(cache.size() > capacity){
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = tail.prev;
        node.prev = prev;
        node.next = tail;
        prev.next = node;
        tail.prev = node;
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
