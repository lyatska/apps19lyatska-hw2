package ua.edu.ucu.collections.immutable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList list1;
    private ImmutableArrayList list2;
    private ImmutableArrayList list3;
    private Object[] sampleList = new Object[]{10, 11, 12};


    @Before
    public void setUp() throws Exception {
        list2 = new ImmutableArrayList(new Object[]{10, 20, 30});
        list1 = new ImmutableArrayList();
        list3 = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListAdd() {
        ImmutableList actual = list2.add(7);
        Object[] expected = new Object[]{10, 20, 30, 7};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(list2.toArray(), new Object[]{10, 20, 30});
    }

    @Test
    public void testListAddIndex() {
        ImmutableList actual = list2.add(1, 7);
        Object[] expected = new Object[]{10, 7, 20, 30};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(list2.toArray(), new Object[]{10, 20, 30});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddIndexOutOfRange() {
        ImmutableList actual = list2.add(10, 5);
    }

    @Test
    public void testListAddAll() {
        ImmutableList actual = list2.addAll(sampleList);
        Object[] expected = new Object[]{10, 20, 30, 10, 11, 12};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(list2.toArray(), new Object[]{10, 20, 30});
    }

    @Test
    public void testListAddAllIndex() {
        ImmutableList actual = list2.addAll(1, sampleList);
        Object[] expected = new Object[]{10, 10, 11, 12, 20, 30};
        assertArrayEquals(actual.toArray(), expected);
        assertArrayEquals(list2.toArray(), new Object[]{10, 20, 30});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListAddAllIndexOutOfRange() {
        ImmutableList actual = list2.addAll(10, sampleList);
    }

    @Test
    public void testListGet() {
        assertEquals(list3.get(3), 4);
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListGetError() {
        list3.get(10);
    }

    @Test
    public void testListRemove() {
        ImmutableList actual = list3.remove(2);
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 4, 5, 6, 7, 8});
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListRemoveError() {
        ImmutableList actual = list3.remove(-1);
    }

    @Test
    public void testListSet() {
        ImmutableList actual = list3.set(2, 10);
        assertArrayEquals(actual.toArray(), new Object[]{1, 2, 10, 4, 5, 6, 7, 8});
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testListSetError() {
        ImmutableList actual = list3.set(-1, 1);
    }

    @Test
    public void testListIndexOfExists() {
        int result = list3.indexOf(2);
        assertEquals(result, 1);
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListIndexOfNotExist() {
        int result = list3.indexOf(100);
        assertEquals(result, -1);
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListSize() {
        assertEquals(list3.size(), 8);
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListSizeEmpty() {
        assertEquals(list1.size(), 0);
    }

    @Test
    public void testListClear() {
        ImmutableList result = list3.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
        assertArrayEquals(list3.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testListClearEmpty() {
        ImmutableList result = list1.clear();
        assertArrayEquals(result.toArray(), new Object[0]);
    }

    @Test
    public void testIsEmptyEmpty() {
        assertFalse(list3.isEmpty());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        assertTrue(list1.isEmpty());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals(list1.toString(), "");
    }

    @Test
    public void testToString() {
        assertEquals(list2.toString(), "10, 20, 30");
    }

}