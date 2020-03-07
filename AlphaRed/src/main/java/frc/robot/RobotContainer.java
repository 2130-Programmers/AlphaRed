/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.ClimbingSubsystem;
import frc.robot.subsystems.ControlPanelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.SensorsSubsystem;
import frc.robot.subsystems.SwerveDriveSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SwerveDriveSubsystem swerveDriveSubsystem = new SwerveDriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
  private final ClimbingSubsystem climbingSubsystem = new ClimbingSubsystem();
  private final ControlPanelSubsystem controlPanelSubsystem = new ControlPanelSubsystem();
  public static final SensorsSubsystem sensorsSubsystem = new SensorsSubsystem();

  private final DriveTrainCommand driveTrainCommand = new DriveTrainCommand();

  private final Joystick driverJoystick = new Joystick(0);
  private final JoystickButton driverButtonA = new JoystickButton(driverJoystick, Constants.driverButtonA);
  private final JoystickButton driverButtonB = new JoystickButton(driverJoystick, Constants.driverButtonB);
  private final JoystickButton driverButtonX = new JoystickButton(driverJoystick, Constants.driverButtonX);
  private final JoystickButton driverButtonY = new JoystickButton(driverJoystick, Constants.driverButtonY);
  private final JoystickButton driverButtonLB = new JoystickButton(driverJoystick, Constants.driverButtonLB);
  private final JoystickButton driverButtonRB = new JoystickButton(driverJoystick, Constants.driverButtonRB);
  private final JoystickButton driverButtonBack = new JoystickButton(driverJoystick, Constants.driverButtonBack);
  private final JoystickButton driverButtonStart = new JoystickButton(driverJoystick, Constants.driverButtonStart);
  private final JoystickButton driverButtonLeftJoyClick = new JoystickButton(driverJoystick, Constants.driverButtonLeftJoyClick);
  private final JoystickButton driverButtonRightJoyClick = new JoystickButton(driverJoystick, Constants.driverButtonRightJoyClick);

  private final Joystick operatorJoystick = new Joystick(1);
  private final static JoystickButton operatorButtonA = new JoystickButton(operatorJoystick, Constants.operatorButtonA);
  private final JoystickButton operatorButtonB = new JoystickButton(operatorJoystick, Constants.operatorButtonB);
  private final JoystickButton operatorButtonX = new JoystickButton(operatorJoystick, Constants.operatorButtonX);
  private final JoystickButton operatorButtonY = new JoystickButton(operatorJoystick, Constants.operatorButtonY);
  private final JoystickButton operatorButtonLB = new JoystickButton(operatorJoystick, Constants.operatorButtonLB);
  private final JoystickButton operatorButtonRB = new JoystickButton(operatorJoystick, Constants.operatorButtonRB);
  private final JoystickButton operatorButtonBack = new JoystickButton(operatorJoystick, Constants.operatorButtonBack);
  private final JoystickButton operatorButtonStart = new JoystickButton(operatorJoystick,
      Constants.operatorButtonStart);
  private final JoystickButton operatorButtonLeftJoyClick = new JoystickButton(operatorJoystick,
      Constants.operatorButtonLeftJoyClick);
  private final JoystickButton operatorButtonRightJoyClick = new JoystickButton(operatorJoystick,
      Constants.operatorButtonRightJoyClick);
  // TODO: make a port

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
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

  public static double getDriverAxis(int axis) {
    if (axis == 1 || axis == 5) {
      return -driverJoystick.getRawAxis(axis);
    } else {
      return driverJoystick.getRawAxis(axis);
    }
  }

  public static boolean handlerPositionValue() {
    return operatorButtonA.get();
}
}
