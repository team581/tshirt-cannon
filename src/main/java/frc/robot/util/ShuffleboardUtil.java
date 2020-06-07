package frc.robot.util;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/// Visualization of the Shuffleboard layout         \\\
/// Please update this when the layout changes       \\\
/// This is a 10x6 grid, upper left corner is (0, 0) \\\
/// Dimensions can change depending on screen size   \\\
//  0123456789
// +----------+
// |JJDDDD   L|
// |JJDDDD    |
// |xxDDDD    |
// |yy        |
// |          |
// +----------+
// Key:
// J: Joystick output graph
// D: Differential drive train diagram (see {@link MotorSubsystem} for reference)
// x: Joystick X number bar
// y: Joystick y number bar
// L: Siren light enabled
public final class ShuffleboardUtil {
  /** Current time used to help distinguish the name of the Shuffleboard tab. */
  private static final String currentTime = DateTimeFormatter
    .ofPattern("hh:mm:ss")
    .format(ZonedDateTime.now())
    .toString();

  /** String used to identify this Shuffleboard tab from duplicates. */
  private static final String tabDistinguisher = Config.id + " " + currentTime;

  /** Shuffleboard tab used for logging. */
  public static final ShuffleboardTab tab = Shuffleboard.getTab(tabDistinguisher);

  private final NetworkTableEntry joystickData = tab
    .add("Joystick Output", new double[] { 0, 0 })
    .withPosition(0, 0)
    .withSize(2, 2)
    .withWidget(BuiltInWidgets.kGraph)
    .getEntry();

  private final NetworkTableEntry joyX = tab
    .add("Joystick X", 0)
    .withPosition(0, 2)
    .withSize(2, 1)
    .withWidget(BuiltInWidgets.kNumberBar)
    .getEntry();
  private final NetworkTableEntry joyY = tab
    .add("Joystick Y", 0)
    .withPosition(0, 3)
    .withSize(2, 1)
    .withWidget(BuiltInWidgets.kNumberBar)
    .getEntry();

  /**
   * Log joystick values using a graph and number bars on Shuffleboard.
   *
   * @param x X-axis value to log
   * @param y Y-axis value to log
   */
  public final void logJoystickValues(double x, double y) {
    double[] joystickValues = new double[] { x, y };

    this.joystickData.setDoubleArray(joystickValues);

    this.joyX.setDouble(x);
    this.joyY.setDouble(y);
  }
}
