/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */

  private TalonSRX intakeMotor;

  private DoubleSolenoid intakeSol;
  
  public IntakeSubsystem() {

    intakeMotor = new TalonSRX(10);

    intakeSol = new DoubleSolenoid(1, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runIntake() {
    intakeMotor.set(ControlMode.PercentOutput, 1);
  }
  public void putIntakeUp() {
    intakeSol.set(Value.kForward);
  }
  public void putIntakeDown() {
    intakeSol.set(Value.kReverse);
  }
  public void putIntakeNeutral() {
    intakeSol.set(Value.kOff);
  }
}
