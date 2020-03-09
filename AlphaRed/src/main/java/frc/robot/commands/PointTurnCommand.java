/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveDrivePIDSubsystem;

public class PointTurnCommand extends CommandBase {

  private SwerveDrivePIDSubsystem swerveDrivePIDSubsystem;

  /**
   * Creates a new PointTurnLeftCommand.
   */
  public PointTurnCommand(SwerveDrivePIDSubsystem swerveDrivePIDSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.swerveDrivePIDSubsystem = swerveDrivePIDSubsystem;

    addRequirements(this.swerveDrivePIDSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    swerveDrivePIDSubsystem.moveSwervePointTurn(RobotContainer.getDriverAxis(Constants.driverLeftAxisTrigger),
                                                RobotContainer.getDriverAxis(Constants.driverRightAxisTrigger));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
