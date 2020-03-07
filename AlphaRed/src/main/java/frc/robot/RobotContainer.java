/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.beans.Beans;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.ClimbingSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LauncherSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
  private final ClimbingSubsystem climbingSubsystem = new ClimbingSubsystem();
  private final ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();


  private final DriveTrainCommand driveTrainCommand = new DriveTrainCommand();

  private final Joystick driverJoystick = new Joystick(0);
  private final JoystickButton driverButtonA = new JoystickButton(driverJoystick, 1);
  private final JoystickButton driverButtonB = new JoystickButton(driverJoystick, 2);
  private final JoystickButton driverButtonX = new JoystickButton(driverJoystick, 3);
  private final JoystickButton driverButtonY = new JoystickButton(driverJoystick, 4);
  private final JoystickButton driverButtonLB = new JoystickButton(driverJoystick, 5);
  private final JoystickButton driverButtonRB = new JoystickButton(driverJoystick, 6);
  private final JoystickButton driverButtonBack = new JoystickButton(driverJoystick, 7);
  private final JoystickButton driverButtonStart = new JoystickButton(driverJoystick, 8);
  private final JoystickButton driverButtonLeftJoyClick = new JoystickButton(driverJoystick, 9);
  private final JoystickButton driverButtonRightJoyClick = new JoystickButton(driverJoystick, 10);

  private final Joystick operatorJoystick = new Joystick(1);
  private final JoystickButton operatorButtonA = new JoystickButton(operatorJoystick, 1);
  private final JoystickButton operatorButtonB = new JoystickButton(operatorJoystick, 2);
  private final JoystickButton operatorButtonX = new JoystickButton(operatorJoystick, 3);
  private final JoystickButton operatorButtonY = new JoystickButton(operatorJoystick, 4);
  private final JoystickButton operatorButtonLB = new JoystickButton(operatorJoystick, 5);
  private final JoystickButton operatorButtonRB = new JoystickButton(operatorJoystick, 6);
  private final JoystickButton operatorButtonBack = new JoystickButton(operatorJoystick, 7);
  private final JoystickButton operatorButtonStart = new JoystickButton(operatorJoystick, 8);
  private final JoystickButton operatorButtonLeftJoyClick = new JoystickButton(operatorJoystick, 9);
  private final JoystickButton operatorButtonRightJoyClick = new JoystickButton(operatorJoystick, 10);
//TODO: make a port

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
