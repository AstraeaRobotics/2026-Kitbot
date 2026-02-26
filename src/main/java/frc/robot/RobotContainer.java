// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.IntakeShootConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.LaunchSequence;
import frc.robot.commands.drive.Drive;
import frc.robot.commands.intake.IntakeFuel;
import frc.robot.commands.intake.PoopFuel;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeShootSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  private final IntakeShootSubsystem m_IntakeShootSubsystem = new IntakeShootSubsystem();


  // private final PS4Controller m_Controller = new PS4Controller(0);

  private final XboxController m_driverController = new XboxController(0);
  JoystickButton leftBumper = new JoystickButton(m_driverController, XboxController.Button.kLeftBumper.value);
  JoystickButton rightBumper = new JoystickButton(m_driverController, XboxController.Button.kRightBumper.value);
  JoystickButton aButton = new JoystickButton(m_driverController, XboxController.Button.kA.value);
  JoystickButton xButton = new JoystickButton(m_driverController, XboxController.Button.kX.value);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
      leftBumper.whileTrue(new IntakeFuel(m_IntakeShootSubsystem, IntakeShootConstants.kIntakingIntakeVoltage, IntakeShootConstants.kIntakingFeederVoltage));

      rightBumper.whileTrue(new LaunchSequence(m_IntakeShootSubsystem)); 

      aButton.whileTrue(new PoopFuel(m_IntakeShootSubsystem, IntakeShootConstants.kIntakingIntakeVoltage, IntakeShootConstants.kIntakingFeederVoltage));
      xButton.whileTrue(m_IntakeShootSubsystem.spinMotor(-5));

    m_DriveSubsystem.setDefaultCommand(
      new Drive(m_DriveSubsystem, 
        () -> m_driverController.getLeftY() * OperatorConstants.kDriveScale,
        () -> m_driverController.getRightX() * OperatorConstants.kRotationScale
      )
    );

    m_IntakeShootSubsystem.setDefaultCommand(
      m_IntakeShootSubsystem.run(m_IntakeShootSubsystem::stop)
    );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
