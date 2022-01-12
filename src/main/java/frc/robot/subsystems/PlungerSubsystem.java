// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PlungerSubsystem extends SubsystemBase {

  public static final double TOGGLE_DURATION_SECONDS = 0.5;

  private static final class Constants {

    public static final int FORWARD_CHANNEL = 2;
    public static final int REVERSE_CHANNEL = 3;

    public static final DoubleSolenoid.Value OPENED_VALUE = DoubleSolenoid.Value.kReverse;
    public static final DoubleSolenoid.Value CLOSED_VALUE = DoubleSolenoid.Value.kForward;
  }

  private final DoubleSolenoid solenoid =
      new DoubleSolenoid(Constants.FORWARD_CHANNEL, Constants.REVERSE_CHANNEL);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void open() {
    solenoid.set(Constants.OPENED_VALUE);
  }

  public void close() {
    solenoid.set(Constants.CLOSED_VALUE);
  }

  public void toggle() {
    if (solenoid.get() == Constants.OPENED_VALUE) {
      close();
    } else {
      open();
    }
  }
}
