package com.wetrade.assets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Field;

import com.wetrade.assets.enums.PurchaseOrderStatus;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public final class PurchaseOrderRequestTest {

    public final static String hash = "some hash";
    public final static String id = "some id";

    public final static String buyerId = "some buyer";
    public final static String sellerId = "some seller";
    public final static Double price = 100.00;
    public final static int units = 10;
    public final static String productDescriptor = "some product";
    public final static PurchaseOrderStatus status = PurchaseOrderStatus.APPROVED;

    @Nested
    class Constructors {

        @Test
        public void shouldCreateFullObject() {
            PurchaseOrder po = new PurchaseOrder(id, buyerId, sellerId, price, units, productDescriptor, status);
            System.out.println(po);

            assertEquals(po.getId(), id);
            assertEquals(po.getBuyerId(), buyerId);
            assertEquals(po.getSellerId(), sellerId);
            assertEquals(po.getPrice(), price);
            assertEquals(po.getUnits(), units);
            assertEquals(po.getProductDescriptor(), productDescriptor);
        }

        @Test
        public void shouldCreatePartialObject() {
            PurchaseOrder po = new PurchaseOrder(id, hash);

            assertEquals(po.getId(), id);
            assertEquals(po.getHash(), hash);

            assertNull(po.getBuyerId());
            assertNull(po.getSellerId());
            assertNull(po.getPrice());
            assertNull(po.getUnits());
            assertNull(po.getProductDescriptor());
        }
    }

    @Nested
    class Getters {

        @Test
        public void shouldGetBuyerId() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("buyerId");
                field.setAccessible(true);
                field.set(po, buyerId);

                assertEquals(po.getBuyerId(), buyerId);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldGetSellerId() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("sellerId");
                field.setAccessible(true);
                field.set(po, sellerId);

                assertEquals(po.getSellerId(), sellerId);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldGetPrice() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("price");
                field.setAccessible(true);
                field.set(po, price);

                assertEquals(po.getPrice(), price);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldGetUnits() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("units");
                field.setAccessible(true);
                field.set(po, units);

                assertEquals(po.getUnits(), units);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldGetProductDescriptor() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("productDescriptor");
                field.setAccessible(true);
                field.set(po, productDescriptor);

                assertEquals(po.getProductDescriptor(), productDescriptor);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldGetStatus() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("status");
                field.setAccessible(true);
                field.set(po, status);

                assertEquals(po.getStatus(), status);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }
    }

    @Nested
    class Setters {

        @Test
        public void shouldSetStatus() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("status");
                field.setAccessible(true);
                field.set(po, status);

                po.setStatus(PurchaseOrderStatus.CLOSED);

                assertEquals(po.getStatus(), PurchaseOrderStatus.CLOSED);
            }
            catch (Exception e) {
                fail(e.getMessage());
            }
        }

        @Test
        public void shouldFailToSetStatusWhenBackwardStep() {
            try {
                PurchaseOrder po = new PurchaseOrder(id, hash);

                Field field = PurchaseOrder.class.getDeclaredField("status");
                field.setAccessible(true);
                field.set(po, status);

                po.setStatus(PurchaseOrderStatus.PENDING);

                fail("should have failed to set status");
            }
            catch (Exception e) {
                assertEquals(e.getMessage(), "Status cannot go backwards");
            }
        }

        @Test
        public void shouldCreateTheCorrectHash() {
            PurchaseOrder po = new PurchaseOrder(id, "liam", "andy", 1.0, 1, "Widgets", PurchaseOrderStatus.PENDING);
            PurchaseOrder po1 = new PurchaseOrder(id, "liam", "andy", 1.0, 1, "Widgets", PurchaseOrderStatus.PENDING);

            assertEquals(po.getHash(), po1.getHash());
        }

        @Test
        public void shouldVerifyHashCorrectly() {
            PurchaseOrder po = new PurchaseOrder(id, buyerId, sellerId, price, units, productDescriptor, status);
            boolean isValid = PurchaseOrder.verifyHash(PurchaseOrder.class, po.getHash(), id, buyerId, sellerId, price, units, productDescriptor, PurchaseOrderStatus.valueOf("APPROVED"));
            assertTrue(isValid);
        }
    }
}
