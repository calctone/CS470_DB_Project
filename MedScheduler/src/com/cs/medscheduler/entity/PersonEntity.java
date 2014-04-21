package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class PersonEntity
{
    private int id;
    private String firstName;
    private String mInit;
    private String lastName;
    private int ssn;

    public void setId (int id)
    {
        this.id = id;
    }

    public int getId ()
    {
        return id;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setMInit (String mInit)
    {
        this.mInit = mInit;
    }

    public String getMInit ()
    {
        return mInit;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setSSN (int ssn)
    {
        this.ssn = ssn;
    }

    public int getSSN ()
    {
        return ssn;
    }

    @Override
    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        String NEW_LINE = System.getProperty("line.separator");
        result.append(this.getClass().getName() + " Object {" + NEW_LINE);
        result.append(" Id: " + id + NEW_LINE);
        result.append(" First Name: " + firstName + NEW_LINE);
        result.append(" Middle Init: " + mInit + NEW_LINE);
        result.append(" Last Name: " + lastName + NEW_LINE);
        result.append(" SSN: " + ssn + NEW_LINE);
        result.append("}");

        return result.toString();
    }
}
