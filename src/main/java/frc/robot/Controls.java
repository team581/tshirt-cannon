// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.FireCommand;
import frc.robot.commands.TogglePlungerCommand;

/** Add your docs here. */
public class Controls {

  public static final Joystick driveJoystick = new Joystick(Constants.CONTROLLER_PORT);

  private final JoystickButton aButton = new JoystickButton(driveJoystick, XboxController.Button.kA.value);
  private final JoystickButton bButton = new JoystickButton(driveJoystick, XboxController.Button.kB.value);

  public Controls() {
    this.aButton.whenPressed(new FireCommand());
    this.bButton.toggleWhenPressed(new TogglePlungerCommand());
  }
}
