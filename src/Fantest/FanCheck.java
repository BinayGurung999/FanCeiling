package Fantest;
import java.util.Scanner;
import Fantest.Fan.Direction;

public class FanCheck {
	private Fan fan=new Fan();
	public static final int OFF = 0;
	static String new_direction=null;
	void SpeedUp_Test(int speed,String direction)
	{
		int fanspeed=fan.speedUP(speed);
		// checking and increasing the fan speed based on cord pulled
		switch(fanspeed)
		{
			case 1:
				displayinfo(fanspeed, direction);	
				break;
			case 2:
				displayinfo(fanspeed, direction);	
				break;
			case 3:
				displayinfo(fanspeed, direction);
				break;
			case 4:
				System.out.println("The ceiling fan is turned off!!!");
				fanspeed=0;
				break;
		}	
		checkcord(fanspeed,direction);
	}
	// method for displaying the fan speed and direction
	static void displayinfo(int speed, String direction) 
	{
		System.out.println("The fan is spining on " + speed + " speed in " + direction + " direction");
	}
	// checks the cord whether user wants to pull off the left or right string. If pulls the left string then it will increase fan speed otherwise change the direction if right string pulled off.
	public static boolean checkcord(int speed,String direction) 
	{
		FanCheck fancheck=new FanCheck();
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in);
		System.out.println("Press 1 for Left Cord or Press 2 for Right Cord!!");
		int cord=myObj.nextInt();
		if(cord == 1) 
		{
			fancheck.SpeedUp_Test(speed,direction);
			return true;
		}
		else
		{
			if(direction== Direction.BACKWARD.toString())
			{
				direction=Direction.FORWARD.toString();
			}
			else 
			{
				direction=Direction.BACKWARD.toString();
			}
			displayinfo(speed,direction);
			checkcord(speed,direction);
			return false;
		}
	}
	public static void main(String[] args)
	{
		Fan fan=new Fan();
		String direction=null; 
		//checking the initial stage of fan configuration
		boolean check=checkcord(fan.getSpeed(),fan.getDirection().toString());
		if(check==true)
		{
			direction=Direction.FORWARD.toString();
			checkcord(fan.getSpeed(),direction);
		}
		else
		{
			direction=Direction.BACKWARD.toString();
			checkcord(fan.getSpeed(),direction);
		}		
	}
}
