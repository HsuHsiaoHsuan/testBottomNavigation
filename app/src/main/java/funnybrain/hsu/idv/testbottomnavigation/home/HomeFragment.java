package funnybrain.hsu.idv.testbottomnavigation.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import funnybrain.hsu.idv.testbottomnavigation.R;
import funnybrain.hsu.idv.testbottomnavigation.Utils;
import funnybrain.hsu.idv.testbottomnavigation.widget.fancycoverflow.FancyCoverFlow;

public class HomeFragment extends Fragment {

    @BindView(R.id.fcf_card) FancyCoverFlow mCardCoverFlow;

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
        if (getArguments() != null) {
        }
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

        initCardCoverFlow();
    }

    private void initCardCoverFlow() {
        ViewGroup.LayoutParams fcfParams = mCardCoverFlow.getLayoutParams();
        fcfParams.height = Utils.getPx(getActivity(), 100);
        mCardCoverFlow.setLayoutParams(fcfParams);
        mCardCoverFlow.setUnselectedAlpha(1f);
        mCardCoverFlow.setUnselectedSaturation(1f);
        mCardCoverFlow.setUnselectedScale(1f);
        mCardCoverFlow.setSpacing(30);
        mCardCoverFlow.setMaxRotation(0);
        mCardCoverFlow.setScaleDownGravity(1f);
        mCardCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
        mCardCoverFlow.setCallbackDuringFling(false);
        mCardCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mCardCoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
//        mCardCoverFlow.setAdapter(mapCardAdapter);
    }
}