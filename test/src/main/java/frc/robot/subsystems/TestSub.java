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

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class TestSub extends SubsystemBase {
  /**
   * Creates a new testSub.
   */
  private TalonSRX testMotor;
  private Solenoid testSol;
  private DigitalInput testProx1;
  private DigitalInput testProx2;
  private DigitalInput testProx3;
  private DigitalInput testProx4;
  private Encoder testEnc1;
  private Encoder testEnc2;
  private Encoder testEnc3;
  private Encoder testEnc4;
  private DoubleSolenoid testDoubieSol;
  public TestSub() {
    testMotor = new TalonSRX(8);
    //testSol = new Solenoid(1);
    testDoubieSol = new DoubleSolenoid(3, 4);

    testProx1 = new DigitalInput(0);
    testProx2 = new DigitalInput(1);
    testProx3 = new DigitalInput(2);
    testProx4 = new DigitalInput(3);

    testEnc1 = new Encoder(12,10);
    testEnc2 = new Encoder(14,13);
    testEnc3 = new Encoder(16,15);
    testEnc4 = new Encoder(18,17);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //testMotor.setInverted(true);
    testMotor.configPeakOutputForward(1);
    testMotor.configPeakOutputReverse(-1);
  }

  public void testTheMotor() {
    testMotor.set(ControlMode.PercentOutput, -RobotContainer.driverJoystick.getRawAxis(1));
  }

  public void testTheSolenoid() {
    //testSol.set(true);
    testDoubieSol.set(Value.kForward);
  }
  public void testTheSolenoidOpposite() {
    //testSol.set(false);
    testDoubieSol.set(Value.kReverse);
  }

  public boolean testtheProx(int prox) {
    switch(prox) {
      case 0: 
        return testProx1.get();
      case 1: 
        return testProx2.get();
      case 2:
        return testProx3.get();
      case 3:
        return testProx4.get();
      default:
        return false;

    }
  }

  public double testTheEncoders(int encoder) {
    switch(encoder) {
      case 0:
      return testEnc1.get();
      case 1:
      return testEnc2.get();
      case 2:
      return testEnc3.get();
      case 3:
      return testEnc4.get();
      default:
      return 0;
    }
  }
}
