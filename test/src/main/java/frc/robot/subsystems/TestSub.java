/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;

public class TestSub extends SubsystemBase {
  /**
   * Creates a new testSub.
   */
  private TalonSRX testMotor;
  private Solenoid testSol;
  public TestSub() {
    testMotor = new TalonSRX(1);
    testSol = new Solenoid(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    testMotor.setInverted(true);
  }

  public void testTheMotor() {
    testMotor.set(ControlMode.PercentOutput, RobotContainer.driverJoystick.getRawAxis(1));
  }

  public void testTheSolenoid() {
    testSol.set(true);
  }
  public void testTheSolenoidOpposite() {
    testSol.set(false);
  }
}
