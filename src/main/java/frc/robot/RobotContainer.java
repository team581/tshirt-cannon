// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.FireCommand;
import frc.robot.subsystems.CannonSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import frc.robot.subsystems.PlungerSubsystem;
import frc.robot.util.ControllerUtil;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public final class RobotContainer {
  private final CannonSubsystem cannonSubsystem = new CannonSubsystem();

  private final MotorSubsystem motorSubsystem = new MotorSubsystem();

  private final PlungerSubsystem plungerSubsystem = new PlungerSubsystem();

  private final XboxController controller = new XboxController(Constants.CONTROLLER_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  public Command getAutonomousCommand() {
    return null;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final var aButton = new JoystickButton(controller, XboxController.Button.kA.value);
    final var bButton = new JoystickButton(controller, XboxController.Button.kB.value);

    aButton.whenPressed(new FireCommand(plungerSubsystem, cannonSubsystem));
    bButton.toggleWhenPressed(new InstantCommand(plungerSubsystem::toggle, plungerSubsystem));
  }

  public void teleopDrive() {
    final var leftY = -controller.getY(Hand.kLeft);
    final var leftSpeed = ControllerUtil.joystickScale(leftY);

    final var rightY = controller.getY(Hand.kRight);
    final var rightSpeed = ControllerUtil.joystickScale(rightY);

    motorSubsystem.tankDrive(leftSpeed, rightSpeed);
  }
}
