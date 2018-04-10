package sunlearning.sunlearningdemo.examine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.ExamineSurveyEntity;
import sunlearning.sunlearningdemo.utils.DateFormatUtil;
import sunlearning.sunlearningdemo.utils.enums.ExamTestStatusEnum;
import sunlearning.sunlearningdemo.utils.enums.ExamineSurveyStatusEnum;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineSurveyAdapter extends BaseAdapter {
    private Context mContext;
    private List<ExamineSurveyEntity> mData;

    public ExamineSurveyAdapter(Context mContext, List<ExamineSurveyEntity> mData) {
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
        return ((ExamineSurveyEntity) getItem(position)).getQnId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_questionnaire, null);
            viewHolder = new ViewHolder();
            viewHolder.questionnaireNameTv = convertView.findViewById(R.id.questionnaire_name);
            viewHolder.questionnaireEndTimeTv = convertView.findViewById(R.id.questionnaire_end_time);
            viewHolder.questionnaireStatus = convertView.findViewById(R.id.questionnaire_status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ExamineSurveyEntity item = (ExamineSurveyEntity) getItem(position);
        viewHolder.questionnaireNameTv.setText(item.getQnName());
        viewHolder.questionnaireEndTimeTv.setText(DateFormatUtil.dateToString(item.getEndDate(),"yyyy-MM-dd hh:mm:ss"));
        if(ExamineSurveyStatusEnum.C.name().equals(item.getQnStatus())){
            viewHolder.questionnaireStatus.setText(ExamineSurveyStatusEnum.getDesc(item.getQnStatus()));
            viewHolder.questionnaireStatus.setTextColor(mContext.getResources().getColor(R.color.color_46BC62));
        }else if(ExamineSurveyStatusEnum.NOTSTART.name().equals(item.getQnStatus())){
            viewHolder.questionnaireStatus.setText(ExamineSurveyStatusEnum.getDesc(item.getQnStatus()));
            viewHolder.questionnaireStatus.setTextColor(mContext.getResources().getColor(R.color.color_FF0000));
        }else{
            viewHolder.questionnaireStatus.setText(ExamTestStatusEnum.getDesc(item.getQnStatus()));
        }
        return convertView;
    }


    public static class ViewHolder {
        public TextView questionnaireNameTv;
        public TextView questionnaireEndTimeTv;
        public TextView questionnaireStatus;
    }
}
