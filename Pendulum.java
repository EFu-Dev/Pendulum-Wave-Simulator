
// A simple class to represent a pendulum
public class Pendulum {
    double length; // length of the pendulum
    double mass; // mass of the pendulum bob
    double angle; // angle of the pendulum from the vertical (in radians)
    double angularVelocity; // angular velocity of the pendulum
    double angularAcceleration; // angular acceleration of the pendulum

    //constants for physics calculations
    private final double gravity = 9.8;
    private final double damping = 0.995; //air resistance

    public Pendulum(double l, double a){
        length = l;
        angle = a; // initial angle
        mass = 1.0; // default mass
        angularVelocity = 0.0; // initial angular velocity
        angularAcceleration = 0.0; // initial angular acceleration
    }

    public void update(double timeStep){
 // 1. Calculate Acceleration: a = -(g/L) * sin(theta)
        angularAcceleration = (-gravity / length) * Math.sin(angle);
        
        // 2. Euler Integration: Velocity
        angularVelocity += angularAcceleration * timeStep;
        
        // 3. Apply Damping (Slows down over time)
        angularVelocity *= damping;
        
        // 4. Euler Integration: Position
        angle += angularVelocity * timeStep;
    }
}

