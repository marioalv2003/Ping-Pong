import java.awt.Color; // This code was copied from the basic file I just modified it meet teh requirements of the proj
public class CreativeCPU extends CPUBasic{

/*** These variables were copied from CPU Basic ***/
   public static double CreativeCPU_PADDLE_LENGTH = 125.0;
   public static double CreativeCPU_PADDLE_SPEED = 15.0;
   public static Color CreativeCPU_PADDLE_COLOR = Color.gray; 
   public int paddle_hits =0;

   //****************   CONSTRUCTORS  *************

   public CreativeCPU(){
      this(CreativeCPU_PADDLE_LENGTH,CreativeCPU_PADDLE_SPEED,CreativeCPU_PADDLE_COLOR);
   } 


   public CreativeCPU(double length, double speed, Color color){ 
      super(length, speed, color);
   }  

   
   //Called automatically whenever EITHER the player or CPU scores a point.
   //argument boolean indicates if it was the CPU who scored (true) or
   //the human (false).
   public void pointScored(boolean didCPUScore){
      if (didCPUScore){ // the messed up part was that if this fucntion was called
         paddle_hits = 0;
         this.score++; 
         changePaddle(); // it automatically rewarded the CPU with a point because it was
   }              // missing the conditional if it was the CPU or human who scored
}

   public void changePaddle (){ // portion of function was worked with Lyboult
    //   System.out.println("color change func called");
      if (paddle_hits < 2){
         change_color(Color.gray);
         change_speed(15.0);
         change_length(125.0);
      }
      else if (paddle_hits == 3){
         change_color(Color.blue);
         change_length(90.0);
      }
      else if (paddle_hits == 5){
        change_color(Color.green);
        change_length(75.0);
      }
      else if (paddle_hits == 8){
         change_color(Color.red);
         change_speed(8.0);
         change_length(50.0);
      }
      else if (paddle_hits >= 10){
         change_color(Color.pink);
         change_speed(2.0);
         change_length(25.0);
      }
   }
   
   //Called automatically whenver the ball collides with this paddle
   public void ballVolleyed(){
      paddle_hits++; 
    //  System.out.println("the ball hit the paddle this amount of times: "+ paddle_hits);
      changePaddle();
      if (paddle_hits >= 13){
         paddle_hits = 0;
         changePaddle();
      }
      
   }  

   
   
   
   
   
   //******************************************************************************
   //Determine how the paddle should move when the ball is moving left or right with 
   //the argument coordinates/velocities.
   //Returns -1, 0, or 1 if paddle should move up, neutral, or down, respectively.
   //
   //arguments include (in order):
   //bX, bY: the ball's current x and y coordinates
   //bXVel, bYVel: the ball's current x and y velocities  
   protected int reactBallMovingLeft(double bX, double bY, double bXVel, double bYVel){
      /* Go to office hours im confused...  */

      double paddleY = this.getY();
      
      if (Math.abs(bY - paddleY) < MOVE_THRESHOLD)
         return MOVE_NEUTRAL;
      else if (paddleY < bY)
         return MOVE_DOWN;
      else if (paddleY > bY){
         return MOVE_UP; 
      }
      return MOVE_NEUTRAL;    
   }
   
   
   protected int reactBallMovingRight(double bX, double bY, double bXVel, double bYVel){
      
      double paddleY = this.getY();
      
      if (Math.abs(bY - paddleY) < MOVE_THRESHOLD)
         return MOVE_NEUTRAL;
      else if (paddleY < bY)
         return MOVE_DOWN;
      return MOVE_UP;    
   }
   //******************************************************************************
   
   
   

   
}