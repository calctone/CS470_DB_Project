package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class LocationEntity
{
    private int providerId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String country;
    private int zip;
    private int phone;

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
     * @return The street.
     */
    public String getStreet ()
    {
        return street;
    }

    /**
     * @param street
     *            The street to set.
     */
    public void setStreet (String street)
    {
        this.street = street;
    }

    /**
     * @return The city.
     */
    public String getCity ()
    {
        return city;
    }

    /**
     * @param city
     *            The city to set.
     */
    public void setCity (String city)
    {
        this.city = city;
    }

    /**
     * @return The state.
     */
    public String getState ()
    {
        return state;
    }

    /**
     * @param state
     *            The state to set.
     */
    public void setState (String state)
    {
        this.state = state;
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
        return "LocationEntity [providerId=" + providerId + ", name=" + name + ", street=" + street
                + ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip
                + ", phone=" + phone + "]";
    }

}
