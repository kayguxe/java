import java.util.Arrays;
import java.awt.Color;
import becker.robots.*;
public class RobotsMoveLights {
  final static int LIGHT_STREET = 1;
  final static int LIGHT_AVENUE = 1;
  final static int CITY_SIZE = 10;
  
  //we create method rightIsClear to check if the right is clear by turning to the right and then checking if the front is clear if so we turn left
  public static boolean rightIsClear(Robot robot)
  { 
    for(int i = 0; i < 3; i++){
      robot.turnLeft();
    }
    if ( robot.frontIsClear() ) 
    {
      robot.turnLeft();
      return true;
    }
    robot.turnLeft();
    return false;
  }
  
  public static void getLoot(Robot robot) {
    //complete this method
    
    int x = robot.getAvenue();
    int y = robot.getStreet();
    //while the number of things inside the backpack doesnt equal to 3 keep looping
    while(robot.countThingsInBackpack(IPredicate.anyLight) != 3){
      //while the robot is beside a wall
      while(robot.isBesideThing(IPredicate.anyWall)){
      //when the number of lights equals to 3 change the colour of the robot to green
        if(robot.countThingsInBackpack(IPredicate.anyLight) == 3){
          robot.setColor(Color.green);
          break;
        }
        //picking the lights when the robot is beside them
        if(robot.isBesideThing(IPredicate.anyLight)){
          robot.pickThing(IPredicate.anyLight);
        }
        //if the right is clear turn right
        if(rightIsClear(robot)){
          for(int i = 0; i < 3; i++){
            robot.turnLeft();
          }
        }
        //else if the front is not clear turn left
        else{
          while(robot.frontIsClear() == false){
            robot.turnLeft();
            robot.getIntersection();
          }
        }
        robot.move();
      }
      //if the robot is not beside a wall and the right clear the robot should turn right and moves forward and it pick lights and change the light to green 
      //when the number of things in backpack equals 3
      while(rightIsClear(robot)){
        for(int i = 0; i < 3; i++){
          robot.turnLeft();
        }
        robot.move();
        if(robot.isBesideThing(IPredicate.anyLight)){
          robot.pickThing(IPredicate.anyLight);
        }
        if(robot.countThingsInBackpack(IPredicate.anyLight) == 3){
          robot.setColor(Color.green);
          break;
          
        }
      }
      if(robot.countThingsInBackpack(IPredicate.anyLight) == 3){
        
        break;
        
      }
    }
    // here we are sending the robot back to the starting point, if the robott picked the lights and is in the starting point it should break out of the
    //loop and stop
    while(robot.countThingsInBackpack(IPredicate.anyLight) == 3){
      if(robot.getAvenue() == 0 && robot.getStreet() == 1){
        break;
      }
      while(robot.isBesideThing(IPredicate.anyWall)){
        if(rightIsClear(robot)){
          if(robot.getAvenue() == 0 && robot.getStreet() == 1){
            break;
          }
          for(int i = 0; i < 3; i++){
            robot.turnLeft();
          }
        }
        else{
          if(robot.getAvenue() == 0 && robot.getStreet() == 1){
            break;
          }
          while(robot.frontIsClear() == false){
            robot.turnLeft();
            
          }
        }
        robot.move();
      }
      while(rightIsClear(robot)){
        if(robot.getAvenue() == 0 && robot.getStreet() == 1){
          break;
        }
        for(int i = 0; i < 3; i++){
          robot.turnLeft();
        }
        robot.move();
        
      }
      
      
    }
  }
  
  
  
  public static void main(String[] args) {
    MazeCity montreal = new MazeCity(CITY_SIZE, CITY_SIZE);
    
    Robot asimo = new Robot(montreal, LIGHT_STREET, LIGHT_AVENUE - 1, Direction.EAST);
    
    new Flasher(montreal, 8, 8,    true);
    new Flasher(montreal, 3, 4,    true);
    new Flasher(montreal, 2, 6,    true);
    
    getLoot(asimo);  
  }
  
}
