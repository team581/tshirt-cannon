// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Spark;

//import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import frc.robot.util.MotorConstants;

public class MotorSubsystem extends SubsystemBase {

  // TODO: Swap the talons with sparks and swap mecanum with differential drive
  public final Spark frontRightMotor = new Spark(1); //TODO: Change numbers later after electronics wire the PWMS
  public final Spark frontLeftMotor = new Spark(2);
  public final Spark rearRightMotor = new Spark(3);
  public final Spark rearLeftMotor = new Spark(4);

  //public final MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
  private final SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
  private final SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);

  public final DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  /** Creates a new Motors. */
  public MotorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
