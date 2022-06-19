package com.nhuy.lesson19recyclerviewchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editMessage;
    private Button btnSend;

    private RecyclerView rcvMessage;
    private List<Message> mListMessage;
    private  MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMessage = findViewById(R.id.edt_message);
        btnSend = findViewById(R.id.btn_send);
        rcvMessage = findViewById(R.id.rcv_message);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMessage.setLayoutManager(linearLayoutManager);

        mListMessage = new ArrayList<>();
        messageAdapter = new MessageAdapter();
        messageAdapter.setData(mListMessage);

        rcvMessage.setAdapter(messageAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        editMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkKeybord();
            }
        });
    }

    private void sendMessage() {
        //xóa kí tự khoảng trắng đầu và cuối trong editText
        String strMessage = editMessage.getText().toString().trim();
        if(TextUtils.isEmpty(strMessage)){
            return;
        }

        mListMessage.add(new Message(strMessage));
        messageAdapter.notifyDataSetChanged();
        rcvMessage.scrollToPosition(mListMessage.size()-1);
        //reset
        editMessage.setText("");
    }
    //check khi nào bàn phím xuất hiện, thì dòng chat cuối cùng sẽ xuất hiện trên bàn phím và không bị che khuất
    private void checkKeybord(){
    final View activityRootView = findViewById(R.id.activityRoot);
    activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            Rect r = new Rect();
            activityRootView.getWindowVisibleDisplayFrame(r);

            int heightDiff = activityRootView.getRootView().getHeight()-r.height();
            if(heightDiff > 0.25*activityRootView.getRootView().getHeight()){
                if(mListMessage.size() > 0){
                    rcvMessage.scrollToPosition(mListMessage.size() - 1);
                    activityRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    });
    }
    //14:26
}