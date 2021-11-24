// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {

  private static final class Constants {

    public static final int FRONT_LEFT = 2;
    public static final int FRONT_RIGHT = 1;
    public static final int REAR_LEFT = 4;
    public static final int REAR_RIGHT = 3;
  }

  public final Spark frontRightMotor = new Spark(Constants.FRONT_LEFT);
  public final Spark frontLeftMotor = new Spark(Constants.FRONT_RIGHT);
  public final Spark rearRightMotor = new Spark(Constants.REAR_LEFT);
  public final Spark rearLeftMotor = new Spark(Constants.REAR_RIGHT);

  private final SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
  private final SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);

  public final DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
