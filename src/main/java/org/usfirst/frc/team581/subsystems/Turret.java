package org.usfirst.frc.team581.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team581.robot.RobotMap;

public class Turret extends Subsystem {

  // Talon rotateMotor = new Talon(RobotMap.rotateMotor);
  Victor rotateMotor = new Victor(RobotMap.rotateMotor);
  Talon rotateShirtMotor = new Talon(RobotMap.rotateShirtMotor);

  public Turret() {

  }

  public void rotateCannonForward() {
    rotateMotor.set(0.50);
  }

  public void rotateCannonBackward() {
    rotateMotor.set(-0.50);
  }

  public void rotateShirtsForward() {
    rotateShirtMotor.set(0.50);
  }

  public void rotateShirtsBackward() {
    rotateShirtMotor.set(-0.50);
  }

  public void rotateStop() {
    rotateMotor.set(0);
  }

  public void rotateShirtsStop() {
    rotateShirtMotor.set(0);
  }

  @Override
  protected void initDefaultCommand() {

  }

}
