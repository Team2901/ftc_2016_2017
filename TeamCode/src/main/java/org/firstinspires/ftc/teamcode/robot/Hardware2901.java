package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Hardware2901
{
    /* Public OpMode members. */
    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;
    public DcMotor shootingMotor = null;
    public DcMotor sweeperMotor = null;
    public Servo arm = null;


    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware2901(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;


        // Define and Initialize Motors
        leftMotor   = hwMap.dcMotor.get("left");
        rightMotor  = hwMap.dcMotor.get("right");
        shootingMotor =hwMap.dcMotor.get("shooter");
        sweeperMotor =hwMap.dcMotor.get("sweeper");
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        shootingMotor.setDirection(DcMotor.Direction.REVERSE);
        sweeperMotor.setDirection(DcMotor.Direction.REVERSE);


        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        sweeperMotor.setPower(0);
        shootingMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        sweeperMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shootingMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }


    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

