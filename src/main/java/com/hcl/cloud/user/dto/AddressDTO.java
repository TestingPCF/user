package com.hcl.cloud.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * com.hcl.cloud.user.DTO. abhishek_sin
 */
@JsonIgnoreProperties("id")
public class AddressDTO {
    /**
     * id.
     */
    private long id;
    /**
     * address.
     */
    private String address;
    /**	
     * city.
     */
    private String city;
    /**
     * country.
     */
    private String country;
    /**
     * state.
     */
    private String state;
    /**
     * pincode.
     */
    private int pincode;
    /**
     * addressType.
     */
    private String addressType;

    /**
     *
     * @return tag the id.
     */
    public final long getId() {
        return id;
    }

    /**
     *
     * @param ids
     * the ids to set.
     */
    public void setId(final long ids) {
        this.id = ids;
    }

    /**
     *
     * @return tag the addressType.
     */
    public final String getAddressType() {
        return addressType;
    }

    /**
     *
     * @param addrType
     * the addrType to set.
     */
    public void setAddressType(final String addrType) {
        this.addressType = addrType;
    }

    /**
     *
     * @param pcode
     * the pcode to set.
     */
    public final void setPincode(final int pcode) {
        this.pincode = pcode;
    }

    /**
     * Default constructor .
     */
    public AddressDTO() {

    }

    /**
     * @return tag the state.
     */
    public final String getState() {
        return state;
    }

    /**
     * @param st
     * the state to set.
     */
    public void setState(final String st) {
        this.state = st;
    }

    /**
     * @return tag the pin.
     */
    public final int getPincode() {
        return pincode;
    }

     /**
     * @return the address.
     */
    public final String getAddress() {
        return address;
    }

    /**
     * @param addr
     * the addr to set.
     */
    public void setAddress(final String addr) {
        this.address = addr;
    }

    /**
     * @return tag the city.
     */
    public final String getCity() {
        return city;
    }

    /**
     * @param cty
     *  the cty to set.
     */
    public void setCity(final String cty) {
        this.city = cty;
    }

    /**
     * @return the country.
     */
    public final String getCountry() {
        return country;
    }

    /**
     * @param cntry
     * the cntry to set.
     */
    public void setCountry(final String cntry) {
        this.country = cntry;
    }

}
