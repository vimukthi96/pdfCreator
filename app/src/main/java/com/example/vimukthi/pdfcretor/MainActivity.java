package com.example.vimukthi.pdfcretor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

   /* private Button btnCreatePDF,btnViewPDF;
    public static final int REQUEST_PERM_WRITE_STORAGE =102;
    public static final int REQUEST_PERM_READ_STORAGE =103;*/

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  btnCreatePDF=(Button)findViewById(R.id.btnCreatePdf);
        btnViewPDF=(Button)findViewById(R.id.btnViewPdf);

        btnCreatePDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_PERM_WRITE_STORAGE);
                }
                else {
                    createPDF();
                }
                //createPDF();
            }
        });

        btnViewPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_PERM_READ_STORAGE);
                }
                else {
                    viewPDF();
                }
               // viewPDF();
            }
        });*/


   /* private void viewPDF() {

        String path =Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF/demo.pdf";
        Intent intent =new Intent(Intent.ACTION_VIEW);
        File file =new File(path);
        String mimeType= MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(path));
        intent.setDataAndType(Uri.fromFile(file),mimeType);
        Intent intent1=Intent.createChooser(intent,"Open With...");
        startActivity(intent);
    }

    private void createPDF() {
        Document document =new Document();


        try{
            String path= Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

            File dir =new File(path);
            if(!dir.exists()){
                dir.mkdirs();
            }
            Log.d("PDFCretor","PDF path" +path);
            File file =new File(dir ,"demo.pdf");
            FileOutputStream fileOutputStream =new FileOutputStream(file);


            PdfWriter.getInstance( document,fileOutputStream);
            document.open();

            Paragraph p1 =new Paragraph("sjdhgsadhjksld dgdhjwkqdkjhgjhfgd  wydwfgdhjwdjh");

            Font paraFont =new Font(Font.HELVETICA);
            paraFont.setSize(45);
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            p1.setFont(paraFont);

            p1.add();

            Paragraph p2 =new Paragraph("sjdhgsadhjksld dgdhjwkqdkjhgjhfgd  wydwfgdhjwdjh");

            Font paraFont2 =new Font(Font.HELVETICA);
            paraFont.setSize(45);
            p2.setAlignment(Paragraph.ALIGN_CENTER);
            p2.setFont(paraFont2);

            document.add(p2);


            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.mipmap.ic_launcher);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 , stream);
            Image myImg = Image.getInstance(stream.toByteArray());
            myImg.setAlignment(Image.MIDDLE);

            document.add(myImg);

            Phrase footerText = new Phrase("This is an example of a footer");
            HeaderFooter pdfFooter = new HeaderFooter(footerText, false);
            document.setFooter(pdfFooter);

            Toast.makeText(getApplicationContext() ,"Created",Toast.LENGTH_SHORT).show();;


        }
        catch (DocumentException de){
            Log.e("PDFCReator","DocumentException:" +de);
        }
        catch (IOException e){
            Log.e("PDFCReator","IOException:" +e);
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}*/
   private static final String FILE_NAME = "example.pdf";

    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.edit_text);
    }

    public void save(View v) {
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            mEditText.getText().clear();
            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(View v) {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            mEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

