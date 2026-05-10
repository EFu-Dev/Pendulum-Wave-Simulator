public class Pendulum {
    double length; 
    double mass; 
    double angle; // angle of the pendulum from the vertical (in radians)
    double angularVelocity; 
    double angularAcceleration; 

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
        angularAcceleration = (-gravity / length) * Math.sin(angle); // a = -(g/L) * sin(theta)
        angularVelocity += angularAcceleration * timeStep // Euler Velocity
        angularVelocity *= damping;
        angle += angularVelocity * timeStep; // Euler Position
    }
}

