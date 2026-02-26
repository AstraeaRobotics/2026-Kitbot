// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeShootSubsystem extends SubsystemBase {
  /** Creates a new IntakeShootSubsystem. */

  private final SparkMax m_feederRoller;
  private final SparkMax m_intakeLauncherRoller;

  public IntakeShootSubsystem() {
    //TODO fix
    m_feederRoller = new SparkMax(4, MotorType.kBrushed);
    m_intakeLauncherRoller = new SparkMax(17, MotorType.kBrushed);

    configureMotors();
  }

  public void configureMotors() {
    SparkMaxConfig m_feederConfig = new SparkMaxConfig();
    m_feederConfig.smartCurrentLimit(20); 

    m_feederRoller.configure(m_feederConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
 
    SparkMaxConfig m_launcherConfig = new SparkMaxConfig();
    m_launcherConfig.inverted(true);
    m_launcherConfig.smartCurrentLimit(20); 
    m_intakeLauncherRoller.configure(m_launcherConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  } 

  public void setIntakeLauncherRoller(double voltage) { 
    m_intakeLauncherRoller.setVoltage(voltage);
    System.out.println("Voltage: " + voltage);
    System.out.println("Applied Output: " + m_intakeLauncherRoller.getAppliedOutput());
  }

  public void setFeederRoller(double voltage) {
    m_feederRoller.setVoltage(voltage);
  }

  public StartEndCommand spinMotor(double voltage){
    return new StartEndCommand(() -> setFeederRoller(voltage), () -> stop(), this);
  }

  public void stop() {
    m_feederRoller.set(0);
    m_intakeLauncherRoller.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
