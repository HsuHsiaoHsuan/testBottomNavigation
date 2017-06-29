package funnybrain.hsu.idv.testbottomnavigation.home.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import funnybrain.hsu.idv.testbottomnavigation.R;
import funnybrain.hsu.idv.testbottomnavigation.Utils;
import funnybrain.hsu.idv.testbottomnavigation.data.Card;
import funnybrain.hsu.idv.testbottomnavigation.data.CardCode;
import funnybrain.hsu.idv.testbottomnavigation.widget.fancycoverflow.FancyCoverFlowAdapter;

public class CardCoverFlowAdapter extends FancyCoverFlowAdapter {

    private Context mContext;
    private List<Card> mCardData;
    private Point mPoint;

    public CardCoverFlowAdapter(Context context, List<Card> data) {
        mContext = context;
        mCardData = data;
        mPoint = Utils.getWindowScreen(context);
    }

    @Override
    public View getCoverFlowItem(int position, View view, ViewGroup parent) {
        CardViewHolder holder;
        if (view != null) {
            holder = (CardViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.view_card_home, parent, false);
            holder = new CardViewHolder(view);
            view.setTag(holder);
        }

        holder.ivCardLogo.setImageResource(getLogoByCode(mCardData.get(position).getCARD_CODE()));
        holder.tvCardTitle.setText(getTitleByCode(mCardData.get(position).getCARD_CODE()));
        holder.tvCardPoint.setText(mCardData.get(position).getCARD_POINT());

        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.width = mPoint.x * 3 / 4;
        params.height = params.width * 3 / 8;
        int paddingPx = Utils.getDp2Px(mContext, 16);
        holder.itemView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);
        holder.itemView.setLayoutParams(params);
        holder.itemView.setFocusable(false);
        holder.itemView.setClickable(false);

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

    static class CardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_logo) ImageView ivCardLogo;
        @BindView(R.id.tv_card_title) TextView tvCardTitle;
        @BindView(R.id.tv_point) TextView tvCardPoint;

        public CardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static int getLogoByCode(String code) {
        switch (code) {
            case CardCode.BP:
                return R.drawable.ic_logo_cathay_w;
            case CardCode.CO:
                return R.drawable.ic_logo_costco;
            case CardCode.AM:
                return R.drawable.ic_logo_am;
            case CardCode.EV:
                return R.drawable.ic_logo_eva;
            default:
                return 0;
        }
    }

    static int getTitleByCode(String code) {
        switch (code) {
            case CardCode.BP:
                return R.string.home_card_title_bp;
            case CardCode.CO:
                return R.string.home_card_title_co;
            case CardCode.AM:
                return R.string.home_card_title_am;
            case CardCode.EV:
                return R.string.home_card_title_ev;
            default:
                return R.string.home_card_title_empty;
        }
    }
}