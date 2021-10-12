package com.sweetch.core_user;
import android.content.Context;

import com.sweetch.sdktestmodule.CoreTest;
import com.sweetch.sdktestmodule.Injection;
import com.sweetch.sdktestmodule.User;
import com.sweetch.sdktestmodule.UserDatabase;

public class UseCore {
    public static void use(Context context) {
        CoreTest.test();
        System.out.println("YO YO");
    }

    public static void addUser(Context context, User user) {
        CoreTest.test();
        User user1 = new User("","");
        //Injection.provideUSer(context).insertUserData(user);
        System.out.println("YO YO");
    }
}
