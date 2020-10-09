// Georgios Psevdiotis
// C1841824

import java.util.Scanner; //To input from user
import java.util.Random; //To shuffle the magic box
import java.util.Arrays; //To print out sums of rows/columns/diagonals


public class Q1_C1841824
{

  public static void main(String[] args){
    int n; //n = mb.length
    
    System.out.println("\nEnter an odd integer to create a Magic Square of that size");
    Scanner myObj = new Scanner(System.in); //Scanner so that user inputs n
    n = myObj.nextInt(); //Gets n from scanner
    
    while (n % 2 == 0 || n == 1)  { //While loop to insist that n is odd and more than 1
        System.out.println("Please re-enter an Odd integer larger than 1 to create a Magic Square of that size");
        myObj = new Scanner(System.in);
        n = myObj.nextInt();
  }
   
   int [][] mb = algorithm(n); 
   shuffle(mb, n);
    move(mb,n);
  }

  
static int[][] algorithm(int n){
   int[][] mb = new int[n][n]; //2d array
   int x = 0;  //1-1
   int y = ((n+1)/2)-1;
   int x2;
   int y2;
      
   System.out.println("\nLength of the Magic Box is " + n);
   
   mb[x][y]=1;

   for(int i=2; i<= n * n; i++){
     x2 = x;
     y2 = y;

     if(x2-1<0){
      x2 = n;
     }
     
     if (y2-1<0){
       y2 = n;
     }
     
     if (mb[x2-1][y2-1]==0){
       x = x2 - 1;
       y = y2 - 1;
     }
     else{
       if (x == n -1) {
         x = 0;
       }
       else {
         x = x +1;
         y = y;
        }
     }
     mb[x][y] = i;
    }
    
    System.out.println();
    square(mb);
    return mb;
 }

 static void shuffle(int[][] mb, int n){
   String[] directions = {"U", "D", "L", "R"};
   Random random = new java.util.Random(); 
   int random_direction, x1, y1, temp;
   String r;
  
  System.out.println("\n\nShuffled Square is:\n");

    for (int i=0; i<n*n; i++ ) { //Shuffles Square Randomly by n*n times
      random_direction = random.nextInt(directions.length);
      r = directions[random_direction]; //random direction string
      x1 = random.nextInt(n);
      y1 = random.nextInt(n);
      temp = mb[x1][y1];

      if(r.equals("L")){
        if(y1-1<0){
          mb[x1][y1] = mb[x1][n-1];
          mb[x1][n-1] = temp;
        }
        else{
          mb[x1][y1] = mb[x1][y1-1];
          mb[x1][y1-1] = temp;
        }
      }
      else if(r.equals("R")){
        if(y1+1==n){
          mb[x1][y1] = mb[x1][0];
          mb[x1][0] = temp;
        }
        else{
          mb[x1][y1] = mb[x1][y1+1];
          mb[x1][y1+1] = temp;
        }
      }
      else if(r.equals("U")){
        if(x1-1<0){
          mb[x1][y1] = mb[n-1][y1];
          mb[n-1][y1] = temp;
        }
        else{
          mb[x1][y1] = mb[x1-1][y1];
          mb[x1-1][y1] = temp;
        }
      }
      else if(r.equals("D")){
        if(x1+1==n){
          mb[x1][y1] = mb[0][y1];
          mb[0][y1] = temp;
        }
        else{
          mb[x1][y1] = mb[x1+1][y1];
          mb[x1+1][y1] = temp;
        }
      }
    }
    square(mb);
  }

  static void square(int[][] mb){ //Prints Square at any time it's called
    for (int i = 0; i<mb.length; i++){
      for(int j = 0; j<mb[i].length; j++){
        System.out.print(" [ ");
        System.out.print(mb[i][j]);
        System.out.print(" ]\t");
      }
      System.out.println();
    }  
  }
    
