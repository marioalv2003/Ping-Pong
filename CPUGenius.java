import java.awt.Color; // This code was copied from the challenging file I just modified it meet teh requirements of the proj
public class CPUGenius extends CPUChallenging{

/*** These variables were copied from CPU Basic ***/
   public static final double CPU_Genius_PADDLE_LENGTH = 25.0;
   public static final double CPU_Genius_PADDLE_SPEED = 3.0;
   public static final Color CPU_Genius_PADDLE_COLOR = Color.pink; 

   //****************   CONSTRUCTORS  *************
   public CPUGenius(){
      this(CPU_Genius_PADDLE_LENGTH, CPU_Genius_PADDLE_SPEED, CPU_Genius_PADDLE_COLOR);
   }
   
   public CPUGenius(double length, double speed, Color color){ 
      super(length, speed, color);
   }  
   
   //Called automatically whenever EITHER the player or CPU scores a point.
   //argument boolean indicates if it was the CPU who scored (true) or
   //the human (false).
   public void pointScored(boolean didCPUScore){
      if (didCPUScore){ // the messed up part was that if this fucntion was called
         this.score++; // it automatically rewarded the CPU with a point because it was
   }              // missing the conditional if it was the CPU or human who scored
}
   
   //Called automatically whenver the ball collides with this paddle
   public void ballVolleyed(){
      //This paddle doesn't react to a ball being volleyed
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
      return super.reactBallMovingRight(bX, bY, bXVel,bYVel);
      // same as the cpu challenging paddle it implements the same logic for the ball moving 
      // to the left as the right so called the parents moving right function using super.
   }

    protected int reactBallMovingRight(double bX, double bY, double bXVel, double bYVel){
      double bounce= TrigHelpers.calcNextWallBounceX(bX,bY,bXVel,bYVel,getWindowHeight()); // for this would it be getY() or get getY()-10?
      
      if (bounce > getX()){ // i feel like this might be wrong
         return super.reactBallMovingRight(bX, bY, bXVel,bYVel);
      }
      else {
         double yCoordinate= TrigHelpers.calcTargetY(bX,bY,bXVel,bYVel,this.getY()); // for this would it be getY() or get getY()-10?
      double centerY = getY();
      if (yCoordinate < centerY-10){
         return MOVE_DOWN;
      }
      else if (yCoordinate> centerY+10){
         return MOVE_DOWN;
      }
      else if ((yCoordinate> centerY+10)||(yCoordinate < centerY-10)){
         return MOVE_UP;
      }
      return MOVE_UP ;
      }
    }
   //******************************************************************************
   
   
   

   
}