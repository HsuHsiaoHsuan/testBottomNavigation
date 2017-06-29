package funnybrain.hsu.idv.testbottomnavigation.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import funnybrain.hsu.idv.testbottomnavigation.BaseActivity;
import funnybrain.hsu.idv.testbottomnavigation.R;
import funnybrain.hsu.idv.testbottomnavigation.Utils;
import funnybrain.hsu.idv.testbottomnavigation.data.Card;
import funnybrain.hsu.idv.testbottomnavigation.data.CardCode;
import funnybrain.hsu.idv.testbottomnavigation.home.adapter.CardCoverFlowAdapter;

public class HomeFragment extends Fragment {

    private CardCoverFlowAdapter mCoverFlowAdapter;
    private List<Card> data = new ArrayList<>();

    public HomeFragment() {}

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.add(new Card("1", "91820291", "1", "http://www.google.com.tw", CardCode.BP));
        data.add(new Card("1", "12343", "1", "http://www.google.com.tw", CardCode.CO));
        data.add(new Card("1", "983245", "0", "http://www.google.com.tw", CardCode.AM));
        data.add(new Card("1", "91820291", "1", "http://www.google.com.tw", CardCode.EV));
        data.add(new Card("1", "91820291", "1", "http://www.google.com.tw", CardCode.CL));
        data.add(new Card("1", "91820291", "1", "http://www.google.com.tw", CardCode.CB));
        data.add(new Card("1", "91820291", "1", "http://www.google.com.tw", CardCode.MR));

        mCoverFlowAdapter = new CardCoverFlowAdapter(getActivity(), data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        initCardCoverFlow();
        if (getActivity() instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) getActivity();

            ViewGroup.LayoutParams params = activity.getCardCoverFlowParams();
            params.height = Utils.getDp2Px(getActivity(), 160);
            activity.setCardCoverFlowParams(params);
            activity.setCardCoverFlowAdapter(mCoverFlowAdapter);
            activity.setCardCoverFlowVisibility(View.VISIBLE);
        } else {
            Log.e("FREEMAN", "please let your activity extends BaseActivity");
            getActivity().finish();
        }
    }

//    private void initCardCoverFlow() {
//        ViewGroup.LayoutParams fcfParams = mCardCoverFlow.getLayoutParams();
//        fcfParams.height = Utils.getDp2Px(getActivity(), 100);
//        mCardCoverFlow.setLayoutParams(fcfParams);
//        mCardCoverFlow.setUnselectedAlpha(1f);
//        mCardCoverFlow.setUnselectedSaturation(1f);
//        mCardCoverFlow.setUnselectedScale(1f);
//        mCardCoverFlow.setSpacing(30);
//        mCardCoverFlow.setMaxRotation(0);
//        mCardCoverFlow.setScaleDownGravity(1f);
//        mCardCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
//        mCardCoverFlow.setCallbackDuringFling(false);
//        mCardCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        mCardCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
//        mCardCoverFlow.setAdapter(mCoverFlowAdapter);
//    }
}