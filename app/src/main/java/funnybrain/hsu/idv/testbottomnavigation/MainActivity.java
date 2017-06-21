package funnybrain.hsu.idv.testbottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_reward:
                    mTextMessage.setText(R.string.title_reward);
                    return true;
                case R.id.navigation_store:
                    mTextMessage.setText(R.string.title_store);
                    return true;
                case R.id.navigation_signin:
                    mTextMessage.setText(R.string.title_signin);
                    return true;
                case R.id.navigation_my:
                    mTextMessage.setText(R.string.title_my);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomBar);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void setActionBar() {

    }

    @Override
    public void findView() {

    }

    @Override
    public void initView() {

    }

}