  static void move(int[][] mb, int n){ //Moves numbers in square
    Scanner input2 = new Scanner(System.in);
    String input;
    int moves = 0;
    
    while(checksum(mb,n) == false ){ //While loop to keep on prompting to move numbers when sums are not 15
      if (moves == 0) { //To display this message once
        System.out.println("\nTry to move the numbers using: \n\t [U]p \n[L]eft \t\t[R]ight \n\t[D]own ");  
      }
      System.out.print("\nYour next move is: ");
      moves += 1; //Counter to add moves everytime it loops
      input2 = new Scanner(System.in);
      input = input2.nextLine(); //Gets user input
            
      String[] split = input.split(" "); //Splits user input to 3 parts
      split[2] = split[2].toUpperCase(); //Converts letter to upper case
      System.out.println("\n");
      int x = Integer.parseInt(split[0])-1; //Converts 1st num to integer
      int y = Integer.parseInt(split[1])-1; //Converts 2nd num to integer
      String thirdletter = split[2]; //Converts letter to string
          
      int temp = mb[x][y];
      
      if(thirdletter.equals("L")){ 
        if(y-1<0){
          mb[x][y] = mb[x][n-1];
          mb[x][n-1] = temp;
        }
        else{
          mb[x][y] = mb[x][y-1];
          mb[x][y-1] = temp;
        }
      }
      else if(thirdletter.equals("R")){
        if(y+1==n){
          mb[x][y] = mb[x][0];
          mb[x][0] = temp;
        }
        else{
          mb[x][y] = mb[x][y+1];
          mb[x][y+1] = temp;
        }
      }
      else if(thirdletter.equals("U")){
        if(x-1 < 0){
          mb[x][y] = mb[n-1][y];
          mb[n-1][y] = temp;
        }
        else{
          mb[x][y] = mb[x-1][y];
          mb[x-1][y] = temp;
        }
      }
      else if(thirdletter.equals("D")){
        if(x+1 == n){
          mb[x][y] = mb[0][y];
          mb[0][y] = temp;
        }
        else{
          mb[x][y] = mb[x+1][y];
          mb[x+1][y] = temp;
        }
      }
      
      square(mb);
      System.out.println("\n\tNumber of moves:" + moves);
    }
    //Outside Loop --> If loop stops it means that winning condition is reached so Congratulations is displayed...
    System.out.println("\n\n");
	System.out.println(" _____                             _         _       _   _             ");
	System.out.println("/  __ \\                           | |       | |     | | (_)            ");
	System.out.println("| /  \\/ ___  _ __   __ _ _ __ __ _| |_ _   _| | __ _| |_ _  ___  _ __  ");
	System.out.println("| |    / _ \\| '_ \\ / _` | '__/ _` | __| | | | |/ _` | __| |/ _ \\| '_ \\ ");
	System.out.println("| \\__/\\ (_) | | | | (_| | | | (_| | |_| |_| | | (_| | |_| | (_) | | | |");
	System.out.println(" \\____/\\___/|_| |_|\\__, |_|  \\__,_|\\__|\\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
	System.out.println("                    __/ |                                              ");
	System.out.println("                   |___/                                               ");
    System.out.println("\n\n You solved the Magic Square in " + moves + " moves!"); // ... and number of moves

  }
    
  static boolean checksum(int[][] mb, int n){ 
    int[] rowSum = new int[n];
    int[] columnSum = new int[n];
    int[] diagon = {0,0};
    int formula = ((n * (n * n +1)) /2); //Given formula
    boolean bool = true;
  
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        rowSum[i] += mb[i][j]; //Gets sum of rows
        columnSum[i] += mb[j][i]; //Gets sum of columns
        
        if (i == j){ 
          diagon[0] += mb[i][j]; //Gets sums of 1st diagonal
        }
        
        if (i == n-j-1){
          diagon[1] += mb[j][i]; //Gets sum of 2nd diagonal
        }
      }
    }
    
    System.out.println("\nSum of Rows: " + Arrays.toString(rowSum)); //Prints sum of rows
    System.out.println("Sum of Columns: " + Arrays.toString(columnSum)); //Prints sum of columns
    System.out.println("Sum of Diagonals: " + Arrays.toString(diagon)); //Prints sum of diagonals
    
    for (int i = 0; i < n; i++) {
      if (rowSum[i] != formula) { //Checks if sum of rows is equal to the formula
        bool = false; 
        return bool;
      }
      if (columnSum[i] != formula){ //Checks if sum of columns is equal to formula
        bool = false;
        return bool;
      }
    }
      if (diagon[0]!= formula || diagon[1]!= formula){ //Checks if sum of diagonals is equal to formula
        bool = false;
      }
        
    return bool;
 }
}