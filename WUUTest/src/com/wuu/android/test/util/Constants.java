package com.wuu.android.test.util;

import com.wuu.android.test.onboarding.NavigationTests;

/**
 * Contains common constants used by the tests like {@link NavigationTests}
 * 
 * @author Ashraf Iftekhar
 *
 */
public class Constants {

	// WUU Email and code
	public static String EMAIL_ID = "mutualmobile333@gmail.com";
	public static boolean IS_NEW_USER = false;

	// Package
	public static String PACKAGE_NAME = "com.wuu.android";

	// First Page
	public static String WUU_ACTIVITY = "";
	public static String WHATISWUU_BUTTON = "what_is_wuu_text";
	public static String CLOSE_IMAGE = "close_image";
	public static String SIGNIN_UP = "com.wuu.android:id/sign_in_up_button";

	// Whats your email page
	public static String ENTER_EMAIL_EDITTEXT = "com.wuu.android:id/enter_email_edit_text";
	public static String WUU_TERMS = "Wuu Terms";
	public static String PRIVACY_POLICY = "Privacy Policy";
	public static String ERROR_LABEL = "com.wuu.android:id/error_text";

	// Check your email page
	public static String TRY_AGAIN = "com.wuu.android:id/try_again_text";
	public static String ENTER_IT_HERE = "com.wuu.android:id/enter_here_text";

	// What's your code page
	public static String ENTER_CODE_EDITTEXT = "com.wuu.android:id/enter_code_edit_text";
	public static String TRY_AGAIN_CODE = "com.wuu.android:id/try_again_text";

	// Find friends Page
	public static String SKIP_BUTTON_CONTACTS = "com.wuu.android:id/skip_text";
	public static String CONNECT_CONTACTS_BUTTON = "com.wuu.android:id/connect_contacts_layout";

	// Find Facebook Friends
	public static String FACEBOOK_SKIP = "com.wuu.android:id/skip_text";
	public static String FACEBOOK_CONNECT = "com.wuu.android:id/activity_contact_request";

	// Home Page Elements
	public static String WUU_IMAGEVIEW_ID = "android.widget.ImageView";
	public static String SQUARE_BUTTON_ID = "com.wuu.android:id/send_text_wuu";
	public static String CIRCLE_BUTTON_ID = "com.wuu.android:id/send_image_wuu";
	public static String TRAINGLE_BUTTON_ID = "com.wuu.android:id/send_voice_wuu";

	// Write text page elements
	public static String TEXT_WUU_EDITTEXT_ID = "com.wuu.android:id/ghost_view";
	public static String X_BUTTON_ID = "com.wuu.android:id/action_cancel";
	public static String FORWARD_BUTTON_ID = "com.wuu.android:id/action_go";
	public static String ALLOW_BUTTON = "com.android.packageinstaller:id/permission_allow_button";

	// Activities
	public static String LAUNCH_ACTIVITY = ".feature.onboarding.launch.LaunchActivity";
	public static String EMAIL_ACTIVITY = ".feature.onboarding.email.EmailActivity";
	public static String MAGIC_LINK_ACTIVITY = ".feature.onboarding.magiclink.MagicLinkActivity";
	public static String ADD_CONTACTS_ACTIVITY = ".feature.onboarding.contactrequest.ContactRequestActivity";
	public static String ADD_FB_CONTACTS_ACTIVITY = ".feature.onboarding.facebookrequest.FacebookRequestActivity";
	public static String STREAM_ACTIVITY = ".feature.stream.StreamActivity";
	public static String SEND_TO_ACTIVITY = ".feature.sendWuu.sendto.SendToActivity";
}
