package org.usfirst.frc.team581.subsystems;

import org.usfirst.frc.team581.robot.RobotMap;
import org.usfirst.frc.team581.commands.DriverDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive extends Subsystem{
	
	public DifferentialDrive robotDrive;
	public Spark m_left = new Spark(RobotMap.leftMotor);
	public Spark m_right = new Spark(RobotMap.rightMotor);

	public Drive() {
		// TODO Auto-generated constructor stub
		robotDrive = new DifferentialDrive(m_left, m_right);
	}
	public void initDefaultCommand() {
    	
    	setDefaultCommand(new DriverDrive());
    	//robotDrive.setExpiration(0.1);
    	//stick = new Joystick(joystickChannel);
    	//System.out.println("made Drive class");
    	
    }
	public void driveWithJoysticks(double left, double right){
    	robotDrive.tankDrive(left, right);
    	//System.out.println("--> Calling tankdrive and giving joysticks.");
    }

}
