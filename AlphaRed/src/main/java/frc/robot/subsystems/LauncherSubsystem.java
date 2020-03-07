/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class LauncherSubsystem extends SubsystemBase {
  /**
   * Creates a new LauncherSubsystem.
   */
  private CANSparkMax launcherMotorMaster;
  private CANSparkMax launcherMotorSlave;
  private TalonSRX aimingMotor;

  

  public LauncherSubsystem() {
    launcherMotorMaster = new CANSparkMax(13, MotorType.kBrushless);
    launcherMotorSlave = new CANSparkMax(14, MotorType.kBrushless);

    setMasterMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void setMasterMotor() {
    launcherMotorSlave.follow(launcherMotorMaster);
  }

}
