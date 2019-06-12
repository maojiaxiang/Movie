package mao.bw.com.movie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mao.bw.com.movie.R;
import mao.bw.com.movie.bean.Login.RegistBean;
import mao.bw.com.movie.core.DataCalls;
import mao.bw.com.movie.presenter.RegistPresenter;
import mao.bw.com.movie.util.EncryptUtil;

public class RegisterActivity extends AppCompatActivity implements DataCalls<RegistBean> {

    private EditText registername,registersex,registerdate,
                      registerphone,registeremail,registerpwd;
    private Button registerbtn;
    private RegistPresenter registPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registername = findViewById(R.id.registername);
        registersex = findViewById(R.id.registersex);
        registerdate = findViewById(R.id.registerdate);
        registerphone = findViewById(R.id.registerphone);
        registeremail = findViewById(R.id.registeremail);
        registerpwd = findViewById(R.id.registerpwd);
        registerbtn = findViewById(R.id.registerbtn);
        registPresenter = new RegistPresenter(this);
        //点击注册
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取到输入框的值
                String name = registername.getText().toString();
                String sex = registersex.getText().toString();
                String birdata = registerdate.getText().toString();
                String phone = registerphone.getText().toString();
                String email = registeremail.getText().toString();
                String pwd = registerpwd.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "昵称输入不能为空", Toast.LENGTH_SHORT).show();
                }
                if (sex.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "性别输入不能为空", Toast.LENGTH_SHORT).show();
                }
                if (birdata.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "出生日期输入不能为空", Toast.LENGTH_SHORT).show();
                }
                if (phone.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "手机号输入不能为空", Toast.LENGTH_SHORT).show();
                }
                if (email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "邮箱输入不能为空", Toast.LENGTH_SHORT).show();
                }
                if (pwd.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "密码输入不能为空", Toast.LENGTH_SHORT).show();
                }
                if (pwd.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "密码不能低于六位数", Toast.LENGTH_SHORT).show();
                    return;
                }
                String encrypt = EncryptUtil.encrypt(pwd);
                String pwd2=encrypt;
                registPresenter.requestData(name,sex,birdata,phone,email,encrypt,pwd2);
            }
        });
    }

    @Override
    public void onSuccess(RegistBean result) {
        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
