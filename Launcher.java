
public class Launcher{
  
  //Set to true to enable debug mode
  //Debug mode will draw RED SQUARES to show the approximate
  //locations of each time the ball will hit a wall and where
  //it will be when it reaches the paddle.
  public static final boolean ASSIST_MODE = false;  
  

   
  //Run this to launch the JPong Game!
  public static void main(String[] args){
         
    //Change these two values to test your different paddles!
     // HumanPaddle p1 = new HumanPaddle();
      HumanPaddle p1 = new CreativeHuman();
     // CPUPaddle p2 = new CPUBasic();
     // CPUPaddle p2 = new CPUChallenging(); // this is for challenging 
     // CPUPaddle p2 = new CPUGenius(); // this is for genius 
      CPUPaddle p2 = new CreativeCPU(); // this is for creative paddle 
    //*******************************************************
        
      JPong game = new JPong(p1, p2);
    
    game.playGame();
  }
}