/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.macros;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.commands.pneumatics.MoveDoubleSolenoid;
import frc.robot.Robot;

public class Fire extends CommandGroup {

  /**
   * Fire a t-shirt.
   */
  public Fire() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.
    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
    // Seal firing chamber
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.plunger, Value.kForward));

    // Fire T-shirt
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.firingMechanism, Value.kForward));

    // Wait a bit
    addSequential(new WaitCommand(1));

    // Stop releasing air
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.firingMechanism, Value.kReverse));

    // Open chamber again
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.plunger, Value.kReverse));

    // Eject the shell
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.ejector, Value.kForward));

    // Wait a bit
    addSequential(new WaitCommand(1));

    // Pull ejector back in
    addSequential(new MoveDoubleSolenoid(Robot.pneumaticsSubsystem.ejector, Value.kReverse));
  }
}
