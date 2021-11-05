// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class FireCommand extends SequentialCommandGroup {

  public FireCommand() {
    addCommands(
      // close the plunger
      new SetPlungerCommand(DoubleSolenoid.Value.kForward),
      new WaitCommand(0.5),
      // fire t-shirt
      new LaunchFiringMechanismCommand(),
      // open the plunger
      new SetPlungerCommand(DoubleSolenoid.Value.kReverse)
    );
  }
}
