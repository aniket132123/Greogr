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
import edu.wpi.first.wpilibj.Timer;


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

  private TalonSRX armsRoller = new TalonSRX(6);
  private TalonSRX handler = new TalonSRX(5);
  private TalonSRX shooter = new TalonSRX(4);

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
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    drive();
    intake();
    shoot();
  }
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  public void drive(){
    double turn = controller.getRightX() * 0.5;
    double speed = controller.getLeftY() * 0.5;

    double left = speed + turn;
    double right = speed - turn;

    leftMotor1.set(ControlMode.PercentOutput, left);
    leftMotor2.set(ControlMode.PercentOutput, left);
    rightMotor1.set(ControlMode.PercentOutput, -right);
    rightMotor2.set(ControlMode.PercentOutput, -right);
  }
  public void intake(){
    if (controller.getAButton()){
      armsRoller.set(ControlMode.PercentOutput, 0.5);
      handler.set(ControlMode.PercentOutput, 0.4);
    } else {
      armsRoller.set(ControlMode.PercentOutput, 0);
      handler.set(ControlMode.PercentOutput, 0);
    }
  }
  public void shoot(){
    if (controller.getBButton()){
      handler.set(ControlMode.PercentOutput, 0.5);
      shooter.set(ControlMode.PercentOutput, 0.7);
    } else {
      handler.set(ControlMode.PercentOutput, 0);
      shooter.set(ControlMode.PercentOutput, 0);
    }
  }
}
