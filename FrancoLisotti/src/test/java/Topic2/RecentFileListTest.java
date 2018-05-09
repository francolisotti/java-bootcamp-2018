package Topic2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecentFileListTest {

    private RecentFileList recentFileList;

    @Before
    public void setUp() {
        recentFileList = new RecentFileList();
    }

    @Test
    public void whenListIsEmpty() {

        int result = recentFileList.getListQty();
        Assert.assertEquals(0, result);
    }

    @Test
    public void whenAFileIsOpened() throws IOException {
        String ruta = System.getProperty("user.dir");
        File archivo = new File(ruta+"/archivo1.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        recentFileList.addFile(archivo.toString());
        bw.close();

        boolean result = recentFileList.hasFile(archivo.toString());
        Assert.assertEquals(true, result);
    }

    @Test
    public void whenListHasTheElement() throws IOException {
        String ruta = System.getProperty("user.dir");
        File archivo = new File(ruta+"/archivo1.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        recentFileList.addFile(archivo.toString());

        archivo=new File(ruta+"/archivo2.txt");
        bw = new BufferedWriter(new FileWriter(archivo));
        recentFileList.addFile(archivo.toString());

        archivo=new File(ruta+"/archivo1.txt");
        bw = new BufferedWriter(new FileWriter(archivo));
        recentFileList.addFile(archivo.toString());
        bw.close();

        String result = recentFileList.getLastFile(ruta+"/archivo1.txt");
        Assert.assertEquals(archivo.toString(), result);

    }

    @Test
    public void whenListHasOneElement() throws IOException {
        //si se llena la lista (15 elementos) el mas viejo se borra
        String ruta = System.getProperty("user.dir");
        for (int i=0; i<15; i++)
        {
            File archivo = new File(ruta+"/archivo"+i+".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            recentFileList.addFile(archivo.toString());
        }


        int result = recentFileList.getListQty();
        Assert.assertEquals(15, result);


    }



}