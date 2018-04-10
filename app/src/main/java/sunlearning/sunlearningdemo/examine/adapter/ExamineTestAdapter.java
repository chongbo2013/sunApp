package sunlearning.sunlearningdemo.examine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.ExamineTestEntity;
import sunlearning.sunlearningdemo.utils.DateFormatUtil;
import sunlearning.sunlearningdemo.utils.enums.ExamTestStatusEnum;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineTestAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExamineTestEntity> mData;

    public ExamineTestAdapter(Context mContext, List<ExamineTestEntity> mData) {
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
        return ((ExamineTestEntity) getItem(position)).getExamActivityId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_examine, null);
            viewHolder = new ViewHolder();
            viewHolder.examineNameTv = convertView.findViewById(R.id.examine_name);
            viewHolder.examineStatusTv = convertView.findViewById(R.id.examine_status);
            viewHolder.examineStartTimeTv = convertView.findViewById(R.id.examine_start_time);
            viewHolder.examineEndTimeTv = convertView.findViewById(R.id.examine_end_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ExamineTestEntity item = (ExamineTestEntity) getItem(position);
        viewHolder.examineNameTv.setText(item.getExamActivityName());
        if(ExamTestStatusEnum.ASSESSING.name().equals(item.getExamStatus())){
            viewHolder.examineStatusTv.setText(ExamTestStatusEnum.getDesc(item.getExamStatus()));
            viewHolder.examineStatusTv.setTextColor(mContext.getResources().getColor(R.color.color_FF0000));
        }else{
            viewHolder.examineStatusTv.setText("");
        }

        viewHolder.examineStartTimeTv.setText(DateFormatUtil.dateToString(item.getExamStartDate(),"yyyy-MM-dd hh:mm:ss"));
        viewHolder.examineEndTimeTv.setText(DateFormatUtil.dateToString(item.getExamEndDate(),"yyyy-MM-dd hh:mm:ss"));

        return convertView;
    }

    public static class ViewHolder {
        public TextView examineNameTv;
        public TextView examineStatusTv;
        public TextView examineStartTimeTv;
        public TextView examineEndTimeTv;
    }
}
