package com.itopener.demo.shardingjdbc.config;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author fuwei.deng
 * @date 2017年12月18日 下午1:30:19
 * @version 1.0.0
 */
public class IpUtils {

	/**
	 * @description 获取本机ip
	 * @author fuwei.deng
	 * @date 2017年12月18日 下午1:30:29
	 * @version 1.0.0
	 * @return
	 */
	public static String getLocalIP() {
		if (isWindowsOS()) {
			return getWindowsIp();
		} else {
			return getLinuxLocalIp();
		}
	}

	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	private static InetAddress inetAddress;

	public static String getWindowsIp() {
		if (inetAddress == null) {
			try {
				inetAddress = InetAddress.getLocalHost();
			} catch (Exception e) {
				inetAddress = null;
				return "";
			}
		}
		return inetAddress.getHostAddress();
	}

	private static String ipCahe = null;

	public static String getLinuxLocalIp() {
		// String ip = "";
		if (ipCahe == null || ipCahe.isEmpty() || ipCahe.equals("127.0.0.1")) {
			try {
				for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en
						.hasMoreElements();) {
					NetworkInterface intf = en.nextElement();
					String name = intf.getName();
					if (!name.contains("docker") && !name.contains("lo")) {
						for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr
								.hasMoreElements();) {
							InetAddress inetAddress = enumIpAddr.nextElement();
							if (!inetAddress.isLoopbackAddress()) {
								String ipaddress = inetAddress.getHostAddress().toString();
								if (!ipaddress.contains("::") && !ipaddress.contains("0:0:")
										&& !ipaddress.contains("fe80")) {
									ipCahe = ipaddress;
									return ipCahe;
								}
							}
						}
					}
				}
			} catch (SocketException ex) {
				System.out.println("获取ip地址异常");
				ipCahe = "127.0.0.1";
				ex.printStackTrace();
			}
		}
		System.out.println("IP:" + ipCahe);
		return ipCahe;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			long start4 = new Date().getTime();
			String ipStr = getLocalIP();
			System.out.println(ipStr + " 获取本机ip耗时：" + (new Date().getTime() - start4));
		}

		for (int i = 0; i < 5; i++) {
			long start = new Date().getTime();
			String ip = getLinuxLocalIp();
			System.out.println(ip + " 获取ip耗时：" + (new Date().getTime() - start));
		}
	}
}
