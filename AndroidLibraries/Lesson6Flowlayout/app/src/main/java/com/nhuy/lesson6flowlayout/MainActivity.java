package com.nhuy.lesson6flowlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wefika.flowlayout.FlowLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FlowLayout mFlowLayout;
    private ArrayList<Keyword> mListKeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlowLayout = findViewById(R.id.flow_layout);

        //innit data
        initData();
        //setData
        setData();
    }

    private void initData(){
        mListKeyword = new ArrayList<>();
        mListKeyword.add(new Keyword(1, "Nhu Y"));
        mListKeyword.add(new Keyword(2, "Nhu Y dang huynh nghuye ha"));
        mListKeyword.add(new Keyword(3, "Nhu Y hai ba"));
        mListKeyword.add(new Keyword(4, "Nhu Y"));
        mListKeyword.add(new Keyword(5, "Nhu Y hai ba bốn "));
    }

    private void setData(){
        if(mFlowLayout == null){
            return;
        }
        mFlowLayout.removeAllViews();
        //!= null và có phần tử không được rỗng
        if(mListKeyword != null && mListKeyword.size() > 0){
            for (int i = 0; i < mListKeyword.size(); i++){
                Keyword keyword = mListKeyword.get(i);
                TextView textView = new TextView(this);
                FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT,
                        FlowLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 10, 20, 10);
                textView.setLayoutParams(params);
                textView.setId(keyword.getId());
                textView.setText(keyword.getName());
                textView.setPadding(30, 10, 30, 10 );
                textView.setBackgroundResource(R.drawable.custom_layout_item);
                textView.setTextColor(getResources().getColor(R.color.black));
                // set Listener
                textView.setOnClickListener(this);
                mFlowLayout.addView(textView);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 1:
                Toast.makeText(this, "Click 1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Click 2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Click 3", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "Click 4", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this, "Click 5", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}