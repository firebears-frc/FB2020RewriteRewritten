// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.REVLibError;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.RelativeEncoder;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Chassis extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private CANSparkMax rightFrontMotor;
    private CANSparkMax rightBackMotor;
    private MotorControllerGroup rightMotors;
    private CANSparkMax leftFrontMotor;
    private CANSparkMax leftBackMotor;
    private MotorControllerGroup leftMotors;
    private DifferentialDrive differentialDrive;

    private RelativeEncoder measurer;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public Chassis() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        rightFrontMotor = new CANSparkMax(4, MotorType.kBrushless);

        rightFrontMotor.restoreFactoryDefaults();
        rightFrontMotor.setInverted(false);
        rightFrontMotor.setIdleMode(IdleMode.kCoast);

        rightBackMotor = new CANSparkMax(5, MotorType.kBrushless);

        rightBackMotor.restoreFactoryDefaults();
        rightBackMotor.setInverted(false);
        rightBackMotor.setIdleMode(IdleMode.kCoast);

        rightMotors = new MotorControllerGroup(rightFrontMotor, rightBackMotor);
        addChild("rightMotors", rightMotors);

        leftFrontMotor = new CANSparkMax(2, MotorType.kBrushless);

        leftFrontMotor.restoreFactoryDefaults();
        leftFrontMotor.setInverted(false);
        leftFrontMotor.setIdleMode(IdleMode.kCoast);

        leftBackMotor = new CANSparkMax(3, MotorType.kBrushless);

        leftBackMotor.restoreFactoryDefaults();
        leftBackMotor.setInverted(false);
        leftBackMotor.setIdleMode(IdleMode.kCoast);

        leftMotors = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
        addChild("leftMotors", leftMotors);

        differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
        addChild("differentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        measurer = rightFrontMotor.getEncoder();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("getDistance", distanceTraveled());
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void arcadeDrive(double speed, double rotation) {

        differentialDrive.arcadeDrive(rotation, speed);
    }

    public void getEncoder(){

    }

    public double distanceTraveled(){
        return measurer.getPosition()*-2.1;
    }

}
