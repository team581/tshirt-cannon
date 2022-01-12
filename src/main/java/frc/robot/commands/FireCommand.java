// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.PlungerSubsystem;

public class FireCommand extends SequentialCommandGroup {
  public FireCommand(PlungerSubsystem plungerSubsystem, CannonSubsystem cannonSubsystem) {
    addCommands(
        // Close plunger
        new InstantCommand(plungerSubsystem::close, plungerSubsystem),
        new WaitCommand(PlungerSubsystem.TOGGLE_DURATION_SECONDS),
        // Fire t-shirt
        new InstantCommand(cannonSubsystem::activate, cannonSubsystem),
        new WaitCommand(CannonSubsystem.FIRE_DURATION_SECONDS),
        new InstantCommand(cannonSubsystem::deactivate, cannonSubsystem),
        // Open plunger
        new InstantCommand(plungerSubsystem::open, plungerSubsystem),
        new WaitCommand(PlungerSubsystem.TOGGLE_DURATION_SECONDS));
  }
}
