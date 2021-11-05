// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public final class PneumaticsSubsystem extends SubsystemBase {

  private static final class Constants {

    public static final int firingMechanismForward = 0;
    public static final int firingMechanismReverse = 1;
    public static final int plungerForward = 2;
    public static final int plungerReverse = 3;
  }

  public final DoubleSolenoid plunger = new DoubleSolenoid(Constants.plungerForward, Constants.plungerReverse);
  public final DoubleSolenoid firingMechanism = new DoubleSolenoid(Constants.firingMechanismForward, Constants.firingMechanismReverse);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
