# Pendulum-Wave-Simulator

File Structure:

• Pendulum.java: The Model class.

• PendulumWave.java: The driver and view class. Run this file and enter the desired number of pendulums to generate the visualization.

How to Run:

1) Compile both files:

         javac Pendulum.java PendulumWave.java

3) Run the program:

         java PendulumWave

5) Enter the desired number of pendulums when prompted.

How it works:

A Java simulation of a Multi-Pendulum System demonstrating Simple Harmonic Motion and Euler Integration where users can change how many non-interacting pendulums are present. This project uses math and code to show how pendulums move in the real world. 

By giving each pendulum a different length (L), they create a "wave" effect as they swing in and out of sync, meaning each pendulum has a different period (T) which is the amount of time it takes to complete a full cycle.As length (L) increases, period (T) increases so each pendulum is swinging at a slightly different speed.

Period formula: 

      T = 2π√(L/g)
      
Using Euler Integration we calculate the Angular acceleration (α) at every millisecond.

Equation for the motion:

      α =-(g/L)sin(θ)

After having angular acceleration (α), we can update the velocity (ω) and position where △t is time step.

Euler Integration:

      ω  new = ω old + (α  • △t)
      Θ new = θ old + (ω new  • △t)
