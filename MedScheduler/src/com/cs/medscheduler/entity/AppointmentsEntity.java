package com.cs.medscheduler.entity;

import java.util.Date;

@SuppressWarnings("javadoc")
public class AppointmentsEntity
{
    private int id;
    private int personId;
    private int providerId;
    private int locationId;
    private Date apptDtTm;

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
     * @return The providerId.
     */
    public int getProviderId ()
    {
        return providerId;
    }

    /**
     * @param providerId
     *            The providerId to set.
     */
    public void setProviderId (int providerId)
    {
        this.providerId = providerId;
    }

    /**
     * @return The locationId.
     */
    public int getLocationId ()
    {
        return locationId;
    }

    /**
     * @param locationId
     *            The locationId to set.
     */
    public void setLocationId (int locationId)
    {
        this.locationId = locationId;
    }

    /**
     * @return The apptDtTm.
     */
    public Date getApptDtTm ()
    {
        return apptDtTm;
    }

    /**
     * @param apptDtTm
     *            The apptDtTm to set.
     */
    public void setApptDtTm (Date apptDtTm)
    {
        this.apptDtTm = apptDtTm;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "AppointmentsEntity [id=" + id + ", personId=" + personId + ", providerId="
                + providerId + ", locationId=" + locationId + ", apptDtTm=" + apptDtTm + "]";
    }

}
