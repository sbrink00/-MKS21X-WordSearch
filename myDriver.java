public class myDriver{
  public static void main(String[]args){
    WordSearch ws1 = new WordSearch(5, 5);
    System.out.println(ws1.addWordHorizontally("four", 0, 0));
    //System.out.println(ws1.addWordHorizontally("me", 0, 3));
    System.out.println(ws1.addWordVertically("two", 2, 2));
    System.out.println(ws1);
  }
}
