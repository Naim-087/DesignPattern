package structural.adapter;
/*
Let's build a real-world USB Adapter example in Java using the Adapter Design Pattern.

We'll simulate this situation:
- A laptop supports a USB-C port.
- An old USB device uses a USB-A connector.
- The laptop cannot directly communicate with the old device because their interfaces are different.
- We create a USBAdapter that converts the laptop's USB-C request into a USB-A device operation.
*/

//1. interface expected by the laptop / target interface

interface USB_C {
    void connectWithUSB_C();
}

// 2. Adaptee ; existing device that supports USB-A

class USB_A_Device {
    void connectWithUSB_A() {
        System.out.println("USB-A device connected successfully...");
    }
}

// 3.adapter - convert USB-C request into USB-A operations

class USBAdapter implements USB_C {

    private USB_A_Device usbADevice;

    public USBAdapter(USB_A_Device usbADevice) {
        this.usbADevice = usbADevice;
    }

    @Override
    public void connectWithUSB_C() {

        System.out.println("Adapter converting USB-C to USB-A...");

        // Forward the request to the existing device
        usbADevice.connectWithUSB_A();
    }
}

class Laptop {

    public void connectDevice(USB_C device) {

        System.out.println("Laptop requesting USB-C connection...");

        device.connectWithUSB_C();
    }
}

public class adapter1 {

    public static void main(String[] args) {

        // Create an existing USB-A device
        USB_A_Device oldDevice = new USB_A_Device();

        // Create the adapter
        USBAdapter adapter = new USBAdapter(oldDevice);

        // Create laptop
        Laptop laptop = new Laptop();

        // Connect USB-A device to laptop through adapter
        laptop.connectDevice(adapter);
    }

}
