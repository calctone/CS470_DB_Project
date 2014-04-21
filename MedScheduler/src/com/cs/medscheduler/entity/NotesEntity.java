package com.cs.medscheduler.entity;

@SuppressWarnings("javadoc")
public class NotesEntity
{
    private int id;
    private int providerId;
    private String noteText;

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
     * @return The noteText.
     */
    public String getNoteText ()
    {
        return noteText;
    }

    /**
     * @param noteText
     *            The noteText to set.
     */
    public void setNoteText (String noteText)
    {
        this.noteText = noteText;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        return "NotesEntity [id=" + id + ", providerId=" + providerId + ", noteText=" + noteText
                + "]";
    }

}
