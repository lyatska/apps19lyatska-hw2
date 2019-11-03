package ua.edu.ucu.collections.immutable;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList emptyList;
    private ImmutableLinkedList smallList;
    private ImmutableLinkedList largeList;
    private Object[] sampleList = new Object[]{10, 11, 12};


    @Before
    public void setUp() throws Exception {
        smallList = new ImmutableLinkedList(new Object[]{1, 2, 3});
        emptyList = new ImmutableLinkedList();
        largeList = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListAdd() {
        ImmutableList actual = smallList.add(1);
        Object[] expected = new Object[]{1, 2, 3, 1};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(smallList.toArray(), new Object[]{1, 2, 3});
    }

    @Test
    public void testListAddIndex() {
        ImmutableList actual = smallList.add(1, 5);
        Object[] expected = new Object[]{1, 5, 2, 3};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(smallList.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddIndexOutOfRange() {
        ImmutableList actual = smallList.add(10, 5);
    }

    @Test
    public void testListAddAll() {
        ImmutableList actual = smallList.addAll(sampleList);
//        System.out.println(Arrays.toString);
        Object[] expected = new Object[]{1, 2, 3, 10, 11, 12};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(smallList.toArray(), new Object[]{1, 2, 3});
    }

    @Test
    public void testListAddAllIndex() {
        ImmutableList actual = smallList.addAll(1, sampleList);
        Object[] expected = new Object[]{1, 10, 11, 12, 2, 3};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(smallList.toArray(), new Object[]{1, 2, 3});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddAllIndexOutOfRange() {
        ImmutableList actual = smallList.addAll(10, sampleList);
    }

    @Test
    public void testListGet() {
        assertEquals(largeList.get(3), 4);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError() {
        largeList.get(10);
    }

    @Test
    public void testListRemove() {
        ImmutableList actual = largeList.remove(2);
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 4, 5, 6, 7, 8});
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveError() {
        ImmutableList actual = largeList.remove(-1);
    }

    @Test
    public void testListSet() {
        ImmutableList actual = largeList.set(2, 10);
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 10, 4, 5, 6, 7, 8});
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetError() {
        ImmutableList actual = largeList.set(-1, 1);
    }

    @Test
    public void testListIndexOfExists() {
        int result = largeList.indexOf(2);
        assertEquals(result, 1);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListIndexOfNotExist() {
        int result = largeList.indexOf(100);
        assertEquals(result, -1);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListSize() {
        assertEquals(largeList.size(), 8);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListSizeEmpty() {
        assertEquals(emptyList.size(), 0);
    }

    @Test
    public void testListClear() {
        ImmutableList result = largeList.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListClearEmpty() {
        ImmutableList result = emptyList.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
    }

    @Test
    public void testIsEmptyEmpty() {
        assertFalse(largeList.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals(emptyList.toString(), "");
    }

    @Test
    public void testToString() {
        assertEquals(smallList.toString(), "1, 2, 3");
    }

    @Test
    public void testListAddFirst() {
        ImmutableLinkedList actual = smallList.addFirst(1);
        Object[] expected = new Object[]{1, 1, 2, 3};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(smallList.toArray(), new Object[]{1, 2, 3});
        assertEquals(smallList.size(), 3);
        assertEquals(actual.size(), 4);
    }

    @Test
    public void testListAddFirstEmpty() {
        ImmutableLinkedList actual = emptyList.addFirst(1);
        Object[] expected = new Object[]{1};
        assertArrayEquals(actual.toArray(), expected);
        assertEquals(actual.size(), 1);
    }

    @Test
    public void testListAddLastEmpty() {
        ImmutableLinkedList actual = emptyList.addLast(1);
        Object[] expected = new Object[]{1};
        assertArrayEquals(actual.toArray(), expected);
        assertEquals(actual.size(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetFirstEmpty() {
        emptyList.getFirst();
    }

    @Test
    public void testListAddLast() {
        ImmutableLinkedList actual = smallList.addLast(1);
        Object[] expected = new Object[]{1, 2, 3, 1};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(smallList.toArray(), new Object[]{1, 2, 3});
        assertEquals(smallList.size(), 3);
        assertEquals(actual.size(), 4);
    }

    @Test
    public void testListRemoveFirst() {
        ImmutableLinkedList actual = largeList.removeFirst();
        assertArrayEquals(actual.toArray(), new Object[]{2, 3, 4, 5, 6, 7, 8});
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertEquals(largeList.size(), 8);
        assertEquals(actual.size(), 7);
    }

    @Test
    public void testListRemoveLast() {
        ImmutableLinkedList actual = largeList.removeLast();
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7});
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertEquals(largeList.size(), 8);
        assertEquals(actual.size(), 7);
    }


    @Test
    public void testListGetFirst() {
        assertEquals(largeList.getFirst(), 1);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListGetLast() {
        assertEquals(largeList.getLast(), 8);
        assertArrayEquals(largeList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetLastError() {
        emptyList.getLast();
    }

}