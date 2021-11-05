// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

/**
 * Util functions for joysticks.
 */
public class ControllerUtil {

  private static final double DEAD_ZONE = 0.04f;
  private static final double FAST_THRESHOLD = 0.98f;
  private static final double DIVISOR = 3;
  private static final double MIN = 0.08f;

  private ControllerUtil() {}

  /**
   * Scale a joystick value.
   */
  public static double joystickScale(double x) {
    return Math.copySign(positiveJoystickScale(Math.abs(x)), x);
  }

  /**
   * Scales a joystick value that is a positive number.
   */
  private static double positiveJoystickScale(double x) {
    if (x < DEAD_ZONE) {
      // Deadzone for the highlight tape
      return 0;
    } else if (x < FAST_THRESHOLD) {
      // Regular usage
      return Math.max(x / DIVISOR, MIN);
    } else {
      // Go really fast if you are flooring the joystick
      return 1;
    }
  }
}
