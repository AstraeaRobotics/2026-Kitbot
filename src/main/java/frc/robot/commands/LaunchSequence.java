// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.IntakeShootConstants;
import frc.robot.commands.shoot.ShootFuel;
import frc.robot.commands.shoot.SpinUp;
import frc.robot.subsystems.IntakeShootSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LaunchSequence extends SequentialCommandGroup {
  /** Creates a new LaunchSequence. */
  public LaunchSequence(IntakeShootSubsystem m_IntakeShootSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new SpinUp(m_IntakeShootSubsystem, IntakeShootConstants.kLaunchingLauncherVoltage, IntakeShootConstants.kSpinUpVoltage).withTimeout(IntakeShootConstants.kSpinUpTime),
      new ShootFuel(m_IntakeShootSubsystem, IntakeShootConstants.kLaunchingLauncherVoltage, IntakeShootConstants.kLaunchingFeederVoltage)
    );
  }
}
