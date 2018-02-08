package org.usfirst.frc.team581.robot;

import org.usfirst.frc.team581.commands.CompressorLoop;
import org.usfirst.frc.team581.commands.DsolenoidExtend;
import org.usfirst.frc.team581.commands.DsolenoidOff;
import org.usfirst.frc.team581.commands.DsolenoidRetract;
import org.usfirst.frc.team581.commands.RotateCannonBackward;
import org.usfirst.frc.team581.commands.RotateCannonForward;
import org.usfirst.frc.team581.commands.RotateShirtsBackward;
import org.usfirst.frc.team581.commands.RotateShirtsForward;
import org.usfirst.frc.team581.commands.RotateShirtsStop;
import org.usfirst.frc.team581.commands.RotateStop;
import org.usfirst.frc.team581.commands.SolenoidCOff;
import org.usfirst.frc.team581.commands.SolenoidCOn;
import org.usfirst.frc.team581.commands.SolenoidOff;
import org.usfirst.frc.team581.commands.SolenoidOn;
import org.usfirst.frc.team581.commands.ToggleCompressor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	public Joystick leftJoy = new Joystick(0);
	public Joystick rightJoy = new Joystick(1);
	public Joystick controlJoy = new Joystick(2);

	//Relay spike = new Relay(4);
	Button cbutton2 = new JoystickButton(controlJoy,2);
	Button cbutton3 = new JoystickButton(controlJoy,3);
	Button cbutton4 = new JoystickButton(controlJoy,4);
	Button cbutton1 = new JoystickButton(controlJoy,1);
	Button cbutton10 = new JoystickButton(controlJoy,10);
	Button cbutton5 = new JoystickButton(controlJoy,5);
	
	Button rbutton2 = new JoystickButton(rightJoy,2);
	Button rbutton3 = new JoystickButton(rightJoy,3);
	
	Button lbutton2 = new JoystickButton(leftJoy,2);
	Button lbutton3 = new JoystickButton(leftJoy,3);
	Button lbutton4 = new JoystickButton(leftJoy,4);
	Button lbutton5 = new JoystickButton(leftJoy,5);
	
	Button rbutton4 = new JoystickButton(rightJoy,4);
	
	public double getLeftJoy(){
		return leftJoy.getY();
	}
	
	public double getRightJoy(){
		return rightJoy.getY();
	} 
	
	public OI() {
		cbutton1.whenPressed(new SolenoidOn());
		cbutton1.whenReleased(new SolenoidOff());
		cbutton10.whenPressed(new ToggleCompressor());
		cbutton2.whenPressed(new DsolenoidRetract());
		cbutton2.whenReleased(new DsolenoidOff());
		cbutton3.whenPressed(new DsolenoidExtend());
		cbutton3.whenReleased(new DsolenoidOff());
		
		lbutton4.whenPressed(new RotateCannonForward());
		lbutton5.whenPressed(new RotateCannonBackward());
		lbutton4.whenReleased(new RotateStop());
		lbutton5.whenReleased(new RotateStop());
		
		cbutton4.whenPressed(new RotateShirtsForward());
		cbutton5.whenPressed(new RotateShirtsBackward());
		cbutton5.whenReleased(new RotateShirtsStop());
		cbutton4.whenReleased(new RotateShirtsStop());
		
		lbutton3.whenPressed(new SolenoidCOn());
		lbutton3.whenReleased(new SolenoidCOff());
	}

}
