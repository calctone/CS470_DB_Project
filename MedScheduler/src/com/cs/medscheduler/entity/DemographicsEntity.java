package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class DemographicsEntity
{
    private int id;
    private int personId;
    private String dob;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zip;
    private String phone;

    public void setId (int id)
    {
        this.id = id;
    }

    public int getId ()
    {
        return id;
    }

    public void setPersonId (int personId)
    {
        this.personId = personId;
    }

    public int getPersonId ()
    {
        return personId;
    }

    public void setDOB (String dob)
    {
        this.dob = dob;
    }

    public String getDOB ()
    {
        return dob;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCity ()
    {
        return city;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getState ()
    {
        return state;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setZip (int zip)
    {
        this.zip = zip;
    }

    public int getZIP ()
    {
        return zip;
    }

    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public String getPhone ()
    {
        return phone;
    }

    @Override
    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");
        result.append(this.getClass().getName() + " Object {" + NEW_LINE);
        result.append(" Id: " + id + NEW_LINE);
        result.append(" PersonID: " + personId + NEW_LINE);
        result.append(" DOB: " + dob + NEW_LINE);
        result.append(" Street: " + street + NEW_LINE);
        result.append(" City: " + city + NEW_LINE);
        result.append(" State: " + state + NEW_LINE);
        result.append(" Country: " + country + NEW_LINE);
        result.append(" Zip: " + zip + NEW_LINE);
        result.append(" Phone: " + phone + NEW_LINE);
        result.append("}");

        return result.toString();
    }
}
