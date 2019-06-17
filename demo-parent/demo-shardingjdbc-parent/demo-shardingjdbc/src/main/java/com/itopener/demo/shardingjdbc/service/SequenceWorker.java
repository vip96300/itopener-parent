package com.itopener.demo.shardingjdbc.service;

/**
 * @author fuwei.deng
 * @date 2017年12月18日 下午1:18:31
 * @version 1.0.0
 */
public class SequenceWorker {

	public static final long twepoch;
	final static long workerIdBits;
	final static long datacenterIdBits;
	public final static long maxWorkerId;
	final static long maxDatacenterId;
	final static long sequenceBits;
	final static long workerIdShift;
	final static long datacenterIdShift;
	final static long timestampLeftShift;
	final static long sequenceMask;

	static long sequence;
	static long lastTimestamp;
	static {
		twepoch = 1288834974657L;
		workerIdBits = 5L;
		datacenterIdBits = 5L;
		maxWorkerId = -1L ^ (-1L << workerIdBits);
		maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
		sequenceBits = 12L;
		workerIdShift = sequenceBits;
		datacenterIdShift = sequenceBits + workerIdBits;
		timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
		sequenceMask = -1L ^ (-1L << sequenceBits);
		sequence = 0L;
		lastTimestamp = -1L;
	}

	private long workerId;
	private long datacenterId;

	public SequenceWorker(long workerId, long datacenterId) {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		if (datacenterId > maxDatacenterId || datacenterId < 0) {
			throw new IllegalArgumentException(
					String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	public synchronized long nextId() {
		long timestamp = timeGen();
		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}
		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;

		return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
				| (workerId << workerIdShift) | sequence;
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
		SequenceWorker idWorker = new SequenceWorker(1, 1);
		for (int i = 0; i < 10; i++) {
			long id = idWorker.nextId();
			System.out.println(id);
		}
	}
}
