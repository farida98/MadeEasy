package com.example.madeeasy;

import android.provider.BaseColumns;

import java.sql.Blob;

public class DatabaseContract {
    public DatabaseContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class USERS implements BaseColumns {
        public static final String TABLE_NAME = "CustomerData";
        public static final String COL_NAME = "User";
        public static final String COL_EMAIL = "Useremail";
        public static final String COL_PASSWORD = "Userpassword";

    }
    public static abstract class USERS1 implements BaseColumns {
        public static final String TABLE_NAME = "FeedBack";
        public static final String COL_NAME = "Userename";
        public static final String COL_FEEDBACK = "Userfeedback";

    }
    public static abstract class USERS2 implements BaseColumns {
        public static final String TABLE_NAME = "AddRecipe";
        public static final String COL_RNAME = "Name";
        public static final String COL_TIME= "Time";
        public static final String COL_DISCRIPTION= "Description";
        public static final String COL_INGREDIENTS = "Ingredients";
        public static final String COL_METHOD = "Method";


    }

}