// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public final class MotorSubsystem extends SubsystemBase {

  private static final class Constants {

    public static final int FRONT_LEFT = 3;
    public static final int FRONT_RIGHT = 1;
    public static final int REAR_LEFT = 2;
    public static final int REAR_RIGHT = 4;
  }

  // TODO: Swap the talons with sparks and swap mecanum with differential drive
  public final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(Constants.FRONT_LEFT);
  public final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(Constants.FRONT_RIGHT);
  public final WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(Constants.REAR_LEFT);
  public final WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(Constants.REAR_RIGHT);

  public final MecanumDrive mecanumDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
