import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public  class PercolationTest {

    @Test
    void test2by2BlockedGrid() {
        Percolation p = new Percolation(2);
        Assertions.assertFalse(p.percolates());
        Assertions.assertFalse(p.isOpen(1, 1));
        Assertions.assertFalse(p.isOpen(1, 2));
        Assertions.assertFalse(p.isOpen(2, 1));
        Assertions.assertFalse(p.isOpen(2, 2));
        Assertions.assertEquals(p.numberOfOpenSites(), 0);
        Assertions.assertFalse(p.isFull(1, 1));
        Assertions.assertFalse(p.isFull(1, 2));
        Assertions.assertFalse(p.isFull(2, 1));
        Assertions.assertFalse(p.isFull(2, 2));
    }
}