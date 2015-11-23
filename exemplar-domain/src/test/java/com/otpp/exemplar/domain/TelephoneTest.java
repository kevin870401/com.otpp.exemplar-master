package com.otpp.exemplar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.otpp.exemplar.domain.Telephone.TelephoneTypes;

@Test
public class TelephoneTest {

    private Telephone phone = new Telephone();

    public void whenTypeIsNull_ExpectIsHomeNumberToBeFalse() {
        phone.setType(null);
        assertThat(phone.isHomeNumber()).isFalse();
    }

    public void whenTypeIsEmptyString_ExpectIsHomeNumberToBeFalse() {
        phone.setType("");
        assertThat(phone.isHomeNumber()).isFalse();
    }

    public void whenTypeIsNotAHomeType_ExpectIsHomeNumberToBeFalse() {
        phone.setType(TelephoneTypes.CELL_TYPE.name);
        assertThat(phone.isHomeNumber()).isFalse();
    }

    public void whenTypeIsPrimaryHomeType_ExpectIsHomeNumberToBeTrue() {
        phone.setType(TelephoneTypes.PRIMARY_HOME_TYPE.name);
        assertThat(phone.isHomeNumber()).isTrue();
    }

    public void whenTypeIsSecondaryHomeType_ExpectIsHomeNumberToBeTrue() {
        phone.setType(TelephoneTypes.SECONDARY_HOME_TYPE.name);
        assertThat(phone.isHomeNumber()).isTrue();
    }

    public void whenTypeIsNull_ExpectIsWorkNumberToBeFalse() {
        phone.setType(null);
        assertThat(phone.isWorkNumber()).isFalse();
    }

    public void whenTypeIsEmptyString_ExpectIsWorkNumberToBeFalse() {
        phone.setType("");
        assertThat(phone.isWorkNumber()).isFalse();
    }

    public void whenTypeIsNotAWorkType_ExpectIsWorkNumberToBeFalse() {
        phone.setType(TelephoneTypes.CELL_TYPE.name);
        assertThat(phone.isWorkNumber()).isFalse();
    }

    public void whenTypeIsPrimaryWorkType_ExpectIsWorkNumberToBeTrue() {
        phone.setType(TelephoneTypes.PRIMARY_WORK_TYPE.name);
        assertThat(phone.isWorkNumber()).isTrue();
    }

    public void whenTypeIsSecondaryWorkType_ExpectIsWorkNumberToBeTrue() {
        phone.setType(TelephoneTypes.SECONDARY_WORK_TYPE.name);
        assertThat(phone.isWorkNumber()).isTrue();
    }

    public void whenTypeIsNull_ExpectIsCellNumberToBeFalse() {
        phone.setType(null);
        assertThat(phone.isCellNumber()).isFalse();
    }

    public void whenTypeIsEmptyString_ExpectIsCellNumberToBeFalse() {
        phone.setType("");
        assertThat(phone.isCellNumber()).isFalse();
    }

    public void whenTypeIsNotCellNumber_ExpectIsCellNumberToBeFalse() {
        phone.setType(TelephoneTypes.FAX_TYPE.name);
        assertThat(phone.isCellNumber()).isFalse();
    }

    public void whenTypeIsCellNumberType_ExpectIsCellNumberToBeTrue() {
        phone.setType(TelephoneTypes.CELL_TYPE.name);
        assertThat(phone.isCellNumber()).isTrue();
    }

    public void whenTypeIsNull_ExpectIsFaxNumberToBeFalse() {
        phone.setType(null);
        assertThat(phone.isFaxNumber()).isFalse();
    }

    public void whenTypeIsEmptyString_ExpectIsFaxNumberToBeFalse() {
        phone.setType("");
        assertThat(phone.isFaxNumber()).isFalse();
    }

    public void whenTypeIsNotFaxNumber_ExpectIsFaxNumberToBeFalse() {
        phone.setType(TelephoneTypes.CELL_TYPE.name);
        assertThat(phone.isFaxNumber()).isFalse();
    }

    public void whenTypeIsFaxNumberType_ExpectIsFaxNumberToBeTrue() {
        phone.setType(TelephoneTypes.FAX_TYPE.name);
        assertThat(phone.isFaxNumber()).isTrue();
    }
}
