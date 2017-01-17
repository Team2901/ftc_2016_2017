
package org.firstinspires.ftc.teamcode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.robot.Hardware2901;


@TeleOp(name="Oh dear God make it stop", group="2901")
// Test for github
public class p2901_Iterative extends OpMode{

    /* Declare OpMode members. */
    Hardware2901 robot       = new Hardware2901();


    //      Code to run ONCE when the driver hits INIT

    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here*/
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");
        updateTelemetry(telemetry);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP

    @Override
    public void loop() {
        double left;
        double right;

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;
        robot.leftMotor.setPower(left);
        robot.rightMotor.setPower(right);
        if(gamepad1.right_trigger>0.25)
        {
            robot.shootingMotor.setPower(1.0);
        }
        else
        {
            robot.shootingMotor.setPower(0.0);
        }
        if ((gamepad1.left_bumper) && !(gamepad1.right_bumper))
        {
            robot.sweeperMotor.setDirection(DcMotor.Direction.REVERSE);
            robot.sweeperMotor.setPower(1.0);
        }
       else if((gamepad1.right_bumper) && !(gamepad1.left_bumper))
        {
            robot.sweeperMotor.setDirection(DcMotor.Direction.FORWARD);
            robot.sweeperMotor.setPower(1.0);
        }
        else
        {
            robot.sweeperMotor.setPower(0.0);
        }
        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right);
        telemetry.addData("shooter","%.2f",robot.shootingMotor.getPower());
        telemetry.addData("sweeper","%.2f",robot.sweeperMotor.getPower());
        updateTelemetry(telemetry);
    }

    //      Code to run ONCE after the driver hits STOP

    @Override
    public void stop() {
    }

}
