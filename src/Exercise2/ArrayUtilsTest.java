package Exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    public void testProduct() {
        int[][] nums = {{1, 2, 3}, {0, 0}, {12, 9, 33, 1}, {6, 2}};
        int[] expected = {6, 0, 297, 12};

        for (int i = 0; i < nums.length; i++) {
            int ans = Ex2.maxAdjacentProduct(nums[i]);

            assertEquals(expected[i], ans);
        }
    }

    @Test
    public void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> Ex2.maxAdjacentProduct(null));
    }


    @Test
    public void testSmallArray() {
        int[] arr1 = {5};
        int[] arr2 = {};

        assertThrows(IllegalArgumentException.class, () -> Ex2.maxAdjacentProduct(arr1));
        assertThrows(IllegalArgumentException.class, () -> Ex2.maxAdjacentProduct(arr2));
    }

    @Test
    public void testNegativeProduct() {
        int nums[][] = {{-1, -2}, {-1, -4, -44, -3, -49}, {-6, -6, -6}};
        int expected[] = {2, 176, 36};

        for (int i = 0; i < nums.length; i++) {
            int ans = Ex2.maxAdjacentProduct(nums[i]);

            assertEquals(expected[i], ans);
        }
    }

    @Test
    public void testNegativeProductWithZero() {
        int nums[][] = {{-5, -2, 0, -1}, {-1, 0, -1, 0}, {0, 0}};
        int expected[] = {10, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            int ans = Ex2.maxAdjacentProduct(nums[i]);

            assertEquals(expected[i], ans);
        }
    }

    @Test
    public void test2Elements() {

        int nums[][] = {{1, 2}, {-1, -2}, {0, 0}};
        int expected[] = {2, 2, 0};

        for (int i = 0; i < nums.length; i++) {
            int ans = Ex2.maxAdjacentProduct(nums[i]);

            assertEquals(expected[i], ans);
        }
    }
}

