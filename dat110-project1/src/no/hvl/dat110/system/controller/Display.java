package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {

		// DONE
		// implement marshalling, call and unmarshalling for write RPC method

		byte [] marshalled = RPCUtils.marshallString(RPCID, message);
		rpcclient.call(marshalled);
		System.out.println("Current temperature is: " + RPCUtils.unmarshallString(marshalled));
	}
}
