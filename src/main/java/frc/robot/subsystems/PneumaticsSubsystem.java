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
import frc.robot.util.ShuffleboardUtil;
import java.util.Map;

/**
 * Pneumatics subsystem.
 * Handles compressed air, mainly just solenoids.
 */
public class PneumaticsSubsystem extends Subsystem {
  private final NetworkTableEntry sirenLightIndicator = ShuffleboardUtil
    .tab.add("Siren light", false)
    .withSize(1, 1)
    .withPosition(9, 0)
    .withWidget(BuiltInWidgets.kBooleanBox)
    .withProperties(Map.of("color when true", "#ff8040", "color when false", "#121212"))
    .getEntry();

  /** The firing mechanism double solenoid. */
  public final DoubleSolenoid firingMechanism = new DoubleSolenoid(
    RobotMap.firingMechanism.forward,
    RobotMap.firingMechanism.reverse
  );

  /** The double solenoid that controls the plunger used to load t-shirts. */
  public final DoubleSolenoid plunger = new DoubleSolenoid(RobotMap.plunger.forward, RobotMap.plunger.reverse);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
    /** Current value of the plunger double solenoid. */
    final DoubleSolenoid.Value plungerValue = this.plunger.get();

    if (plungerValue == DoubleSolenoid.Value.kForward) {
      Robot.relaySubsystem.siren.set(Relay.Value.kOn);

      this.sirenLightIndicator.setBoolean(true);
    } else {
      this.sirenLightIndicator.setBoolean(false);

      Robot.relaySubsystem.siren.set(Relay.Value.kOff);
    }

    // Turn on the siren when the plunger is sealed
    Robot.relaySubsystem.siren.set(plungerValue == DoubleSolenoid.Value.kForward ? Relay.Value.kOn : Relay.Value.kOff);
  }
}
