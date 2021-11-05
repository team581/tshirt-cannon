// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public final class CannonSubsystem extends SubsystemBase {

  public static final double FIRE_DURATION_SECONDS = 0.5;

  private static final class Constants {

    public static final int FORWARD_CHANNEL = 0;
    public static final int REVERSE_CHANNEL = 1;
  }

  private final DoubleSolenoid solenoid = new DoubleSolenoid(Constants.FORWARD_CHANNEL, Constants.REVERSE_CHANNEL);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void activate() {
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void deactivate() {
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
