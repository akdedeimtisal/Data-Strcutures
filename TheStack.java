
import java.util.Arrays;


public class TheStack {
    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;

    public TheStack(int size) {
        stackSize = size;
        stackArray = new String[size];
        //arrayin bütün elemanlarını -1 yapıyor
        Arrays.fill(stackArray, "-1");
    }
    public void push(String input){
        if(topOfStack + 1 < stackSize){
            topOfStack++;
            stackArray[topOfStack] = input;
        }
        else{
            System.out.println("stack is full");
        }
     //displayTheStack();
    System.out.println("PUSH" + input + " was added to the stack");
    
    }
  
    public String pop(){
        if(topOfStack >= 0){
       //     displayTheStack();
            System.out.println("POP " + stackArray[topOfStack] + " was removed from stack");
           stackArray[topOfStack] = "-1"; 
           return stackArray[topOfStack--];
        }
        else{
    //       displayTheStack();
            System.out.println("stack is empty.");
            return "-1";
        }
        
    }
    public String peek(){
   //     displayTheStack();
        System.out.println("PEEK " + stackArray[topOfStack] + " Is at the top");
        return stackArray[topOfStack];
    }
    public void pushMany(String multipleValues){
        String[] tempString = multipleValues.split(" ");
        for(int i = 0; i < tempString.length; i++){
            push(tempString[i]);
        }
    }
    public void displayTheStack(){
        for(int i = 0; i <stackArray.length; i++){
                System.out.print(stackArray[i] + " ");
        }
        System.out.println("");
    }
    
    public void popAll(){
        for(int i = topOfStack; i >= 0; i--){
            pop();
        }
    }
    
    public static void main(String[] args) {
       TheStack theStack = new TheStack(10);
       theStack.push("10");
       theStack.push("15");
       System.out.println( theStack.peek());
       theStack.pop();
        
       theStack.pushMany("12 16 18");
       
       theStack.displayTheStack();
       
     //  theStack.popAll();
    //  theStack.displayTheStack();
    }
    
}
