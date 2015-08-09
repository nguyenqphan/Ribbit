package com.nguyenqphan.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by nguyenphan on 8/7/15.
 */
public class RibbitApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "pAxb6LJcuywc157gH7e8vBFjJSCMccfwUuUNmhby", "g8cvucK4Lsirh4hBn3Lx3BCDaZVFIxQYVPOqksFW");

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

    }


}
