package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class LoginEntity
{
    private String userName;
    private String password;
    private int personId;

    /**
     * @return The userName.
     */
    public String getUserName ()
    {
        return userName;
    }

    /**
     * @param userName
     *            The userName to set.
     */
    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    /**
     * @return The password.
     */
    public String getPassword ()
    {
        return password;
    }

    /**
     * @param password
     *            The password to set.
     */
    public void setPassword (String password)
    {
        this.password = password;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "LoginEntity [userName=" + userName + ", password=" + password + "]";
    }

    /**
     * @return The personId.
     */
    public int getPersonId ()
    {
        return personId;
    }

    /**
     * @param personId
     *            The personId to set.
     */
    public void setPersonId (int personId)
    {
        this.personId = personId;
    }
}
