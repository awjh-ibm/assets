package com.wetrade.assets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public final class ShipmentTest {
    
    public final static String hash = "some hash";
    public final static String id = "some id";

    public final static String purchaseOrderId = "some purchase order";
    public final static int units = 10;

    @Nested
    class Constructors {

        @Test
        public void shouldCreateFullObject() {
            Shipment shipment = new Shipment(id, purchaseOrderId, units);

            assertEquals(shipment.getId(), id);
            assertEquals(shipment.getPurchaseOrderId(), purchaseOrderId);
            assertEquals(shipment.getUnits(), units);
        }

        @Test
        public void shouldCreatePartialObject() {
            Shipment shipment = new Shipment(id, hash);

            assertEquals(shipment.getId(), id);
            assertEquals(shipment.getHash(), hash);

            assertNull(shipment.getPurchaseOrderId());
            assertNull(shipment.getUnits());
        }
    }

    @Nested
    class Getters {

        @Test
        public void shouldGetPurchaseOrderId() {
            try {
                Shipment shipment = new Shipment(id, hash);

                Field field = Shipment.class.getDeclaredField("purchaseOrderId");
                field.setAccessible(true);
                field.set(shipment, purchaseOrderId);

                assertEquals(shipment.getPurchaseOrderId(), purchaseOrderId);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldGetUnits() {
            try {
                Shipment shipment = new Shipment(id, hash);

                Field field = Shipment.class.getDeclaredField("units");
                field.setAccessible(true);
                field.set(shipment, units);

                assertEquals(shipment.getUnits(), units);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }
}