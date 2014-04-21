package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class ProviderEntity
{
    private int id;
    private int personId;

    /**
     * @return The id.
     */
    public int getId ()
    {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId (int id)
    {
        this.id = id;
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

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "ProviderEntity [id=" + id + ", personId=" + personId + "]";
    }
}
