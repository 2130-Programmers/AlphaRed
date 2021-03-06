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

  /**
   * Creates a new SwerveDrivePIDSubsystem.
   */
  public SwerveDrivePIDSubsystem() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.01, 0, 0));

    motorFL = new Motor(2, 12, 10, 0);
    motorFR = new Motor(4, 18, 17, 1);
    motorRL = new Motor(6, 14, 13, 2);
    motorRR = new Motor(8, 16, 15, 3);    
    
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
    motorFL.setInverted(true);
    motorFR.setInverted(true);
    motorRL.setInverted(true);
    motorRR.setInverted(true);

    frontLeftDriveMotor.setInverted(false);
    frontRightDriveMotor.setInverted(true);
    rearLeftDriveMotor.setInverted(false);
    rearRightDriveMotor.setInverted(true);
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

    double frontDesiredSpeed = findSpeed(rightT, leftT);
    double rearDesiredSpeed = frontDesiredSpeed;

    if (leftY < 0) {
      frontDesiredSpeed = -frontDesiredSpeed;
    }

    if (rightY < 0) {
      rearDesiredSpeed = -rearDesiredSpeed;
    }

    moveDriveMotors(frontDesiredSpeed, rearDesiredSpeed);
    
  }

  public void moveSwerveStrafe(double rightT, double leftT) {
    motorFL.swerveDatBoi(1, 0);
    motorFR.swerveDatBoi(1, 0);
    motorRL.swerveDatBoi(1, 0);
    motorRR.swerveDatBoi(1, 0);

    double appliedSpeed = findSpeed(rightT, leftT);

    moveDriveMotors(appliedSpeed, appliedSpeed);
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

  private double findSpeed(double positive, double negitive) {
    return (positive - negitive)/2;
  }

  public void stopPID() {
    disable();
    moveSwerveAxis(0, 0, 0, 0, 0, 0);
  }

  private void moveDriveMotors(double frontSpeed, double rearSpeed) {
    frontLeftDriveMotor.set(ControlMode.PercentOutput, frontSpeed);
    frontRightDriveMotor.set(ControlMode.PercentOutput, frontSpeed);
    rearLeftDriveMotor.set(ControlMode.PercentOutput, rearSpeed);
    rearRightDriveMotor.set(ControlMode.PercentOutput, rearSpeed);

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

  /**
   * 
   * 
   * 
   * @param rightT The 
   * @param leftT
   */

  public void moveSwervePointTurn(double rightT, double leftT) {
    motorFL.swerveDatBoi(0.833, 0.552);
    motorFR.swerveDatBoi(-0.833, 0.552);
    motorRL.swerveDatBoi(-0.833, 0.552);
    motorRR.swerveDatBoi(0.833, 0.552);

    double appliedSpeed = findSpeed(rightT, leftT);

    frontLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    frontRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
    rearLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    rearRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
  }

  public void moveSwervePointTurn(double appliedSpeed) {
    motorFL.swerveDatBoi(0.833, 0.552); //TODO: Check if these need to be swapped
    motorFR.swerveDatBoi(-0.833, 0.552);
    motorRL.swerveDatBoi(-0.833, 0.552);
    motorRR.swerveDatBoi(0.833, 0.552);

    frontLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    frontRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
    rearLeftDriveMotor.set(ControlMode.PercentOutput, appliedSpeed);
    rearRightDriveMotor.set(ControlMode.PercentOutput, -appliedSpeed);
  }
}
