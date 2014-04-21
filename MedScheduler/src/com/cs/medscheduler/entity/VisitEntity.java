package com.cs.medscheduler.entity;

import java.util.Date;

@SuppressWarnings("javadoc")
public class VisitEntity
{
    private int id;
    private int providerId;
    private int personId;
    private String reasonForVisit;
    private Date visitDtTm;

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
     * @return The reasonForVisit.
     */
    public String getReasonForVisit ()
    {
        return reasonForVisit;
    }

    /**
     * @param reasonForVisit
     *            The reasonForVisit to set.
     */
    public void setReasonForVisit (String reasonForVisit)
    {
        this.reasonForVisit = reasonForVisit;
    }

    /**
     * @return The visitDtTm.
     */
    public Date getVisitDtTm ()
    {
        return visitDtTm;
    }

    /**
     * @param visitDtTm
     *            The visitDtTm to set.
     */
    public void setVisitDtTm (Date visitDtTm)
    {
        this.visitDtTm = visitDtTm;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "VisitEntity [id=" + id + ", providerId=" + providerId + ", personId=" + personId
                + ", reasonForVisit=" + reasonForVisit + ", visitDtTm=" + visitDtTm + "]";
    }

}
