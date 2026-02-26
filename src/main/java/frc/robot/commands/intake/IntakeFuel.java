// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeShootSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeFuel extends Command {
  /** Creates a new IntakeFuel. */

  IntakeShootSubsystem m_intakeShootSubsystem;
  double m_intakeVoltage;
  double m_feederVoltage;

  public IntakeFuel(IntakeShootSubsystem m_intakeShootSubsystem, double m_intakeVoltage, double m_feederVoltage) {

    //System.out.println("Intake fuel method run!!");

    // Use addRequirements() here to declare subsystem dependencies.
    this.m_intakeShootSubsystem = m_intakeShootSubsystem;
    this.m_intakeVoltage = m_intakeVoltage;
    this.m_feederVoltage = m_feederVoltage;

    addRequirements(m_intakeShootSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakeShootSubsystem.setIntakeLauncherRoller(m_intakeVoltage);
    m_intakeShootSubsystem.setFeederRoller(m_feederVoltage);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeShootSubsystem.setIntakeLauncherRoller(0);
    m_intakeShootSubsystem.setFeederRoller(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
