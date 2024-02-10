package modelTest;

import java.io.File;
import java.net.URI;
import org.junit.Test;
import model.Billboard;
import org.junit.Assert;
import java.util.ArrayList;
import model.InfrastructureDepartment;
import ui.Main;

public class InfrastructureTest {

    @Test
    public void testSetBillboards() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 3"));
        billboards.add(new Billboard(250, 500, false, "Brand 4"));
        billboards.add(new Billboard(300, 600, true, "Brand 5"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        int sizeBillboards = id.getBillboards().size();

        Assert.assertEquals(5, sizeBillboards, 0.0);
    }

    @Test
    public void testAverageHeight() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 3"));
        billboards.add(new Billboard(250, 500, false, "Brand 4"));
        billboards.add(new Billboard(300, 600, true, "Brand 5"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        double averageHeight = id.averageHeight();

        Assert.assertEquals(400, averageHeight, 0.0);
    }

    @Test
    public void testAverageWidth() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 3"));
        billboards.add(new Billboard(250, 500, false, "Brand 4"));
        billboards.add(new Billboard(300, 600, true, "Brand 5"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        double averageWidth = id.averageWidth();

        Assert.assertEquals(200, averageWidth, 0.0);
    }

    @Test
    public void testAverageArea() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 3"));
        billboards.add(new Billboard(250, 500, false, "Brand 4"));
        billboards.add(new Billboard(300, 600, true, "Brand 5"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        double averageArea = id.averageArea();

        Assert.assertEquals(90000, averageArea, 0.0);
    }
}