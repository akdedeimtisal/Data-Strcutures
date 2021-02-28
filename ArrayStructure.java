
public class ArrayStructure {
    private Integer[] theArray = new Integer[50];
    
    private int arraySize = 10;
    
    public void generateRandomArray(){
        for(int i = 0; i < arraySize; i++){
            theArray[i] =(int)(Math.random() * 10) + 10;
        }
        
        
    }
    public void printArray(){
        System.out.println("-----------");
        for(int i = 0; i < arraySize; i++){
            System.out.print(" | " + i + " | ");
            System.out.println(theArray[i] + " | ");
            System.out.println("-----------");
        }
        
    }
    
    public int getValueAtIndex(int index){
        if(index < arraySize){
            return theArray[index];
        }
        return 0;
    }
    public boolean doesArrayContainThisValue(int searchValue){
        boolean valueInArray = false;
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == searchValue){
                valueInArray = true;
            }
        }
        return valueInArray;
    }
    public void deleteIndex(int index){
        if(index < arraySize){
            
            for(int i = index; i <(arraySize - 1); i++){
                theArray[i] = theArray[i+1];
                               
            }
            
            arraySize--;
            
        }
        
        
        
    }
    
    public void insertValue(int value){
        if(arraySize < 50){
            theArray[arraySize] = value;
            arraySize++;
        }
    }
    public String linearSearchForValue(int value){
        boolean valueInArray = false;
        String indexWithValue = "";
        
        System.out.println("the value was found in the following:");
        
        for(int i = 0; i < arraySize; i++){
            if(theArray[i] == value){
                valueInArray = true;
                System.out.println(i + " ");
                indexWithValue += i + " ";
            }
            
           
        } 
         if(!valueInArray){
                indexWithValue = "None";
                System.out.println(indexWithValue);
            }
        System.out.println("");
        return indexWithValue;
    }
    
    public void bubbleSort(){
        for(int i = arraySize - 1; i > 1; i--){
            for(int j = 0; j < i; j++){
                if(theArray[j] > theArray[j + 1]){
                    swapValues(j, j + 1);
                    printArray();
                }
            }
       }
    }
    public void swapValues(int indexOne, int indexTwo){
        int temp  = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }
    public void binarySearchForValue(int value){
        int lowIndex = 0;
        int highIndex = arraySize - 1;
        while(lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex) / 2;
            if(theArray[middleIndex] < value){
                lowIndex = middleIndex + 1;
            }
            else if(theArray[middleIndex] > value){
                highIndex = middleIndex - 1;
                
            }
            else{
                System.out.println("Found a match for " + value + " at index " + middleIndex);
                lowIndex = highIndex + 1;
            }
            printArray();
        }
        
        
    }
    
    public void selectionSort(){
        for(int x = 0; x < arraySize; x++){
            int minimum = x;
            for(int y = x; y < arraySize; y++){
                if(theArray[minimum] > theArray[y]){
                    
                    minimum = y;
                                        
                }
                
            }
            swapValues(x, minimum);
            
        }
        
        printArray();
    }
    public void insertionSort(){
        for(int i = 1; i < arraySize; i++){
            int j = i;
            int toInsert = theArray[i];
            while((j > 0) && (theArray[j - 1] > toInsert)){
                
                theArray[j] = theArray[j - 1];
                j--;
                
                
            }
            printArray();
            theArray[j] = toInsert;
            printArray();
            System.out.println("Array[i] = " + theArray[i] + "Array[j]= " + theArray[j] + " toInsert= " + toInsert );
        }
    }
    
    
    
    
    public static void main(String[] args) {
        ArrayStructure newArray = new ArrayStructure();
        newArray.generateRandomArray();
        newArray.printArray();
          
      /*  System.out.println(newArray.getValueAtIndex(3));
        System.out.println(newArray.doesArrayContainThisValue(11));
        
        newArray.deleteIndex(4);
        newArray.printArray();
        
        newArray.insertValue(55);
        newArray.printArray();
        
        newArray.linearSearchForValue(17);
        newArray.bubbleSort(); */
      //  newArray.bubbleSort();
      //  newArray.binarySearchForValue(19);
       // newArray.selectionSort();
       newArray.insertionSort();
    }
    
}
