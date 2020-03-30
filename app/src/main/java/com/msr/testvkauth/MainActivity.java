package com.msr.testvkauth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;
import com.vk.api.sdk.auth.VKScope;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VK.login(this);
    }

    protected String str(String s) {
        return s != null ? s : "";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final MainActivity self2 = this;
        if (!VK.onActivityResult(requestCode, resultCode, data, new VKAuthCallback() {
            @Override
            public void onLogin(VKAccessToken res) {
                try {
                    Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_LONG);
                    Log.d("success getSecret", str(res.getSecret()));
                    Log.d("success getAccessToken", str(res.getAccessToken()));
                    Log.d("success getEmail", str(res.getEmail()));
                    Log.d("success getPhone", str(res.getPhone()));
                    Log.d("success getPhoneAcces", str(res.getPhoneAccessKey()));
                    Log.d("success getCreated", str(String.valueOf(res.getCreated())));
                    Log.d("success getUserId", str(String.valueOf(res.getUserId())));
                } catch (Exception ex) {
                    Log.d("success err", ex.getMessage());
                }
            }
            @Override
            public void onLoginFailed(int error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                Toast.makeText(getApplicationContext(), "1err", Toast.LENGTH_LONG);
                Log.d("fail", String.valueOf(error));
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
