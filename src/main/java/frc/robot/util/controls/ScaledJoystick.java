package frc.robot.util.controls;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.OI;

public final class ScaledJoystick extends Joystick {
  public ScaledJoystick(int port) {
    super(port);
  }

  /**
   * Get the scaled x position of the HID.
   *
   * @return the scaled x position of the HID
   */
  public final double getScaledX() {
    return OI.scale(super.getX());
  }

  /**
   * Get the scaled y position of the HID.
   *
   * @return the scaled y position of the HID
   */
  public final double getScaledY() {
    return OI.scale(super.getY());
  }

  /**
   * Get the scaled z position of the HID.
   *
   * @return the scaled z position of the HID
   */
  public final double getScaledZ() {
    return OI.scale(super.getZ());
  }

  /**
   * Get the scaled value of the axis.
   *
   * @param axis the axis to read, starting at 0
   * @return the scaled value of the axis
   */
  public final double getScaledAxis(int axis) {
    return OI.scale(super.getRawAxis(axis));
  }
}
