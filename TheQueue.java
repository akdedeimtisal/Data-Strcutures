
import java.util.Arrays;


public class TheQueue {
    private Integer[] queueArray;
    private int queueSize;
    private int front, rear, numberofItems = 0;

    public TheQueue(int size) {
        queueSize = size;
        queueArray = new Integer[size];
        Arrays.fill(queueArray, -1);
                
    }
    
    public void push(int input){
        if( numberofItems + 1 <= queueSize){
            queueArray[rear] = input;
            rear++;
            numberofItems++;
            System.out.println("INSERT " + input + " was added");
            
        }
        else{
            System.out.println("queue is full");
        }
    }
    public int pop(){
        if(numberofItems > 0){
            System.out.println("REMOVE " + queueArray[front] + " was removed");
            queueArray[front] = -1;
            front++;
            numberofItems --;
            return  queueArray[front];
        }
        else{
            System.out.println("queue is empty");
            return -1;
        }
    }
    public int peek(){
        System.out.println("the first element is " + queueArray[front]);
        return queueArray[front];
    
    }
    
    public void displayQueue(){
        for (int i = 0; i < queueArray.length; i++){
            System.out.print(queueArray[i] + " ");
        }
        System.out.println("");
    }
    
    
    public  boolean isPalindrome(){
      
        for(int i = front; i < queueArray.length / 2; i++){
            if(queueArray[i] != queueArray[rear - i - 1]){
                return false;
            }
           
        }
        
         return true;
        
        
    }
    
    public static void main(String[] args) {
        
        TheQueue theQueue = new TheQueue(10);
        
       theQueue.push(6);
       theQueue.push(5);
       theQueue.push(4);
       theQueue.push(5);
       theQueue.push(6);
      // theQueue.push(5);
       theQueue.displayQueue();
       if(theQueue.isPalindrome()){
           System.out.println("Queue is palindrome");
       }
       else{
           System.out.println("Queue is not palindrome");
       }
        theQueue.pop();
        theQueue.displayQueue();
         
          if(theQueue.isPalindrome()){
           System.out.println("Queue is palindrome");
       }
       else{
           System.out.println("Queue is not palindrome");
       }
     
        
    }
}
