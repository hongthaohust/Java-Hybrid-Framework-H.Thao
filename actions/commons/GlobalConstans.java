package commons;

import java.time.Duration;

public class GlobalConstans {
	public static final String DEV_SERVER = "https://demo.nopcommerce.com";
	public static final String TESTING_SERVER = "https://demo.nopcommerce.com";
	public static final String STANGING_SERVER = "https://demo.nopcommerce.com";
	public static final Duration SHORT_TIMEOUT = Duration.ofSeconds(5);
	public static final Duration LONG_TIMEOUT = Duration.ofSeconds(30);

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String ROOT_FOLDER = System.getProperty("user.dir");
	public static final String BROWSER_LOG_FOLDER = ROOT_FOLDER + getDirectorySlash("browserLog");
	public static final String DOWNLOAD_FOLDER = ROOT_FOLDER + getDirectorySlash("downloadFiles");
	public static final String UPLOAD_FOLDER = ROOT_FOLDER +getDirectorySlash( "uploadFiles");
	public static final String AUTOIT_FOLDER = ROOT_FOLDER + getDirectorySlash("autoITScript");

	public static String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public static boolean isWindows() {
		return (GlobalConstans.OS_NAME.toLowerCase().indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (GlobalConstans.OS_NAME.toLowerCase().indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (GlobalConstans.OS_NAME.toLowerCase().indexOf("nix") >= 0 || GlobalConstans.OS_NAME.toLowerCase().indexOf("nux") >= 0 || GlobalConstans.OS_NAME.toLowerCase().indexOf("aix") >= 0);
	}

	public static boolean isSolaris() {
		return (GlobalConstans.OS_NAME.toLowerCase().indexOf("sunos") >= 0);
	}
}
