package Fantest;
import static Fantest.Fan.Direction.FORWARD;
public class Fan 
{
	private int speed=0;
	private Direction direction = FORWARD;
	public int getSpeed()
	{
		return speed;
	}
	public Direction getDirection() 
	{
		return direction;
	}
	public int speedUP(int speed)
	{
		if(speed > 3)
		{
			speed = 0;
		}
		else
		{
			speed++;
		}
		return speed;
	}
	public enum Direction 
	{
		FORWARD,
		BACKWARD;
	}
}
