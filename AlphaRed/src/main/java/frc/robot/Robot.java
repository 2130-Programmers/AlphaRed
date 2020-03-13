/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    SmartDashboard.putNumber("FL Encoder", RobotContainer.swerveDrivePIDSubsystem.motorFL.encoderValue());
    SmartDashboard.putNumber("FR Encoder", RobotContainer.swerveDrivePIDSubsystem.motorFR.encoderValue());
    SmartDashboard.putNumber("RL Encoder", RobotContainer.swerveDrivePIDSubsystem.motorRL.encoderValue());
    SmartDashboard.putNumber("RR Encoder", RobotContainer.swerveDrivePIDSubsystem.motorRR.encoderValue());

    SmartDashboard.putNumber("FL Remaining", RobotContainer.swerveDrivePIDSubsystem.motorFL.encoderRemainingValue);
    SmartDashboard.putNumber("FR Remaining", RobotContainer.swerveDrivePIDSubsystem.motorFR.encoderRemainingValue);
    SmartDashboard.putNumber("RL Remaining", RobotContainer.swerveDrivePIDSubsystem.motorRL.encoderRemainingValue);
    SmartDashboard.putNumber("RR Remaining", RobotContainer.swerveDrivePIDSubsystem.motorRR.encoderRemainingValue);

    SmartDashboard.putNumber("FL Target", RobotContainer.swerveDrivePIDSubsystem.motorFL.directionTarget);
    SmartDashboard.putNumber("FR Target", RobotContainer.swerveDrivePIDSubsystem.motorFR.directionTarget);
    SmartDashboard.putNumber("RL Target", RobotContainer.swerveDrivePIDSubsystem.motorRL.directionTarget);
    SmartDashboard.putNumber("RR Target", RobotContainer.swerveDrivePIDSubsystem.motorRR.directionTarget);

    SmartDashboard.putBoolean("FL Prox", RobotContainer.swerveDrivePIDSubsystem.motorFL.proxValue());
    SmartDashboard.putBoolean("FR Prox", RobotContainer.swerveDrivePIDSubsystem.motorFR.proxValue());
    SmartDashboard.putBoolean("RL Prox", RobotContainer.swerveDrivePIDSubsystem.motorRL.proxValue());
    SmartDashboard.putBoolean("RR Prox", RobotContainer.swerveDrivePIDSubsystem.motorRR.proxValue());
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

    RobotContainer.swerveDrivePIDSubsystem.findAllZeros();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    RobotContainer.swerveDrivePIDSubsystem.findAllZeros();

    RobotContainer.climbingSubsystem.putClimberDown();
  }

  /**
   * 
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    SmartDashboard.putNumber("FL Encoder", RobotContainer.swerveDrivePIDSubsystem.motorFL.encoderValue());
    SmartDashboard.putNumber("FR Encoder", RobotContainer.swerveDrivePIDSubsystem.motorFR.encoderValue());
    SmartDashboard.putNumber("RL Encoder", RobotContainer.swerveDrivePIDSubsystem.motorRL.encoderValue());
    SmartDashboard.putNumber("RR Encoder", RobotContainer.swerveDrivePIDSubsystem.motorRR.encoderValue());

    SmartDashboard.putNumber("FL Remaining", RobotContainer.swerveDrivePIDSubsystem.motorFL.encoderRemainingValue);
    SmartDashboard.putNumber("FR Remaining", RobotContainer.swerveDrivePIDSubsystem.motorFR.encoderRemainingValue);
    SmartDashboard.putNumber("RL Remaining", RobotContainer.swerveDrivePIDSubsystem.motorRL.encoderRemainingValue);
    SmartDashboard.putNumber("RR Remaining", RobotContainer.swerveDrivePIDSubsystem.motorRR.encoderRemainingValue);

    SmartDashboard.putNumber("FL Target", RobotContainer.swerveDrivePIDSubsystem.motorFL.directionTarget);
    SmartDashboard.putNumber("FR Target", RobotContainer.swerveDrivePIDSubsystem.motorFR.directionTarget);
    SmartDashboard.putNumber("RL Target", RobotContainer.swerveDrivePIDSubsystem.motorRL.directionTarget);
    SmartDashboard.putNumber("RR Target", RobotContainer.swerveDrivePIDSubsystem.motorRR.directionTarget);

    SmartDashboard.putBoolean("FL Prox", RobotContainer.swerveDrivePIDSubsystem.motorFL.proxValue());
    SmartDashboard.putBoolean("FR Prox", RobotContainer.swerveDrivePIDSubsystem.motorFR.proxValue());
    SmartDashboard.putBoolean("RL Prox", RobotContainer.swerveDrivePIDSubsystem.motorRL.proxValue());
    SmartDashboard.putBoolean("RR Prox", RobotContainer.swerveDrivePIDSubsystem.motorRR.proxValue());

    SmartDashboard.putNumber("X Value", RobotContainer.getDriverAxis(0));
    SmartDashboard.putNumber("Y Value", RobotContainer.getDriverAxis(1));

    SmartDashboard.putNumber("Limelight X", RobotContainer.sensorsSubsystem.x);
    SmartDashboard.putNumber("Limelight Y", RobotContainer.sensorsSubsystem.y);
    SmartDashboard.putNumber("LimelightArea", RobotContainer.sensorsSubsystem.area);

    RobotContainer.swerveDrivePIDSubsystem.invertTheMotors();
    RobotContainer.swerveDrivePIDSubsystem.zeroAllEncodersBasedOnProx();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
