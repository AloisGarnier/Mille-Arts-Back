package fr.eql.ai113.mille.arts.back.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DecorationTest {

    private Decoration decoration;

    @BeforeEach
    public void init() throws Exception {
        decoration = new Decoration();
    }

    @AfterEach
    public void clean() throws Exception {
        decoration = null;
    }

    @Test
    public void getPriceAtDateTest() {
        /*
         The decoration is created on January 1st 2023 and costs €14.5.
         The price changes on May 1st 2023 at €15.
         */
        Price firstPrice = new Price();
        firstPrice.setAmount(14.5F);
        Price secondPrice = new Price();
        secondPrice.setAmount(15F);

        DecorationPrice firstDecorationPrice = new DecorationPrice();
        firstDecorationPrice.setPrice(firstPrice);
        firstDecorationPrice.setAdditionDate(LocalDate.of(2023, 1, 1));
        firstDecorationPrice.setWithdrawalDate(LocalDate.of(2023, 4, 30));

        DecorationPrice secondDecorationPrice = new DecorationPrice();
        secondDecorationPrice.setPrice(secondPrice);
        secondDecorationPrice.setAdditionDate(LocalDate.of(2023, 5, 1));

        List<DecorationPrice> decorationPrices = new ArrayList<>();
        decorationPrices.add(firstDecorationPrice);
        decorationPrices.add(secondDecorationPrice);
        decoration.setDecorationPrices(decorationPrices);

        /*
        Now we test 3 cases :
        - the price before January 1st
        - the price between January 1st and April 30th
        - the price after May 1st
         */
        assertThrows(NullPointerException.class, () -> decoration.getPriceAtDate(LocalDate.of(2022, 12, 12)));
        assertEquals(14.5F, decoration.getPriceAtDate(LocalDate.of(2023, 2, 24)));
        assertEquals(15F, decoration.getPriceAtDate(LocalDate.of(2023, 6, 8)));

    }
}
