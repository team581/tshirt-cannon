// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.PlungerSubsystem;

public class FireCommand extends SequentialCommandGroup {

  public FireCommand() {
    addCommands(
        // Close plunger
        new InstantCommand(RobotContainer.plungerSubsystem::close, RobotContainer.plungerSubsystem),
        new WaitCommand(PlungerSubsystem.TOGGLE_DURATION_SECONDS),
        // Fire t-shirt
        new InstantCommand(
            RobotContainer.cannonSubsystem::activate, RobotContainer.cannonSubsystem),
        new WaitCommand(CannonSubsystem.FIRE_DURATION_SECONDS),
        new InstantCommand(
            RobotContainer.cannonSubsystem::deactivate, RobotContainer.cannonSubsystem),
        // Open plunger
        new InstantCommand(RobotContainer.plungerSubsystem::open, RobotContainer.plungerSubsystem),
        new WaitCommand(PlungerSubsystem.TOGGLE_DURATION_SECONDS));
  }
}
