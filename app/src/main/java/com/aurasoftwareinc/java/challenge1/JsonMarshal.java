package com.aurasoftwareinc.java.challenge1;

import org.json.JSONObject;

import java.lang.reflect.Field;


public class JsonMarshal
{
    public static JSONObject marshalJSON(Object object)
    {
        //Get the class of the object received as a parameter
        Class originalClass = object.getClass();
        //Declare an array of Fields and put the fields of the received class into it
        Field[] fields = originalClass.getDeclaredFields();
        //Declare two arrays, one for the names and the other for the values of the JSON
        String[] names = new String[fields.length];
        Object[] values = new Object[fields.length];
        for(int i = 0; i < fields.length; i++){
            //Convert each field to string and put it into the array names
            names[i] = fields[i].toString();

            //In case some field is null
            Object value = null;
            try {
                //Get the object of each field
                value = fields[i].get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //Put the object obtained previously into the array values
            values[i] = value;

        }


        JSONObject json = new JSONObject();

        try
        {
            //each name-value extracted previously from the received object is added to the JSON
            for(int i = 0; i < fields.length; i++){
                json.put(names[i], values[i]);
            }

        }
        catch (Exception ignore)
        {
        }

        return json;
    }

    public static boolean unmarshalJSON(Object object, JSONObject json)
    {

        // Todo: replace contents of this method with Your code.


        return true;
    }
}