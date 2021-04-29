package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveForward extends CommandBase {
    private double speed;
    private double time;
    private RomiDrivetrain driveTrain;
    private long startTime;
    
    //1s == 1000ms
    public DriveForward(double speed, double time, 
                        RomiDrivetrain driveTrain) {
        this.speed = speed;
        this.time = time;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    //initialize() is called when the command is initially scheduled
    @Override
    public void initialize() {
        this.startTime = System.currentTimeMillis();
        this.driveTrain.arcadeDrive(0, 0);
    }

    //execute() is called over and over again until the isFinished() returns true 
    //or the command gets descheduled
    @Override
    public void execute() {
        this.driveTrain.arcadeDrive(this.speed, 0);
    }

    //isFinished() is called once per execute() loop to check if the command is complete
    @Override
    public boolean isFinished(){
        return (System.currentTimeMillis() - this.startTime) >= this.time;
    }

    //end() is called once the command ends or is interrupted
    @Override
    public void end(boolean interrupted) {
        this.driveTrain.arcadeDrive(0, 0);
    }
}
