import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class Conversation {
  /**
   * to mirror the words given by the imput
   * @param sentence
   * @return a sentence with correct mirrored words and a question mark
   */
  public static String mirrorWords(String sentence){
      //break sentence into string[] of words 
      sentence = sentence.toLowerCase();
      String[] words = sentence.split(" ");
      // loop over all the words in string
      String[] initialWords = {"i", "you", "my", "am", "your", "me"};
      String[] replacement={"you", "I", "your", "are", "my", "you"};
      String newSentence= "";

      boolean replace = false;
      //replaces mirror words
      for (int i = 0; i<words.length; i++){
        replace= false;
        if(i!=0){newSentence+=" ";}
        for(int j = 0; j<initialWords.length; j++){
        //if(i!=0){newSentence+=" ";}
        //System.out.println("We're comparing these two things");
        //System.out.print(words[i]);
        //System.out.print(initialWords[j]);
        if(words[i].equals(initialWords[j])){
          newSentence+= replacement[j]; 
          replace = true;
        }
        //else{newSentence += words[i]; break;}
      }
      if(!replace){
        newSentence += words[i];
      }
    }
      String finalSentence = newSentence.substring(0, 1).toUpperCase() + newSentence.substring(1);
      //for (int i = 0; i<words.length ; i++){
          //check for i 
        //  if(i!=0){newSentence += " ";}
          //if (words[i].equals("i")){
          //  words[i]= "you"; newSentence+="you";}
          //if (words[i].equals("my")){words[i]="your"; newSentence+="your";}
          //if (words[i].equals("you")){words[i]="i"; newSentence+="your";}
          //else{newSentence +=words[i];}
      //}
      return finalSentence;
  }
  /**
   * runs the conversation
   * @param arguments
   */
  public static void main(String[] arguments) {
    // You will start the conversation here.
    ArrayList<String> transcript = new ArrayList<String>();
    String[] generic =  {"That's pretty weird.", "Alright then.", "You should go to a doctor for that.", "Uh-huh."};
    //asks for rounds
    int rounds = -1;
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter a number of rounds");
    rounds = userInput.nextInt();
    userInput.nextLine(); //clearing input
    System.out.println("Hello! How are you?");
    Random random= new Random();

    //starts conversation
      for (int i = 0; i < rounds; i++ ) {
          String response = userInput.nextLine();
          transcript.add(response);
          String answer = mirrorWords(response);//replacemirrorwords //generic[random.nextInt(generic.length+1)];
          if(answer.toUpperCase().equals(response.toUpperCase())){ 
            answer = generic[random.nextInt(generic.length)];
          }
          else{
            answer = answer+="?";
          }
          transcript.add(answer);
          System.out.println(answer);
      }
      userInput.close();


      //prints transcript 
      System.out.println("Transcript");
      for (int i = 0; i < transcript.size(); i++){
        if (i%2==0){
        System.out.println("You: " + transcript.get(i)); 
      }
        if (i%2 ==1){
          System.out.println("Computer: "+ transcript.get(i)); 
        }
      }
    }
  }