import android.content.Context;
import java.util.regex.Pattern;

/**
 * Form validator class
 */
public class Validator {

    private Context myContext;

    /**
     * Init class
     * @param myContext
     */
    public Validator(Context myContext) {
        this.myContext = myContext;
    }

    /**
     * Show toast message for user
     * @param text
     */
    private void showMessage(String text) {
        Toasty.error(myContext, text, Toast.LENGTH_LONG, false).show();
    }

    /**
     * If string was empty
     * @param value
     * @param inputName
     * @return boolean
     */
    public boolean isEmpty(String value, String inputName) {
        if ( value.equals( "" ) ) {
            showMessage( "Please fill '" + inputName + "' field." );
            return true;
        }
        return false;
    }

    /**
     * If string was email
     * @param email
     * @return boolean
     */
    public boolean isValidEmail(String email) {
        if ( isEmpty( email, "email address" ) ) {
            return false;
        }
        if ( !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ) {
            showMessage( "The 'email address' you entered is invalid." );
            return false;
        }
        return true;
    }

    /**
     * If phone number is valid
     * @param phone
     * @return boolean
     */
    public boolean isValidMobile(String phone) {
        if ( !Pattern.matches( "[a-zA-Z]+", phone ) ) {
            if ( phone.length() == 10 || phone.length() == 11 ) {
                return true;
            }
        }
        showMessage( "The 'phone number' you entered is invalid." );
        return false;
    }

    /**
     * If entered password is valid
     * @param value
     * @return boolean
     */
    public boolean isValidPassword( String value ) {
        if ( value.length() < 3 ) {
            showMessage( "Your 'password' must be at least 6 characters long." );
            return false;
        }
        return true;
    }

    /**
     * If entered string was alpha-numeric
     * @param value
     * @return boolean
     */
    public boolean isAlphaNumeric(String value) {
        return value.matches("^[a-zA-Z0-9]*$");
    }

    /**
     * if string was a-zA-Z
     * @param value
     * @return boolean
     */
    public boolean isPersonName(String value) {
        return value.matches("^[a-zA-Z '.,]*$");
    }

}
