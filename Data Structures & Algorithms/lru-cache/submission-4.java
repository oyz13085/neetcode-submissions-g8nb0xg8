class LRUCache {
    int capacity;
    Map<Integer,Node> cache = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
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
    // 1. If the key exists, clear the old version from both structures
    if(cache.containsKey(key)){
        remove(cache.get(key));
        cache.remove(key);
    }

    // 2. Check if we need to make room BEFORE adding the new one
    // Note: Since we removed the key above, size reflects only unique items
    if(cache.size() >= capacity){
        cache.remove(head.next.key);
        remove(head.next);
    }
    
    // 3. Create and Link the new node
    Node newNode = new Node(key, value);
    insert(newNode);
    
    // 4. THE MISSING LINK: Add it to the map so 'get' can find it!
    cache.put(key, newNode); 
}

    public void insert(Node newNode){
        if(cache.containsKey(newNode.key)){
            remove(cache.get(newNode.key));
        }

        Node prev = tail.prev;

        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
        prev.next = newNode;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}