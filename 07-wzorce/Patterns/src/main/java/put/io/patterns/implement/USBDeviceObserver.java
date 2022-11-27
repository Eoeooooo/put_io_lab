package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    int usb_old = 0;

    @Override
    public void update(SystemState lastSystemState) {
        int usb_new = lastSystemState.getUsbDevices();
        if (usb_old != usb_new){
            System.out.println("USB devices count changed");
            usb_old = usb_new;
        }
    }
}
