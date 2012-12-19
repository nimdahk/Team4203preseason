/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.camera.AxisCamera;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class RobotTemplate extends IterativeRobot {
    
    private Joystick joy1;
    
    private Jaguar drive1;
    private Jaguar drive2;
    
    private Claw claw1;
    // private Relay piston1;
    private EncoderTest encoder1;
    
    private RobotDrive robotDrive;
    
    AxisCamera camera;
    
    
    public void robotInit() {
        joy1 = new Joystick(1); // Joystick(int port)

        drive1 = new Jaguar(1); // Jaguar(int channel)
        drive2 = new Jaguar(2);

        claw1 = new Claw(2, 3, 1);
        // <editor-fold>
        /* piston1 = new Relay(3); // Relay(int channel)
            piston1.setDirection(Relay.Direction.kBoth); // Allow retracting the piston
        */
        // </editor-fold>
        encoder1   = new EncoderTest();

        robotDrive = new RobotDrive(drive1, drive2); // RobotDrive(int leftMotorChannel, int rightMotorChannel) 
        // RobotDrive default sensitivity; can change with RobotDrive(int, int, double sensitivity)

        camera = AxisCamera.getInstance();
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);
        camera.writeBrightness(0);
    }
     
    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        if (joy1.getRawButton(2)){
            claw1.RelayToggle();
            while (joy1.getRawButton(2)){
                // got to fix this loop
            }
        }
        driveControl();
        DriverStationLCD.getInstance().updateLCD();        
        pistonControl();
        updateDashboard();
    }
    
    public void driveControl() {
        robotDrive.arcadeDrive(joy1);
    }
    
    public void pistonControl(){
        if (joy1.getTrigger()){
            claw1.Extend();
        }else{
            claw1.Retract();
        }
    }
    private void updateDashboard(){
  /*      SmartDashboard.putNumber("distance", encoder1.getDistance());
        SmartDashboard.putBoolean("direction", encoder1.getDirection());
        SmartDashboard.putNumber("count", encoder1.getCount()); */
    }
}