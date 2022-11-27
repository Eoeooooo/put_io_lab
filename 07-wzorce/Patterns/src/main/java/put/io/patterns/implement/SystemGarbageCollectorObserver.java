package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{
    @Override
    public void update(SystemState status){
        if (status.getAvailableMemory() < 200.00){
            System.out.println("> Running garbage collector...");
        }
    }
}
