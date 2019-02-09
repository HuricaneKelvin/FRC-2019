/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import java.time.LocalDateTime;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;


public class Robot extends IterativeRobot {\
  private XboxController m_controller = new XboxController(0);
	private Joystick m_joystick = new Joystick(0);
  private LocalDateTime stopTime;
	private double motorSpeed = 0.0;

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }


  @Override
  public void robotPeriodic() {
  }


  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
  }


  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:

      case kDefaultAuto:
      default:

    }
  }


  @Override
  public void teleopPeriodic() {
    m_driveBase.driveCartesian(m_joystick.getRawAxis(0), m_controller.getY()*-1, m_controller.getX()*-1);
    aIsPressed = m_controller.getAButtonPressed();
		bIsPressed = m_controller.getBButtonPressed();
		xIsPressed = m_controller.getXButtonPressed();
		yIsPressed = m_controller.getYButtonPressed();
  }

  @Override
  public void testPeriodic() {
  }
}

private void testMovement()
	{
		m_driveBase.driveCartesian(.5, 0, 0);
		Timer.delay(2.0);

		m_driveBase.driveCartesian(-.5, 0, 0);
		Timer.delay(2.0);

		m_driveBase.driveCartesian(0, .5, 0);
		Timer.delay(2.0);

		m_driveBase.driveCartesian(0, -.5, 0);
		Timer.delay(2.0);

		m_driveBase.driveCartesian(0, 0, .5);
		Timer.delay(2.0);

		m_driveBase.driveCartesian(0, 0, -.5);
		Timer.delay(2.0);
	}