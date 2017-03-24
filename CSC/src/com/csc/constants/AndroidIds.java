/**
 * 
 */
package com.csc.constants;

/**
 * Contains IDs for the android elements presents in CSC Android
 * 
 * @author Ashraf Iftekhar, Feb 27, 2017
 *
 */
public class AndroidIds {

	// Launch page id's
	public String SIGN_IN_BUTTON = "org.cscpbc.parenting:id/splash_log_in";
	public String SIGN_UP_BUTTON = "org.cscpbc.parenting:id/splash_sign_up";

	// Sign In page id's
	public String EMAIL_TEXTBOX = "org.cscpbc.parenting:id/email";
	public String PASSWORD_TEXTBOX = "org.cscpbc.parenting:id/password";
	public String LOGIN_BUTTON = "org.cscpbc.parenting:id/login_button";
	public String CREATE_NEW_BUTTON = "//android.widget.TextView[@text='Create one here.']";
	public String FORGOT_PASSWORD_BUTTON = "//android.widget.TextView[@text='Forgot Password?']";
	// XPATH
	public String EMAIL_ERROR = "//android.widget.TextView[@text='Please enter a valid email.']";
	public String PASSWORD_ERROR = "//android.widget.TextView[@text='Passwords must have at least 6 characters']";

	// Home page id's
	public String HAMBURGER_ICON = "//android.widget.ImageButton[@index='0']"; // xpath
	public String SIGNOUT = "org.cscpbc.parenting:id/navigation_drawer_sign_out";

	// Webview id
	public String WEBVIEW = "org.cscpbc.parenting:id/webview";

	// Register Page ids
	// TODO Add ids before running
	public String FIRST_NAME = "";
	public String LAST_NAME = "";
	public String PROFILE_NAME = "";
	public String EMAIL = "";
	public String PASSWORD = "";
	public String CONFIRM_PASSWORD = "";
	public String CONTINUE = "";
	public String LOGIN_LINK = "";
	public String BACK_BUTTON = "";
}
