import java.awt.Color; // this was copied from the other classes 
import java.awt.event.*;

//A human controlled JPong paddle
public class CreativeHuman extends HumanPaddle{
   
   //Human Paddle attributes
   private static double CreativeHuman_PADDLE_LENGTH = 75.0;
   public static final double CreativeHuman_PADDLE_SPEED = 6.0;
   public static final Color CreativeHuman_PADDLE_COLOR = Color.red;  
   
   //Key binds for if the Paddle should move up or down
   public static final int KEY_MOVE_UP = KeyEvent.VK_UP;
   public static final int KEY_MOVE_DOWN = KeyEvent.VK_DOWN;   
   
   //the count of times this Paddle has successfully deflected the ball
   //resets when a point is scored by either Paddle.
   protected int volleys;
   int hits;
   
   
   //****************   CONSTRUCTOR  *************

   public CreativeHuman(){
      this(CreativeHuman_PADDLE_LENGTH, CreativeHuman_PADDLE_SPEED, CreativeHuman_PADDLE_COLOR);
      this.volleys = 0;
   }  

   public CreativeHuman(double length, double speed, Color color){
      super(length, speed, color);
      CreativeHuman_PADDLE_LENGTH = length;
      this.volleys = 0;
   }  
   

   //called on each game update for every key that is pressed on the keyboard
   //Returns one of three int values, telling the game that, per the key being 
   //pressed, if the Paddle should move up, down, or not move at all (neutral)
   //
   //Specifically, -1, 0, and 1 correspond to moving up, neutral, and down respectively
   public int reactToKey(int keyPressed){
      return super.reactToKey(keyPressed);
   }
   
   public void goodAsNew (){
      change_length(75.0);
   }
   
   public void paddle_change (){
      if (hits == 1){
         change_length(65.0);
      }
      else if (hits == 2){
         change_length(55.0);
      }
      else if (hits == 3){
         change_length(45.0);
      }
      else if (hits == 4){
         change_length(35.0);
      }
      else if (hits ==5){
         change_length(25.0);
      }
   hits++;
   }  

   //Called automatically whenver the ball collides with this paddle
   public void ballVolleyed(){
      this.volleys++; // the problem for this was that it added 1+1 2 times
      paddle_change();         // but if you just do this.volleys++ it fixes it
   }  
   
   //Called automatically whenever EITHER the player or CPU scores a goal.
   //argument boolean indicates if it was the human who scored (true) or
   //the CPU (false).
   public void pointScored(boolean didHumanScore){
      if (didHumanScore)
         this.score++;
         this.volleys = 0; // this resets the volleys after every score as the instructions said
         goodAsNew();
      }
   
   
   public int getVolleys(){
      return volleys;
   }     
}