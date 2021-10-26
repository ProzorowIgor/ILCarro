package aplication;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

   /* @DataProvider
    public Iterator<Object[]> validDataLogin (){

        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }*/

    @DataProvider
    public Iterator<Object[]> dataLoginCVS() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line =reader.readLine();

        while (line!=null){
            String [] split = line.split(",");
            //list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1]) });
            list.add(new Object[]{split[0],split[1]});
            line = reader.readLine();
        }


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> dataRentingCar() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/infoData.txt")));
        String line =reader.readLine();

        while (line!=null){
            String [] split = line.split(",");
            //list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1]) });
            list.add(new Object[]{split[0],split[1],split[2],split[3],split[4],split[5],split[6] });
            line = reader.readLine();

        }


        return list.iterator();
    }

}
