package sunlearning.sunlearningdemo.ask.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.AskEntity;
import sunlearning.sunlearningdemo.utils.DateFormatUtil;
import sunlearning.sunlearningdemo.utils.enums.AskStatusEnum;
import sunlearning.sunlearningdemo.utils.widegt.CircleImageView;

/**
 * Created by chenny on 2018/4/8.
 */

public class AskListAdapter extends BaseAdapter {
    private Context mContext;
    private List<AskEntity> mData;

    public AskListAdapter(Context mContext, List<AskEntity> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((AskEntity) getItem(position)).getKnowQuestionId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_ask, null);
            viewHolder = new ViewHolder();
            viewHolder.userHeadImgIv = convertView.findViewById(R.id.ask_head_img);
            viewHolder.userNameTv = convertView.findViewById(R.id.ask_user_name);
            viewHolder.askCreateDateTV = convertView.findViewById(R.id.ask_create_date);
            viewHolder.askTitleTv = convertView.findViewById(R.id.ask_title);
            viewHolder.askRewardTv = convertView.findViewById(R.id.ask_reward);
            viewHolder.askAnswerCountTv = convertView.findViewById(R.id.ask_answer_count);
            viewHolder.askStatusTv = convertView.findViewById(R.id.ask_status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AskEntity item = (AskEntity) getItem(position);
        String host = "http://sun-learning.com/";
        String url = host + item.getUserEntity().getUserImg();
        Glide.with(mContext).load(url).into(viewHolder.userHeadImgIv);
        viewHolder.userNameTv.setText(item.getUserEntity().getUserName());
        viewHolder.askCreateDateTV.setText(DateFormatUtil.dateToString(item.getCreateDate(), "yyyy-MM-dd hh:mm:ss"));
        viewHolder.askTitleTv.setText(item.getTitle());
        viewHolder.askRewardTv.setText(String.valueOf(item.getGoldCoins()));
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.ask_gold);
        drawable.setBounds(0, 0, 26, 18);
        viewHolder.askRewardTv.setCompoundDrawables(null, null, drawable, null);
        viewHolder.askAnswerCountTv.setText(String.valueOf(item.getAnswerTotal()));
        if (AskStatusEnum.PENDING.name().equals(item.getKnowStatus())) {
            viewHolder.askStatusTv.setText(AskStatusEnum.getDesc(item.getKnowStatus()));
            viewHolder.askStatusTv.setTextColor(mContext.getResources().getColor(R.color.color_FF0000));

        } else if (AskStatusEnum.SOLVED.name().equals(item.getKnowStatus())) {
            viewHolder.askStatusTv.setText(AskStatusEnum.getDesc(item.getKnowStatus()));
            viewHolder.askStatusTv.setTextColor(mContext.getResources().getColor(R.color.color_999999));
        } else {
            viewHolder.askStatusTv.setText(AskStatusEnum.getDesc(item.getKnowStatus()));
        }
        return convertView;
    }

    public static class ViewHolder {
        public CircleImageView userHeadImgIv;
        public TextView userNameTv;
        public TextView askCreateDateTV;
        public TextView askTitleTv;
        public TextView askRewardTv;
        public TextView askAnswerCountTv;
        public TextView askStatusTv;
    }
}
