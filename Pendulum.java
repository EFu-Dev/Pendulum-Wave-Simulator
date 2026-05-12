public class Pendulum {
    double length; 
    double mass; 
    double angle; 
    double angularVelocity; 
    double angularAcceleration; 

    private final double gravity = 9.8;
    private final double damping = 0.995; 

    public Pendulum(double l, double a){
        length = l;
        angle = a;
        mass = 1.0; 
        angularVelocity = 0.0;
        angularAcceleration = 0.0; 
    }

    public void update(double timeStep){
        angularAcceleration = (-gravity / length) * Math.sin(angle);
        angularVelocity += angularAcceleration * timeStep; 
        angularVelocity *= damping;
        angle += angularVelocity * timeStep; 
    }
}

