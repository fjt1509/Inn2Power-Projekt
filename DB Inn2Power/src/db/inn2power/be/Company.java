/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.inn2power.be;

import java.io.Serializable;

/**
 *
 * @author pgn
 */
public class Company implements Serializable
{

    private final int id;
    private String name;
    private String country;
    private String address;
    private String website;
    private String supplyChainCategoriy;
    private String buisnessRole;
    private double lat;
    private double lng;
    private int isSME;

    /**
     * Constructs a company object
     *
     * @param id
     * @param name
     * @param country
     * @param address
     * @param website
     * @param supplyChainCategoriy
     * @param buisnessRole
     * @param lat
     * @param lng
     * @param isSME
     */
    public Company(int id, String name, String country, String address, String website, String supplyChainCategoriy, String buisnessRole, double lat, double lng, int isSME)
    {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.website = website;
        this.supplyChainCategoriy = supplyChainCategoriy;
        this.buisnessRole = buisnessRole;
        this.lat = lat;
        this.lng = lng;
        this.isSME = isSME;
    }

    /**
     * Get the value of isSME
     *
     * @return the value of isSME, -1=unknown, 0=not an SME, and 1=is an SME.
     */
    public int getIsSME()
    {
        return isSME;
    }

    /**
     * Set the value of isSME
     *
     * @param isSME new value of isSME
     */
    public void setIsSME(int isSME) 
    {
        if (isSME < -1 || isSME > 1)
        {
            throw new RuntimeException("Valid values for isSME is -1,0,1");
        }
        this.isSME = isSME;
    }

    /**
     * Get the value of lng
     *
     * @return the value of lng
     */
    public double getLng()
    {
        return lng;
    }

    /**
     * Set the value of lng
     *
     * @param lng new value of lng
     */
    public void setLng(double lng)
    {
        this.lng = lng;
    }

    /**
     * Get the value of lat
     *
     * @return the value of lat
     */
    public double getLat()
    {
        return lat;
    }

    /**
     * Set the value of lat
     *
     * @param lat new value of lat
     */
    public void setLat(double lat)
    {
        this.lat = lat;
    }

    /**
     * Get the value of buisnessRole
     *
     * @return the value of buisnessRole
     */
    public String getBuisnessRole()
    {
        return buisnessRole;
    }

    /**
     * Set the value of buisnessRole
     *
     * @param buisnessRole new value of buisnessRole
     */
    public void setBuisnessRole(String buisnessRole)
    {
        this.buisnessRole = buisnessRole;
    }

    /**
     * Get the value of supplyChainCategoriy
     *
     * @return the value of supplyChainCategoriy
     */
    public String getSupplyChainCategoriy()
    {
        return supplyChainCategoriy;
    }

    /**
     * Set the value of supplyChainCategoriy
     *
     * @param supplyChainCategoriy new value of supplyChainCategoriy
     */
    public void setSupplyChainCategoriy(String supplyChainCategoriy)
    {
        this.supplyChainCategoriy = supplyChainCategoriy;
    }

    /**
     * Get the value of website
     *
     * @return the value of website
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     * Set the value of website
     *
     * @param website new value of website
     */
    public void setWebsite(String website)
    {
        this.website = website;
    }

    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Get the value of country
     *
     * @return the value of country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * Set the value of country
     *
     * @param country new value of country
     */
    public void setCountry(String country)
    {
        this.country = country;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Company)
        {
            Company other = (Company) obj;
            return other.getId() == this.id;
        } else
        {
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public String toString()
    {
        return "Company{" + "id=" + id + ", name=" + name + ", country=" + country + ", address=" + address + ", website=" + website + ", supplyChainCategoriy=" + supplyChainCategoriy + ", buisnessRole=" + buisnessRole + ", lat=" + lat + ", lng=" + lng + ", isSME=" + isSME + '}';
    }

}
