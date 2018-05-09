package com.example.amine.islamicevents;

/**
 * Created by amine on 25/07/2017.
 */

public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://10.0.2.2:8080/eventapp/users/addUser.php";
    public static final String URL_GET_ALL = "http://10.0.2.2:8080/eventapp/users/getAllUser.php";
    public static final String URL_GET_USER = "http://10.0.2.2:8080/eventapp/users/getUser.php?id=";
    public static final String URL_UPDATE_USER = "http://10.0.2.2:8080/eventapp/users/updateUser.php";
    public static final String URL_DELETE_USER = "http://10.0.2.2:8080/eventapp/users/deleteUser.php?id=";
    public static final String URL_GET_USER_BY_MAIL = "http://10.0.2.2:8080/eventapp/users/getUser.php?mail=";
    //Keys that will be used to send the request to php scripts
    //id_user	name	username	address	email	password	phone photo
    public static final String KEY_USER_ID = "id";
    public static final String KEY_USER_NAME = "name";
    public static final String KEY_USER_USERNAME = "username";
    public static final String KEY_USER_ADDRESS = "address";
    public static final String KEY_USER_EMAIL = "email";
    public static final String KEY_USER_PASSWORD = "password";
    public static final String KEY_USER_PHONE = "phone";
    public static final String KEY_USER_PHOTO = "photo";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_USERNAME = "username";
    public static final String TAG_ADDRESS = "address";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_PASSWORD = "password";
    public static final String TAG_PHONE = "phone";
    public static final String TAG_PHOTO = "photo";


    //employee id to pass with intent
    public static final String USER_ID = "user_id";
}
