package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		// DONE
		// encapsulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		byte[] encoded = new byte[128];
		if (payload.length > 128) {
			return null;
		}
		else {
			encoded[0] = (byte) payload.length;
			for (int i = 0; i < payload.length; i++) {
				encoded[i+1] = payload[i];
			}
			return encoded;
		}
	}

	public void decapsulate(byte[] received) {

		// DONE
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		
		int counter = 0;
		byte[] decapsulated = new byte [received.length - 1];
		for (int i = 0; i < received.length - 1; i++) {
			if (received[i+1] != 0) {
				counter++;
				decapsulated[i] = received[i+1];
			}
		}
		if (counter > 1) {
			this.payload = Arrays.copyOfRange(decapsulated, 0, counter);
		} else {
			payload = new byte [0];
		}
		
		//payload = received;
	}
}
