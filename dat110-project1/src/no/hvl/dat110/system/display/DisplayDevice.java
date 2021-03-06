package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		// DONE
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice	
		
		System.out.println("Display server starting ...");
		
		DisplayImpl display = new DisplayImpl();
		
		RPCServer displayServer = new RPCServer(Common.DISPLAYPORT);
		
		displayServer.register(0, display);
		
		displayServer.run();
		
		displayServer.stop();
		
		System.out.println("Display server stopping ...");
		
	}
}
