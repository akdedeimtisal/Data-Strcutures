
public class HeapByArray {
    int[] arr;
    int sizeOfTree;
    public HeapByArray(int size)
    {
        arr = new int[size + 1]; // + 1 because 0 index is not used.
        this.sizeOfTree = 0;
        System.out.println("Empty heap is created");
    }
    
    public int sizeOfTree() {
        System.out.println("Size Of Tree: " + sizeOfTree);
        return sizeOfTree;
    }
    public boolean isHeapEmpty() {
        if(sizeOfTree <= 0) {
            System.out.println("Tree is empty.");
            return true;
        }
        else {
            System.out.println("Tree is not empty");
            return false;
        }
    }
    public void deleteHeap() {
        arr = null;
        System.out.println("Heap is deleted.");
    }
    public void insertInHeap(int value) {
        System.out.println("Inserting " + value + " in heap");
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        HeapifyBottomToTop(sizeOfTree);
        System.out.println("Inserted " + value + " successfully in Heap !");
	levelOrder();
    }
    public void peek() {
        if(sizeOfTree == 0) {
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("Head of heap is : " + arr[1]);
        }
    }
    public int extractHeadOfHeap() {
        if(isHeapEmpty()) {
            System.out.println("Tree is empty");
            return -1;
        }
        else {
            System.out.println("Head of the heap is: " + arr[1]);
            System.out.println("Extracting is starting. . ");
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree]; //son elemanı root'a atadık.
            sizeOfTree--;
            HeapifyTopToBottom(1);
            System.out.println("Successfully extracted value from heap.");
            levelOrder();
            return extractedValue;
         }
    }
    public void HeapifyBottomToTop(int index) {
        int parent = index / 2;
        //eğer root'daysak heapify'e gerek yok.
        if(index <= 1) 
            return;
        //eğer şu anki değerimiz parent'in değerinden büyükse swap yapmak zorundayız
        if(arr[index] < arr[parent]) {
            int temp;
            temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
        }
        HeapifyBottomToTop(parent);
    }
    public void HeapifyTopToBottom(int index){
        int left = index * 2;
        int right = (index * 2) + 1;
        int smallestChild = 0;
        //left'te child yoksa
        if(sizeOfTree < left) 
            return;
        //sadece left'te  child varsa
        else if(sizeOfTree == left) {
            if(arr[index] > arr[left]) {
                int temp;
                temp = arr[index];
                arr[index] = arr[left];
                arr[left] = temp;
            }
            return;
        }
        //hem left'te hem right'da child varsa
        else { 
            if(arr[left] < arr[right]) 
                smallestChild = left;
            else
                smallestChild = right;
            if(arr[index] > arr[smallestChild]) //parent daha büyükse
            {
                int temp;
                temp = arr[index];
                arr[index] = arr[smallestChild];
                arr[smallestChild] = temp;
                        
                        
            }
        }
        HeapifyTopToBottom(smallestChild);
    }
    public void levelOrder() {
        System.out.println("Printing all elements of the Heap. . . ");
        for(int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        System.out.println("Creating a blank heap");
        HeapByArray heap = new HeapByArray(9);
        heap.insertInHeap(100);
        heap.insertInHeap(90);
        heap.insertInHeap(80);
        heap.insertInHeap(70);
        heap.insertInHeap(60);
        heap.insertInHeap(50);
        heap.insertInHeap(40);
        heap.insertInHeap(30);
        heap.insertInHeap(20);
        
        heap.extractHeadOfHeap();
        heap.insertInHeap(110);
       // heap.extractHeadOfHeap();
    }
}
