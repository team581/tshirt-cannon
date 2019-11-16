/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import frc.robot.RobotMap;
import frc.robot.util.Colors;
import frc.robot.util.ShuffleboardUtil;
import java.util.Map;

/**
 * Pneumatics subsystem.
 * Handles compressed air, mainly just solenoids.
 */
public class PneumaticsSubsystem extends Subsystem {

  public PneumaticsSubsystem() {
    ShuffleboardUtil
      .tab.add("Solenoid value", solenoid1.get() == Value.kForward)
      .withSize(1, 1)
      .withPosition(2, 3)
      .withWidget(BuiltInWidgets.kDifferentialDrive)
      .withProperties(Map.of("color when true", Colors.GREEN, "color when false", Colors.RED));
  }

  /** The solenoid. */
  public final DoubleSolenoid solenoid1 = new DoubleSolenoid(
    RobotMap.doubleSolenoidOneForwardChannel,
    RobotMap.doubleSolenoidOneReverseChannel
 );

    public final DoubleSolenoid solenoid2 = new DoubleSolenoid(
    RobotMap.doubleSolenoidTwoForwardChannel,
    RobotMap.doubleSolenoidTwoReverseChannel
  );

  public final DoubleSolenoid solenoid3 = new DoubleSolenoid(
    RobotMap.doubleSolenoidThreeForwardChannel,
    RobotMap.doubleSolenoidThreeReverseChannel
  );

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
  }
}
