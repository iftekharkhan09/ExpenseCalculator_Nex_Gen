package com.expensecalculator.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MachineDetails {
	public String getIPAddress() {
		try {
			InetAddress ipAddr = InetAddress.getLocalHost();
			return ipAddr.getHostAddress();
		} catch (UnknownHostException ex) {
			return null;
		}
	}
}
