/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.be;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author pgn
 */
public class Relation implements Serializable
{

    private final Company source;
    private final Company target;
    private String type;
    private String strength;

    public Relation(Company source, Company target, String type, String strength)
    {
        this.source = source;
        this.target = target;
        this.type = type;
        this.strength = strength;
    }

    /**
     * Get the value of strength
     *
     * @return the value of strength
     */
    public String getStrength()
    {
        return strength;
    }

    /**
     * Set the value of strength
     *
     * @param strength new value of strength
     */
    public void setStrength(String strength)
    {
        this.strength = strength;
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    public Company getSource()
    {
        return source;
    }

    public Company getTarget()
    {
        return target;
    }

    @Override
    public String toString()
    {
        return "Type:" + type + ", Strength:" + strength + " [" + source.getId() + ":" + source.getName() + " --> " + target.getId() + ":" + target.getName() + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Relation)
        {
            Relation r = (Relation) obj;
            return r.getSource().equals(this.source) && r.getTarget().equals(this.getTarget());
        } else
        {
            return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.source);
        hash = 47 * hash + Objects.hashCode(this.target);
        return hash;
    }

}
