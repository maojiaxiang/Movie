package mao.bw.com.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mao.bw.com.movie.R;
import mao.bw.com.movie.bean.Login.LoginBean;
import mao.bw.com.movie.core.DataCalls;
import mao.bw.com.movie.presenter.LoginPresenter;
import mao.bw.com.movie.util.EncryptUtil;

public class LoginActivity extends AppCompatActivity implements DataCalls<LoginBean> {

    private EditText phone,pwd;
    private ImageView eye;
    private CheckBox checkbox,checkbox2;
    private TextView register;
    private Button login;
    private ImageView weixin;
    private LoginPresenter loginPresenter;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //初始化控件
        phone = findViewById(R.id.loginname);
        pwd = findViewById(R.id.loginpwd);
        eye = findViewById(R.id.eye);
        checkbox = findViewById(R.id.remberpwd);
        checkbox2 = findViewById(R.id.rember);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        weixin = findViewById(R.id.weixin);
        loginPresenter = new LoginPresenter(this);

        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        if (sp.getBoolean("记住密码",false)){
            String phone1 = sp.getString("phone1", "");
            String pwd1 = sp.getString("pwd1", "");
            phone.setText(phone1);
            pwd.setText(pwd1);
            checkbox.setChecked(true);
        }
        //跳转注册页面
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //密码的显示和隐藏

            }
        });
        //登录按钮
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone1 = phone.getText().toString();
                String pwd1 = pwd.getText().toString();
                if (TextUtils.isEmpty(phone1)||TextUtils.isEmpty(pwd1)){
                    Toast.makeText(LoginActivity.this,"输入框不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    loginPresenter.requestData(phone1,EncryptUtil.encrypt(pwd1));
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("phone1",phone1);
                    edit.putString("pwd1",pwd1);
                    edit.putBoolean("记住密码",checkbox.isChecked());
                    edit.commit();
                }
            }
        });
    }

    @Override
    public void onSuccess(LoginBean result) {
        Intent intent =new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
