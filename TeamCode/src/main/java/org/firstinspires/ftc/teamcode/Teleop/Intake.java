package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Intake {
    OpMode op;
    public static CRServo intake;
    DcMotor secondaryIntakeRollerOne, secondaryIntakeRollerTwo;

    final double INTAKE_SERVO_SPEED = 1;
    final double BALL_SUPRESSOR_SPEED = 0.3;
    double MOTOR_SI_ONE_SPEED = .6;
    double MOTOR_SI_TWO_SPEED = .6;


    public void init(OpMode OP){
        op = OP;

        intake = op.hardwareMap.get(CRServo.class, "intake");
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

        secondaryIntakeRollerOne = op.hardwareMap.dcMotor.get("rollerOne");

        secondaryIntakeRollerTwo = op.hardwareMap.dcMotor.get("rollerTwo");
    }

    public void loop(){
        campbellMoveIntakeConOne();
    }

    public void moveIntakeConOne(){
        if (op.gamepad1.b){
            intake.setPower(INTAKE_SERVO_SPEED);
        } else if (op.gamepad1.x){
            intake.setPower(-INTAKE_SERVO_SPEED);
        } else if(op.gamepad1.y){
            secondaryIntakeRollerOne.setPower(MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(MOTOR_SI_TWO_SPEED);
        } else if (op.gamepad1.a){
            secondaryIntakeRollerOne.setPower(-MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(-MOTOR_SI_TWO_SPEED);
        }else if (op.gamepad1.dpad_up){
            Shooter.leftShooter.setPower(-BALL_SUPRESSOR_SPEED);
            Shooter.rightShooter.setPower(-BALL_SUPRESSOR_SPEED);
        } else if (op.gamepad1.right_trigger > 0){
            intake.setPower(INTAKE_SERVO_SPEED);
            secondaryIntakeRollerOne.setPower(MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(MOTOR_SI_TWO_SPEED);
        } else if(op.gamepad1.left_trigger > 0){
            intake.setPower(-INTAKE_SERVO_SPEED);
            secondaryIntakeRollerOne.setPower(-MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(-MOTOR_SI_TWO_SPEED);
        }else {
            intake.setPower(0);
            secondaryIntakeRollerOne.setPower(0);
            secondaryIntakeRollerTwo.setPower(0);
        }
    }

    /*public void testIntakeConTwo(){
        if (op.gamepad2.b){
            secondaryIntake.setPower(INTAKE_SPEED);
            intake.setPower(1);
        } else if (op.gamepad2.x){
            secondaryIntake.setPower(-INTAKE_SPEED);
        } else {
            secondaryIntake.setPower(0);
            intake.setPower(0);
        }
    }*/

    //Just Campbell's Preferences for intake. Sub out for normal when he uses controller
    public void campbellMoveIntakeConOne(){
        if (op.gamepad1.a){
            intake.setPower(INTAKE_SERVO_SPEED);
        } else if (op.gamepad1.b){
            intake.setPower(-INTAKE_SERVO_SPEED);
        } else if(op.gamepad1.y){
            secondaryIntakeRollerOne.setPower(MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(MOTOR_SI_TWO_SPEED);
        } else if (op.gamepad1.x){
            secondaryIntakeRollerOne.setPower(-MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(-MOTOR_SI_TWO_SPEED);
        }else if (op.gamepad1.dpad_up){
            Shooter.leftShooter.setPower(-BALL_SUPRESSOR_SPEED);
            Shooter.rightShooter.setPower(-BALL_SUPRESSOR_SPEED);
        } else if (op.gamepad1.right_trigger > 0){
            intake.setPower(1);
            secondaryIntakeRollerOne.setPower(MOTOR_SI_ONE_SPEED);
            secondaryIntakeRollerTwo.setPower(MOTOR_SI_TWO_SPEED);
        }else {
            intake.setPower(0);
            secondaryIntakeRollerOne.setPower(0);
            secondaryIntakeRollerTwo.setPower(0);
        }
    }
}
