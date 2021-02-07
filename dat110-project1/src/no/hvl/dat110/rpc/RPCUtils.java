package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and unmarshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// DONE: marshall RPC identifier and string into byte array
		
		encoded = new byte [str.length()];
		byte[] encodedFinal = new byte [encoded.length + 1];
		//assert rpcid != 0 : "The method identifier is empty!";
		assert !str.isEmpty() : "The string you parsed is empty!";
		encoded = str.getBytes();
		System.arraycopy(encoded, 0, encodedFinal, 1, str.length());
		encodedFinal[0] = rpcid;
		return encodedFinal;
		//return encoded;
	}

	public static String unmarshallString(byte[] data) {

		byte[] decoded;

		// DONE: unmarshall String contained in data into decoded

		assert data.length > 0 : "The byte array is empty!";
		decoded = new byte [data.length - 1];
		for (int i = 0; i < data.length - 1; i++) {
			decoded[i] = data[i+1];
		}
		decoded = Arrays.copyOf(decoded, data.length - 1);
		String decodedStr = new String(decoded);

		return decodedStr;
	}

	public static byte[] marshallVoid(byte rpcid) {

		// DONE: marshall RPC identifier in case of void type
		
		byte[] encoded = {rpcid, 0};
		
		return encoded;
	}

	public static void unmarshallVoid(byte[] data) {

		// DONE: unmarshall void type
		
		assert data.length > 0 : "The byte array is empty!";
		byte [] decoded = new byte [data.length - 1];
		for (int i = 0; i < data.length - 1; i++) {
			decoded[i] = data[i+1];
		}
		decoded = Arrays.copyOf(decoded, data.length - 1);
		
		String decodedStr = new String(decoded);
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		// DONE: marshall RPC identifier and string into byte array
		
		byte[] encoded = new byte [Integer.bitCount(x)];
		byte[] encodedFinal = new byte [encoded.length + 1];
		//assert rpcid != 0 : "The method identifier is empty!";
		encoded = ByteBuffer.allocate(4).putInt(x).array();
		System.arraycopy(encoded, 0, encodedFinal, 1, encoded.length);
		encodedFinal[0] = rpcid;
		return encodedFinal;
		
		//return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		// DONE: unmarshall integer contained in data
		
		assert data.length > 0 : "The byte array is empty!";
		byte[] decoded = new byte [data.length - 1];
		for (int i = 0; i < data.length - 1; i++) {
			decoded[i] = data[i+1];
		}
		decoded = Arrays.copyOf(decoded, data.length - 1);
		int decodedInt = ByteBuffer.wrap(decoded).getInt();
		// DONE: unmarshall String contained in data into decoded
		return decodedInt;

		//return decoded;
	}
}
