package sunlearning.sunlearningdemo.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseEntity;
import sunlearning.sunlearningdemo.utils.DateFormatUtil;

/**
 * Created by chenny on 2018/4/2.
 */

public class CourseAdapter extends BaseAdapter {
    private List<CourseEntity> mData;
    private Context mContext;

    public CourseAdapter(List<CourseEntity> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
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
        return mData.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_course, null);
            viewHolder = new ViewHolder();
            viewHolder.courseIcon = convertView.findViewById(R.id.item_list_course_icon);
            viewHolder.courseId = convertView.findViewById(R.id.item_list_course_id);
            viewHolder.courseName = convertView.findViewById(R.id.item_list_course_name);
            viewHolder.courseDesc = convertView.findViewById(R.id.item_list_course_desc);
            viewHolder.courseCreateDate = convertView.findViewById(R.id.item_list_course_create_date);
            viewHolder.courseViewNum = convertView.findViewById(R.id.item_list_course_view_num);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CourseEntity curCourse = mData.get(position);
        viewHolder.courseIcon.setBackground(mContext.getResources().getDrawable(R.drawable.icon_course));
        viewHolder.courseId.setText(String.valueOf(curCourse.getId()));
        viewHolder.courseName.setText(curCourse.getName());
        viewHolder.courseDesc.setText(curCourse.getDesc());
        viewHolder.courseCreateDate.setText(DateFormatUtil.dateToString(curCourse.getCreateDate(), "yyyy-MM-dd hh:mm:ss"));
        viewHolder.courseViewNum.setText(String.valueOf(curCourse.getViewNum()));

        return convertView;
    }

    public List<CourseEntity> getmData() {
        return mData;
    }

    public void setmData(List<CourseEntity> mData) {
        this.mData = mData;
    }

    public static class ViewHolder {
        public ImageView courseIcon;
        public TextView courseId;
        public TextView courseName;
        public TextView courseDesc;
        public TextView courseCreateDate;
        public TextView courseViewNum;
    }
}
