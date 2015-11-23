package com.otpp.exemplar.domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString(includeFieldNames = true)
public class Telephone {

    protected enum TelephoneTypes {
        //@formatter:off
        PRIMARY_HOME_TYPE("HM1"),
        SECONDARY_HOME_TYPE("HM2"),
        PRIMARY_WORK_TYPE("WK1"),
        SECONDARY_WORK_TYPE("WK2"),
        CELL_TYPE("CEL"),
        FAX_TYPE("FAX");

        //@formatter:on

        @Getter
        String name;

        TelephoneTypes(String name) {
            this.name = name;
        }
    }

    private String entityIrn;
    private String type;
    private String routing;
    private String country;
    private String areaCode;
    private String number;
    private String extension;
    private String comment;

    public boolean isHomeNumber() {
        return TelephoneTypes.PRIMARY_HOME_TYPE.name.equals(getType()) || TelephoneTypes.SECONDARY_HOME_TYPE.name.equals(getType());
    }

    public boolean isWorkNumber() {
        return TelephoneTypes.PRIMARY_WORK_TYPE.name.equals(getType()) || TelephoneTypes.SECONDARY_WORK_TYPE.name.equals(getType());
    }

    public boolean isCellNumber() {
        return TelephoneTypes.CELL_TYPE.name.equals(getType());
    }

    public boolean isFaxNumber() {
        return TelephoneTypes.FAX_TYPE.name.equals(getType());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
        result = prime * result + ((entityIrn == null) ? 0 : entityIrn.hashCode());
        result = prime * result + ((extension == null) ? 0 : extension.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Telephone other = (Telephone) obj;
        if (areaCode == null) {
            if (other.areaCode != null) {
                return false;
            }
        }
        else if (!areaCode.equals(other.areaCode)) {
            return false;
        }
        if (entityIrn == null) {
            if (other.entityIrn != null) {
                return false;
            }
        }
        else if (!entityIrn.equals(other.entityIrn)) {
            return false;
        }
        if (extension == null) {
            if (other.extension != null) {
                return false;
            }
        }
        else if (!extension.equals(other.extension)) {
            return false;
        }
        if (number == null) {
            if (other.number != null) {
                return false;
            }
        }
        else if (!number.equals(other.number)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        }
        else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

}
