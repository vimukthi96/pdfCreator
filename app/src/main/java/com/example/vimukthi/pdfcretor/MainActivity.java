package com.example.vimukthi.pdfcretor;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Document;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button btnCreatePDF,btnViewPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreatePDF=(Button)findViewById(R.id.btnCreatePdf);
        btnViewPDF=(Button)findViewById(R.id.btnViewPdf);

        btnCreatePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPDF();
            }
        });

        btnViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPDF();
            }
        });
    }

    private void viewPDF() {
    }

    private void createPDF() {
        Document doc =new Document();

        try{
            String path= Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

            File dir =new File(path);
            if(!dir.exists()){
                dir.mkdirs();
            }
            Log.d("PDFCretor","PDF path" +path);
            File file =new File(dir ,"demo.pdf");
            FileOutputStream fileOutputStream =new FileOutputStream(file);

            PdfWriter.getIns
        }
        catch (Exception e){

        }
    }
}
