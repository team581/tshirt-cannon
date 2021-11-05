// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.PneumaticsConstants;

public class PneumaticsSubsystem extends SubsystemBase {

  public final DoubleSolenoid plunger = new DoubleSolenoid(PneumaticsConstants.firingMechanismForward, PneumaticsConstants.firingMechanismReverse);
  public final DoubleSolenoid firingMechanism = new DoubleSolenoid(PneumaticsConstants.firingMechanismForward, PneumaticsConstants.firingMechanismReverse);

  /** Creates a new PneumaticsSubsystem. */
  public PneumaticsSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
