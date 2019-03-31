package com.delhipolice.avishigoyal.delhipolice.Database;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    String curl="com.mysql.jdbc.Driver";
    String un = "hello";
    String pass = "hello";
    String url="jdbc:mysql://192.168.43.196/android";


    @SuppressLint("NewApi")
    public Connection Conn(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        try{
            Class.forName(curl);
            conn = DriverManager.getConnection(url,un,pass);
        }catch (SQLException se){
            Log.e("ERRO1",se.getMessage());
        }catch (ClassNotFoundException e){
            Log.e("ERRO2",e.getMessage());
        }catch (Exception e)
        {
            Log.e("ERRO3",e.getMessage());
        }
        return conn;
    }
}
