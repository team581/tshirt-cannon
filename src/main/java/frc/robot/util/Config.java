package frc.robot.util;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Stores the configuration for the robot.
 */
public final class Config {
  /** The loader for getting environnment variables from the system or the `.env` file. */
  private static final Dotenv dotenv = Dotenv.load();

  /** ID of the robot. */
  public static final String id = dotenv.get("ROBOT_IDENTIFIER");
}
