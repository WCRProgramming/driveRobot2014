/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    RobotDrive chassis = new RobotDrive(1, 2, 3, 4);
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(isOperatorControl() && isEnabled()){
            
            
            //Right Handed
            double speedControl = rightStick.getZ();
            speedControl++;
            speedControl/=2;
            double gamepadLeftY = leftStick.getRawAxis(2)*speedControl; //get left gamepad control for acceleration
            double gamepadRightX = leftStick.getRawAxis(4)*speedControl; //get right gamepad control for driving
            double gamepadTrigger = leftStick.getRawAxis(5)*speedControl;//get gamepad trigger for acceleration
            double joystickLeftY = leftStick.getY()*speedControl;          //get left joystick y axis for acceleration
            double joystickRightX = rightStick.getX()*speedControl;         //get right joystick x axis for driving
                        
                      //A Challenger Approaches!\\
            /*-----------------Tank Drive-----------------*/
            //chassis.tankDrive(leftStick, rightStick, true);                      //use two joysticks to TANK drive
            /*------------Arcade Drive Gamepad------------*/
            //chassis.arcadeDrive(gamepadLeftY, gamepadRightX, true);              //use gamepad to ARCADE drive with joysticks
            /*-----Arcade Drive Gamepad with Trigger------*/
            //chassis.arcadeDrive(gamepadTrigger, gamepadRightX, true);            //use gamepad to ARCADE drive with right joystick & trigger
            /*--------Arcade Drive Two Joystick(s)--------*/
            chassis.arcadeDrive(joystickLeftY, joystickRightX, true);              //use two joysticks to ARCADE drive
            /*--------Arcade Drive One Joystick(s)--------*/
            //chassis.arcadeDrive(leftStick, true);                                //use left joystick to ARCADE drive
            /*--------------------QED---------------------*/
        }   
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
