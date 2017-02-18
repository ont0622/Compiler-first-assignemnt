/*
    Daniel Oh
    CSC 4340

    This is a main file for WAE program
*/

   
import java.io.*;
import java.util.*;
   
public class Main {
  static public void main(String argv[]) throws ArrayIndexOutOfBoundsException {
    /* Start the parser */

    if (argv.length == 0){
      try{
        System.out.print("WAE> ");
        String next;
        StringBuffer userInput = new StringBuffer();
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter("testFile.txt");
        do{
          next = in.next();
          userInput.append(next);
        }
        while(!next.equals(";"));
        out.append(userInput);
        out.close();
        parser p = new parser(new Lexer(new FileReader("testFile.txt")));
        Object result = p.parse().value;
      }
      catch (Error e){
        e.printStackTrace();
      }
      catch (Exception e){
        e.printStackTrace();
      }
    }
    else{
      try {
        parser p = new parser(new Lexer(new FileReader(argv[0])));
        Object result = p.parse().value;
      }
      catch (Error e){
        e.printStackTrace();
      }
      catch (Exception e) {
        e.printStackTrace();
      }

    }

  }
}