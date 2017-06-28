package funnybrain.hsu.idv.testbottomnavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import funnybrain.hsu.idv.testbottomnavigation.widget.fancycoverflow.FancyCoverFlow;
import funnybrain.hsu.idv.testbottomnavigation.widget.fancycoverflow.FancyCoverFlowAdapter;

public abstract class BaseActivity extends AppCompatActivity {

    private static final int INVALID_MENU = -1;
    private int menuRes = INVALID_MENU;

    private LinearLayout mContentView = null;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private Toolbar.OnMenuItemClickListener onMenuItemClickListener;
    private BottomNavigationView mNavigationView;
    private FancyCoverFlow mCardCoverFlow;

    // 對於每一個 View 做初始化設定的動作
    public abstract void initView();
    public abstract void setActionBar();
    public abstract void setNavigation();
    public abstract void setCardCoverFlow();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (mContentView == null && R.layout.activity_base == layoutResID) {
            super.setContentView(R.layout.activity_base);
            mContentView = (LinearLayout) findViewById(R.id.layout_content);
            mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
            mContentView.removeAllViews();
        } else if (layoutResID != R.layout.activity_base) {
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            mContentView.addView(addView, new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            initView();

            // MUST DON'T CHANGE THE SEQUENCE
            initActionBar();
            setActionBar();
            afterSettingActionBar();

            initNavigation();
            setNavigation();

            initCardCoverFlow();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuRes != INVALID_MENU) {
            getMenuInflater().inflate(menuRes, menu);
        }
        return true;
    }

    // ActionBar >>>>>>>>>>>>>>>>
    public void initActionBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setNavigationIcon(R.mipmap.btn_back);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("");
        mToolbar.setEnabled(true);
    }

    private void afterSettingActionBar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            // 隱藏標題欄
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        // TODO 讓子類別呼叫 setOnNavigationClickListener
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        mToolbar.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setActivityTitle(String text) {
        mToolbarTitle.setText(text);
    }

    public void setLeftImg(@DrawableRes int imgId) {}

    public void setRightImg(@DrawableRes int imgId) {}

    public void setNavigationImg(@DrawableRes int imgId) {
        mToolbar.setNavigationIcon(imgId);
    }

    public void setOnNavigationClickListener(View.OnClickListener onNavigationClickListener) {
        mToolbar.setNavigationOnClickListener(onNavigationClickListener);
    }
    // <<<<<<<<<<<<<<<< ActionBar

    // BottomNavigationView >>>>>>>>>>>>>>>>
    public void initNavigation() {
        mNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(mNavigationView);
    }

    public void setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener listener) {
        mNavigationView.setOnNavigationItemSelectedListener(listener);
    }

    public void setDefaultSelectedNavigationItem(int position) {
        mNavigationView.getMenu().getItem(position).setChecked(true);
    }

    public void setNavigationVisibility(int visibility) {
        mNavigationView.setVisibility(visibility);
    }
    // <<<<<<<<<<<<<<<< BottomNavigationView

    // FancyCoverFlow >>>>>>>>>>>>>>>>
    public void initCardCoverFlow() {
        mCardCoverFlow = (FancyCoverFlow) findViewById(R.id.fcf_card);
        ViewGroup.LayoutParams fcfParams = mCardCoverFlow.getLayoutParams();
        fcfParams.height = Utils.getPx(this, 100);
        mCardCoverFlow.setLayoutParams(fcfParams);
        mCardCoverFlow.setUnselectedAlpha(1f);
        mCardCoverFlow.setUnselectedSaturation(1f);
        mCardCoverFlow.setUnselectedScale(1f);
        mCardCoverFlow.setSpacing(30);
        mCardCoverFlow.setMaxRotation(0);
        mCardCoverFlow.setScaleDownGravity(1f);
        mCardCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
        mCardCoverFlow.setCallbackDuringFling(false);
    }

    public void setCardCoverFlowAdapter(FancyCoverFlowAdapter adapter) {
        mCardCoverFlow.setAdapter(adapter);
    }

    public void setCardCoverFlowHeight(int height) {
        ViewGroup.LayoutParams fcfParams = mCardCoverFlow.getLayoutParams();
        fcfParams.height = Utils.getPx(this, height);
        mCardCoverFlow.setLayoutParams(fcfParams);
    }

    public void setCardCoverFlowItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
        mCardCoverFlow.setOnItemSelectedListener(listener);
    }

    public void setCardCoverFlowItemClickListener(AdapterView.OnItemClickListener listener) {
        mCardCoverFlow.setOnItemClickListener(listener);
    }

    public void setCardCoverFlowVisibility(int visibility) {
        mCardCoverFlow.setVisibility(visibility);
    }

    // <<<<<<<<<<<<<<<< FancyCoverFlow

    // OptionsMenu >>>>>>>>>>>>>>>>
    public void setMenuId(@MenuRes int menuRes) {
        this.menuRes = menuRes;
    }

    public void setMenu(@MenuRes int menuRes, Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.menuRes = menuRes;
        setMenuClickListener(onMenuItemClickListener);
    }

    public void setMenuClickListener(Toolbar.OnMenuItemClickListener clickListener) {
        this.onMenuItemClickListener = clickListener;
    }
    // <<<<<<<<<<<<<<<< OptionsMenu

}