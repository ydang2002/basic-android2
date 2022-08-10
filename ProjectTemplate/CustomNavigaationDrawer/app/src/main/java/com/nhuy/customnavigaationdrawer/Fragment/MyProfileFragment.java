package com.nhuy.customnavigaationdrawer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nhuy.customnavigaationdrawer.R;

public class MyProfileFragment extends Fragment {

    private View mView;
    private ImageView imageView;
    private EditText edtFullName, edtEmail;
    private Button btnUpdateProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_my_profile, container, false);

        initUi();

        return mView;
    }

    private void initUi(){
        imageView = mView.findViewById(R.id.img_avatar);
        edtFullName = mView.findViewById(R.id.edt_full_name);
        edtEmail = mView.findViewById(R.id.edt_email_profile);
        btnUpdateProfile = mView.findViewById(R.id.btn_update_profile);
    }
}
