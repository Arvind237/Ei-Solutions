public class Rocket {

    private static final int STAGE_1_FUEL_BURN_RATE = 10;
    private static final int STAGE_2_FUEL_BURN_RATE = 5;
    private static final int STAGE_1_ALTITUDE_GAIN = 10;
    private static final int STAGE_2_ALTITUDE_GAIN = 5;
    private static final int STAGE_1_SPEED_GAIN = 1000;
    private static final int STAGE_2_SPEED_GAIN = 500;

    private RocketStage stage;
    private int fuel;
    private int altitude;
    private int speed;
    private boolean checksCompleted;

    public Rocket() {
        this.stage = RocketStage.PRE_LAUNCH;
        this.fuel = 100;
        this.altitude = 0;
        this.speed = 0;
        this.checksCompleted = false;
    }

    public void startChecks() {
        if (stage == RocketStage.PRE_LAUNCH) {
            checksCompleted = true;
            System.out.println("All systems are 'Go' for launch.");
        } else {
            System.out.println("Checks can only be started in the Pre-Launch stage.");
        }
    }

    public void launch() {
        if (checksCompleted) {
            this.stage = RocketStage.STAGE_1;
            while (fuel > 0 && stage != RocketStage.ORBIT) {
                simulateSecond();
                if (fuel <= 0) {
                    stage = RocketStage.FAILED;
                    System.out.println("Mission Failed due to insufficient fuel.");
                    return;
                }
                if (stage == RocketStage.ORBIT) {
                    System.out.println("Orbit achieved! Mission Successful.");
                    return;
                }
                try {
                    Thread.sleep(1000);  // Simulate real-time updates
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Launch cannot proceed without completing checks.");
        }
    }

    public void fastForward(int seconds) {
        for (int i = 0; i < seconds; i++) {
            simulateSecond();
            if (fuel <= 0) {
                stage = RocketStage.FAILED;
                System.out.println("Mission Failed due to insufficient fuel.");
                return;
            }
            if (stage == RocketStage.ORBIT) {
                System.out.println("Orbit achieved! Mission Successful.");
                return;
            }
        }
    }

    private void simulateSecond() {
        if (stage == RocketStage.PRE_LAUNCH) {
            System.out.println("Please start the launch sequence.");
            return;
        }

        if (stage == RocketStage.STAGE_1) {
            fuel -= STAGE_1_FUEL_BURN_RATE;
            altitude += STAGE_1_ALTITUDE_GAIN;
            speed += STAGE_1_SPEED_GAIN;
            System.out.println("Stage: 1, Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: " + speed + " km/h");
            if (fuel <= 50) {
                stage = RocketStage.STAGE_2;
                System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
            }
        } else if (stage == RocketStage.STAGE_2) {
            fuel -= STAGE_2_FUEL_BURN_RATE;
            altitude += STAGE_2_ALTITUDE_GAIN;
            speed += STAGE_2_SPEED_GAIN;
            System.out.println("Stage: 2, Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: " + speed + " km/h");
            if (altitude >= 100) {
                stage = RocketStage.ORBIT;
            }
        }
    }
}
