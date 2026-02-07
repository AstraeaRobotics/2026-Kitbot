// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shoot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeShootSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class SpinUp extends Command {
  /** Creates a new SpinUp. */

  IntakeShootSubsystem m_IntakeShootSubsystem;
  double m_launcherVoltage;
  double m_spinFeederVoltage;

  public SpinUp(IntakeShootSubsystem m_IntakeShootSubsystem, double m_launcherVoltage, double m_spinFeederVoltage) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_IntakeShootSubsystem = m_IntakeShootSubsystem;
    this.m_launcherVoltage = m_launcherVoltage;
    this.m_spinFeederVoltage = m_spinFeederVoltage;

    addRequirements(m_IntakeShootSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_IntakeShootSubsystem.setIntakeLauncherRoller(m_launcherVoltage);
    m_IntakeShootSubsystem.setFeederRoller(m_spinFeederVoltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
