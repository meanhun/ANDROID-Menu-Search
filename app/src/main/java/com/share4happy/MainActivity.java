package com.share4happy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lv_tinhthanh;
    ArrayAdapter<String> adapter;
    ArrayList<String> dsTinhThanh = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        lv_tinhthanh = findViewById(R.id.lv_tinhthanh);
        dsTinhThanh.addAll(Arrays.asList(getResources().getStringArray(R.array.arrtinhthanh)));
        adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,dsTinhThanh
        );
        lv_tinhthanh.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tinhthanh,menu);
        // Lấy mennu
        MenuItem menuItem = menu.findItem(R.id.menusearch);
        // lấy search view ra
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            //Tìm kiếm tới đâu sử lý tới đó
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}