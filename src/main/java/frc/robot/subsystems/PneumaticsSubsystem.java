/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.util.Colors;
import frc.robot.util.ShuffleboardUtil;
import java.util.Map;

/**
 * Pneumatics subsystem.
 * Handles compressed air, mainly just solenoids.
 */
public class PneumaticsSubsystem extends Subsystem {
  private NetworkTableEntry solenoidIndicator = ShuffleboardUtil
    .tab.add("Firing mechanism solenoid value", false)
    .withSize(1, 1)
    .withPosition(2, 3)
    .withWidget(BuiltInWidgets.kBooleanBox)
    .withProperties(Map.of("color when true", Colors.GREEN, "color when false", Colors.RED))
    .getEntry();

  /** The firing mechanism double solenoid. */
  public final DoubleSolenoid firingMechanism = new DoubleSolenoid(
    RobotMap.firingMechanism.forward,
    RobotMap.firingMechanism.reverse
  );

  /** The double solenoid that controls the plunger used to load t-shirts. */
  public final DoubleSolenoid plunger = new DoubleSolenoid(RobotMap.plunger.forward, RobotMap.plunger.reverse);

  /** The double solenoid that controls the shell ejector. */
  public final DoubleSolenoid ejector = new DoubleSolenoid(RobotMap.ejector.forward, RobotMap.ejector.reverse);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    // Log solenoid status to Shuffleboard.
    this.solenoidIndicator.setBoolean(firingMechanism.get() == DoubleSolenoid.Value.kForward);

    // Turn on the siren when the plunger is sealed
    Robot.relaySubsystem.siren.set(
      this.plunger.get() == DoubleSolenoid.Value.kForward ? Relay.Value.kOn : Relay.Value.kOff
    );
  }
}
