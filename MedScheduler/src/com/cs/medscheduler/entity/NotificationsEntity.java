package com.cs.medscheduler.entity;

import java.util.Date;

@SuppressWarnings("javadoc")
public class NotificationsEntity
{
    private int id;
    private int providerId;
    private String alertText;
    private Date notifDtTm;

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
     * @return The alertText.
     */
    public String getAlertText ()
    {
        return alertText;
    }

    /**
     * @param alertText
     *            The alertText to set.
     */
    public void setAlertText (String alertText)
    {
        this.alertText = alertText;
    }

    /**
     * @return The notifDtTm.
     */
    public Date getNotifDtTm ()
    {
        return notifDtTm;
    }

    /**
     * @param notifDtTm
     *            The notifDtTm to set.
     */
    public void setNotifDtTm (Date notifDtTm)
    {
        this.notifDtTm = notifDtTm;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "NotificationsEntity [id=" + id + ", providerId=" + providerId + ", alertText="
                + alertText + ", notifDtTm=" + notifDtTm + "]";
    }

}
