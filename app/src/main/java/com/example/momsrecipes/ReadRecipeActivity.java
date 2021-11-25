package com.example.momsrecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.momsrecipes.databinding.ActivityMainBinding;
import com.example.momsrecipes.databinding.ActivityReadRecipeBinding;

import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;

public class ReadRecipeActivity extends AppCompatActivity implements DownloadFile.Listener {

    ActivityReadRecipeBinding binding;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReadRecipeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog =new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please wait..");
        progressDialog.show();

        String url =getIntent().getStringExtra("url");

        RemotePDFViewPager remotePDFViewPager =
                new RemotePDFViewPager(ReadRecipeActivity.this, url, this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        progressDialog.dismiss();
        PDFPagerAdapter adapter = new PDFPagerAdapter(this, extractFileNameFromURL(url));
       binding.pdfViewPager.setAdapter(adapter);
//        setContentView(remotePDFViewPager);
    }
    public static String extractFileNameFromURL(String url){
        return url.substring(url.lastIndexOf('/') + 1);
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}