// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

//import edu.wpi.first.wpilibj.Spark;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.util.MotorConstants;

public class MotorSubsystem extends SubsystemBase {

  // TODO: Swap the talons with sparks and swap mecanum with differential drive
  public final WPI_TalonFX frontRightMotor = new WPI_TalonFX(11);
  public final WPI_TalonFX frontLeftMotor = new WPI_TalonFX(10);
  public final WPI_TalonFX rearRightMotor = new WPI_TalonFX(13);
  public final WPI_TalonFX rearLeftMotor = new WPI_TalonFX(12);

  public final MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

  /** Creates a new Motors. */
  public MotorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
