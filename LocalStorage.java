import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LocalStorage {

    private static SharedPreferences variable;

    private static SharedPreferences.Editor storage;

    public LocalStorage( Context context ) {

        variable = PreferenceManager.getDefaultSharedPreferences( context );

        storage = variable.edit();

    }

    /**
     * Get int variable from local storage
     * @param name
     * @return int
     */
    public int getInt( String name ) {
        return variable.getInt( name, 0 );
    }

    /**
     * Get string variable from local storage
     * @param name
     * @return int
     */
    public String getString( String name ) {
        return variable.getString( name, "" );
    }

    /**
     * Get boolean variable from local storage
     * @param name
     * @return int
     */
    public boolean getBoolean( String name ) {
        return variable.getBoolean( name, false );
    }

    /**
     * Save int variable in local storage
     * @param name
     * @param value
     */
    public void putInt( String name, int value ) {

        storage.putInt( name, value );
        storage.commit();

    }

    /**
     * Save string variable in local storage
     * @param name
     * @param value
     */
    public void putString( String name, String value ) {

        storage.putString( name, value );
        storage.commit();

    }

    /**
     * Save boolean variable in local storage
     * @param name
     * @param value
     */
    public void putBoolean( String name, boolean value ) {

        storage.putBoolean( name, value );
        storage.commit();

    }

}
