package funnybrain.hsu.idv.testbottomnavigation.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Card implements Parcelable {
    private String CARD_TYPE;
    private String CARD_POINT;
    private String HAVE_CARD;
    private String CARD_LINK;
    private String CARD_CODE;

    public Card() {
    }

    public Card(String CARD_TYPE, String CARD_POINT, String HAVE_CARD, String CARD_LINK, String CARD_CODE) {
        this.CARD_TYPE = CARD_TYPE;
        this.CARD_POINT = CARD_POINT;
        this.HAVE_CARD = HAVE_CARD;
        this.CARD_LINK = CARD_LINK;
        this.CARD_CODE = CARD_CODE;
    }

    public String getCARD_TYPE() {
        return CARD_TYPE;
    }

    public void setCARD_TYPE(String CARD_TYPE) {
        this.CARD_TYPE = CARD_TYPE;
    }

    public String getCARD_POINT() {
        return CARD_POINT;
    }

    public void setCARD_POINT(String CARD_POINT) {
        this.CARD_POINT = CARD_POINT;
    }

    public String getHAVE_CARD() {
        return HAVE_CARD;
    }

    public void setHAVE_CARD(String HAVE_CARD) {
        this.HAVE_CARD = HAVE_CARD;
    }

    public String getCARD_LINK() {
        return CARD_LINK;
    }

    public void setCARD_LINK(String CARD_LINK) {
        this.CARD_LINK = CARD_LINK;
    }

    public String getCARD_CODE() {
        return CARD_CODE;
    }

    public void setCARD_CODE(String CARD_CODE) {
        this.CARD_CODE = CARD_CODE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.CARD_TYPE);
        dest.writeString(this.CARD_POINT);
        dest.writeString(this.HAVE_CARD);
        dest.writeString(this.CARD_LINK);
        dest.writeString(this.CARD_CODE);
    }

    protected Card(Parcel in) {
        this.CARD_TYPE = in.readString();
        this.CARD_POINT = in.readString();
        this.HAVE_CARD = in.readString();
        this.CARD_LINK = in.readString();
        this.CARD_CODE = in.readString();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel source) {
            return new Card(source);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };
}