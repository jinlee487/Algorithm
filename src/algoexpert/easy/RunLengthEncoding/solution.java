package algoexpert.easy.RunLengthEncoding;


class Program {
  public String runLengthEncoding(String string) {
    // Write your code here.
    StringBuilder str = new StringBuilder();
    int j = 1;
    for(int i=1;i<string.length();i++,j++){
        char current = string.charAt(i);
        char previous = string.charAt(i-1);
        if(current != previous || j == 9){
            str.append(Integer.toString(j));
            str.append(previous);
            j = 0;
        }
    }
    str.append(Integer.toString(j));
    str.append(string.charAt(string.length() - 1));
    return str.toString();
    }
}
