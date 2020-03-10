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
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TestCom;
import frc.robot.commands.TestComSol;
import frc.robot.commands.TestComSolOpposite;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.TestSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static final TestSub testSub = new TestSub();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final TestCom testCom = new TestCom(testSub);
  private final TestComSol testComSol = new TestComSol(testSub);
  private final TestComSolOpposite testComSolOpposite = new TestComSolOpposite(testSub);

  public final static Joystick driverJoystick = new Joystick(0);
  public final static JoystickButton driverButtonA = new JoystickButton(driverJoystick, 1);
  public final static JoystickButton driverButtonB = new JoystickButton(driverJoystick, 2);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    testSub.setDefaultCommand(testCom);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driverButtonA.whenPressed(testComSol);
    driverButtonB.whenPressed(testComSolOpposite);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }

  public static double getAxis(int axis) {
    return driverJoystick.getRawAxis(axis);
  }
}
