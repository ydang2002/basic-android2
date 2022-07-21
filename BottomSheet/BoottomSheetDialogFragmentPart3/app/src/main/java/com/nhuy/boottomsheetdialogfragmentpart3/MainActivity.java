package com.nhuy.boottomsheetdialogfragmentpart3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nhuy.boottomsheetdialogfragmentpart3.model.MyBottomSheetDialogFragment;
import com.nhuy.boottomsheetdialogfragmentpart3.model.Order;
import com.nhuy.boottomsheetdialogfragmentpart3.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenBottomSheet = findViewById(R.id.btn_open_bottom_sheet);
        btnOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOpenBottomSheetDialogFragment();
            }
        });
    }

    private void clickOpenBottomSheetDialogFragment() {
        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product("Bim Bim 1x5"));
        listProduct.add(new Product("Xuc xich 1x5"));
        listProduct.add(new Product("Tra Sua 1x5"));

        Order order = new Order("500 VND", listProduct, "Thanh Pho HCM");
        MyBottomSheetDialogFragment sheetDialogFragment = MyBottomSheetDialogFragment.newInstance(order);
        sheetDialogFragment.show(getSupportFragmentManager(), sheetDialogFragment.getTag());
        sheetDialogFragment.setCancelable(false);
    }
}