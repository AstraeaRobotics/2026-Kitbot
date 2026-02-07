// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Drive extends Command {
  /** Creates a new Drive. */

  DriveSubsystem m_driveSubsystem;
  DoubleSupplier m_forwardSpeed;
  DoubleSupplier m_rotationSpeed;

  public Drive(DriveSubsystem m_driveSubsystem, DoubleSupplier m_forwardSpeed, DoubleSupplier m_rotationSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_driveSubsystem = m_driveSubsystem;
    this.m_forwardSpeed = m_forwardSpeed;
    this.m_rotationSpeed = m_rotationSpeed;

    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSubsystem.arcadeDrive(m_forwardSpeed.getAsDouble(), m_rotationSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
