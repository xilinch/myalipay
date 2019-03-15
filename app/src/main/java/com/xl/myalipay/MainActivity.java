package com.xl.myalipay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * 返回信息说明
     */
    private TextView tv_info;

    /**
     * 订单
     */
    private Button btn_oder;

    /**
     * 支付
     */
    private Button btn_pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_info = findViewById(R.id.tv_info);
        btn_oder = findViewById(R.id.btn_oder);
        btn_pay = findViewById(R.id.btn_pay);
        btn_oder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOder();
            }
        });

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay();
            }
        });
    }


    String key = "tv&ZuaqD1s_WRSzGfeYlM$9EArQy:&7o";
    private void getOder(){
        String url = "http://120.24.174.61/sdk/pay/";

        OkHttpClient okHttpClient = new OkHttpClient();
        String gameid = "1000044";
        String dsid = "1";
        String deviceno = "900150983cd24fb0d6963f7d28e17f72";
        String referer = "37wan";
        String partner = "1";
        String uid = "123456789";
        String passport = "apollosaar";
        String money = "1.01";
        String payway = "alipay";
        String role = "aa";

        String time = String.valueOf(System.currentTimeMillis());
        String sign = MD5Util.md5(gameid+ deviceno + referer + partner + passport + time + key).toLowerCase();
        RequestBody requestBody = new FormBody.Builder()
                .add("gameid", gameid)
                .add("dsid", dsid)
                .add("deviceno", deviceno)
                .add("referer", referer)
                .add("partner", partner)
                .add("uid", uid)
                .add("passport", passport)
                .add("money", money)
                .add("payway", payway)
                .add("role", role)
                .add("time", time)
                .add("sign", sign)
                .build();
        final Request request = new Request.Builder().url(url).post(requestBody).build();
        try {
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    tv_info.setText(response.body().string());
                }
            });

        } catch (Exception exception){
            exception.printStackTrace();
        } finally {

        }


    }

    private void pay(){

    }


    private String getSign(){
        ///strtolower(md5($gameid.$deviceno.$referer.$partner.$passport.$password.$time.$REG_KEY));
        String sign = "";


        return sign;

    }

}
