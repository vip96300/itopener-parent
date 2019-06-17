package com.itopener.tools.zookeeper.vo;

public class ZookeeperInfo {

	private int connectionTimeoutMs;
	
	private String currentConnectionString;
	
	private long instanceIndex;

	public int getConnectionTimeoutMs() {
		return connectionTimeoutMs;
	}

	public void setConnectionTimeoutMs(int connectionTimeoutMs) {
		this.connectionTimeoutMs = connectionTimeoutMs;
	}

	public String getCurrentConnectionString() {
		return currentConnectionString;
	}

	public void setCurrentConnectionString(String currentConnectionString) {
		this.currentConnectionString = currentConnectionString;
	}

	public long getInstanceIndex() {
		return instanceIndex;
	}

	public void setInstanceIndex(long instanceIndex) {
		this.instanceIndex = instanceIndex;
	}
	
}
