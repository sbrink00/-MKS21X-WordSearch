import java.io.*;
public class myDriver{
  public static void main(String[]args){
      String instructions = ""; //Displaying the answer key isn't coded yet, so the instructions will cover that later
      instructions += "This program can be used with three or four arguments\n";
      instructions += "3 arguments:\n arg 1 - number that represents number of rows";
      instructions += "\n arg 2 - number that represents number of columns";
      instructions += "\n arg 3 - string that is the file name you wish to use";
      instructions += "\n4 arguments:\n the first three arguments are the same as when you are only using three arguments";
      instructions += "\n arg 4 - number that will be a random seed so you can recreate the same wordsearch";
      //note that if the terminal is too small the instructions won't be nicely formatted
      WordSearch output;
      if (args.length < 2 || args.length > 5) System.out.println(instructions);

      if (args.length == 3){
        output = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
        System.out.println(output);
      }
      if (args.length == 4){
        output = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), "");
        System.out.println(output);
      }
      if (args.length == 5){
        output = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[4]);
        System.out.println(output);
      }

  }
}
