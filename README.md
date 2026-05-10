# Pendulum-Wave-Simulator
A Java simulation of a Multi-Pendulum System demonstrating Simple Harmonic Motion and Euler Integration where users can change how many non-interacting pendulums are present. This project uses math and code to show how pendulums move in the real world. 

By giving each pendulum a different length (L), they create a "wave" effect as they swing in and out of sync, meaning each pendulum has a different period (T) which is the amount of time it takes to complete a full cycle.
Period formula: 
T = 2π√(L/g)
As length (L) increases, period (T) increases so each pendulum is swinging at a slightly different speed.

Using Euler Integration we calculate the Angular acceleration (α) at every millisecond.
Equation for the motion:
α =-(g/L)sin(θ)

After having angular acceleration (α), we can update the velocity (ω) and position where △t is time step.
Euler Integration:
ω  new = ω old + (α  • △t)
Θ new = θ old + (ω new  • △t)
