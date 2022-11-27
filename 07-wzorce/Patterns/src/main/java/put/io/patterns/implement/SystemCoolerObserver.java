package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver{
    @Override
    public void update(SystemState lastSystemState) {
        // Increase CPU cooling if the temperature is too high
        if (lastSystemState.getCpuTemp() > 60.00) {
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
