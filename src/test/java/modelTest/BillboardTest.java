package modelTest;

import org.junit.Test;
import model.Billboard;
import org.junit.Assert;

public class BillboardTest {

    @Test
    public void testWidth(){
        Billboard obj = new Billboard(200, 50, true, "Brand");
        double width = obj.getWidth();
        Assert.assertEquals(200, width, 0.0);
    }

    @Test
    public void testHeight(){
        Billboard obj = new Billboard(150, 60, false, "Brand");
        double height = obj.getHeight();
        Assert.assertEquals(60, height, 0.0);
    }

    @Test
    public void testInUse(){
        Billboard obj = new Billboard(300, 30, true, "Brand");
        boolean state = obj.getInUse();
        Assert.assertTrue(state);
    }

    @Test
    public void testBrand(){
        Billboard obj = new Billboard(100, 90, false, "Example Brand");
        String brand = obj.getBrand();
        Assert.assertEquals("Example Brand", brand);
    }

    @Test
    public void testArea(){
        Billboard obj = new Billboard(100, 40, true, "Brand");
        double area = obj.calculateArea();
        Assert.assertEquals(4000.0, area, 0.0);
    }
}
