// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final double kDriveScale = 0.7;
    public static final double kRotationScale = 0.8;
  }

  public static final class DriveConstants {
    public static final int kLeftLeader_CANID = 1;
    public static final int kLeftFollower_CANID = 2;
    public static final int kRightLeader_CANID = 3;
    public static final int kRightFollower_CANID = 4;
  }

  public static final class IntakeShootConstants {
    public static final int kFeeder_CANID = 0;
    public static final int kIntakeLauncher_CANID = 0;

    public static final int kFeederCurrentLimit = 60;
    public static final int kIntakeLaunchCurrentLimit = 60;

    public static final double kIntakingFeederVoltage = -12;
    public static final double kIntakingIntakeVoltage = 10;
    public static final double kLaunchingFeederVoltage = 9;
    public static final double kLaunchingLauncherVoltage = 10.6;
    public static final double kSpinUpVoltage = -6;
    public static final double kSpinUpTime = 1;
  }
}
