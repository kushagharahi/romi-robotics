package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class ArcadeDrive extends CommandBase {
    private RomiDrivetrain driveTrain;
    private Supplier<Double> xAxisSpeed;
    private Supplier<Double> zAxisRotate;
    
    public ArcadeDrive(RomiDrivetrain driveTrain, 
                        Supplier<Double> xAxisSpeed,
                        Supplier<Double> zAxisRotate) {
        this.driveTrain = driveTrain;
        this.xAxisSpeed = xAxisSpeed;
        this.zAxisRotate = zAxisRotate;
        addRequirements(this.driveTrain);
    }
    
    @Override
    public void execute() {
        this.driveTrain.arcadeDrive(this.xAxisSpeed.get(), this.zAxisRotate.get());
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
