/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotContainer;

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

  
  public double joyVal;
  public double joyValPrev;
  public double finalSpeed;

  public LauncherSubsystem() {
    launcherMotorMaster = new CANSparkMax(13, MotorType.kBrushless);
    launcherMotorSlave = new CANSparkMax(14, MotorType.kBrushless);

    joyValPrev = 0;
    finalSpeed = 0;

    setMasterMotor();
  }

  @Override
  public void periodic() {
    joyVal = RobotContainer.getDriverAxis(2);
    setMaster();
    // This method will be called once per scheduler run
  }

  public void setMaster(){
    launcherMotorSlave.follow(launcherMotorMaster);
  }

  public void MotorStop() {
    //setting speed for sparkMax motor controllers -cory
    launcherMotorMaster.set(0);
  }

  public final void finalSpeedReset() {
    finalSpeed = 0;
  }

  public void motorRun() {
    //getting input from left trigger using getdriveraxis method and check value -cory
    if (RobotContainer.getDriverAxis(2) > .01) {
      //setting speed for sparkMax motor controllers -cory
      launcherMotorMaster.set(finalSpeed);
    } else {
      MotorStop();
    }
  }

  public void setMasterMotor() {
    launcherMotorSlave.follow(launcherMotorMaster);
  }

}
