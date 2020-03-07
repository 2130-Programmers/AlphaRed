/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.SparkMax;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

public class LauncherSubsystem extends SubsystemBase {
  /**
   * Creates a new LauncherSubsystem.
   */
  private SparkMax launcherMotorMaster;
  private SparkMax launcherMotorSlave;
  private TalonSRX aimingMotor;

  private Solenoid launcherSol;

  public LauncherSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
