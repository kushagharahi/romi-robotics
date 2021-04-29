package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

/* This command will turn your robot for a desired rotation speed and time */
public class TurnTime extends CommandBase {
    private double speed;
    private double time;
    private RomiDrivetrain drivetrain;
    private long startTime;

    public TurnTime(double speed, double time, 
                    RomiDrivetrain drivetrain) {
        this.speed = speed;
        this.time = time;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        this.startTime = System.currentTimeMillis();
        this.drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {
        this.drivetrain.arcadeDrive(0, this.speed);
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - this.startTime) >= this.time;
    }

    @Override
    public void end(boolean interrupted) {
        this.drivetrain.arcadeDrive(0, 0);
    }
}
