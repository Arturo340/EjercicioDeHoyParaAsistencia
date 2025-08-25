/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainprioritynode;

/**
 *
 * @author Arturo González
 */
class PriorityQueue {

    private PriorityNode<String>[] data;

private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity) {
        if (capacity < 1) capacity = 16;
        data = (PriorityNode<String>[]) new PriorityNode[capacity + 1];
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    private void ensureCapacity() {
        if (size + 1 >= data.length) {
            int newCap = data.length * 2;
            data = java.util.Arrays.copyOf(data, newCap);
        }
    }
    public void push(int priority, String value) {
        ensureCapacity();
        PriorityNode<String> nodeToInsert = new PriorityNode<>(priority, value);
        size++;
        int pos = size;
        data[pos] = nodeToInsert;
        while (pos > 1) {
            int parent = pos / 2;
            PriorityNode<String> parentNode = data[parent];
            if (parentNode.getPriority() <= nodeToInsert.getPriority()) break;
            
data[pos] = parentNode;
            data[parent] = nodeToInsert;
            pos = parent;
        }
    }
     public String peek() {
        if (isEmpty()) return null;
        return data[1].getData();
    }
     public String pop() {
        if (isEmpty()) return null;
        String result = data[1].getData();
        data[1] = data[size];
        data[size] = null;
        size--;
        heapifyDown(1);
        return result;
    }
     private void heapifyDown(int i) {
        while (true) {
            int left = i * 2;
            int right = left + 1;
            int smallest = i;
            if (left <= size && data[left].getPriority() < data[smallest].getPriority()) smallest = left;
            if (right <= size && data[right].getPriority() < data[smallest].getPriority()) smallest = right;
            if (smallest == i) break;
            PriorityNode<String> tmp = data[i];
            data[i] = data[smallest];
            data[smallest] = tmp;
            i = smallest;
        }
    }
     public void show() {
        if (isEmpty()) {
            System.out.println("[cola vacía]");
            return;
        }
        System.out.println("Contenido de la cola (orden de heap):");
        for (int i = 1; i <= size; i++) {
            System.out.printf("(%d: \"%s\")%s",
                    data[i].getPriority(),
                    data[i].getData(),
                    (i < size ? " - " : "\n"));
        }
    }
}