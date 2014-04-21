package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class ServicesEntity
{
    private int id;
    private int providerId;
    private String description;
    private int cost;

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
     * @return The description.
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * @param description
     *            The description to set.
     */
    public void setDescription (String description)
    {
        this.description = description;
    }

    /**
     * @return The cost.
     */
    public int getCost ()
    {
        return cost;
    }

    /**
     * @param cost
     *            The cost to set.
     */
    public void setCost (int cost)
    {
        this.cost = cost;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "ServicesEntity [id=" + id + ", providerId=" + providerId + ", description="
                + description + ", cost=" + cost + "]";
    }

}
