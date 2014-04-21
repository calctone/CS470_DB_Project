package com.cs.medscheduler.entity;

import java.util.Date;

@SuppressWarnings("javadoc")
public class ConditionsEntity
{
    private int id;
    private int personId;
    private String name;
    private String type;
    private String classification;
    private Date onsetDtTm;
    private String country;
    private int zip;
    private int phone;

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
     * @return The name.
     */
    public String getName ()
    {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName (String name)
    {
        this.name = name;
    }

    /**
     * @return The type.
     */
    public String getType ()
    {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType (String type)
    {
        this.type = type;
    }

    /**
     * @return The classification.
     */
    public String getClassification ()
    {
        return classification;
    }

    /**
     * @param classification
     *            The classification to set.
     */
    public void setClassification (String classification)
    {
        this.classification = classification;
    }

    /**
     * @return The onsetDtTm.
     */
    public Date getOnsetDtTm ()
    {
        return onsetDtTm;
    }

    /**
     * @param onsetDtTm
     *            The onsetDtTm to set.
     */
    public void setOnsetDtTm (Date onsetDtTm)
    {
        this.onsetDtTm = onsetDtTm;
    }

    /**
     * @return The country.
     */
    public String getCountry ()
    {
        return country;
    }

    /**
     * @param country
     *            The country to set.
     */
    public void setCountry (String country)
    {
        this.country = country;
    }

    /**
     * @return The zip.
     */
    public int getZip ()
    {
        return zip;
    }

    /**
     * @param zip
     *            The zip to set.
     */
    public void setZip (int zip)
    {
        this.zip = zip;
    }

    /**
     * @return The phone.
     */
    public int getPhone ()
    {
        return phone;
    }

    /**
     * @param phone
     *            The phone to set.
     */
    public void setPhone (int phone)
    {
        this.phone = phone;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "ConditionsEntity [id=" + id + ", personId=" + personId + ", name=" + name
                + ", type=" + type + ", classification=" + classification + ", onsetDtTm="
                + onsetDtTm + ", country=" + country + ", zip=" + zip + ", phone=" + phone + "]";
    }
}
