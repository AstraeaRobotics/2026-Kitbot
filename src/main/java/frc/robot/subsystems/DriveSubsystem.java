// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private final SparkMax m_leftLeader;
  private final SparkMax m_leftFollower;
  private final SparkMax m_rightLeader;
  private final SparkMax m_rightFollower;

  private final DifferentialDrive m_drive;

  public DriveSubsystem() {
    m_leftLeader = new SparkMax(5, MotorType.kBrushed);
    m_leftFollower = new SparkMax(16, MotorType.kBrushed);
    m_rightLeader = new SparkMax(6, MotorType.kBrushed);
    m_rightFollower = new SparkMax(18, MotorType.kBrushed);

    m_drive = new DifferentialDrive(m_leftLeader, m_rightLeader);

    configureMotors();
  }

  public void configureMotors() {
    SparkMaxConfig m_config = new SparkMaxConfig();
    m_config.voltageCompensation(12);
    m_config.smartCurrentLimit(60); 

    m_config.follow(m_leftLeader);
    m_leftFollower.configure(m_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_config.follow(m_rightLeader);
    m_rightFollower.configure(m_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    m_config.disableFollowerMode();
    m_rightLeader.configure(m_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    m_config.inverted(true);
    m_leftLeader.configure(m_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    m_drive.arcadeDrive(xSpeed, zRotation);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
