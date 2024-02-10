package model;

import ui.Main;
import java.io.File;
import java.net.URI;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class InfrastructureDepartment {

    private ArrayList<Billboard> billboards;
    public static final String BILLBOARD_FILE_NAME = "BillboardDataExported.csv";

    public InfrastructureDepartment() throws Exception{
        billboards = new ArrayList<>();
        loadBillboard();
    }

    public ArrayList<Billboard> getBillboards() {
        return billboards;
    }

    public void setBillboards(ArrayList<Billboard> billboards) {
        this.billboards = billboards;
    }

    public void loadBillboard()throws Exception{

        URI resource = Main.class.getClassLoader().getResource(InfrastructureDepartment.BILLBOARD_FILE_NAME).toURI();
        File file = new File(resource);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        line = br.readLine();
        while (line!=null){
            importData(line);
            line = br.readLine();
        }

        br.close();
        fr.close();

    }

    public void importData(String fn){
        String[] columns = fn.split("\\|");
        //System.out.println(Arrays.toString(columns));
        Billboard billboard = new Billboard(Double.parseDouble(columns[0]),Double.parseDouble(columns[1]),Boolean.parseBoolean(columns[2]),columns[3]);
        billboards.add(billboard);
    }

    public String toString() {

        String text = "";

        for (int i = 0; i < billboards.size(); i++) {

            Billboard b = billboards.get(i);

            text += "\n Billboard #" + (i + 1) + "\n -" + b.getWidth() + "";
            text += "\n -" + b.getHeight();
            text += "\n -" + b.getInUse();
            text += "\n -" + b.getBrand() + "\n";

        }
        return text;
    }

    public double averageHeight() {

        double averageH = 0;
        double acumulatedHeight = 0;

        if (!billboards.isEmpty()) {
            for (int i = 0; i < billboards.size(); i++) {

                Billboard b = billboards.get(i);
                acumulatedHeight += b.getHeight();
            }

            averageH = acumulatedHeight/ billboards.size();
            return averageH;

        } else {
            System.out.println("The array is empty!");
            return 0;
        }
    }

    public double averageWidth() {

        double averageW = 0;
        double acumulatedWidth = 0;

        if (!billboards.isEmpty()) {
            for (int i = 0; i < billboards.size(); i++) {

                Billboard b = billboards.get(i);
                acumulatedWidth += b.getWidth();
            }

            averageW = acumulatedWidth/ billboards.size();
            return averageW;

        } else {
            System.out.println("The array is empty!");
            return 0;
        }
    }

    public double averageArea() {

        double averageA = 0;
        double acumulatedArea = 0;

        if (!billboards.isEmpty()) {
            for (int i = 0; i < billboards.size(); i++) {

                Billboard b = billboards.get(i);
                acumulatedArea += b.calculateArea();
            }

            averageA = acumulatedArea/ billboards.size();
            return averageA;

        } else {
            System.out.println("The array is empty!");
            return 0;
        }
    }

    public String showActiveBillboards() {

        String text = "";
        int countActive = 0;

        ArrayList<Billboard> activeBillboards = new ArrayList<>();

        for (int i = 0; i < billboards.size(); i++) {

            Billboard b = billboards.get(i);

            if(b.getInUse() == true) {

                activeBillboards.add(b);
            }
        }

        for (int i = 0; i < activeBillboards.size(); i++) {

            Billboard activeB = activeBillboards.get(i);

            text += "\n Billboard #" + (i + 1) + "\n -" + activeB.getWidth() + "";
            text += "\n -" + activeB.getHeight() + "";
            text += "\n -" + activeB.getInUse();
            text += "\n -" + activeB.getBrand() + "\n";

            countActive = i+1;
        }

        text += "\n Total active billboards: " + countActive;

        return text;
    }

    public String showBillboardsByBrand() {
        String text = "";

        ArrayList<String> uniqueBrands = new ArrayList<>();

        for (int i = 0; i < billboards.size(); i++) {
            Billboard b = billboards.get(i);
            String brand = b.getBrand();

            if (!uniqueBrands.contains(brand)) {
                uniqueBrands.add(brand);

                int count = 0;
                for (Billboard bb : billboards) {
                    if (bb.getBrand().equals(brand)) {
                        count++;
                    }
                }

                text += "\n" + brand + ": " + count + " Billboards\n";
            }
        }

        return text;
    }
}