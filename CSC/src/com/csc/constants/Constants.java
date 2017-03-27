package com.csc.constants;

import com.csc.tests.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Constants extends BaseTest {

	@AndroidFindBy(id = "test")
	public MobileElement elemet;

	// set platform
	public static String Platform = "Android";

	// Android capabilities
	public static String apkPath = "/Users/md.ashrafiftekhar/Documents/CSC/app-release.apk";
	public static String PackageName = "org.cscpbc.parenting";
	public static String LaunchActivity = "org.cscpbc.parenting.view.activity.LaunchActivity";
	public static String AndroidVersion = "4.4";

	// iOS Capabilities
	public static String appPath = "";
	public static String DeviceName = "";
	public static String UDID = "";
	public static String iOSVersion = "";

	// Activities
	public static String LoginActivity = ".view.activity.LoginActivity";
	public static String SignUpActivity = ".view.activity.SignUpActivity";
	public static String HomeActivity = ".view.activity.HomeActivity";
	public static String UploadPhotoActivity = ".view.activity.UploadPhotoActivity";

}
