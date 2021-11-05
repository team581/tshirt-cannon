// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class LaunchFiringMechanismCommand extends SequentialCommandGroup {

  public LaunchFiringMechanismCommand() {
    addCommands(
      // fire the t-shirt
      new SetFiringMechanismCommand(DoubleSolenoid.Value.kForward),
      // Wait for the air to release
      new WaitCommand(0.5),
      // Stop releasing air
      new SetFiringMechanismCommand(DoubleSolenoid.Value.kReverse)
    );
  }
}
