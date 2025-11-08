package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "SimpleAuto)")
public class SimpleAuto extends LinearOpMode {

    MovementSystem movementSystem = new MovementSystem();


    @Override
    public void runOpMode() throws InterruptedException {
        movementSystem.init(this);

        while (opModeIsActive()) {
        Thread.sleep(1000);
        }
        Thread.sleep(3000);
        movementSystem.SetMoveFromVector(0, 1, 1);
        Thread.sleep(1000);
        movementSystem.SetMoveFromVector(0, 0,0);

}
}
