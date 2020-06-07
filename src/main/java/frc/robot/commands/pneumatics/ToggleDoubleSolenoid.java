/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class ToggleDoubleSolenoid extends InstantCommand {
  /** The double solenoid to toggle. */
  private DoubleSolenoid targetSolenoid;

  /**
   * Toggle a double solenoid's value.
   * @param solenoid The solenoid that should be moved
   */
  public ToggleDoubleSolenoid(DoubleSolenoid solenoid) {
    super();
    requires(Robot.pneumaticsSubsystem);

    this.targetSolenoid = solenoid;
  }

  @Override
  protected void initialize() {
    // This will set the value to forward if the value is reverse of off (the default value)
    this.targetSolenoid.set(this.targetSolenoid.get() == Value.kForward ? Value.kReverse : Value.kForward);
  }
}
