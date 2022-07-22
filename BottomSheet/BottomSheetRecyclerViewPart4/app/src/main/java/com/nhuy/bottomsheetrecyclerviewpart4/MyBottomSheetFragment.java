package com.nhuy.bottomsheetrecyclerviewpart4;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class MyBottomSheetFragment extends BottomSheetDialogFragment {

    private List<ItemObject> mListItem;
    private IClickListener iClickListener;

    public MyBottomSheetFragment(List<ItemObject> mListItem, IClickListener iClickListener) {
        this.mListItem = mListItem;
        this.iClickListener = iClickListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_bottom_sheet, null);
        bottomSheetDialog.setContentView(view);

        RecyclerView rcvData = view.findViewById(R.id.rcv_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvData.setLayoutManager(linearLayoutManager);

        ItemAdapter itemAdapter = new ItemAdapter(mListItem, new IClickListener() {
            @Override
            public void clickItem(ItemObject itemObject) {
                iClickListener.clickItem(itemObject);
            }
        });
        rcvData.setAdapter(itemAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        return bottomSheetDialog;
    }
}
