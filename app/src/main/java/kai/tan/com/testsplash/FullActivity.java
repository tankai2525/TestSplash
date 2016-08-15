package kai.tan.com.testsplash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class FullActivity extends AppCompatActivity {

    private boolean isFulllScreen = true;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//不显示程序的标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//不显示系统的标题栏
        setContentView(R.layout.activity_full);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                isFulllScreen = !isFulllScreen;

                if (isFulllScreen) {

                    button.setText("退出全屏");

                    WindowManager.LayoutParams params = getWindow().getAttributes();

                    params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;

                    getWindow().setAttributes(params);

                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

                } else {

                    button.setText("全屏");

                    WindowManager.LayoutParams params = getWindow().getAttributes();

                    params.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);

                    getWindow().setAttributes(params);

                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

                }

            }

        });


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void go() {
        Intent intent = new Intent(FullActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
