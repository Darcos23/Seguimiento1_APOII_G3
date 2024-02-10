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
    public void testGetBillboards() throws Exception {
        InfrastructureDepartment id = new InfrastructureDepartment();
        ArrayList<Billboard> actualBillboards = id.getBillboards();

        Assert.assertEquals(100, actualBillboards.size(), 0.0);
    }

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
    public void testToString() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 3"));
        billboards.add(new Billboard(250, 500, false, "Brand 4"));
        billboards.add(new Billboard(300, 600, true, "Brand 5"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        String expectedText = "\n Billboard #1\n -100.0\n -200.0\n -true\n -Brand 1\n" +
                "\n Billboard #2\n -150.0\n -300.0\n -false\n -Brand 2\n" +
                "\n Billboard #3\n -200.0\n -400.0\n -true\n -Brand 3\n" +
                "\n Billboard #4\n -250.0\n -500.0\n -false\n -Brand 4\n" +
                "\n Billboard #5\n -300.0\n -600.0\n -true\n -Brand 5\n";

        String actualText = id.toString();
        Assert.assertEquals(expectedText, actualText);
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

    @Test
    public void testShowActiveBillboards() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 2"));
        billboards.add(new Billboard(250, 500, false, "Brand 3"));
        billboards.add(new Billboard(300, 600, true, "Brand 2"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        String expectedText = "\n Billboard #1\n -100.0\n -200.0\n -true\n -Brand 1\n" +
                "\n Billboard #2\n -200.0\n -400.0\n -true\n -Brand 2\n" +
                "\n Billboard #3\n -300.0\n -600.0\n -true\n -Brand 2\n" +
                "\n Total active billboards: 3";

        String actualText = id.showActiveBillboards();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void testShowBillboardsByBrand() throws Exception {
        ArrayList<Billboard> billboards = new ArrayList<>();

        billboards.add(new Billboard(100, 200, true, "Brand 1"));
        billboards.add(new Billboard(150, 300, false, "Brand 2"));
        billboards.add(new Billboard(200, 400, true, "Brand 2"));
        billboards.add(new Billboard(250, 500, false, "Brand 3"));
        billboards.add(new Billboard(300, 600, true, "Brand 2"));

        InfrastructureDepartment id = new InfrastructureDepartment();
        id.setBillboards(billboards);

        String expectedText = "\nBrand 1: 1 Billboards\n" + "\nBrand 2: 3 Billboards\n" + "\nBrand 3: 1 Billboards\n";

        String actualText = id.showBillboardsByBrand();
        Assert.assertEquals(expectedText, actualText);
    }

}