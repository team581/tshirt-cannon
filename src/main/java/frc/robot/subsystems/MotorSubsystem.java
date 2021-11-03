// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.MotorConstants;

public class MotorSubsystem extends SubsystemBase {
  public final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(MotorConstants.FRONT_RIGHT);
  public final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(MotorConstants.FRONT_LEFT);
  public final WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(MotorConstants.REAR_RIGHT);
  public final WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(MotorConstants.REAR_LEFT);

  public final MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor,
      rearRightMotor);


  /** Creates a new Motors. */
  public MotorSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

