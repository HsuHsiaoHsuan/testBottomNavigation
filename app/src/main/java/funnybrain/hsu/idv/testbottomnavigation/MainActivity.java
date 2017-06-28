package funnybrain.hsu.idv.testbottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import funnybrain.hsu.idv.testbottomnavigation.home.HomeFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.message) TextView mTextMessage;
    @BindView(R.id.navigation) BottomNavigationView mNavigation;

    private FragmentManager mFragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    ft.replace(R.id.content, HomeFragment.newInstance());
                    ft.commit();
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
        ButterKnife.bind(this);

        mFragmentManager = getSupportFragmentManager();

        BottomNavigationViewHelper.removeShiftMode(mNavigation);
        mNavigation.getMenu().getItem(0).setChecked(true);
        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void setActionBar() {
        setActivityTitle("國泰優惠");
    }

    @Override
    public void findView() {

    }

    @Override
    public void initView() {

    }

}
