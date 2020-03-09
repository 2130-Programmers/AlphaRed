/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.RobotContainer;

public class SwerveDrivePIDSubsystem extends PIDSubsystem {

  private TalonFX frontLeftDriveMotor;
  private TalonFX frontRightDriveMotor;
  private TalonFX rearLeftDriveMotor;
  private TalonFX rearRightDriveMotor;

  public Motor motorFL;
  public Motor motorFR;
  public Motor motorRL;
  public Motor motorRR;


  private double desiredSpeed;

  /**
   * Creates a new SwerveDrivePIDSubsystem.
   */
  public SwerveDrivePIDSubsystem() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.01, 0, 0));

    motorFL = new Motor(2, 12, 10, 0);
    motorFR = new Motor(4, 14, 13, 1);
    motorRL = new Motor(6, 16, 15, 2);
    motorRR = new Motor(8, 18, 17, 3);    
    
    frontLeftDriveMotor = new TalonFX(1);
    frontRightDriveMotor = new TalonFX(3);
    rearLeftDriveMotor = new TalonFX(5);
    rearRightDriveMotor = new TalonFX(7);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here

    moveSwervePointTurn(output);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return RobotContainer.sensorsSubsystem.x;
  }

  public void invertTheMotors() {
    frontLeftDriveMotor.setInverted(true);
    frontRightDriveMotor.setInverted(false);
    rearLeftDriveMotor.setInverted(true);
    rearRightDriveMotor.setInverted(false);
  }

  public void moveSwerveAxis(double leftX, double leftY, 
                             double rightX, double rightY, 
                             double leftT, double rightT) {
      leftSwerves(leftX, leftY); 

    if (Math.abs(leftX - rightX) < 0.15 && Math.abs(leftY + rightY) < 0.15) {
      rightSwerves(leftX, leftY);
    } else {
      rightSwerves(rightX, rightY);
    }

    desiredSpeed = findSpeed(leftT, rightT);

    moveDriveMotors(desiredSpeed);
  }

  public void moveSwerveStrafe(double leftT, double rightT) {
    motorFL.swerveDatBoi(1, 0);
    motorFR.swerveDatBoi(1, 0);
    motorRL.swerveDatBoi(1, 0);
    motorRR.swerveDatBoi(1, 0);

    double appliedSpeed = findSpeed(leftT, rightT);

    moveDriveMotors(appliedSpeed);
  }

  public void zeroAllEncoders() {
    motorFL.zeroEncoder();
    motorFR.zeroEncoder();
    motorRL.zeroEncoder();
    motorRR.zeroEncoder();
  }

  public void findAllZeros() {
    motorFL.findZero();
    motorFR.findZero();
    motorRL.findZero();
    motorRR.findZero();
  }

  public void zeroAllEncodersBasedOnProx() {
    motorFL.zeroEncoderBasedOnProx();
    motorFR.zeroEncoderBasedOnProx();
    motorRL.zeroEncoderBasedOnProx();
    motorRR.zeroEncoderBasedOnProx();
  }

  private double findSpeed(double negitive, double positive) {
    return (positive - negitive)/2;
  }

  private void moveDriveMotors(double speed) {

    frontLeftDriveMotor.set(ControlMode.PercentOutput, speed);
    frontRightDriveMotor.set(ControlMode.PercentOutput, speed);
    rearLeftDriveMotor.set(ControlMode.PercentOutput, speed);
    rearRightDriveMotor.set(ControlMode.PercentOutput, speed);

    frontLeftDriveMotor.setInverted(true);
    frontRightDriveMotor.setInverted(false);
    rearLeftDriveMotor.setInverted(true);
    rearRightDriveMotor.setInverted(false);

  }

  private void leftSwerves(double x, double y) {
    motorFL.swerveDatBoi(x, y);
    motorFR.swerveDatBoi(x, y);
  }

  private void rightSwerves(double x, double y) {
    motorRL.swerveDatBoi(x, y);
    motorRR.swerveDatBoi(x, y);
  }

  public void moveSwervePointTurn(double leftT, double rightT) {
    motorFL.swerveDatBoi(0.8, 0.6);
    motorFR.swerveDatBoi(-0.8, 0.6);
    motorRL.swerveDatBoi(-0.8, 0.6);
    motorRR.swerveDatBoi(0.8, 0.6);

    double appliedSpeed = findSpeed(leftT, rightT);

    frontLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    frontRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
    rearLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    rearRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
  }

  public void moveSwervePointTurn(double appliedSpeed) {
    motorFL.swerveDatBoi(0.8, 0.6); //TODO: Check if these need to be swapped
    motorFR.swerveDatBoi(-0.8, 0.6);
    motorRL.swerveDatBoi(-0.8, 0.6);
    motorRR.swerveDatBoi(0.8, 0.6);

    frontLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    frontRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
    rearLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    rearRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
  }
}
