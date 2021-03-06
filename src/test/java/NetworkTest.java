import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkTest {

    Network network;
    Desktop desktop;
    Printer printer;
    InternetRadio internetRadio;

    @Before
    public void before() {
        network = new Network("CodeClan", 2);
        desktop = new Desktop("Keith's Desktop", "Apple", "Macbook Pro");
        printer = new Printer();
        internetRadio = new InternetRadio();
    }

    @Test
    public void hasName(){
        assertEquals("CodeClan", network.getName());
    }

    @Test
    public void deviceListStartsEmpty() {
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectDesktop() {
        network.connect(desktop);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnectPrinter() {  //NEW TEST
        network.connect(printer);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void shouldEmptyDeviceListAfterDisconnectingAll(){
        network.connect(desktop);
        network.connect(printer);
        network.disconnectAll();
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectInternetRadio() {
        network.connect(internetRadio);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void cannotAddConnectionsOverMax() {
        network.connect(desktop);
        network.connect(printer);
        network.connect(internetRadio);
        assertEquals(2, network.deviceCount());
    }

    @Test
    public void canGetSlotsFree() {
        assertEquals(2, network.slotsFree());
    }

    @Test
    public void canGetSlotsFreeAfterConnection() {
        network.connect(internetRadio);
        assertEquals(1, network.slotsFree());
    }

}
