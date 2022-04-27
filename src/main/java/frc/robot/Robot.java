// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  private XboxController controller = new XboxController(0);

  private TalonSRX ArmsRoller = new TalonSRX(6);
  private TalonSRX Handler = new TalonSRX(5);
  private TalonSRX Shooter = new TalonSRX(4);

  private TalonSRX leftMotor1 = new TalonSRX(0);
  private TalonSRX leftMotor2 = new TalonSRX(1);
  private TalonSRX rightMotor1 = new TalonSRX(2);
  private TalonSRX rightMotor2 = new TalonSRX(3);

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double turn = controller.getRightX() * 0.5;
    double speed = controller.getLeftY() * 0.5;

    double left = speed + turn;
    double right = speed - turn;

    leftMotor1.set(ControlMode.PercentOutput, left);
    leftMotor2.set(ControlMode.PercentOutput, left);
    rightMotor1.set(ControlMode.PercentOutput, -right);
    rightMotor2.set(ControlMode.PercentOutput, -right);
  }
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
