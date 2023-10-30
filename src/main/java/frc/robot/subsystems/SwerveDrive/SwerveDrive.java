package frc.robot.subsystems.SwerveDrive;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveDrive extends SubsystemBase {
    private final SwerveDriveIO io;
    private final SwerveDriveIOInputsAutoLogged inputs = new SwerveDriveIOInputsAutoLogged();

    public SwerveDrive(SwerveDriveIO io) {
        this.io = io;
    }

    public void stopModules() {
        io.stopModules();
    }

    public void setModuleStates(SwerveModuleState[] states) {
        io.setModuleStates(states);
    }

    public Rotation2d getRotation2d() {
        return io.getRotation2d();
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.getInstance().processInputs("SwerveDrive", inputs);
    }
}