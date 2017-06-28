package funnybrain.hsu.idv.testbottomnavigation.home.adapter;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import funnybrain.hsu.idv.testbottomnavigation.R;
import funnybrain.hsu.idv.testbottomnavigation.data.Card;
import funnybrain.hsu.idv.testbottomnavigation.widget.fancycoverflow.FancyCoverFlowAdapter;

public class CardCoverFlowAdapter extends FancyCoverFlowAdapter {

    private Context mContext;
    private List<Card> mCardData;

    public CardCoverFlowAdapter(Context context, List<Card> data) {
        mContext = context;
        mCardData = data;
    }

    @Override
    public View getCoverFlowItem(int position, View view, ViewGroup parent) {
        CardViewHolder holder;
        if (view == null) {
            holder = (CardViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.view_card_home, parent, false);
            holder = new CardViewHolder(view);
            view.setTag(holder);
        }
        holder.tvPoint.setText(mCardData.get(position).getCARD_POINT());

        return view;
    }

    @Override
    public int getCount() {
        return mCardData.size();
    }

    @Override
    public Object getItem(int position) {
        return mCardData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class CardViewHolder {
        @BindView(R.id.tv_point) TextView tvPoint;

        public CardViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}